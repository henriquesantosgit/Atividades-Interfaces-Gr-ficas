package br.edu.fatecpg.gui.model;

public class CadastroForm {
    private String nome;
    private int idade;
    private String sexo;


    public CadastroForm(String nome, int idade, String sexo) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
    }

  
    public String exibirResumo() {
        return "Nome: " + nome + "\nIdade: " + idade + "\nSexo: " + sexo;
    }
}
