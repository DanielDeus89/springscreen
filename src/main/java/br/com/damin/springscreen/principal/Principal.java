package br.com.damin.springscreen.principal;

import br.com.damin.springscreen.model.DadosEpisodio;
import br.com.damin.springscreen.model.DadosSerie;
import br.com.damin.springscreen.model.DadosTemporada;
import br.com.damin.springscreen.model.Episodio;
import br.com.damin.springscreen.service.ConsumoApi;
import br.com.damin.springscreen.service.ConverteDados;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
    Scanner scanner = new Scanner(System.in);

    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=6585022c";

    public void exbirMenu() {
        System.out.print("Digite o nome da Serie para Busca: ");
        String nomeSerie = scanner.nextLine();


        var consumoApi = new ConsumoApi();
        var json = consumoApi.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);

        ConverteDados converteDados = new ConverteDados();
        DadosSerie dados = converteDados.obterDados(json, DadosSerie.class);
        System.out.println(dados);

        List<DadosTemporada> temporadas = new ArrayList<>();


        try{
            for (int i = 1; i < dados.totalTemporadas(); i++){
                json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&season=" + i + "&apikey=6585022c");
                DadosTemporada dadosTemporada = converteDados.obterDados(json, DadosTemporada.class);
                temporadas.add(dadosTemporada);
            }
        }catch (NullPointerException e){
            System.out.println("Movie not found");
            exbirMenu();
        }
		//temporadas.forEach(System.out::println);

//        temporadas.forEach(t -> {
//            if (t.episodios() != null) {
//                t.episodios().forEach(e -> System.out.println(e.titulo()));
//            } else {
//                System.out.println("Nenhum episódio encontrado para a temporada " + t.numero());
//            }
//        });

        List<DadosEpisodio> dadosEpisodios = temporadas.stream()
                .flatMap(t -> t.episodios().stream())
                .collect(Collectors.toList());

        System.out.println("\nTop 5 episodios");
        dadosEpisodios.stream()
                .filter(e -> !e.avaliacao().equalsIgnoreCase("N/A"))
                .sorted(Comparator.comparing(DadosEpisodio::avaliacao).reversed())
                .limit(5)
                .forEach(System.out::println);


        List<Episodio> episodios = temporadas.stream()
                .flatMap(t -> t.episodios().stream()
                        .map(d -> new Episodio(t.numero(), d))
                ).collect(Collectors.toList());
        episodios.forEach(System.out::println);

        System.out.println("A partir de que ano você deseja ver os episódios? ");
        int ano = scanner.nextInt();

        LocalDate dataBusca = LocalDate.of(ano,1,1);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        episodios.stream()
                .filter(e -> e.getDataLancamento() != null && e.getDataLancamento().isAfter(dataBusca))
                .forEach(e -> System.out.println(
                        "Temporada: " + e.getTemporada() +
                                " Episodio: " + e.getTitulo() +
                                " Data Lançamento: " + e.getDataLancamento().format(formatter)
                ));

    }
}
