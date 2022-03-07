package Repository;

import Entity.CourseAndScore;
import Entity.Student;
import org.hibernate.SessionFactory;
import SessionFactory.SessionFactorySingleton;


public class CourseAndScoreRepository extends GenericRepositoryImpl<CourseAndScore, Long> {
    private SessionFactory sessionFactory = SessionFactorySingleton.getInstance();

    public void findById(Integer id) {
        try (var session = sessionFactory.openSession()) {
            session.beginTransaction();
            var a = session.find(CourseAndScore.class, id);
            System.out.println(a);
            session.getTransaction().commit();
        }
    }

    public void findAll() {
        try (var session = sessionFactory.openSession()) {
            var query = session.createNamedQuery("findAll", CourseAndScore.class);
            query.getResultStream().forEach(System.out::println);
        }
    }
}
