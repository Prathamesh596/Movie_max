import React from "react";
import { NavLink } from "react-router-dom";
import { ROUTES } from "../constants/RouteConstants";

export function Footer() {
  return (
    <footer className="py-5" style={{ background: 'linear-gradient(180deg, #081029, #071427)', color: '#e6eef8' }}>
      <div className="container">
        <div className="row gy-4">
          <div className="col-lg-4">
            <h4 className="fw-bold mb-2">MovieMax</h4>
            <p className="text-muted">Your premium destination for movies, showtimes and exclusive offers.</p>
            <div className="d-flex gap-2 mt-3">
              <a className="btn btn-outline-light btn-sm" href="#">Now Showing</a>
              <a className="btn btn-outline-light btn-sm" href="#">Book Now</a>
            </div>
          </div>

          <div className="col-lg-2">
            <h6 className="fw-semibold">Explore</h6>
            <ul className="list-unstyled text-muted">
              <li className="py-1"><NavLink to={ROUTES.MOVIES} className="text-decoration-none text-muted">Movies</NavLink></li>
              <li className="py-1"><NavLink to={ROUTES.SEARCH} className="text-decoration-none text-muted">Search</NavLink></li>
              <li className="py-1"><NavLink to={ROUTES.ABOUTUS} className="text-decoration-none text-muted">About</NavLink></li>
            </ul>
          </div>

          <div className="col-lg-3">
            <h6 className="fw-semibold">Support</h6>
            <ul className="list-unstyled text-muted">
              <li className="py-1"><NavLink to={ROUTES.CONTACTUS} className="text-decoration-none text-muted">Contact Us</NavLink></li>
              <li className="py-1"><NavLink to={ROUTES.RETURN_POLICY} className="text-decoration-none text-muted">Return Policy</NavLink></li>
              <li className="py-1"><NavLink to={ROUTES.TERMS_CONDITION} className="text-decoration-none text-muted">Terms & Conditions</NavLink></li>
            </ul>
          </div>

          <div className="col-lg-3">
            <h6 className="fw-semibold">Stay in the loop</h6>
            <p className="text-muted small">Subscribe for weekly picks and offers.</p>
            <div className="d-flex">
              <input className="form-control form-control-sm me-2" type="email" placeholder="Your email" aria-label="Subscribe" />
              <button className="btn btn-danger btn-sm">Subscribe</button>
            </div>

            <div className="mt-3">
              <a className="text-muted me-3" href="https://www.instagram.com/" aria-label="Instagram"><i className="bi bi-instagram fs-5"></i></a>
              <a className="text-muted me-3" href="https://www.facebook.com/" aria-label="Facebook"><i className="bi bi-facebook fs-5"></i></a>
              <a className="text-muted" href="https://www.youtube.com/" aria-label="YouTube"><i className="bi bi-youtube fs-5"></i></a>
            </div>
          </div>
        </div>

        <div className="row mt-4">
          <div className="col-12 text-center text-muted small">
            © {new Date().getFullYear()} MovieMax. All rights reserved.
          </div>
        </div>
      </div>
    </footer>
  );
}

