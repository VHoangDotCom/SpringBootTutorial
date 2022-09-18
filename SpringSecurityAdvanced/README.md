## Spring Security Advanced ( SpringSecurityAdvanced )
1. Dependencies
- Data JPA
- MySQL Driver
- Lombok
- Pring Web
- Spring Security

2. Database config

    spring.datasource.url=jdbc:mysql://localhost:3306/user_register?useSSL=false
    spring.datasource.username=root
    spring.datasource.password=
    
    // Hibernate properties ( comment = # )
    spring.jpa.hibernate.dialect=org.hibernate.dialect.MySQL5InnoDBDialect
    // create, create-drop
    spring.jpa.hibernate.ddl-auto=update

3. Packages
- config ( WebSecurityConfig : Config Authentication and Routes )
- controller ( RegistrationController )
- entity ( User, VerificationToken ) - listener ( RegistrationCompleteEventListener )
- event (RegistrationCompleteEvent
- model (UserModel : like ViewModel
- repository ( UserRepository, VerificationTokenRepository
- service (UserService, UserServiceImpl

==> Register
Send Link to refresh token
Verify Token
Send Link to reset password
Reset password
Change Password
Configure Web Security


