package Repository;

import Entity.Course;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class CourseRepositoryTest {
    private CourseRepository courseRepository;

    @BeforeEach
    public void beforeEach() throws SQLException {
        courseRepository = new CourseRepository();
    }
    @AfterAll
    static void afterAll() throws SQLException {
        var sessionFactory = SessionFactoryConnection.getInstance();
        sessionFactory.getCurrentSession().createQuery("delete from Entity.Course")
                .executeUpdate();
    }
    @Test
    public void insertTest() throws SQLException {
        // Arrange -->
        Course course = new Course("Test1", 1, null);

        // Act
        courseRepository.save(course);

        // Assert
        assertAll(
                () -> assertNotNull(courseRepository.findById(course.getId())),
                () -> assertEquals("Test1", course.getCourseName())
        );

    }
    @Test
    public void delete() throws SQLException {
        // Arrange -->
        Course course = new Course("Test1", 1, null);

        // Act
        courseRepository.save(course);
        courseRepository.delete(course);

        // Assert
        assertNull(courseRepository.findById(course.getId()));
    }

    @Test
    public void update() throws SQLException {
        // Arrange -->
        Course course = new Course("Test1", 1, null);

        // Act
        courseRepository.save(course);
        course.setCourseName("Test2");
        courseRepository.update(course);

        // Assert
        assertEquals("Test2",courseRepository.findById(course.getId()).getCourseName());
    }
    @Test
    public void findId() throws SQLException {
        // Arrange -->
        Course course = new Course("Test1", 1, null);

        // Act
        courseRepository.save(course);

        // Assert
        assertEquals(course.getCourseName(),courseRepository.findById(course.getId()).getCourseName());
    }
}