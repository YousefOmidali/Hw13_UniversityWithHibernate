package Repository;

import Entity.Employee;
import Entity.Student;
import org.hibernate.SessionFactory;
import SessionFactory.SessionFactorySingleton;


public class StudentRepository extends GenericRepositoryImpl<Student, Long> {
    private SessionFactory sessionFactory = SessionFactorySingleton.getInstance();

    public void findById(Integer id) {
        try (var session = sessionFactory.openSession()) {
            session.beginTransaction();

            var a = session.find(Student.class, id);
            System.out.println(a);
            session.getTransaction().commit();
        }
    }

    public void findAll() {
        try (var session = sessionFactory.openSession()) {
            var query = session.createNamedQuery("findAll", Student.class);
            query.getResultStream().forEach(System.out::println);
        }
    }

    public void status(Integer id) {
        try (var session = sessionFactory.openSession()) {
            session.beginTransaction();
            var student = session.find(Student.class, id);
            if (student.getIsExcellent()) {
                System.out.println("well done you can pick 24 unit this term! ");
            } else System.out.println("you cant pick more than 20 unit! ");
            session.getTransaction().commit();
        }
    }
}
