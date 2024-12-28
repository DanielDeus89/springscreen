package br.com.damin.springscreen.atividades.estatico.calculadora;

public class Calculadora {
    public static double calculaMedia(double[] numeros){
        double soma = 0;
        for(double num : numeros){
            soma += num;
        }
        return soma / numeros.length;
    }
}
