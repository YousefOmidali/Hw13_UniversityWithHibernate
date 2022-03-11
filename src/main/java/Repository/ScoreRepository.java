package Repository;

import Entity.Score;
import Entity.Student;
import org.hibernate.SessionFactory;

import java.util.List;

public class ScoreRepository extends GenericRepositoryImpl {
    private SessionFactory sessionFactory = SessionFactoryConnection.getInstance();

    public Score findById(Long id) {
        try (var session = sessionFactory.openSession()) {
            session.beginTransaction();
            var a = session.find(Score.class, id);
            System.out.println(a);
            session.getTransaction().commit();
            return a;
        }
    }

    //    public void findAll() {
//        try (var session = sessionFactory.openSession()) {
//            var query = session.createNamedQuery("findAll", Score.class);
//            query.getResultStream().forEach(System.out::println);
//        }
//    }
    public List<Score> findAll(Long studentId ) {
        try (var session = sessionFactory.openSession()){
            String hql = "  FROM Entity.Score s WHERE s.student.id = :student_id ";
            var query = session.createQuery(hql, Score.class);
            query.setParameter("student_id",studentId);
            return query.getResultList();
        }
    }

}
