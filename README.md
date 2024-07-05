Flight Directory Management System
This project is a Spring Boot MVC application for managing flight information.

Technologies Used
Java 22
Spring Boot 3.3.1
Thymeleaf
MySQL
Bootstrap 5

What's Covered in the README

Project Structure
pom.xml
The pom.xml file is the Maven project configuration file. It specifies dependencies (spring-boot-starter-parent, spring-boot-starter-data-jpa, spring-boot-starter-web, etc.) and plugins (spring-boot-maven-plugin) needed to build and run the project. These dependencies include Spring Boot starters for web, data JPA, Thymeleaf for templating, and MySQL connector for database connectivity, and spring-boot-starter-validation to validate data entered by users or coming from other sources.

Directory Structure
src/
├── main/
│   ├── java/
│   │   └── com.springdemo.flightsMVCCRUDApplication/
│   │       ├── controller/
│   │       │   └── FlightController.java
│   │       ├── dao/
│   │       │   └── FlightRepository.java
│   │       ├── model/
│   │       │   └── Flight.java
│   │       ├── service/
│   │       │   ├── FlightService.java
│   │       │   └── FlightServiceImpl.java
│   │       └── FlightsMVCCRUDApplication.java
│   └── resources/
│       ├── templates/
│       │   └── flights/
│       │       ├── add-form.html
│       │       └── flight-list.html
│       └── application.properties
└── test/
   └── java/
       └── com.springdemo.flightsMVCCRUDApplication/
This section outlines the project's directory structure. The src/main/java folder contains the main Java source files, including:

Controllers (FlightController.java):
Handles HTTP requests and manages flight-related operations.

Data Access Objects (DAO) (FlightRepository.java): Interface that extends JpaRepository for database operations.

Model (Flight.java): Entity class representing a flight with JPA annotations.

Services (FlightService.java, FlightServiceImpl.java): Service layer interfaces and implementation containing business logic for flights.

Main Application (FlightsMVCCRUDApplication.java): Entry point of the Spring Boot application.

The src/main/resources directory contains configuration files and frontend templates (src/main/resources/templates/flights/):
Thymeleaf Templates (add-form.html, flight-list.html): HTML templates using Thymeleaf for rendering dynamic content and handling form submissions.

application.properties: Configuration file for setting up application-specific properties, including database connection details (spring.datasource.url, spring.datasource.username, spring.datasource.password).

Database Setup
Database Name: flight_directory

Run the sql script:
create database if not exists flight_directory;
use flight_directory;
drop table if exists flight;
create table flight 
(flight_no varchar(50) not null, 
airlines_name varchar(100) not null,
starting_point varchar(100) not null,
ending_point varchar(100) not null,
price int not null,
primary key(flight_no)
)
engine = InnoDB default charset= latin1;
insert into flight values
('AI 856','Air India','Ladakh ','Mumbai',10500),
('6E 5345','IndiGo','Hyderabad','New Delhi',9039),
('UK 993','Vistara','Bengaluru','Dimapur',11498),
('6E 7309','Akasa','Shillong','Ahmedabad',19590);

Tables:
flight (columns: flight_no, airlines_name, starting_point, ending_point, price)


Functionality Overview

FlightController: Manages HTTP requests (GET and POST) related to flights:
GET /flight/list: Displays a list of all flights.
GET /flight/addForm: Displays a form to add a new flight.
POST /flight/save: Handles form submission to save a new flight or update an existing one.
GET /flight/update: Retrieves flight data for updating.
GET /flight/delete: Deletes a flight.

FlightService and FlightServiceImpl: Service layer interfaces and implementation for CRUD operations (findAll(), findById(), save(), deleteById()).

Flight Model layer :
Handles the representation, validation, and persistence of flight-related data, ensuring data integrity and facilitating interaction with the database through Spring Data JPA.

FlightRepository: Spring Data JPA interface providing methods for interacting with the flight table in the database (findAll(), findById(), save(), deleteById()).

Frontend Templates (/resources/templates/flights/)
flight-list.html: Displays a table listing all flights with options to update or delete each flight.
add-form.html: Form for adding or updating flights, with client-side validation (@Valid) and error handling (BindingResult).


Running the Application

Clone the repository:
git clone <repository_url>


Configure the MySQL database:
Create a database named flight_directory.
Update application.properties with your MySQL database connection details (spring.datasource.username, spring.datasource.password).


Build and run the application using Maven:
mvn spring-boot:run
This command builds and starts the Spring Boot application on port 8089 (as configured in server.port in application.properties).


