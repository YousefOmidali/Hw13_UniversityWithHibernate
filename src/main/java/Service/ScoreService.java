package Service;

import Entity.Course;
import Entity.Score;
import Repository.ScoreRepository;

public class ScoreService {
    private ScoreRepository scoreRepository = new ScoreRepository();

    public void save(Score score) {
        scoreRepository.save(score);
    }

    public void deleteById(Long id) {
        scoreRepository.findById(id);
    }

    public void update(Score score) {
        scoreRepository.update(score);
    }

    public void findById(Long id) {
        scoreRepository.findById(id);
    }

    public void findAll() {
        scoreRepository.findAll();
    }
}
