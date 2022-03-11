package Repository;

import Entity.Employee;
import Entity.Master;
import Entity.MasterLevel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MasterRepositoryTest {
    private MasterRepository masterRepository;

    @BeforeEach
    public void beforeEach() throws SQLException {
        masterRepository = new MasterRepository();
    }

//    @AfterEach
//    public void afterEach() throws SQLException {
//        var sessionFactory = SessionFactoryConnection.getInstance();
//        try (var session = sessionFactory.openSession()) {
//            var transaction = session.beginTransaction();
//            try {
//                session.createQuery("DELETE FROM Entity.Master").executeUpdate();
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
        Master master = new Master("Test1", "Test1", "Yousef",
                MasterLevel.HAGHOTADRIS, 0, 7000000L);
        // Act
        masterRepository.save(master);

        // Assert
        assertAll(
                () -> assertNotNull(masterRepository.findById(master.getId())),
                () -> assertEquals("Yousef",
                        masterRepository.findById(master.getId()).getFullName())
        );
        masterRepository.delete(master);
    }

    @Test
    public void delete() throws SQLException {
        // Arrange -->
        Master master = new Master("Test1", "Test1", "Yousef",
                MasterLevel.HAGHOTADRIS, 0, 7000000L);
        // Act
        masterRepository.save(master);
        masterRepository.delete(master);

        // Assert
        assertNull(masterRepository.findById(master.getId()));
    }

    @Test
    public void update() throws SQLException {
        // Arrange -->
        Master master = new Master("Test1", "Test1", "Yousef",
                MasterLevel.HAGHOTADRIS, 0, 7000000L);
        // Act
        masterRepository.save(master);
        master.setFullName("Benyamin");
        masterRepository.update(master);

        // Assert
        assertEquals("Benyamin", masterRepository.findById(master.getId()).getFullName());
        masterRepository.delete(master);

    }

    @Test
    public void findId() throws SQLException {
        // Arrange -->
        Master master = new Master("Test1", "Test1", "Yousef",
                MasterLevel.HAGHOTADRIS, 0, 7000000L);

        // Act
        masterRepository.save(master);

        // Assert
        assertEquals(master.getFullName(), masterRepository.findById(master.getId()).getFullName());
        masterRepository.delete(master);

    }

    @Test
    void findAll() {
        Master master1 = new Master("Test1", "Test1", "Yousef",
                MasterLevel.HAGHOTADRIS, 0, 7000000L);
        Master master2 = new Master("Test2", "Test2", "Yousef",
                MasterLevel.HAGHOTADRIS, 0, 7000000L);
        masterRepository.save(master1);
        masterRepository.save(master2);
        List<Master> findAll = masterRepository.findAll();

        assertTrue(findAll.size() >= 2);
        masterRepository.delete(master1);
        masterRepository.delete(master2);

    }

    @Test
    void login() {
        Master master = new Master("Test1", "Test1", "Yousef",
                MasterLevel.HAGHOTADRIS, 0, 7000000L);

        masterRepository.save(master);

        assertEquals(master.getFullName(),
                masterRepository.login(master.getUserName(), master.getPassword()).getFullName());
        masterRepository.delete(master);


    }
}