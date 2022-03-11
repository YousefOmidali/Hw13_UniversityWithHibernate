package Service;

import Entity.Employee;
import Entity.Master;
import Repository.MasterRepository;

import java.util.List;

public class MasterService {
    private MasterRepository masterRepository = new MasterRepository();

    public void save(Master master) {
        masterRepository.save(master);
    }

    public void deleteById(Long id) {
        masterRepository.findById(id);
    }

    public void update(Master master) {
        masterRepository.update(master);
    }

    public Master findById(Long id) {
        return masterRepository.findById(id);
    }

    public List<Master> findAll() {
        return masterRepository.findAll();
    }

    public Master login(String username, String password) {
        return masterRepository.login(username, password);
    }
}
