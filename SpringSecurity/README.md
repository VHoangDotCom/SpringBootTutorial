
## Spring Security with JWT ( SpringSecurity )
1. Dependencies
- Spring Data JPA
- MySQL Driver
- Spring Web
- Spring Security
- Spring Boot DevTools
- Lombok

2. Create Entity (domain) User - Role : n - n
- User
- Role
* FetchType.EAGER: When you load User table from database, it will automatically load Role table
  as well.
* FetchType.LAZY : When you load User table from database, it just loads User from DB, you have
  to call getAllRoles() from User to get their roles.

3. Create Service + Repository

4. Create APi ( Controller )

5. Configuration DB
   spring.datasource.url=jdbc:mysql://localhost:3306/userservice?useSSL=false
   spring.datasource.username=root
   spring.datasource.password=
   // Hibernate properties ( comment = # )
   spring.jpa.hibernate.dialect=org.hibernate.dialect.MySQL5InnoDBDialect
   // create, create-drop
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.hibernate.format_sql=true

6. Run Program => check created DB

7. Access this link : http://localhost:8080/login
   check login form

8. Create JWT ( Json Web Token )

9. Search dependency
   -( oauth java jwt :  https://mvnrepository.com/artifact/com.auth0/java-jwt )

10. Create Security Config ( chu y config )
- Configure the path and role of them

11. Filter ( folder quan trong nhat trong JWT )
- CustomAuthenticationFilter
- CustomAuthorizationFilter

12. How to use Postman
- Login ( http://localhost:8080/api/login )
  Method : Post
  Body : +) x-www-form-urlencoded
  KEY : username, password
  VALUE : hoang, hoang ( Enter your account )

- Get List Users : ( http://localhost:8080/api/users )
  Method : GET
  Headers : KEY : Authorization
  Value : Bearer 'access_token' ( get from login )

- Create new User : ( http://localhost:8080/api/user/save )
  Method : POST
  Headers : KEY : Authorization
  Value : Bearer 'access_token' ( get from login )
  Body : +) raw -> json ...

- Create new Role : ( http://localhost:8080/api/role/save )
  Method : POST
  Headers : KEY : Authorization
  Value : Bearer 'access_token' ( get from login )
  Body : +) raw -> json ...

- 