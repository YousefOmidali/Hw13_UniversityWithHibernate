package Repository;
import Entity.Master;
import SessionFactory.SessionFactorySingleton;
import org.hibernate.SessionFactory;

public class MasterRepository extends GenericRepositoryImpl<MasterRepository,Long>{
    private SessionFactory sessionFactory = SessionFactorySingleton.getInstance();

    public void findById(Integer id) {
        try (var session = sessionFactory.openSession()) {
            session.beginTransaction();
            var a = session.find(Master.class, id);
            System.out.println(a);
            session.getTransaction().commit();
        }
    }

    public void findAll() {
        try(var session = sessionFactory.openSession()){
            var query = session.createNamedQuery("findAll", Master.class);
            query.getResultStream().forEach(System.out::println);
        }

    }
}
