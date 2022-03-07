package Entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;



@org.hibernate.annotations.NamedQueries({
        @org.hibernate.annotations.NamedQuery(
                name = "findAll",
                query = "FROM Entity.Student"
        )
})


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Student extends Person {
    @Column(unique = true)
    private Long studentNumber;

    @ManyToMany
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "courseandscore_id")
    )
    private Set<CourseAndScore> courseAndScoreSet;

    @Override
    public String toString() {
        return "Student{" +
                " id=" + getId() +
                ", fullName=" + getFullName() +
                ", studentNumber=" + studentNumber +
                ", username=" + getUserName() +
                ", password=" + getPassword() +
                ", courseAndScoreSet=" + courseAndScoreSet +
                '}';
    }
}
