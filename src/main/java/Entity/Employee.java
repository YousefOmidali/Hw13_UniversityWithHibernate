package Entity;

import lombok.*;

import javax.persistence.*;

/*
@org.hibernate.annotations.NamedQueries({
        @org.hibernate.annotations.NamedQuery(
                name = "findAll",
                query = "FROM Entity.Employee"
        )
})
*/

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
//@ToString
@Entity
public class Employee extends Person {
    @Column(unique = true)
    private Long nationalCode;
    private Long salary;

    public Employee(Long id, String userName, String password, String fullName, Long nationalCode, Long salary) {
        super(id, userName, password, fullName);
        this.nationalCode = nationalCode;
        this.salary = salary;
    }

    public Employee(String userName, String password, String fullName, Long nationalCode, Long salary) {
        super(userName, password, fullName);
        this.nationalCode = nationalCode;
        this.salary = salary;
    }

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
