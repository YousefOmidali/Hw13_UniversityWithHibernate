package Entity;

import lombok.*;

import javax.persistence.*;


@org.hibernate.annotations.NamedQueries({
        @org.hibernate.annotations.NamedQuery(
                name = "findAll",
                query = "FROM Entity.CourseAndScore"
        )
})


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class CourseAndScore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer score;
    private String courseName;
    private Integer unit;

    @ManyToOne
    private Master master;



}
