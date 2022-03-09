package Entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
/*
@org.hibernate.annotations.NamedQueries({
        @org.hibernate.annotations.NamedQuery(
                name = "findAll",
                query = "FROM Entity.Course"
        )
})
*/

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String courseName;
    private Integer unit;

    @ManyToOne
    private Master master;

    @OneToMany(mappedBy = "course")
    private List<Score> scoreList;

    @ManyToOne
    private Student student;

    public Course(String courseName, Integer unit, Master master) {
        this.courseName = courseName;
        this.unit = unit;
        this.master = master;
    }


}
