# My Health Application

## Overview
My Health Application is a Spring Boot-based web application designed for managing user profiles, addresses, mobile verification, Aadhaar authentication, and QR code generation for sharing health records. The application enables users to register, log in, update their profiles, and manage addresses efficiently.

## Features
- User registration with mobile number and Aadhaar verification.
- Mobile number verification through OTP.
- Secure login using mobile number and Aadhaar number.
- Profile management for updating user information.
- Address management to add and retrieve user addresses.
- QR code generation for sharing user profiles.

## Technologies Used
- Java 17
- Spring Boot
- Spring Data JPA
- H2 Database (in-memory)
- Twilio (for SMS OTP service)
- ZXing (for QR code generation)

## Prerequisites
- Java Development Kit (JDK) 17 or higher
- Maven (for building the application)
- IDE (e.g., IntelliJ IDEA, Eclipse)

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/my-health-application.git
   cd my-health-application
