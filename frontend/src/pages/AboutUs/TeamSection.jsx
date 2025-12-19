import React from 'react';
import './TeamSection.css';

const teamMembers = [
  {
    name: 'Prathamesh P',
    image: '/images/member1.png',
    email: 'prathaam19@gmail.com',
    linkedin: 'https://www.linkedin.com/in/prathamesh96',
    github: 'https://github.com/Prathamesh596',
  }
];

const TeamSection = () => {
  return (
    <section className="team-section" id="team">
      <div className="container">
        <h2 className="text-center mb-4">Meet Me</h2>
        <div className="row justify-content-center">
          {teamMembers.map((member, index) => (
            <div className="col-md-4 mb-4" key={index}>
              <div className="card">
                <img
                  src={member.image}
                  alt={member.name}
                  className="card-img-top team-member-img"
                  style={{ width: '100%', height: '450px', objectFit: 'cover' }}
                />
                <div className="card-body text-center">
                  <h5 className="card-title">{member.name}</h5>
                  <p className="card-text">
                    <a href={`mailto:${member.email}`}>{member.email}</a> {/* Email link */}
                  </p>
                  <div className="social-links">
                    <a href={member.linkedin} target="_blank" rel="noopener noreferrer">
                      <img
                        src="/images/linkedin-icon.png"
                        alt="LinkedIn"
                        className="social-icon"
                      />
                    </a>
                    <a href={member.github} target="_blank" rel="noopener noreferrer">
                      <img
                        src="/images/github-icon.png"
                        alt="GitHub"
                        className="social-icon"
                      />
                    </a>
                  </div>
                </div>
              </div>
            </div>
          ))}
        </div>
      </div>
    </section>
  );
};

export default TeamSection;
