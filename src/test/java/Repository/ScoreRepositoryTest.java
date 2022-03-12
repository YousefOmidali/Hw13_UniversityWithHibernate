package Repository;

import Entity.Master;
import Entity.MasterLevel;
import Entity.Score;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ScoreRepositoryTest {
    private ScoreRepository scoreRepository;
    private StudentRepository studentRepository;
    private MasterRepository masterRepository;
    private CourseRepository courseRepository;
    private Score score;
    private Score score2;

    @BeforeEach
    public void beforeEach() throws SQLException {
        scoreRepository = new ScoreRepository();
        studentRepository = new StudentRepository();
        masterRepository = new MasterRepository();
        courseRepository = new CourseRepository();
    }

//    @AfterEach
//    public void afterEach() throws SQLException {
//        var sessionFactory = SessionFactoryConnection.getInstance();
//        try (var session = sessionFactory.openSession()) {
//            var transaction = session.beginTransaction();
//            try {
//                session.createQuery("DELETE FROM Entity.Score").executeUpdate();
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
        score = new Score(null,19.5,courseRepository.findById(24)
                ,masterRepository.findById(1L),studentRepository.findById(1L));
        // Act
        scoreRepository.save(score);

        // Assert
        assertAll(
                () -> assertNotNull(scoreRepository.findById(score.getId())),
                () -> assertEquals(19.5 ,
                        scoreRepository.findById(score.getId()).getScore())
        );
        scoreRepository.delete(score);
    }

    @Test
    public void delete() throws SQLException {
        // Arrange -->
        score = new Score(null,19.5,courseRepository.findById(24)
                ,masterRepository.findById(1L),studentRepository.findById(1L));
        // Act
        scoreRepository.save(score);
        scoreRepository.delete(score);

        // Assert
        assertNull(scoreRepository.findById(score.getId()));
    }

    @Test
    public void update() throws SQLException {
        // Arrange -->
        score = new Score(null,19.5,courseRepository.findById(24)
                ,masterRepository.findById(1L),studentRepository.findById(1L));
        // Act
        scoreRepository.save(score);
        score.setScore(18d);
        scoreRepository.update(score);

        // Assert
        assertEquals(18d, scoreRepository.findById(score.getId()).getScore());
        scoreRepository.delete(score);

    }

    @Test
    public void findById() throws SQLException {
        // Arrange -->
        score = new Score(null,19.5,courseRepository.findById(24)
                ,masterRepository.findById(1L),studentRepository.findById(1L));
        // Act
        scoreRepository.save(score);

        // Assert
        assertEquals(score.getScore(), scoreRepository.findById(score.getId()).getScore());
        assertNotNull(scoreRepository.findById(score.getId()));
        scoreRepository.delete(score);

    }

    @Test
    void findAll() {
        // Arrange -->
        score = new Score(null,19.5,courseRepository.findById(24)
                ,masterRepository.findById(1L),studentRepository.findById(1L));
        score2 = new Score(null,17.25,courseRepository.findById(26)
                ,masterRepository.findById(1L),studentRepository.findById(1L));
        // Act
        scoreRepository.save(score);
        scoreRepository.save(score2);
        List<Score> findAll = new ArrayList<>();
        findAll = scoreRepository.findAll(1L);

        assertTrue(findAll.size() >= 2);
        scoreRepository.delete(score);
        scoreRepository.delete(score2);

    }
}