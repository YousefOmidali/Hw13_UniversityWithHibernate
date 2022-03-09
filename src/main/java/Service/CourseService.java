package Service;

import Entity.Course;
import Repository.CourseRepository;

public class CourseService {
    private CourseRepository courseRepository = new CourseRepository();

    public void save(Course course) {
        courseRepository.save(course);
    }

    public void deleteById(Integer id) {
        courseRepository.findById(id);
    }

    public void update(Course course) {
        courseRepository.update(course);
    }

    public Course findById(Integer id) {
        return courseRepository.findById(id);
    }

    public void findAll() {
        courseRepository.findAll();
    }
}
