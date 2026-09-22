# PA LC — Java DSA Website

A static website generated from the Java files in the uploaded `PA LC` project.

## Run locally

### Without Docker
Open `index.html` in a browser.

### With Docker

```bash
docker build -t pa-lc .
docker run -p 8080:80 pa-lc
```

Then open `http://localhost:8080`.

## Deploy

This project is Docker-ready for platforms such as Render, Railway, Fly.io, or any Docker-compatible host.

The site is fully client-side: HTML + CSS + JavaScript + Nginx. No database or backend is required.
