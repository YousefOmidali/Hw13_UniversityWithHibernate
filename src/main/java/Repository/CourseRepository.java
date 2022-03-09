package Repository;

import Entity.Course;
import org.hibernate.SessionFactory;


public class CourseRepository extends GenericRepositoryImpl<Course, Long> {
    private SessionFactory sessionFactory = SessionFactoryConnection.getInstance();

    public void findById(Integer id) {
        try (var session = sessionFactory.openSession()) {
            session.beginTransaction();
            var a = session.find(Course.class, id);
            System.out.println(a);
            session.getTransaction().commit();
        }
    }

    public void findAll() {
        try (var session = sessionFactory.openSession()) {
            var query = session.createNamedQuery("findAll", Course.class);
            query.getResultStream().forEach(System.out::println);
        }
    }
}
