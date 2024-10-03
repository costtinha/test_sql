package model;

public class Client {
    private int id;         // ID do cliente (auto-incrementado no banco de dados)
    private String nome;    // Nome do cliente
    private int idade;      // Idade do cliente
    private String email;   // Email do cliente
    private String telefone; // Telefone do cliente


    public Client() {}

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


    @Override
    public String toString() {
        return "Cliente{" +
                "ID=" + id +
                ", Nome='" + nome + '\'' +
                ", Idade=" + idade +
                ", Email='" + email + '\'' +
                ", Telefone='" + telefone + '\'' +
                '}';
    }
}
