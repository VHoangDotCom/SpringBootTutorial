## Upload and Download file in Spring Boot ( UploadDownloadFile )
1. Dependencies
- Lombok
- Spring web
- MySQL Driver
- Spring Data JPA
2. Config application.properties
   spring.servlet.multipart.enabled=true

spring.datasource.url= jdbc:mysql://localhost:3306/file_db?useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false
spring.datasource.username= root
spring.datasource.password=

spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5InnoDBDialect
spring.jpa.hibernate.ddl-auto= update


spring.servlet.multipart.enabled=true

// Threshold after which files are written to disk.
spring.servlet.multipart.file-size-threshold=2KB
// Max file size.
spring.servlet.multipart.max-file-size=200MB
#Max request size
spring.servlet.multipart.max-request-size=215MB

3. Create Package ( controller, entity, service, repository )

4. Right Click main package -> new -> Servlet -> Servlet -> named it
   Right Click model -> new -> java class -> ResponseData

5. Test API
- Upload File (Post) : http://localhost:8080/upload
  Body -> form-data -> Key:file -> Value:File-> Choose file
- Download File (Get) : http://localhost:8080/download/{fileId}

6. Export data to excel
- Create Entity ( Customer + Address )
- Create Excel Styling ( ExcelExportUtils )
- Create Repository ( CustomerRepository )
- Create Service ( CustomerService )
- Create Seeding file ( CustomerSeeding )

7. Upload File to Cloudinary

        <dependency>
           <groupId>com.cloudinary</groupId>
           <artifactId>cloudinary-http44</artifactId>
           <version>1.29.0</version>
        </dependency>

        <dependency>
            <groupId>com.cloudinary</groupId>
            <artifactId>cloudinary-taglib</artifactId>
            <version>1.29.0</version>
        </dependency>

         <!-- Apache Commons Upload -->
        <dependency>
            <groupId>commons-fileupload</groupId>
            <artifactId>commons-fileupload</artifactId>
            <version>1.2.2</version>
        </dependency>

        <!-- Apache Commons Upload -->
        <dependency>
            <groupId>commons-io</groupId>
            <artifactId>commons-io</artifactId>
            <version>1.3.2</version>
        </dependency>

8. Create ConfigFile

9. Dump Data into Database