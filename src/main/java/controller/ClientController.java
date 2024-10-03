package controller;

import dao.ClientDAO;
import dao.ClientDAOImpl;
import model.Client;
import view.ClientView;

import java.util.List;

public class ClientController {

    private final ClientDAO clientDAO;
    private final ClientView clientView;

    public ClientController() {
        this.clientDAO = new ClientDAOImpl();
        this.clientView = new ClientView();
    }


    public void addClient() {
        String nome = clientView.ClientNome();
        int idade = clientView.ClientAge();
        String email = clientView.ClientEmail();
        String telefone = clientView.ClientTelefone();

        Client client = new Client();
        client.setNome(nome);
        client.setIdade(idade);
        client.setEmail(email);
        client.setTelefone(telefone);

        clientDAO.save(client);
        clientView.showClientInfo("Cliente adicionado com sucesso: " + client.getNome());
    }


    public void showAllClients() {
        List<Client> clients = clientDAO.findAll();
        if (clients.isEmpty()) {
            clientView.showClientInfo("Nenhum cliente encontrado.");
        } else {
            for (Client client : clients) {
                clientView.showClientInfo(client.toString());
            }
        }
    }

    public void updateClient(int id) {
        Client existingClient = clientDAO.findById(id);
        if (existingClient == null) {
            clientView.showClientInfo("Cliente não encontrado com ID: " + id);
            return;
        }

        String novoNome = clientView.ClientNome();
        int novaIdade = clientView.ClientAge();
        String novoEmail = clientView.ClientEmail();
        String novoTelefone = clientView.ClientTelefone();

        existingClient.setNome(novoNome);
        existingClient.setIdade(novaIdade);
        existingClient.setEmail(novoEmail);
        existingClient.setTelefone(novoTelefone);

        clientDAO.update(existingClient);
        clientView.showClientInfo("Cliente atualizado com sucesso: " + existingClient.getNome());
    }

    public void deleteClient(int id) {
        Client existingClient = clientDAO.findById(id);
        if (existingClient == null) {
            clientView.showClientInfo("Cliente não encontrado com ID: " + id);
            return;
        }

        clientDAO.delete(id);
        clientView.showClientInfo("Cliente deletado com sucesso: " + existingClient.getNome());
    }
}
