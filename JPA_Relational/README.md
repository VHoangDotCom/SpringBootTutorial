
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
Chúng ta sử dụng sequence-generator để có cấu hình cách tạo ra các giá trị cho khóa chính.
Như ta thấy ở ví dụ Identify Generation. Thì thứ tự bắt đầu là 1 , sau đó tăng lên 2,3,4.
Khi sử dụng sequence-generator ta hoàn toàn có thể thay đổi lại bước nhảy . Như ví dụ bên
dưới, ta yêu cầu giá trị ban đầu là 4 (@Parameter(name = “initial_value”, value = “4”).
Và ta muốn mỗi lần tăng là 2 đơn vị @Parameter(name = “increment_size”, value = “2”). Như
vậy giá trị của userId sẽ là : 4,6,8,10.

==> Recommend develop along with this structure

7. Tao Database ao tranh viec dong den Database that
- Dependency (pom.xml)

<dependency>
<groupId>com.h2database</groupId>
<artifactId>h2</artifactId>
<scope>test</scope>
</dependency>

- Chuot phai test -> new -> Directory -> resources -> Them file application.properties

- Config properties file
  spring.datasource.url=jdbc:h2://mem:db:testdb;DB_CLOSE_DELAY=-1
  spring.h2.console.enabled=true
  spring.datasource.username=sa
  spring.datasource.password=
  spring.datasource.driver-class-name=org.h2.Driver

logging.level.org.hibernate.SQL = debug

// create, create-drop
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
// Hibernate properties ( comment = # )
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5InnoDBDialect

8. Mockito
- StudentService -> chuot phai -> Create New Test
- Add @Disable truoc cac Test khong muon chay
