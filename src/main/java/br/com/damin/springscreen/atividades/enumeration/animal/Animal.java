package br.com.damin.springscreen.atividades.enumeration.animal;

public class Animal {
    private String nome;
    private TipoAnimal tipoAnimal;

    public Animal(String nome, TipoAnimal tipoAnimal) {
        this.nome = nome;
        this.tipoAnimal = tipoAnimal;
    }

    public void exibirInfoAnimal() {
        System.out.println("Nome: " + nome);
        System.out.println("Tipo: " + tipoAnimal);
    }
}
