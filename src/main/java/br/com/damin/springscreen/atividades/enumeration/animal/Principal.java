package br.com.damin.springscreen.atividades.enumeration.animal;

public class Principal {
    public static void main(String[] args) {
        Animal leao = new Animal("Leão", TipoAnimal.MAMIFERO);
        leao.exibirInfoAnimal();

        Animal cobra = new Animal("Cobra", TipoAnimal.REPTIL);
        cobra.exibirInfoAnimal();

    }
}
