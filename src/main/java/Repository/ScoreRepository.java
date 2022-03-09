package Repository;

import Entity.Score;
import org.hibernate.SessionFactory;

public class ScoreRepository extends GenericRepositoryImpl {
    private SessionFactory sessionFactory = SessionFactoryConnection.getInstance();

    public void findById(Long id) {
        try (var session = sessionFactory.openSession()) {
            session.beginTransaction();
            var a = session.find(Score.class, id);
            System.out.println(a);
            session.getTransaction().commit();
        }
    }

    //    public void findAll() {
//        try (var session = sessionFactory.openSession()) {
//            var query = session.createNamedQuery("findAll", Score.class);
//            query.getResultStream().forEach(System.out::println);
//        }
//    }
    public void findAll() {
        var session = sessionFactory.openSession();
        String hql = " FROM Entity.Score s";
        var query = session.createQuery(hql, Score.class);
        query.getResultStream().forEach(System.out::println);
    }

}
