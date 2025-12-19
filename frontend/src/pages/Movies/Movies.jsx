import React, { useState } from 'react';
import PageHero from '../../components/PageHero';
import CardComp from '../../components/CardComp';
import Filter from '../../components/Filter';

export default function Movies() {
    const [filters, setFilters] = useState({
        status: "",
        category: "",
        rating: ""
    });               

    return (
        <>
            <PageHero title="Browse Movies" subtitle="Discover popular, upcoming and trending releases" image="/images/theatre-photo.jpg" height="28vh" />
            <div className='container'>
                <div className='row gx-5 align-items-start'>
                    <div className='col-3 d-none d-lg-inline-block'>
                        <Filter filters={filters} setFilters={setFilters}/>
                    </div>
                    <div className='col-lg-9'>
                        <CardComp filters={filters}/>
                    </div>
                </div>
            </div>
        </>
    )
}
