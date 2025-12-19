# React + Vite

This template provides a minimal setup to get React working in Vite with HMR and some ESLint rules.

Currently, two official plugins are available:


## TMDB (live movies) setup

This project uses The Movie Database (TMDB) to show live movie lists (Trending, Upcoming, Now Playing, etc.). TMDB provides free developer API keys.

1. Get a free API key: visit https://www.themoviedb.org/settings/api and create an API key.
2. Copy the example env file and add your key (PowerShell):

```powershell
cd "D:\JAVA Projects\ticket\TicketHub-SpringBoot\frontend"
copy .env.example .env
notepad .env
# replace the placeholder value for VITE_TMDB_API_KEY with your actual TMDB key
```

3. Restart the dev server: `npm run dev` and open `http://localhost:5173`.

Notes:
- The code reads `VITE_TMDB_API_KEY` from `import.meta.env`. If you don't set it, a fallback key (if present) will be used but it's recommended to set your own.
- TMDB has rate limits; for production consider caching or server-side proxying.
