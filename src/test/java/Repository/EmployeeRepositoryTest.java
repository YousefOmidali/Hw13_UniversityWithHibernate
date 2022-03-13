package Repository;

import Entity.Course;
import Entity.Employee;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeRepositoryTest {
    private EmployeeRepository employeeRepository;

    @BeforeEach
    public void beforeEach() throws SQLException {
        employeeRepository = new EmployeeRepository();
    }

//    @AfterEach
//    public void afterEach() throws SQLException {
//        var sessionFactory = SessionFactoryConnection.getInstance();
//        try (var session = sessionFactory.openSession()) {
//            var transaction = session.beginTransaction();
//            try {
//                session.createQuery("DELETE FROM Entity.Employee").executeUpdate();
//                transaction.commit();
//            } catch (Exception e) {
//                transaction.rollback();
//                throw e;
//            }
//        }
//    }

    @Test
    void save() {
        // Arrange -->
        Employee employee = new Employee("Test1", "Test1", "Yousef", 1234567899L, 10000000L);
        // Act
        employeeRepository.save(employee);

        // Assert
        assertAll(
                () -> assertNotNull(employeeRepository.findById(employee.getId())),
                () -> assertEquals("Yousef", employee.getFullName())
        );
    }

    @Test
    public void delete() throws SQLException {
        // Arrange -->
        Employee employee = new Employee("Test1", "Test1", "Yousef", 1234567899L, 10000000L);

        // Act
        employeeRepository.save(employee);
        employeeRepository.delete(employee);

        // Assert
        assertNull(employeeRepository.findById(employee.getId()));


    }

    @Test
    public void update() throws SQLException {
        // Arrange -->
        Employee employee = new Employee("Test1", "Test1", "Yousef", 1234567899L, 10000000L);

        // Act
        employeeRepository.save(employee);
        employee.setFullName("Benyamin");
        employeeRepository.update(employee);

        // Assert
        assertEquals("Benyamin", employeeRepository.findById(employee.getId()).getFullName());

    }

    @Test
    public void findId() throws SQLException {
        // Arrange -->
        Employee employee = new Employee("Test1", "Test1", "Yousef", 1234567899L, 10000000L);

        // Act
        employeeRepository.save(employee);

        // Assert
        assertEquals(employee.getFullName(), employeeRepository.findById(employee.getId()).getFullName());

    }

    @Test
    void findAll() {
        Employee employee1 = new Employee("Test1", "Test1", "Yousef", 1234547899L, 10000000L);
        Employee employee2 = new Employee("Test2", "Test2", "Benyamin", 1234527899L, 10000000L);

        employeeRepository.save(employee1);
        employeeRepository.save(employee2);
        List<Employee> findAll = employeeRepository.findAll();

        assertTrue(findAll.size() >= 2);


    }

    @Test
    void login() {
        Employee employee1 = new Employee("Test1", "Test1", "Yousef", 1234547899L, 10000000L);

        employeeRepository.save(employee1);

        assertEquals(employee1.getFullName(),
                employeeRepository.login(employee1.getUserName(), employee1.getPassword()).getFullName());


    }
}