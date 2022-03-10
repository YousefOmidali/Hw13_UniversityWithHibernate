package Repository;

import Entity.Employee;
import org.hibernate.SessionFactory;

public class EmployeeRepository extends GenericRepositoryImpl<Employee, Long> {
    private SessionFactory sessionFactory = SessionFactoryConnection.getInstance();


    public void findById(Long id) {
        try (var session = sessionFactory.openSession()) {
            session.beginTransaction();

            var a = session.find(Employee.class, id);
            System.out.println(a);
            session.getTransaction().commit();
        }
    }

    //    public void findAll() {
//        try(var session = sessionFactory.openSession()){
//            var query = session.createNamedQuery("findAll", Employee.class);
//            query.getResultStream().forEach(System.out::println);
//        }
//    }
    public void findAll() {
        var session = sessionFactory.openSession();
        String hql = " FROM Entity.Employee e";
        var query = session.createQuery(hql, Employee.class);
        query.getResultList().forEach(System.out::println);
    }

    public Employee login(String username, String password) {
        var session = sessionFactory.openSession();
        String hql = " FROM Entity.Employee e " +
                " WHERE e.userName = :username " +
                " AND e.password = :password ";
        var query = session.createQuery(hql, Employee.class);
        query.setParameter("username", username);
        query.setParameter("password", password);
        return query.getSingleResult();
    }
}