Access the application:


http://localhost:8089/flight/list
Open this URL in your web browser to view and interact with the Flight Directory Management System.


Additional Notes
Ensure Java 22 is installed on your development environment.
Thymeleaf templates (*.html) facilitate server-side rendering of dynamic content.
Bootstrap 5 (<link> in templates) is used for responsive web design and styling.
This README provides comprehensive information about your project, from its structure and dependencies to setup instructions, functionality overview, and how to run the application. It aims to guide developers and users in understanding and utilizing the Flight Directory Management System effectively. Adjust and expand this document as your project evolves or to include additional details specific to your requirements.


Flow of Components in the Application


Controller Layer (FlightController)


Purpose: Handles incoming HTTP requests related to flights and delegates the processing to appropriate services or views.


Endpoints and Actions:


GET /flight/list
Action: Retrieves all flights from the database.
Outcome: Renders the flight-list.html template, displaying a table of flights with options to update or delete each flight.


GET /flight/addForm
Action: Prepares a new Flight object for adding a new flight.
Outcome: Renders the add-form.html template, displaying a form for adding a new flight.


POST /flight/save
Action: Handles form submission to save a new flight or update an existing one.
Validation: Uses @Valid annotation to enforce validation rules specified in the Flight entity (Flight.java).
Error Handling: Uses BindingResult to capture and display validation errors in the add-form.html template if validation fails.
Outcome:
If validation passes, saves the flight using FlightService.
Redirects to GET /flight/list to display updated flight list.
If validation fails, redisplays the add-form.html template with error messages.


GET /flight/update
Action: Retrieves flight data by flight number (flightNo) for updating.
Outcome: Pre-fills the add-form.html template with existing flight data for updating.


GET /flight/delete
Action: Deletes a flight by flight number (flightNo).
Outcome: Redirects to GET /flight/list to display updated flight list after deletion.


Data Binding and Trimming:
Uses @ModelAttribute to bind form data to Flight objects in save() and update() methods.
Utilizes @InitBinder to register StringTrimmerEditor for automatic trimming of whitespace in form inputs.


Service Layer (FlightService and FlightServiceImpl)
Purpose: Contains business logic for managing flights, including CRUD operations.
Methods:
findAll(): Retrieves all flights from the database.
findById(String flightNo): Retrieves a flight by its flight number (flightNo).
save(Flight flight): Saves a new flight or updates an existing one.
deleteById(String flightNo): Deletes a flight by its flight number (flightNo).
Implementation (FlightServiceImpl):
Uses FlightRepository (JPA repository) to interact with the database for CRUD operations.


Data Access Layer (FlightRepository)
Purpose: Extends JpaRepository<Flight, String> to provide built-in methods for CRUD operations on the Flight entity.
Methods Inherited:
findAll(), findById(String id), save(Flight entity), deleteById(String id): Standard CRUD methods provided by Spring Data JPA.


Model Layer (Flight Entity)
Purpose: Represents the flight table in the database using JPA annotations (@Entity, @Table, @Id, @Column, @NotNull, @Size, @Min, @Max).
Fields:
flightNo: Flight number (primary key).
airlinesName: Name of the airline.
startingPoint, endingPoint: Departure and arrival locations.
ticketPrice: Price of the flight ticket.


Frontend (Thymeleaf Templates)
Purpose: Provides HTML templates for rendering views and handling user interactions.
Templates:
flight-list.html: Displays a table listing all flights with options to update or delete each flight.
add-form.html: Form for adding or updating flights, with client-side validation and error handling.
Bootstrap 5: Integrated for responsive design and styling of HTML elements.


Flow Summary
User Interaction:
Users interact with the application through web browsers by accessing URLs defined in FlightController.


Controller Handling:
FlightController processes HTTP requests (GET, POST) and delegates operations to FlightService.


Service Layer:
FlightService implements business logic, utilizing FlightRepository for database operations.


Database Operations:
FlightRepository interacts with the database (flight_directory) using Spring Data JPA, performing CRUD operations on Flight entities.


Data Presentation:
Data is presented to users through Thymeleaf templates (flight-list.html, add-form.html) styled with Bootstrap 5.


Flow Completion:
The flow completes with user interactions resulting in data manipulation (add, update, delete) reflected in the database and presented in the UI.


This flow diagram illustrates the seamless integration of components within your Spring Boot MVC CRUD application, facilitating efficient management of flight information. Adjustments and enhancements can be made based on specific requirements or future feature developments.
