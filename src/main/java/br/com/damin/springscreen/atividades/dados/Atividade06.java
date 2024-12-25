package br.com.damin.springscreen.atividades.dados;

import java.util.Arrays;
import java.util.List;

public class Atividade06 {
    public static void main(String[] args) {
        List<Pessoa> pessoas = Arrays.asList(
                new Pessoa("Daniel", 35),
                new Pessoa("Milene", 34),
                new Pessoa("Heitor", 6),
                new Pessoa("Isis", 1)
        );

        List<Pessoa> pessoaMaior18 = pessoas.stream()
                .filter(p -> p.getIdade() > 18)
                .toList();

        System.out.println("Lista de Pessoas Maiores de 18 Anos");
        pessoaMaior18.forEach(p -> System.out.println(p.getNome() + " - Idade: " + p.getIdade() ));

        List<Pessoa> pessoaMenor18 = pessoas.stream()
                .filter(p -> p.getIdade() < 18)
                .toList();

        System.out.println("\nLista de Pessoas Menores de 18 Anos");
        pessoaMenor18.forEach(p -> System.out.println(p.getNome() + " - Idade: " + p.getIdade() ));
    }

    public static void imprimirLista(List<Pessoa> lista){
        lista.forEach(p -> System.out.println(p.getNome() + " - Idade: " + p.getIdade()));
    }

    public static class Pessoa{
        String nome;
        int idade;

        public Pessoa(String nome, int idade) {
            this.nome = nome;
            this.idade = idade;
        }

        public String getNome() {
            return nome;
        }


        public int getIdade() {
            return idade;
        }

    }
}
