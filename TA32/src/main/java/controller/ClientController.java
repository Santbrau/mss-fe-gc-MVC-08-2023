package controller;

import java.util.List;

import model.Client;
import model.ClientDAO;

public class ClientController {
    private ClientDAO clientDAO;

    public ClientController(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    public void addClient(Client client) {
        clientDAO.insertClient(client);
    }

    public Client getClient(int id) {
        return clientDAO.getClientById(id);
    }

    public List<Client> getAllClients() {
        return clientDAO.getAllClients();
    }

    public void updateClient(Client client) {
        clientDAO.updateClient(client);
    }

    public void deleteClient(int id) {
        clientDAO.deleteClient(id);
    }
}