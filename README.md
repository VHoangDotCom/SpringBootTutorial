# SpringBootTutorial

## Phim tat
soutv : System.out.println


## CRUD Basic - With Array List ( RestAPI-ManageEmployee ) 



## CRUD Basic - With MySQL ( CRUD_Basic )



## JPA - Relational ( JPA_Relational )



## Scheduler in Spring ( SchedulerSpring )



## Quartz-Schedule in Spring ( QuartzScheduler )



## ElasticSearch in Spring
* Choose Gradle project instead of Maven in setting step
1. Dependencies
- Spring Data Elasticsearch ( Access + Driver )
- Spring Web
2. Turn ElasticSearch on
- C:\Users\Admin\Downloads\elasticsearch-8.1.3-windows-x86_64\elasticsearch-8.1.3\bin
- Click Elasticseach.bat
3. Create package Configuration + Document + Helper + Repository + Service
- Create config file
- Person ( Document )
- ...
4. Create es-settings.json file in static folder



## Spring Security with JWT ( SpringSecurity )


## Spring Send Mail( SendMail )


## Spring Security Advanced ( SpringSecurityAdvanced )


## OAuth2 Spring Security using Facebook ( )
1. Create App in Facebook for developer ( https://developers.facebook.com/ )
My Apps -> Enter App Name -> Facebook Login -> Others -> Dashboard -> Setting -> Save change


## Deploy SpringBoot to AWS Elastic Beanstalk ( CRUD_Basic )
1. Open CRUD_Basic project

2. Check API in localhost again

3. mvn clean install  in terminal
=> Check folder target -> jar file

4. Enter console.aws.amazon.com


## Upload and Download file in Spring Boot ( UploadDownloadFile )


## SpringBoot - ReactJS - Talwind CSS
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