package Service;

import Entity.Course;
import Entity.Score;
import Repository.ScoreRepository;

import java.util.List;

public class ScoreService {
    private ScoreRepository scoreRepository = new ScoreRepository();

    public void save(Score score) {
        scoreRepository.save(score);
    }

    public void deleteById(Integer id) {
        scoreRepository.findById(id);
    }

    public void update(Score score) {
        scoreRepository.update(score);
    }

    public void findById(Integer id) {
        scoreRepository.findById(id);
    }

    public List<Score> findAll(Long student_id) {
       return scoreRepository.findAll(student_id);
    }
}
