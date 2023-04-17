# AtmApplication
The ATM Application is a command-line based application that simulates the basic functionalities of an Automated Teller Machine (ATM). It allows users to create accounts, deposit and withdraw money, and view their account balance.
- User authentication
- Balance inquiry
- Cash withdrawal
- Cash deposit
- Transaction histor


# Tech Stack
- Java
- Spring Framework
- Spring Boot
- Spring Data JPA
- MySQL
- Swagger UI
- Lambok
- Maven


# Modules

- Login Module
- Feedback Module
- User Module
- Bus Module
- Route Module
- Admin Module
- CurrentUser module

# Features
- Account Creation: Users can create new accounts by providing their name, phone number, and a 4-digit PIN number.

- Login: Users can log in to their account by providing their account number and PIN number.

- Deposit: Users can deposit money into their account by specifying the amount they want to deposit.

- Withdrawal: Users can withdraw money from their account by specifying the amount they want to withdraw. The application checks the user's account balance and ensures that they have sufficient funds before allowing the withdrawal.

- Balance Enquiry: Users can view their account balance by selecting the balance enquiry option.

- PIN Change: Users can change their PIN number by selecting the PIN change option and providing their current and new PIN numbers.


# Validation
- This project uses validation annotations to ensure that user input is in the correct format. The following validations are implemented:

- PIN: Must have 4 digits

- Account number: Must have 10 digits

- Amount: Must be a positive number

# Exception Handling
- Custom exceptions are used for handling errors in the application.
- A global exception handler is used to handle exceptions globally


# Installation & Run
 - Before running the API server, you should update the database config inside the application.properties file.
- Update the port number, username and password as per your local database configuration.

```
       server.port=8080

    spring.datasource.url=jdbc:mysql://localhost:3306/MasaiATM;
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.username=root
    spring.datasource.password=root

```

# API Root Endpoint
```
https://localhost:8080/
```
```
http://localhost:8080/swagger-ui/
```
