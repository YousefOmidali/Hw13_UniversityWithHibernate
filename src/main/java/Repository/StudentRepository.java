package Repository;

import Entity.Master;
import Entity.Student;
import org.hibernate.SessionFactory;


public class StudentRepository extends GenericRepositoryImpl<Student, Long> {
    private SessionFactory sessionFactory = SessionFactoryConnection.getInstance();

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
    public Student login(String username, String password) {
        var session = sessionFactory.openSession();
        String hql = " FROM Entity.Student s " +
                " WHERE s.userName = :username " +
                " AND s.password = :password ";
        var query = session.createQuery(hql, Student.class);
        query.setParameter("username", username);
        query.setParameter("password", password);
        return query.getSingleResult();
    }
}
