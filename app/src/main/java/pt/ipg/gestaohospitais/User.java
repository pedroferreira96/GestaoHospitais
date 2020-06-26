package pt.ipg.gestaohospitais;

public class User {

    private String Nome;
    private String NumeroCC;
    private String Idade;
    private String Morada;
    private String Telefone;

    public User(String nome, String numeroCC, String idade, String morada, String telefone){

        Nome = nome;
        NumeroCC = numeroCC;
        Idade = idade;
        Morada = morada;
        Telefone = telefone;

    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getNumeroCC() {
        return NumeroCC;
    }

    public void setNumeroCC(String numeroCC) {
        NumeroCC = numeroCC;
    }

    public String getIdade() {
        return Idade;
    }

    public void setIdade(String idade) {
        Idade = idade;
    }

    public String getMorada() {
        return Morada;
    }

    public void setMorada(String morada) {
        Morada = morada;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String telefone) {
        Telefone = telefone;
    }
}
