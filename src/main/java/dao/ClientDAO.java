package dao;

import model.Client;
import java.util.List;

public interface ClientDAO {
    void save(Client client);
    Client findById(int id);
    List<Client> findAll();
    void update(Client client);
    void delete(int id);
}
