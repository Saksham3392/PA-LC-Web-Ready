# PA-LC — AI / Developer Context

## What this project is
A static Java DSA/LeetCode-style question library. The browser displays Java implementations stored in a JavaScript data file. There is no database and no backend.

## File map

- `index.html` — page structure, hero, stats, search area, filters container, question grid, modal, and script load order.
- `style.css` — all visual styling, responsive layout, cards, modal, filters, code viewer.
- `data.js` — **source of truth for the website question library**. It creates `window.PA_LC_DATA`.
- `script.js` — reads `window.PA_LC_DATA` and renders/filter/searches the questions. Also opens the code modal, copies code, and highlights Java syntax.
- `code/` — original Java source files organized by topic.
- `nginx.conf` — static hosting configuration for Docker deployment.
- `Dockerfile` — builds/runs the site with Nginx.
- `README.md` — basic setup/deployment instructions.

## Data flow

```text
code/**/*.java
      │
      │ copied/represented as entries
      ▼
data.js
      │
      │ window.PA_LC_DATA
      ▼
script.js
      │
      ├── topic filters
      ├── search
      ├── question cards
      └── code modal
      ▼
index.html + style.css
      │
      ▼
Browser UI
```

## Current library
- Java files/problems represented in `data.js`: 65
- Topics: Array, Backtracking, CircularLinkedList, DoublyLinkedList, Searching, SinglyLinkedList, Sorting

## Important bug history
The question cards previously showed `0` because `script.js` contained an invalid JavaScript regular expression inside `highlightJava()`. That caused the entire script to fail parsing, so `render()` never ran. The operator regex has been simplified to a valid expression.

If the UI ever shows `0 Java files` again:
1. Open browser DevTools → Console.
2. Check whether `script.js` has a syntax/runtime error.
3. Check that `data.js` loads successfully.
4. Confirm `data.js` appears before `script.js` in `index.html`.
5. Confirm `window.PA_LC_DATA.files` is an array.

## Safe change rules for future AI
- Do not remove or rename `window.PA_LC_DATA` without updating `script.js`.
- Do not move `script.js` before `data.js` in `index.html`.
- When adding a Java problem, add its original `.java` file under the appropriate `code/` topic and add/update the matching object in `data.js`.
- Keep `name`, `file`, `category`, `lines`, and `code` consistent.
- After editing JavaScript, run a syntax check before packaging/deploying.
- The site is static; do not introduce a database/backend unless the architecture is intentionally being changed.
