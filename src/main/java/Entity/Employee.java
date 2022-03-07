package Entity;

import lombok.*;

import javax.persistence.*;


@org.hibernate.annotations.NamedQueries({
        @org.hibernate.annotations.NamedQuery(
                name = "findAll",
                query = "FROM Entity.Employee"
        )
})

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Employee extends Person{
    @Column(unique = true)
    private Long nationalCode;
    private Long salary;

    @Override
    public String toString() {
        return "Employee{" +
                " id=" + getId() +
                ", fullName=" + getFullName() +
                ", nationalCode=" + nationalCode +
                ", username=" + getUserName() +
                ", password=" + getPassword() +
                ", salary=" + salary +
                '}';
    }

}
