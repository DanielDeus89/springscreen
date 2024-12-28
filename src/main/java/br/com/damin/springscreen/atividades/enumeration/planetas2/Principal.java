package br.com.damin.springscreen.atividades.enumeration.planetas2;

public class Principal {
    public static void main(String[] args) {
        Planetas planetas = Planetas.TERRA;

        System.out.printf("Gravidade na Terra: %.2f m/s²%n", planetas.gravidade());
    }
}
