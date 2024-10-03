package dao;

import model.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDAOImpl implements ClientDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/test_sql";
    private static final String USER = "root"; //
    private static final String PASSWORD = "15940898"; //


    @Override
    public void save(Client client) {
        String sql = "INSERT INTO clients (nome, idade, email, telefone) VALUES (?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, client.getNome());
            statement.setInt(2, client.getIdade());
            statement.setString(3, client.getEmail());
            statement.setString(4, client.getTelefone());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public Client findById(int id) {
        Client client = null;
        String sql = "SELECT * FROM clients WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                client = new Client();
                client.setId(resultSet.getInt("id"));
                client.setNome(resultSet.getString("nome"));
                client.setIdade(resultSet.getInt("idade"));
                client.setEmail(resultSet.getString("email"));
                client.setTelefone(resultSet.getString("telefone"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return client;
    }


    @Override
    public List<Client> findAll() {
        List<Client> clients = new ArrayList<>();
        String sql = "SELECT * FROM clients";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Client client = new Client();
                client.setId(resultSet.getInt("id"));
                client.setNome(resultSet.getString("nome"));
                client.setIdade(resultSet.getInt("idade"));
                client.setEmail(resultSet.getString("email"));
                client.setTelefone(resultSet.getString("telefone"));
                clients.add(client);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }


    @Override
    public void update(Client client) {
        String sql = "UPDATE clients SET nome = ?, idade = ?, email = ?, telefone = ? WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, client.getNome());
            statement.setInt(2, client.getIdade());
            statement.setString(3, client.getEmail());
            statement.setString(4, client.getTelefone());
            statement.setInt(5, client.getId());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void delete(int id) {
        String sql = "DELETE FROM clients WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
