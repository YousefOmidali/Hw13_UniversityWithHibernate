package Service;

import Entity.Employee;
import Repository.EmployeeRepository;

public class EmployeeService {
    private EmployeeRepository employeeRepository = new EmployeeRepository();

    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    public void deleteById(Long id) {
        employeeRepository.findById(id);
    }

    public void update(Employee employee) {
        employeeRepository.update(employee);
    }

    public void findById(Long id) {
        employeeRepository.findById(id);
    }

    public void findAll() {
        employeeRepository.findAll();
    }

    public Employee login(String username,String password) {
        return employeeRepository.login(username, password);
    }
}
