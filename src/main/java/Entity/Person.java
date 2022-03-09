package Entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
@MappedSuperclass
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String userName ;
    private String password ;
    private String fullName ;

    public Person(String userName, String password, String fullName) {
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
    }

    public Person(Long id, String userName, String password, String fullName) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
    }
}
