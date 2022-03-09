package Service;

import Entity.Course;
import Repository.CourseRepository;

public class CourseService {
    private CourseRepository courseRepository = new CourseRepository();

    public void save(Course courseAndScore) {
        courseRepository.save(courseAndScore);
    }

    public void deleteById(Integer id) {
        courseRepository.findById(id);
    }

    public void update(Course courseAndScore) {
        courseRepository.update(courseAndScore);
    }

    public void findById(Integer id) {
        courseRepository.findById(id);
    }

    public void FindAll() {
        courseRepository.findAll();
    }
}
