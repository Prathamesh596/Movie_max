import axios from "axios";
import { MOVIE_BASE_URL, TRENDING_API_URL, UPCOMING_API_URL, NOWPLAYING_API_URL, API_KEY } from "../constants/ApiConstants";

/**
 * Fetch movies. For known public categories, fetch directly from TMDB so lists/images are dynamic.
 * Otherwise fall back to backend endpoints.
 */
export async function getMovies(type) {
    const t = (type || '').toLowerCase();
    try {
        if (t === 'trending') {
            const res = await axios.get(TRENDING_API_URL());
            return { data: res.data.results };
        }

        if (t === 'upcoming') {
            const res = await axios.get(UPCOMING_API_URL());
            return { data: res.data.results };
        }

        if (t === 'nowplaying' || t === 'now playing' || t === 'now_playing') {
            const res = await axios.get(NOWPLAYING_API_URL());
            return { data: res.data.results };
        }

        if (t === 'popular') {
            const url = `https://api.themoviedb.org/3/movie/popular?api_key=${API_KEY}&language=en-US&page=1`;
            const res = await axios.get(url);
            return { data: res.data.results };
        }
    } catch (err) {
        // if TMDB call fails, fall back to backend path below
        console.warn('TMDB fetch failed for', type, err?.message || err);
    }

    // fallback to backend API (existing behavior)
    return axios.get(`${MOVIE_BASE_URL}${type}/type`);
}

export function getMovieById(id) {
    return axios.get(`${MOVIE_BASE_URL}${id}`);
}

export function getMoviesCast(id) {
    return axios.get(`${MOVIE_BASE_URL}${id}/cast`);
}

export function getMovieByTitle(title) {
    return axios.get(`${MOVIE_BASE_URL}search?title=${title}`)
}

export function getMoviesByFilter(type, status, rating, category) {
    return axios.get(`${MOVIE_BASE_URL}${type}/filter`, {
        params: { status, category, rating }
    });
}