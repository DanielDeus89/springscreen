package br.com.damin.springscreen.principal;

import br.com.damin.springscreen.model.DadosSerie;
import br.com.damin.springscreen.model.DadosTemporada;
import br.com.damin.springscreen.model.Series;
import br.com.damin.springscreen.repository.SerieRepository;
import br.com.damin.springscreen.service.ConsumoApi;
import br.com.damin.springscreen.service.ConverteDados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Principal {
    private final SerieRepository serieRepository;
    Scanner scanner = new Scanner(System.in);
    private ConsumoApi consumoApi = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();
    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=6585022c";

    private List<DadosSerie> dadosSerie = new ArrayList<>();

    public Principal(SerieRepository serieRepository) {
        this.serieRepository = serieRepository;
    }

    public void exbirMenu() {
        int opcao = -1;
        while (opcao != 0) {
            var menu = """
            1 - Buscar séries
            2 - Buscar episódios
            3 - Listar séries buscadas

            0 - Sair
            """;

            System.out.println(menu);
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:
                    buscarSerieWeb();
                    break;
                case 2:
                    buscarEpisodioPorSerie();
                    break;
                case 3:
                    listarSeriesBuscadas();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");

            }
        }
    }

    private void buscarSerieWeb() {
        DadosSerie dados = getDadosSerie();
        Series series = new Series(dados);
        try{
            serieRepository.save(series);
        }
        catch (DataIntegrityViolationException e) {
            System.out.println("Registro duplicado. Não foi possível inserir.");
        }

        System.out.println("Série adicionada com sucesso!");
        System.out.println(series);
    }

    private DadosSerie getDadosSerie() {
        System.out.print("Digite o nome da Série para Busca: ");
        String nomeSerie = scanner.nextLine();
        var json = consumoApi.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);
        DadosSerie dados = conversor.obterDados(json, DadosSerie.class);

        if (dados == null || dados.titulo() == null) {
            System.out.println("Série não encontrada.");
            return null;
        }

        return dados;
    }

    private void listarSeriesBuscadas() {

        List<Series> series = serieRepository.findAll();

        series.stream()
                .sorted(Comparator.comparing(Series::getGenero))
                .forEach(System.out::println);

        System.out.println(" ");
    }

    private void buscarEpisodioPorSerie() {
        DadosSerie dadosSerie = getDadosSerie();
        if (dadosSerie == null) {
            System.out.println("Série inválida ou não encontrada.");
            return;
        }

        List<DadosTemporada> dadosTemporadas = new ArrayList<>();

        for (int i = 1; i <= dadosSerie.totalTemporadas(); i++) {
            var json = consumoApi.obterDados(ENDERECO + dadosSerie.titulo().replace(" ", "+") + "&season=" + i + API_KEY);
            DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);

            if (dadosTemporada != null) {
                dadosTemporadas.add(dadosTemporada);
            } else {
                System.out.println("Erro ao buscar a temporada " + i);
            }
        }

        dadosTemporadas.forEach(System.out::println);
    }
}
