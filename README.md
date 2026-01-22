# Carpool Backend (Spring Boot)

A backend system for a carpooling application where users can register, log in, create rides, book seats, and manage bookings securely using JWT authentication.

---

## Tech Stack

- Java 17
- Spring Boot
- Spring Security (JWT Authentication)
- Spring Data JPA (Hibernate)
- MySQL
- Maven
- Postman (API testing)

---

## Features

- User registration with encrypted passwords (BCrypt)
- JWT-based authentication & authorization
- Role-based users (DRIVER / PASSENGER)
- Create and view rides
- Book and cancel ride bookings
- Seat availability management
- Secure REST APIs

---

## Project Structure

src/main/java/com/carpool/carpool

── controller
  ── AuthController.java
  ── UserController.java
  ── RideController.java
  ── BookingController.java

── model
  ── User.java
  ── Ride.java
  ── Booking.java

── repository
  ── UserRepository.java
  ── RideRepository.java
  ── BookingRepository.java

── security
  ── JwtFilter.java
  ── JwtUtil.java
  ── SecurityConfig.java

── service
  ── RideService.java
  ── BookingService.java

---

## Authentication Flow (JWT)

1. User logs in with email & password
2. Backend validates credentials
3. JWT token is generated
4. Token must be sent in headers for protected APIs

---

## API Endpoints

### Auth
| Method | Endpoint | Description |
|------|--------|------------|
| POST | `/api/auth/login` | Login & get JWT token |

### Users
| Method | Endpoint | Description |
|------|--------|------------|
| POST | `/api/users/register` | Register new user |

### Rides
| Method | Endpoint | Description |
|------|--------|------------|
| GET | `/api/rides` | Get all rides |
| POST | `/api/rides` | Create a ride |

### Bookings
| Method | Endpoint | Description |
|------|--------|------------|
| POST | `/api/bookings` | Book a ride |
| POST | `/api/bookings/cancel/{id}` | Cancel booking |

---

## How to Run Locally

###  Clone Repository
```bash
git clone https://github.com/Swalih-works/carpool-backend.git
