## SpringBoot - ReactJS - Tailwind CSS
1.Dependencies
- Lombok
- Spring Data JPA
- MySQL Driver
- Spring Web

2. Create react app
   npx create-react-app employee_frontend

3. application.properties

spring.datasource.url=jdbc:mysql://localhost:3306/employee_system?useSSL=false
spring.datasource.username=root
spring.datasource.password=

// Hibernate properties
spring.jpa.hibernate.dialect=org.hibernate.dialect.MySQL5InnoDBDialect
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
// create, create-drop
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

4. Follow this to Install TailWind CSS
   https://tailwindcss.com/docs/guides/create-react-app

5. Create Navbar + Create Form in React
   npm install axios
   npm install react-router-dom@6