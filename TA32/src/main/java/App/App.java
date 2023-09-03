package App;

import controller.ClientController;
import model.ClientDAO;
import model.ClientDAOImpl;
import view.ClientView;

public class App {
    public static void main(String[] args) {
        ClientDAO clientDAO = new ClientDAOImpl(); 
        ClientController clientController = new ClientController(clientDAO);
        ClientView clientView = new ClientView(clientController);
        clientView.show();
    }
}
