package Entity;

import lombok.*;

import javax.persistence.*;


@org.hibernate.annotations.NamedQueries({
        @org.hibernate.annotations.NamedQuery(
                name = "findAll",
                query = "FROM Entity.Master"
        )
})


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Master extends Person{
    @Enumerated(EnumType.STRING)
    private MasterLevel masterLevel;
    private Integer numberOfLessonTeach;
    private Long salary;

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

