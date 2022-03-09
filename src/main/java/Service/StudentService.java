package Service;

import Entity.Employee;
import Entity.Student;
import Repository.StudentRepository;

public class StudentService {
    private StudentRepository studentRepository = new StudentRepository();

    public void save(Student student) {
        studentRepository.save(student);
    }

    public void deleteById(Long id) {
        studentRepository.findById(id);
    }

    public void update(Student student) {
        studentRepository.update(student);
    }

    public void findById(Long id) {
        studentRepository.findById(id);
    }

    public void findAll() {
        studentRepository.findAll();
    }

    public void status(Long id) {
        studentRepository.status(id);
    }

    public Student login(String username, String password) {
        return studentRepository.login(username, password);
    }

}
