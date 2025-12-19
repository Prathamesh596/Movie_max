// import React from 'react'
// import Banner from '../../components/Banner'
// import SliderComp from '../../components/SliderComp'
// import Box from '../../components/Box'
// import { getMovies } from '../../services/MovieService'

// export default function Home() {
//     return (
//         <>
//             <Banner />
//             <SliderComp heading="Upcoming" getMovies={() => getMovies("Upcoming")} show={true} />
//             <SliderComp heading="Now Playing" getMovies={() => getMovies("NowPlaying")} />
//             <Box />
//             <SliderComp heading="Popular Movies" getMovies={() => getMovies("Popular")} />
//         </>
//     )
// }
import React, { useEffect, useState } from "react";
import Banner from "../../components/Banner";
import SliderComp from "../../components/SliderComp";
import Box from "../../components/Box";
import { getMovies } from "../../services/MovieService";

export default function Home() {
  const [upcoming, setUpcoming] = useState([]);
  const [nowPlaying, setNowPlaying] = useState([]);
  const [popular, setPopular] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const fetchMovies = async () => {
      try {
        const [up, now, pop] = await Promise.all([
          getMovies("Upcoming"),
          getMovies("NowPlaying"),
          getMovies("Popular"),
        ]);

        setUpcoming(up);
        setNowPlaying(now);
        setPopular(pop);
      } catch (error) {
        console.error("Failed to load movies", error);
      } finally {
        setLoading(false);
      }
    };

    fetchMovies();
  }, []);

  return (
    <>
      <Banner />

      <SliderComp
        heading="Upcoming"
        movies={upcoming}
        loading={loading}
        show={true}
      />

      <SliderComp
        heading="Now Playing"
        movies={nowPlaying}
        loading={loading}
      />

      <Box />

      <SliderComp
        heading="Popular Movies"
        movies={popular}
        loading={loading}
      />
    </>
  );
}
