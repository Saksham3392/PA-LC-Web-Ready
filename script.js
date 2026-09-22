const data = window.PA_LC_DATA;
const grid = document.getElementById("problemGrid");
const filters = document.getElementById("filters");
const search = document.getElementById("search");
const resultCount = document.getElementById("resultCount");
const empty = document.getElementById("empty");
const modal = document.getElementById("modal");
const modalTitle = document.getElementById("modalTitle");
const modalCategory = document.getElementById("modalCategory");
const modalPath = document.getElementById("modalPath");
const modalCode = document.getElementById("modalCode");
let activeCategory = "All";
let currentCode = "";

const categories = ["All", ...new Set(data.files.map(x => x.category))];

document.getElementById("statProblems").textContent = data.files.length;
document.getElementById("statTopics").textContent = categories.length - 1;
document.getElementById("year").textContent = new Date().getFullYear();

categories.forEach(cat => {
  const b = document.createElement("button");
  b.className = "filter" + (cat === "All" ? " active" : "");
  b.textContent = cat;
  b.onclick = () => {
    activeCategory = cat;
    document.querySelectorAll(".filter").forEach(x => x.classList.remove("active"));
    b.classList.add("active");
    render();
  };
  filters.appendChild(b);
});

function render() {
  const q = search.value.trim().toLowerCase();
  const shown = data.files.filter(item => {
    const matchesCategory = activeCategory === "All" || item.category === activeCategory;
    const haystack = `${item.name} ${item.file} ${item.category}`.toLowerCase();
    return matchesCategory && (!q || haystack.includes(q));
  });

  resultCount.textContent = `Showing ${shown.length} of ${data.files.length} problems`;
  grid.innerHTML = "";
  empty.hidden = shown.length !== 0;

  shown.forEach(item => {
    const card = document.createElement("article");
    card.className = "problem";
    card.innerHTML = `
      <div class="problem-top">
        <span class="badge">${escapeHtml(item.category)}</span>
        <span class="lines">${item.lines} lines</span>
      </div>
      <h3>${escapeHtml(item.name)}</h3>
      <p>${escapeHtml(item.file)}</p>`;
    card.onclick = () => openModal(item);
    grid.appendChild(card);
  });
}

function openModal(item) {
  modalTitle.textContent = item.name;
  modalCategory.textContent = item.category;
  modalPath.textContent = item.file;
  currentCode = item.code;
  modalCode.innerHTML = highlightJava(item.code);
  modal.classList.add("open");
  modal.setAttribute("aria-hidden", "false");
  document.body.style.overflow = "hidden";
}

function closeModal() {
  modal.classList.remove("open");
  modal.setAttribute("aria-hidden", "true");
  document.body.style.overflow = "";
}

document.querySelectorAll("[data-close]").forEach(x => x.addEventListener("click", closeModal));
document.addEventListener("keydown", e => { if (e.key === "Escape") closeModal(); });
search.addEventListener("input", render);

document.getElementById("copyBtn").addEventListener("click", async () => {
  try {
    await navigator.clipboard.writeText(currentCode);
    const btn = document.getElementById("copyBtn");
    btn.textContent = "Copied!";
    setTimeout(() => btn.textContent = "Copy", 1200);
  } catch {
    alert("Copy failed. Please select and copy the code manually.");
  }
});


