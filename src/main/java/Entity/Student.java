package Entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/*
@org.hibernate.annotations.NamedQueries({
        @org.hibernate.annotations.NamedQuery(
                name = "findAll",
                query = "FROM Entity.Student"
        )
})
*/

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Student extends Person {
    @Column(unique = true)
    private Long studentNumber;
    private Boolean isExcellent;

    @OneToMany(mappedBy = "student")
    private List<Course> courseList;

//    @ManyToMany
//    @JoinTable(
//            name = "student_course",
//            joinColumns = @JoinColumn(name = "student_id"),
//            inverseJoinColumns = @JoinColumn(name = "courseandscore_id"))
//    private Set<Course> courseAndScoreSet;


    public Student(String userName, String password, String fullName, Long studentNumber, Boolean isExcellent) {
        super(userName, password, fullName);
        this.studentNumber = studentNumber;
        this.isExcellent = isExcellent;
    }

    public Student(String userName, String password, String fullName, Long studentNumber,
                   Boolean isExcellent, List<Course> courseList) {
        super(userName, password, fullName);
        this.studentNumber = studentNumber;
        this.isExcellent = isExcellent;
        this.courseList = courseList;
    }

    public Student(Long id, String userName, String password, String fullName, Long studentNumber, Boolean isExcellent) {
        super(id, userName, password, fullName);
        this.studentNumber = studentNumber;
        this.isExcellent = isExcellent;
    }

    @Override
    public String toString() {
        return "Student{" +
                " id= " + getId() +
                ", fullName= " + getFullName() +
                ", studentNumber= " + studentNumber +
                ", username= " + getUserName() +
                ", password= " + getPassword() +
                ", courseList= " + courseList +
                ", isExcellent= " + isExcellent +
                '}';
    }
}
