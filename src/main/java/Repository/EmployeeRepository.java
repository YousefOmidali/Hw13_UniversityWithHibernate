package Repository;

import Entity.Employee;
import SessionFactory.SessionFactorySingleton;
import org.hibernate.SessionFactory;

public class EmployeeRepository extends GenericRepositoryImpl<Employee,Long>{
    private SessionFactory sessionFactory = SessionFactorySingleton.getInstance();



    public void findById(Integer id) {
        try (var session = sessionFactory.openSession()) {
            session.beginTransaction();

            var a = session.find(Employee.class, id);
            System.out.println(a);
            session.getTransaction().commit();
        }
    }

    public void findAll() {
        try(var session = sessionFactory.openSession()){
            var query = session.createNamedQuery("findAll", Employee.class);
            query.getResultStream().forEach(System.out::println);
        }

    }
}
