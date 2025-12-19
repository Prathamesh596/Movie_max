import React, { useEffect, useState } from 'react';
import { Navigate, NavLink, useNavigate } from 'react-router-dom';
import { FaRegCircleUser } from "react-icons/fa6";
import { IoIosSearch } from "react-icons/io";
import Login from './Login';
import { ROUTES } from '../constants/RouteConstants';
import { YOUTUBE_SEARCH_API } from '../constants/ApiConstants';

export default function NavBar({ user, setUser }) {
    const nav = useNavigate();
    const [key, setKey] = useState("");
    const [suggestion, setSuggestion] = useState([]);
    const [showSuggestions, setShowSuggestions] = useState(false);

    useEffect(() => {
        if (key.length > 0) {
            nav(`search?q=${key}`);
        }
    }, [key]);

    const getSearchSuggestions = async () => {
        try {
            const res = await fetch(YOUTUBE_SEARCH_API + key);
            const data = await res.json();
            setSuggestion(data[1] || []);
        } catch (e) {
            setSuggestion([]);
        }
    };

    useEffect(() => {
        if (key.length > 1) getSearchSuggestions();
        else setSuggestion([]);
    }, [key]);

    return (
        <>
            {user && (user?.role === "ADMIN" || user?.role === "THEATER_OWNER") ? (
                user.role === "ADMIN" ? (
                    <Navigate to={ROUTES.ADMIN_DASHBOARD} />
                ) : (
                    <Navigate to={ROUTES.THEATER_OWNER_DASHBOARD} />
                )
            ) : (
                <>
                    <nav
                        className="navbar navbar-expand-lg sticky-top"
                        style={{
                            background: "linear-gradient(90deg,#0f172a, #0b2545)",
                            color: "#fff",
                            borderBottom: "1px solid rgba(255,255,255,0.04)",
                        }}
                    >
                        <div className="container">
                            <NavLink to={ROUTES.HOME} className="navbar-brand d-flex align-items-center text-white">
                                <div className="me-2" style={{ width: 44, height: 44, borderRadius: 10, background: "#ff6b6b" }} />
                                <div>
                                    <div className="fw-bold h6 mb-0">MovieMax</div>
                                    <small className="text-muted" style={{ color: "rgba(255,255,255,0.75)" }}>Premium Cinema</small>
                                </div>
                            </NavLink>

                            <button
                                className="navbar-toggler"
                                type="button"
                                data-bs-toggle="collapse"
                                data-bs-target="#mainNav"
                                aria-controls="mainNav"
                                aria-expanded="false"
                                aria-label="Toggle navigation"
                            >
                                <span className="navbar-toggler-icon" />
                            </button>

                            <div className="collapse navbar-collapse" id="mainNav">
                                <ul className="navbar-nav me-auto mb-2 mb-lg-0">
                                    <li className="nav-item">
                                        <NavLink className="nav-link text-white" to={ROUTES.HOME}>Home</NavLink>
                                    </li>
                                    <li className="nav-item">
                                        <NavLink className="nav-link text-white" to={ROUTES.MOVIES}>Movies</NavLink>
                                    </li>
                                    <li className="nav-item">
                                        <NavLink className="nav-link text-white" to={ROUTES.ABOUTUS}>About</NavLink>
                                    </li>
                                    <li className="nav-item">
                                        <NavLink className="nav-link text-white" to={ROUTES.CONTACTUS}>Contact</NavLink>
                                    </li>
                                </ul>

                                <div className="d-flex align-items-center w-100 w-lg-auto">
                                    <div className="me-3 position-relative" style={{ minWidth: 260 }}>
                                        <div className="input-group">
                                            <span className="input-group-text bg-white text-muted">
                                                <IoIosSearch />
                                            </span>
                                            <input
                                                className="form-control"
                                                type="search"
                                                placeholder="Search movies, shows..."
                                                value={key}
                                                onChange={(e) => setKey(e.target.value)}
                                                onFocus={() => setShowSuggestions(true)}
                                                onBlur={() => setTimeout(() => setShowSuggestions(false), 150)}
                                            />
                                        </div>

                                        {showSuggestions && suggestion.length > 0 && (
                                            <div className="position-absolute bg-white rounded shadow-sm w-100 mt-1" style={{ zIndex: 9999 }}>
                                                {suggestion.slice(0, 6).map((s, i) => (
                                                    <button key={i} type="button" className="btn btn-sm w-100 text-start py-2">
                                                        {s}
                                                    </button>
                                                ))}
                                            </div>
                                        )}
                                    </div>

                                    {user ? (
                                        <NavLink to={ROUTES.USE_DASHBOARD} className="btn btn-outline-light ms-2">
                                            <FaRegCircleUser />
                                        </NavLink>
                                    ) : (
                                        <>
                                            <button className="btn btn-danger ms-2 d-none d-lg-inline-block" data-bs-toggle="modal" data-bs-target="#loginModal">
                                                Login
                                            </button>
                                            <button className="btn btn-link text-white ms-2 d-lg-none" data-bs-toggle="modal" data-bs-target="#loginModal">
                                                Login
                                            </button>
                                        </>
                                    )}
                                </div>
                            </div>
                        </div>
                    </nav>

                    <Login user={user} setUser={setUser} />
                </>
            )}
        </>
    );
}
