import React, { useEffect, useState } from 'react'
import { NavLink, useSearchParams } from 'react-router-dom';
import { getMovieByTitle } from '../../services/MovieService';
import { getImageUrl } from '../../constants/ApiConstants';
import PageHero from '../../components/PageHero';
import moment from 'moment';

export default function Search() {
    const [data, setData] = useState([]);
    const [searchParams] = useSearchParams();
    const query = searchParams.get("q");

    async function getData() {
        let res = await getMovieByTitle(query);
        // console.log(res);

        setData(res.data);
    }

    useEffect(() => {
        getData();
    }, [query]);

    return (
        <>
            <PageHero title={`Search: ${query || ''}`} subtitle="Find movies and shows" image="/images/theatre-photo.jpg" height="24vh" />
            <div className='container'>
                <h2 className='fw-bold my-4'>Search Results</h2>
                <div className='row align-items-start gy-4 mb-5'>
                    {
                        data.map((val, index) => {
                            return (
                                <div key={index} className='col-lg-3 col-md-4 col-sm-6'>
                                    <NavLink to={`/movie_details/${val.id}`} className="text-decoration-none">
                                        <div className='card border-0'>
                                            <img src={getImageUrl(val.poster_path, 'min')} className='card-img anim-scale w-100' alt={val.title} />
                                            <div className='card-body p-0 pt-2'>
                                                <h5 className='card-title text-wrap'>{val.title}</h5>
                                                <p>
                                                    {moment(val.release_date).format('MMM Do YYYY')}
                                                    <span className='badge text-bg-dark float-end'>Ratng {Number(val.vote_average).toFixed(1)}</span>
                                                </p>
                                            </div>
                                        </div>
                                    </NavLink>
                                </div>
                            )
                        })
                    }
                </div>
            </div>
        </>
    )
}
