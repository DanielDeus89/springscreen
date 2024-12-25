package br.com.damin.springscreen.atividades.estatistica;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Atividade03 {
    public static void main(String[] args) {
        List<String> palavras = Arrays.asList("java", "stream", "lambda", "code", "Daniel","Heitor");

        String resultado = String.join(", ", palavras);

        System.out.println(resultado);
    }
}

