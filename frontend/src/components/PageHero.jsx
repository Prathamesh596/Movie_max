import React from 'react';

export default function PageHero({ title, subtitle, image, height = '36vh', children }) {
  const bgStyle = image ? { backgroundImage: `url('${image}')`, backgroundSize: 'cover', backgroundPosition: 'center' } : {};

  return (
    <section className="page-hero" style={{ position: 'relative', height: height, ...bgStyle }}>
      <div style={{ position: 'absolute', inset: 0, background: 'linear-gradient(180deg, rgba(2,6,23,0.6), rgba(2,6,23,0.3))' }} />
      <div style={{ position: 'relative', zIndex: 2, display: 'flex', alignItems: 'center', height: '100%' }}>
        <div className="container">
          <div className="hero-content">
            <h1 className="mb-2">{title}</h1>
            {subtitle && <p className="lead">{subtitle}</p>}
            {children}
          </div>
        </div>
      </div>
    </section>
  );
}
