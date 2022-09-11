## CRUD Basic - With MySQL ( CRUD_Basic):
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

// Hibernate properties ( comment = # )
spring.jpa.hibernate.dialect=org.hibernate.dialect.MySQL5InnoDBDialect
// create, create-drop
spring.jpa.hibernate.ddl-auto=update

4. Create JPA Entity ( Trong Models )
   re-run Main Method => Create Entity ( Code first )
   *Note:
   Giả sử nếu bạn đã sử dụng @Data annotation rồi, nhưng bạn không muốn loại bỏ các
   getter() method trong class chẳng hạn,  hay muốn thay thế @RequireArgsConstructor
   bằng @AllArgsConstructor?

Thật may mắn, bạn có thể chỉ đinh những annotation khác mà Lombok cung cấp, nếu có
sự xung đột giữa @Data và các annotation khác thì chúng sẽ được ưu tiên sử dụng hơn
là của @Data.

5. Create Repository ( Trong Repository package )

6. Create Custom Exception

7. Create Service ( trong folder Service )
   Crete ServiceImpl ( trong folder ServiceImpl )

8. Create Controller
- Build RestFul API CRUD in Controller
- Co the dung method query trong repository file

