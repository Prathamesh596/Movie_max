import React, { useEffect, useState } from 'react';
import moment from 'moment';
import Slider from 'react-slick';
import 'slick-carousel/slick/slick.css';
import 'slick-carousel/slick/slick-theme.css';
import { getImageUrl } from '../constants/ApiConstants';
import { NavLink } from 'react-router-dom';

// CSS
import '../pages/Home/Home.css';

export default function SliderComp({ heading, getMovies, show }) {
  const [data, setData] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(false);

  useEffect(() => {
    let isMounted = true;

    const fetchMovies = async () => {
      try {
        setLoading(true);
        const res = await getMovies();
        if (isMounted) {
          setData(res?.data || []);
        }
      } catch (err) {
        console.error(`Failed to load ${heading}`, err);
        if (isMounted) setError(true);
      } finally {
        if (isMounted) setLoading(false);
      }
    };

    fetchMovies();

    return () => {
      isMounted = false;
    };
  }, [getMovies, heading]);

  if (loading) {
    return (
      <div className="container">
        <h2 className="fw-bold mt-5 mb-4">{heading}</h2>
        <p>Loading movies...</p>
      </div>
    );
  }

  if (error || data.length === 0) {
    return (
      <div className="container">
        <h2 className="fw-bold mt-5 mb-4">{heading}</h2>
        <p>No movies available</p>
      </div>
    );
  }

  const settings = {
    arrows: true,
    infinite: true,
    speed: 500,
    slidesToShow: 4,
    slidesToScroll: 1,
    responsive: [
      {
        breakpoint: 1024,
        settings: { slidesToShow: 3, arrows: true }
      },
      {
        breakpoint: 768,
        settings: { slidesToShow: 2, arrows: false }
      },
      {
        breakpoint: 480,
        settings: { slidesToShow: 1, arrows: false }
      }
    ]
  };

  return (
    <div className="container">
      <h2 className="fw-bold mt-5 mb-4">{heading}</h2>

      <div className="row mb-5">
        <Slider {...settings}>
          {data.map((val, index) => (
            <NavLink
              to={`/movie_details/${val.id}`}
              key={val.id}
              className="text-decoration-none"
            >
              <div className="card border-0 movie-card">
                <img
                  src={getImageUrl(val.poster_path, 'min')}
                  alt={val.title}
                  className="card-img"
                  loading="lazy"
                  onError={(e) => {
                    e.target.src = '/images/no-poster.png';
                  }}
                />

                {show && (
                  <div className="card-img-overlay p-0">
                    <p className="text-bg-dark w-50 rounded-end p-1 px-2 mt-2">
                      # {index + 1} Trending
                    </p>
                  </div>
                )}

                <div className="movie-overlay">
                  <h6 className="mb-1">{val.title}</h6>
                  <div className="d-flex justify-content-between align-items-center">
                    <small className="text-muted">
                      {moment(val.release_date).format('MMM Do YYYY')}
                    </small>
                    <span className="badge bg-dark">
                      ⭐ {Number(val.vote_average || 0).toFixed(1)}
                    </span>
                  </div>
                </div>
              </div>
            </NavLink>
          ))}
        </Slider>
      </div>
    </div>
  );
}
