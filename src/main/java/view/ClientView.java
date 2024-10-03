package view;

import java.util.Scanner;

public class ClientView {

    private Scanner scanner;

    public ClientView() {
        this.scanner = new Scanner(System.in);
    }

    public String ClientNome() {
        System.out.print("Digite o nome do cliente: ");
        return scanner.nextLine();
    }

    public int ClientAge() {
        System.out.print("Digite a idade do cliente: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public String ClientEmail() {
        System.out.print("Digite o email do cliente: ");
        return scanner.nextLine();
    }

    public String ClientTelefone(){
        System.out.print("Digite o telefone do cliente: ");
        return scanner.nextLine();
    }

    public void showClientInfo(String info) {
        System.out.println(info);
    }

    public void showError(String message) {
        System.err.println("Erro: " + message);
    }

    public void close() {
        scanner.close();
    }
}
