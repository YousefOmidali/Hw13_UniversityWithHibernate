package Service;

import Entity.Employee;
import Entity.Student;
import Repository.StudentRepository;

public class StudentService {
    private StudentRepository studentRepository = new StudentRepository();

    public void save(Student student) {
        studentRepository.save(student);
    }

    public void deleteById(Integer id) {
        studentRepository.findById(id);
    }

    public void update(Student student) {
        studentRepository.update(student);
    }

    public void findById(Integer id) {
        studentRepository.findById(id);
    }

    public void FindAll() {
        studentRepository.findAll();
    }

    public void status(Integer id) {
        studentRepository.status(id);
    }

    public Student login(String username, String password) {
        return studentRepository.login(username, password);
    }

}
