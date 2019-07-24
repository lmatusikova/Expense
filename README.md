# ExpenseManagement

Spring Boot application is demonstrating how to implement CRUD operations with 4 entities (User, Role, Expense, Category) and spring security.

## What`s inside

This project is based on the [Spring Boot](http://projects.spring.io/spring-boot/) project and uses these packages :
- Maven
- Spring Core
- Spring Data (Hibernate & MySQL)
- Spring security
- Jwt token
- Ibatis - running scripts

### Installation

The project is created with Maven, so you just need to import it to your IDE and build the project to resolve the dependencies.

### Database configuration
Create a MySQL database with the name `root` and add the credentials to `/resources/application.properties`.  
The default ones are :

```
spring.datasource.url=jdbc:mysql://localhost:3306/expensemanagement
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL57Dialect
```

## Usage
Script `data.sql` creates tables and fills them with sample data before running the application.

### Authors

* **Lucia Matusikova** - *Initial work* - [lmatusikova](https://github.com/lmatusikova)
