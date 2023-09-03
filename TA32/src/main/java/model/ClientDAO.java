package model;

import java.util.List;

public interface ClientDAO {
    void insertClient(Client client);
    Client getClientById(int id);
    List<Client> getAllClients();
    void updateClient(Client client);
    void deleteClient(int id);
}
