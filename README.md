# SpringBootTutorial

## Phim tat
soutv : System.out.println

## CRUD Basic - With Array List ( RestAPI-ManageEmployee ) :
1. Dependencies:
spring-boot-starter-web
lombok
spring-boot-starter-test

2. Tao Package Entity
User

3. Tao Package Controller
Cac API CRUD trong Controller ( CRUD Search )

4. Tao Package Service
UserService ( interface function from ServiceImpl)
UserServiceImpl ( execute controller )


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


## JPA - Relational ( JPA_Relational ):
1. Dependencies:
Lombok
Spring Web
Spring Data JPA
MySQL Driver

2. Tao cac Package tu package parent: 

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

4. Chay Main Method, Check Database co cac cot chua 

5. Tao 1 JUnitTest cua Repository
chuot phai ten class -> Generate -> Test... -> 

@SpringBootTest
@DataJdbcTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("vh@gmail.com")
                .firstName("Shabbit")
                .lastName("Dawoodi")
                .guardianName("Nikhil")
                .guardianEmail("nikki@gmail.com")
                .guardianMobile("032434234")
                .build();
        
        studentRepository.save(student);
    }
}
==> recommend dung Test ( bo qua cac buoc tao ham trong Service va ServiceImpl
			dong thoi ko phai set method trong controller )

6. Dinh nghia cac Annotation
@Embeddable : annotation @Embeddable để khai báo rằng một lớp sẽ được nhúng bởi 
các entity(Thực thể) khác.

@Embeddable
public class ContactPerson {

    private String firstName;

    private String lastName;

    private String phone;

    // standard getters, setters
}

@Embedded : Annotation @Embedded được sử dụng để khai báo rằng nhúng thực thể 
được đánh dấu @Embeddable ở phía trên vào thực thể ở dưới đây.

@Entity
public class Company {
    @Id   @GeneratedValue   private Integer id;
    private String name;
    private String address;
    private String phone;
    @Embedded  private ContactPerson contactPerson;

    // standard getters, setters
}

@AttributeOverrides
Vấn đề là các trường của ta được gọi là những thứ như contactFirstName trong lớp
Company ban đầu của ta và bây giờ là firstName trong lớp ContactPerson của chúng
tôi . Vì vậy, JPA sẽ muốn ánh xạ những thứ này thành contact_first_name và 
first_name, tương ứng.

Tuy nhiên như hai lớp ở trên ta đều có cột điện thoại phone vì vậy ghi đè lên nó 
sẽ trùng lặp

Giải pháp ở đây là ta sử dụng @AttributeOverrides và @AttibuteOverride để ghi đè 
các thuộc tính cột của kiểu embedded của ta.

@Embedded
@AttributeOverrides({
  @AttributeOverride( name = "firstName", column = @Column(name = "contact_first_name")),
  @AttributeOverride( name = "lastName", column = @Column(name = "contact_last_name")),
  @AttributeOverride( name = "phone", column = @Column(name = "contact_phone"))
})
private ContactPerson contactPerson;

@Builder
@Builder annotation trong project lombok sẽ giúp chúng ta triển khai Builder pattern 
mà không cần phải viết thêm bất kỳ đoạn code nào. @Builder có thể sử dụng trên class 
hoặc method,

@SequenceGenerator
The SequenceGenerator annotation defines a primary key generator that may be 
referenced by name when a generator element is specified for the GeneratedValue 
annotation. A sequence generator may be specified on the entity class or on the 
primary key field or property. The scope of the generator name is global to the 
persistence unit (across all generator types).

