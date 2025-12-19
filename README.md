🎬 MovieMax - Fullstack Movie Booking Application

MovieMax is a full-stack web application for browsing movies, viewing details, and booking tickets. It is built using Java Spring Boot for the backend, ReactJS for the frontend, and uses Bootstrap for styling. The application integrates APIs with Axios and handles Promises in JavaScript for dynamic content.

🌟 Features

Browse trending, upcoming, and now-playing movies.

View detailed movie information and images.

Book tickets for movies with seat selection.

User authentication and profile management.

Search movies using external APIs (TMDB & YouTube).

Responsive design using Bootstrap.

Handles asynchronous requests using Axios and Promises.

🛠 Technology Stack
Layer	Technology / Tools
Frontend	ReactJS, JavaScript, Bootstrap
Backend	Java, Spring Boot, REST APIs
Database	MySQL / H2
API Calls	Axios, Promises
Version Control	Git, GitHub
📁 Project Structure
Backend (Spring Boot)
com.moviemax
│
├─ controller   # REST controllers for movies, users, bookings
├─ service      # Business logic for services
├─ repository   # JPA repositories for database operations
├─ model        # Entity classes for movies, users, bookings
└─ BackendApplication.java

Frontend (ReactJS)
src/
│
├─ components   # React components for UI (Navbar, MovieCard, etc.)
├─ pages        # Pages like Home, MovieDetails, Booking
├─ services     # Axios API calls for backend and external APIs
├─ App.js       # Main React component
└─ index.js     # Entry point

🚀 Getting Started
Prerequisites

Java 11+

Node.js & npm

MySQL (or H2 database for testing)

Git

Backend Setup

Clone the repository:

git clone https://github.com/Prathamesh596/Movie_max.git
cd Movie_max/backend


Configure application.properties with your database credentials:

spring.datasource.url=jdbc:mysql://localhost:3306/moviemax
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update


Run the Spring Boot application:

./mvnw spring-boot:run


Backend will run at: http://localhost:8080

Frontend Setup

Navigate to frontend folder:

cd ../frontend


Install dependencies:

npm install


Start React development server:

npm start


Frontend will run at: http://localhost:3000

🌐 API Usage

Movie APIs: /movies/trending, /movies/upcoming, /movies/nowplaying

User APIs: /user/signup, /user/login

Booking APIs: /bookings/create, /booked-seats/{movieId}

Frontend uses Axios for fetching data from backend and external APIs (TMDB, YouTube). All API calls handle Promises for async operations.

🎨 UI & Styling

Bootstrap 5 is used for responsive UI components.

Components include Navbar, Movie Cards, Booking Form, Seat Selector, etc.

Works on desktop, tablet, and mobile screens.

📌 Notes

Make sure TMDB API key is set in frontend environment variables (VITE_TMDB_API_KEY).

Google API key for YouTube search should be set as VITE_GOOGLE_API_KEY.

Ensure CORS is enabled in Spring Boot for frontend to access APIs.

🔧 How It Works

ReactJS frontend requests movie data via Axios.

Spring Boot backend fetches data from database or external APIs (TMDB/YouTube) and returns JSON.

Frontend renders movies, handles booking, and manages users.

Asynchronous requests are managed using Promises in JavaScript.

Users can select seats and book tickets, which are saved in backend database.

📚 Learning Outcomes

Build full-stack applications with Java Spring Boot and ReactJS.

Work with RESTful APIs and external APIs.

Handle asynchronous JavaScript with Promises and Axios.

Implement responsive UI using Bootstrap.

Understand frontend-backend integration and database handling.

📝 Author

Prathamesh
GitHub: https://github.com/Prathamesh596
