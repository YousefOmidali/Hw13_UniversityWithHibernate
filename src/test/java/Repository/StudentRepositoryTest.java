package Repository;

import Entity.Master;
import Entity.MasterLevel;
import Entity.Student;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentRepositoryTest {
    private StudentRepository studentRepository;

    @BeforeEach
    public void beforeEach() throws SQLException {
        studentRepository = new StudentRepository();
    }

//    @AfterEach
//    public void afterEach() throws SQLException {
//        var sessionFactory = SessionFactoryConnection.getInstance();
//        try (var session = sessionFactory.openSession()) {
//            var transaction = session.beginTransaction();
//            try {
//                session.createQuery("DELETE FROM Entity.Student").executeUpdate();
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
        Student student = new Student("Test1","Test1",
                "Yousef",12385678L,Boolean.FALSE);
        // Act
        studentRepository.save(student);

        // Assert
        assertAll(
                () -> assertNotNull(studentRepository.findById(student.getId())),
                () -> assertEquals("Yousef",
                        studentRepository.findById(student.getId()).getFullName())
        );
        studentRepository.delete(student);
    }

    @Test
    public void delete() throws SQLException {
        // Arrange -->
        Student student = new Student("Test1","Test1",
                "Yousef",12385678L,Boolean.FALSE);

        // Act
        studentRepository.save(student);
        studentRepository.delete(student);

        // Assert
        assertNull(studentRepository.findById(student.getId()));
    }

    @Test
    public void update() throws SQLException {
        // Arrange -->
        Student student = new Student("Test1","Test1","Yousef",
                12385678L,Boolean.FALSE);

        // Act
        studentRepository.save(student);
        student.setFullName("Benyamin");
        studentRepository.update(student);

        // Assert
        assertEquals("Benyamin", studentRepository.findById(student.getId()).getFullName());
        studentRepository.delete(student);

    }

    @Test
    public void findId() throws SQLException {
        // Arrange -->
        Student student = new Student("Test1","Test1",
                "Yousef",12385678L,Boolean.FALSE);

        // Act
        studentRepository.save(student);

        // Assert
        assertEquals(student.getFullName(), studentRepository.findById(student.getId()).getFullName());
        studentRepository.delete(student);

    }

    @Test
    void findAll() {
        Student student1 = new Student("Test1","Test1",
                "Yousef1",12385678L,Boolean.FALSE);
        Student student2 = new Student("Test2","Test2",
                "Yousef2",12385688L,Boolean.FALSE);
        studentRepository.save(student1);
        studentRepository.save(student2);
        List<Student> findAll = studentRepository.findAll();

        assertTrue(findAll.size() >= 2);
        studentRepository.delete(student1);
        studentRepository.delete(student2);

    }

    @Test
    void login() {
        Student student = new Student("Test1","Test1",
                "Yousef",12385678L,Boolean.FALSE);

        studentRepository.save(student);

        assertEquals(student.getFullName(),
                studentRepository.login(student.getUserName(), student.getPassword()).getFullName());
        studentRepository.delete(student);


    }
}