package Entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/*
@org.hibernate.annotations.NamedQueries({
        @org.hibernate.annotations.NamedQuery(
                name = "findAll",
                query = "FROM Entity.Master"
        )
})
*/

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Master extends Person {
    @Enumerated(EnumType.STRING)
    private MasterLevel masterLevel;
    private Integer numberOfLessonTeach;
    private Long salary;

    @OneToMany(mappedBy = "master")
    private Set<Course> courseSet;
    /*@OneToMany(mappedBy = "person")
    private List<Address> addresses;
    // ManyToOne*/

    public Master(String userName, String password, String fullName,MasterLevel masterLevel,
                  Integer numberOfLessonTeach, Long salary, Set<Course> courseSet) {
        super(userName, password, fullName);
        this.masterLevel = masterLevel;
        this.numberOfLessonTeach = numberOfLessonTeach;
        this.salary = salary;
        this.courseSet = courseSet;
    }

    public Master(Long id, String userName, String password, String fullName,
                  MasterLevel masterLevel, Integer numberOfLessonTeach, Long salary, Set<Course> courseSet) {
        super(id, userName, password, fullName);
        this.masterLevel = masterLevel;
        this.numberOfLessonTeach = numberOfLessonTeach;
        this.salary = salary;
        this.courseSet = courseSet;
    }

    public Master(String userName, String password, String fullName, MasterLevel masterLevel, Integer numberOfLessonTeach, Long salary) {
        super(userName, password, fullName);
        this.masterLevel = masterLevel;
        this.numberOfLessonTeach = numberOfLessonTeach;
        this.salary = salary;
    }

    public Master(Long id, String userName, String password, String fullName, MasterLevel masterLevel, Integer numberOfLessonTeach, Long salary) {
        super(id, userName, password, fullName);
        this.masterLevel = masterLevel;
        this.numberOfLessonTeach = numberOfLessonTeach;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Master{" +
                " id=" + getId() +
                ", fullName=" + getFullName() +
                ", studentNumber=" + masterLevel +
                ", username=" + getUserName() +
                ", password=" + getPassword() +
                ", salary=" + salary +
                ", numberOfLessonTeach=" + numberOfLessonTeach +
                '}';
    }

}

