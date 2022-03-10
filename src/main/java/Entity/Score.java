package Entity;

import lombok.*;

import javax.persistence.*;

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
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double score;

    @ManyToOne
    private Course course;

    @ManyToOne
    private Master master;

    @ManyToOne
    private Student student;

}
