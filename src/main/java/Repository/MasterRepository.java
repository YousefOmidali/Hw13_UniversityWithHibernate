package Repository;

import Entity.Master;
import org.hibernate.SessionFactory;

import java.util.List;

public class MasterRepository extends GenericRepositoryImpl<Master, Long> {
    private SessionFactory sessionFactory = SessionFactoryConnection.getInstance();

    public Master findById(Long id) {
        try (var session = sessionFactory.openSession()) {
            session.beginTransaction();
            var a = session.find(Master.class, id);
            System.out.println(a);
            session.getTransaction().commit();
            return a;
        }
    }

    //    public void findAll() {
//        try (var session = sessionFactory.openSession()) {
//            var query = session.createNamedQuery("findAll", Master.class);
//            query.getResultStream().forEach(System.out::println);
//        }
//    }
    public List<Master> findAll() {
        var session = sessionFactory.openSession();
        String hql = " FROM Entity.Master m";
        var query = session.createQuery(hql, Master.class);
        return query.getResultList();
    }


    public Master login(String username, String password) {
        var session = sessionFactory.openSession();
        String hql = " FROM Entity.Master m " +
                " WHERE m.userName = :username " +
                " AND m.password = :password ";
        var query = session.createQuery(hql, Master.class);
        query.setParameter("username", username);
        query.setParameter("password", password);
        return query.getSingleResult();
    }
}
