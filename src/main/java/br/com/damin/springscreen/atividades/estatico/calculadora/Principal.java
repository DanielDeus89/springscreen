package br.com.damin.springscreen.atividades.estatico.calculadora;

public class Principal {
    public static void main(String[] args) {

        double[] valores = {10.5, 8.0, 7.5, 9.0};

        double media = Calculadora.calculaMedia(valores);

        System.out.println(media);

    }
}
