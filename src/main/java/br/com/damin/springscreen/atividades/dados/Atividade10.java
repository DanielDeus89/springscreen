package br.com.damin.springscreen.atividades.dados;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class Atividade10 {
    public static void main(String[] args) {
        List<Aluno> alunos = Arrays.asList(
                new Aluno("Daniel", LocalDate.of(2002, 10, 20)),
                new Aluno("Bob", LocalDate.of(1980, 8, 9)),
                new Aluno("Carlos", LocalDate.of(2001, 01, 28)),
                new Aluno("David", LocalDate.of(2003, 05, 12)),
                new Aluno("Eva", LocalDate.of(2005, 12, 03))
        );

        IntSummaryStatistics est = alunos.stream()
                .mapToInt(Aluno::getIdade)
                .summaryStatistics();

        System.out.println("Idade Media: " + est.getAverage());
        System.out.println("Idade Minina: " + est.getMin());
        System.out.println("Idade Maxima: " + est.getMax());
        System.out.println("Total de Alunos : " + est.getCount());

    }


    public static class Aluno{
        String nome;
        LocalDate dataNascimento;

        public Aluno(String nome, LocalDate dataNascimento) {
            this.nome = nome;
            this.dataNascimento = dataNascimento;
        }

        public int getIdade(){
            Period period = Period.between(dataNascimento, LocalDate.now());
            return period.getYears();
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public LocalDate getDataNascimento() {
            return dataNascimento;
        }

        public void setDataNascimento(LocalDate dataNascimento) {
            this.dataNascimento = dataNascimento;
        }
    }
}
