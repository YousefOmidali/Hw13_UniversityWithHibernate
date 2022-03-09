package Service;

import Entity.Employee;
import Entity.Master;
import Repository.MasterRepository;

public class MasterService {
    private MasterRepository masterRepository = new MasterRepository();

    public void save(Master master) {
        masterRepository.save(master);
    }

    public void deleteById(Integer id) {
        masterRepository.findById(id);
    }

    public void update(Master master) {
        masterRepository.update(master);
    }

    public void findById(Integer id) {
        masterRepository.findById(id);
    }

    public void FindAll() {
        masterRepository.findAll();
    }
    public Master login(String username,String password) {
        return masterRepository.login(username, password);
    }
}
