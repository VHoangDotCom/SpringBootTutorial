# SpringBootTutorial

## CRUD Basic - With Array List ( CRUD-ArrayList branch ) :
1. Dependencies:
spring-boot-starter-web
lombok
spring-boot-starter-test

2. Tao Package Entity
User

3. Tao Package Controller
Cac API CRUD trong Controller ( CRUD Search )

4. TAo Package Service
UserService ( interface function from ServiceImpl)
UserServiceImpl ( execute controller )


## CRUD Basic - With MySQL ( CRUD_MYSQL_JPA branch ):
1. Dependencies:
Lombok
Spring Web
Spring Data JPA
MySQL Driver

2. Tao cac Package tu package parent:
controllers, services, models, repositories, services ( services.impl ), exceptions

3. Cau hinh Database
 - Tao database rong trong MySQL ( WorkBench )
 - Them doan sau vao application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/<ten database>?useSSL=false
spring.datasource.username=root
spring.datasource.password=

# Hibernate properties
spring.jpa.hibernate.dialect=org.hibernate.dialect.MySQL5InnoDBDialect
# create, create-drop
spring.jpa.hibernate.ddl-auto=update

4. Create JPA Entity ( Trong Models )
re-run Main Method => Create Entity ( Code first )

5. Create Repository ( Trong Repository package )

6. Create Custom Exception

7. Create Service ( trong folder Service )
Crete ServiceImpl ( trong folder ServiceImpl )

8. Create Controller
 - Build RestFul API CRUD in Controller
