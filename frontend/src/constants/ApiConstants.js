
// //
// / TMDB (The Movie Database) — prefer API key from environment for security
// export const API_KEY = import.meta.env.VITE_TMDB_API_KEY || '4d00e354677d7037dca04151cd23a174';

// export const TRENDING_API_URL = (page = 1) =>
//     https://api.themoviedb.org/3/trending/movie/day?api_key=${API_KEY}&language=en-US&page=${page};
// export const UPCOMING_API_URL = (page = 1) =>
//     https://api.themoviedb.org/3/movie/upcoming?api_key=${API_KEY}&language=en-US&page=${page};
// export const NOWPLAYING_API_URL = (page = 1) =>
//     https://api.themoviedb.org/3/movie/now_playing?api_key=${API_KEY}&language=en-US&page=${page};
// export const EVENTS_API_URL = (page = 1) =>
//     https://api.themoviedb.org/3/trending/tv/day?api_key=${API_KEY}&language=en-US&page=${page};

// export const IMAGE_MIN_BASE_URL = 'https://image.tmdb.org/t/p/w200';
// export const IMAGE_MAX_BASE_URL ='https://image.tmdb.org/t/p/original';

// /**
//  * Build a usable image URL for poster/backdrop paths returned by TMDB or by backend.
//  * - If path is falsy, returns a fallback local image path.
//  * - If path already looks like a full URL (starts with http), returns it as-is.
//  * - Otherwise prefixes the appropriate TMDB base URL depending on size ('min'|'max').
//  */
// export function getImageUrl(path, size = 'min') {
//     if (!path) return '/images/theatre-photo.jpg';
//     if (typeof path === 'string' && path.startsWith('http')) return path;
//     const base = size === 'max' ? IMAGE_MAX_BASE_URL : IMAGE_MIN_BASE_URL;
//     // Ensure we don't duplicate slashes
//     return ${base}${path.startsWith('/') ? path : '/' + path};
// }


// //
// export const USER_BASE_URL='http://localhost:8080/user/'
// export const MOVIE_BASE_URL='http://localhost:8080/movie/'
// export const TICKET_BASE_URL='http://localhost:8080/tickets/'
// export const CONTACT_BASE_URL='http://localhost:8080/contact/'
// export const AUTHENTICATE_BASE_URL='http://localhost:8080/signin'

// export const THEATEROWNER_BASE_URL='http://localhost:8080/theaterowner/';
// export const BOOKING_BASE_URL='http://localhost:8080/bookings/';
// export const BOOKED_SEAT_BASE_URL='http://localhost:8080/booked-seats/'


// // Google API
// const Google_API_KEY = 'AIzaSyAGr445Tqocn-DGDqs0-2ZvF-IWhUaK9TQ';   
// export const YOUTUBE_SEARCH_API =
//     "http://suggestqueries.google.com/complete/search?client=firefox&ds=yt&q=";
// export const YOUTUBE_SEARCH_VIDEO_API =
//     https://youtube.googleapis.com/youtube/v3/search?part=snippet&maxResults=50&type=video&regionCode=IN&key=${Google_API_KEY}&q=;
//
// TMDB (The Movie Database) — prefer API key from environment for security
export const API_KEY = import.meta.env.VITE_TMDB_API_KEY;

if (!API_KEY) {
    console.error("TMDB API key is missing! Please set VITE_TMDB_API_KEY in your environment variables.");
}

export const TRENDING_API_URL = (page = 1) =>
    `https://api.themoviedb.org/3/trending/movie/day?api_key=${API_KEY}&language=en-US&page=${page}`;

export const UPCOMING_API_URL = (page = 1) =>
    `https://api.themoviedb.org/3/movie/upcoming?api_key=${API_KEY}&language=en-US&page=${page}`;

export const NOWPLAYING_API_URL = (page = 1) =>
    `https://api.themoviedb.org/3/movie/now_playing?api_key=${API_KEY}&language=en-US&page=${page}`;

export const EVENTS_API_URL = (page = 1) =>
    `https://api.themoviedb.org/3/trending/tv/day?api_key=${API_KEY}&language=en-US&page=${page}`;

// TMDB image URLs
export const IMAGE_MIN_BASE_URL = 'https://image.tmdb.org/t/p/w200';
export const IMAGE_MAX_BASE_URL = 'https://image.tmdb.org/t/p/original';

export function getImageUrl(path, size = 'min') {
    if (!path) return '/images/theatre-photo.jpg';
    if (typeof path === 'string' && path.startsWith('http')) return path;
    const base = size === 'max' ? IMAGE_MAX_BASE_URL : IMAGE_MIN_BASE_URL;
    return `${base}${path.startsWith('/') ? path : '/' + path}`;
}

// Backend API endpoints
const LOCALHOST = 'http://localhost:8080';
export const USER_BASE_URL = `${LOCALHOST}/user/`;
export const MOVIE_BASE_URL = `${LOCALHOST}/movie/`;
export const TICKET_BASE_URL = `${LOCALHOST}/tickets/`;
export const CONTACT_BASE_URL = `${LOCALHOST}/contact/`;
export const AUTHENTICATE_BASE_URL = `${LOCALHOST}/signin`;
export const THEATEROWNER_BASE_URL = `${LOCALHOST}/theaterowner/`;
export const BOOKING_BASE_URL = `${LOCALHOST}/bookings/`;
export const BOOKED_SEAT_BASE_URL = `${LOCALHOST}/booked-seats/`;

// Google API
const GOOGLE_API_KEY = import.meta.env.VITE_GOOGLE_API_KEY;

if (!GOOGLE_API_KEY) {
    console.error("Google API key is missing! Please set VITE_GOOGLE_API_KEY in your environment variables.");
}

export const YOUTUBE_SEARCH_API =
    "https://suggestqueries.google.com/complete/search?client=firefox&ds=yt&q=";

export const YOUTUBE_SEARCH_VIDEO_API = (query) =>
    `https://youtube.googleapis.com/youtube/v3/search?part=snippet&maxResults=50&type=video&regionCode=IN&key=${GOOGLE_API_KEY}&q=${encodeURIComponent(query)}`;
