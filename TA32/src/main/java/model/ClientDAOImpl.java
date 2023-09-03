package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDAOImpl implements ClientDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    @Override
    public void insertClient(Client client) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String query = "INSERT INTO cliente (nombre, apellido, direccion, dni, fecha) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, client.getNombre());
            statement.setString(2, client.getApellido());
            statement.setString(3, client.getDireccion());
            statement.setInt(4, client.getDni());
            statement.setDate(5, new Date(client.getFecha().getTime()));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Client getClientById(int id) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String query = "SELECT * FROM cliente WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
            	int clientId = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                String apellido = resultSet.getString("apellido");
                String direccion = resultSet.getString("direccion");
                int dni = resultSet.getInt("dni");
                Date fecha = resultSet.getDate("fecha");

                return new Client(clientId, nombre, apellido, direccion, dni, fecha);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Client> getAllClients() {
        List<Client> clients = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String query = "SELECT * FROM cliente";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
            	int clientId = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                String apellido = resultSet.getString("apellido");
                String direccion = resultSet.getString("direccion");
                int dni = resultSet.getInt("dni");
                Date fecha = resultSet.getDate("fecha");

                Client client = new Client(clientId, nombre, apellido, direccion, dni, fecha);
                clients.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }

    @Override
    public void updateClient(Client client) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String query = "UPDATE cliente SET nombre = ?, apellido = ?, direccion = ?, dni = ?, fecha = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, client.getNombre());
            statement.setString(2, client.getApellido());
            statement.setString(3, client.getDireccion());
            statement.setInt(4, client.getDni());
            statement.setDate(5, new Date(client.getFecha().getTime()));
            statement.setInt(6, client.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteClient(int id) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String query = "DELETE FROM cliente WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}