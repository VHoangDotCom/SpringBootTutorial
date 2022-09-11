# SpringBootTutorial

## Phim tat
soutv : System.out.println

## CRUD Basic - With Array List ( RestAPI-ManageEmployee ) :


## CRUD Basic - With MySQL ( CRUD_Basic):


## JPA - Relational ( JPA_Relational ): 


## Scheduler in Spring ( SchedulerSpring )


## Quartz-Schedule in Spring ( )
1. Dependencies
- Spring Web
- Spring Data JPA
- H2 Database
- Lombok
- Thymeleaf
- Quartz Scheduler

SchedulerSpring


## Quartz - Schedule ( CRUD_Basic):
1. Dependencies:
Spring Web
Quartz Scheduler


2. Cau hinh DB trong file application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/quartz_demo?useSSL=false
spring.datasource.username=root
spring.datasource.password=

// Hibernate properties ( comment = # )
spring.jpa.hibernate.dialect=org.hibernate.dialect.MySQL5InnoDBDialect
// create, create-drop
spring.jpa.hibernate.ddl-auto=update

//Quart Properties
spring.quartz.job-store-type=jdbc
spring.quartz.properties.org.quartz.threadPool.threadCount=5
#org.quartz.jobStore.driverDelegateClass = org.quartz.impl.jdbcjobstore.StdJDBCDelegate

// Mail Properties
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=hoangnvth2010033@fpt.edu.vn
spring.mail.password=

spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true


3. Tao DB trong Workbench:
- Vao tab Database click + -> MySQL -> nhap dung description cua DB
- Truy cap link : https://github.com/callicoder/spring-boot-quartz-scheduler-email-scheduling/blob/master/src/main/resources/quartz_tables.sql
Copy dung doan text vao file console
- Nhan nut execute goc ben trai -> check xem DB da ton tai chua ...