function highlightJava(source) {
  const keywords = new Set([
    "abstract","assert","boolean","break","byte","case","catch","char","class",
    "const","continue","default","do","double","else","enum","extends","final",
    "finally","float","for","goto","if","implements","import","instanceof","int",
    "interface","long","native","new","package","private","protected","public",
    "return","short","static","strictfp","super","switch","synchronized","this",
    "throw","throws","transient","try","var","void","volatile","while","record",
    "sealed","permits","non-sealed","yield"
  ]);
  const types = new Set([
    "String","Integer","Long","Double","Float","Boolean","Character","Object",
    "System","Math","Arrays","ArrayList","LinkedList","HashMap","HashSet",
    "Map","Set","List","Queue","Stack","Deque","PriorityQueue","Optional",
    "StringBuilder","StringBuffer","Scanner","Collections","Comparator"
  ]);
  const constants = new Set(["true","false","null","NaN","Infinity"]);

  let out = "";
  let i = 0;

  const esc = s => s.replace(/&/g,"&amp;").replace(/</g,"&lt;").replace(/>/g,"&gt;")
                    .replace(/"/g,"&quot;").replace(/'/g,"&#39;");

  while (i < source.length) {
    // Line comments
    if (source.startsWith("//", i)) {
      const end = source.indexOf("\n", i);
      const part = end === -1 ? source.slice(i) : source.slice(i, end);
      out += `<span class="tok-comment">${esc(part)}</span>`;
      i += part.length;
      continue;
    }

    // Block comments
    if (source.startsWith("/*", i)) {
      const end = source.indexOf("*/", i + 2);
      const j = end === -1 ? source.length : end + 2;
      out += `<span class="tok-comment">${esc(source.slice(i, j))}</span>`;
      i = j;
      continue;
    }

    // Strings / chars
    if (source[i] === '"' || source[i] === "'") {
      const quote = source[i];
      let j = i + 1;
      while (j < source.length) {
        if (source[j] === "\\") j += 2;
        else if (source[j] === quote) { j++; break; }
        else j++;
      }
      out += `<span class="tok-string">${esc(source.slice(i, j))}</span>`;
      i = j;
      continue;
    }

    // Annotation
    if (source[i] === "@") {
      const m = source.slice(i).match(/^@[A-Za-z_$][\w$]*/);
      if (m) {
        out += `<span class="tok-annotation">${esc(m[0])}</span>`;
        i += m[0].length;
        continue;
      }
    }

    // Number
    if (/[0-9]/.test(source[i])) {
      const m = source.slice(i).match(/^(?:0[xX][0-9a-fA-F]+|0[bB][01]+|(?:\d+(?:\.\d*)?|\.\d+)(?:[eE][+-]?\d+)?[fFdDlL]?)/);
      if (m) {
        out += `<span class="tok-number">${m[0]}</span>`;
        i += m[0].length;
        continue;
      }
    }

    // Identifier / keyword
    if (/[A-Za-z_$]/.test(source[i])) {
      const m = source.slice(i).match(/^[A-Za-z_$][\w$]*/);
      const word = m[0];
      const next = source.slice(i + word.length).match(/^\s*\(/);
      let cls = "";
      if (keywords.has(word)) cls = "tok-keyword";
      else if (types.has(word) || /^[A-Z]/.test(word)) cls = "tok-type";
      else if (constants.has(word)) cls = "tok-constant";
      else if (next) cls = "tok-function";

      out += cls
        ? `<span class="${cls}">${esc(word)}</span>`
        : esc(word);
      i += word.length;
      continue;
    }

    // Operators / punctuation
    const op = source.slice(i).match(/^(?:===|!==|>>>|>>=|<<=|==|!=|<=|>=|&&|\|\||\+\+|--|+=|-=|\*=|\/=|%=|&=|\|=|\^=|->|::|<<|>>|[+\-*\/%=<>!&|^~?:])/);
    if (op) {
      out += `<span class="tok-operator">${esc(op[0])}</span>`;
      i += op[0].length;
      continue;
    }

    if ("{}[]();,.".includes(source[i])) {
      out += `<span class="tok-punctuation">${esc(source[i])}</span>`;
      i++;
      continue;
    }

    out += esc(source[i]);
    i++;
  }
  return out;
}

function escapeHtml(s) {
  return s.replace(/[&<>"']/g, c => ({'&':'&amp;','<':'&lt;','>':'&gt;','"':'&quot;',"'":'&#039;'}[c]));
}

render();
