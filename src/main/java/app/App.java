package app;

import controller.ClientController;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        final ClientController clientController = new ClientController();
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("=== Gerenciamento de Clientes ===");
            System.out.println("1. Adicionar Cliente");
            System.out.println("2. Mostrar Todos os Clientes");
            System.out.println("3. Atualizar Cliente");
            System.out.println("4. Deletar Cliente");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    clientController.addClient();
                    break;
                case 2:
                    clientController.showAllClients();
                    break;
                case 3:
                    System.out.print("Digite o ID do cliente a ser atualizado: ");
                    int updateId = Integer.parseInt(scanner.nextLine());
                    clientController.updateClient(updateId);
                    break;
                case 4:
                    System.out.print("Digite o ID do cliente a ser deletado: ");
                    int deleteId = Integer.parseInt(scanner.nextLine());
                    clientController.deleteClient(deleteId);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

            System.out.println(); // Linha em branco para melhor formatação

        } while (option != 0);

        scanner.close();
    }
}
