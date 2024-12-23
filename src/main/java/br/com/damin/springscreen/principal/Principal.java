package br.com.damin.springscreen.principal;

import br.com.damin.springscreen.model.DadosEpisodio;
import br.com.damin.springscreen.model.DadosSerie;
import br.com.damin.springscreen.model.DadosTemporada;
import br.com.damin.springscreen.model.Episodio;
import br.com.damin.springscreen.service.ConsumoApi;
import br.com.damin.springscreen.service.ConverteDados;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
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
            for (int i = 1; i <= dados.totalTemporadas(); i++){
                json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&season=" + i + "&apikey=6585022c");
                DadosTemporada dadosTemporada = converteDados.obterDados(json, DadosTemporada.class);
                temporadas.add(dadosTemporada);
            }
        }catch (NullPointerException e){
            System.out.println("Movie not found");
            exbirMenu();
        }
		temporadas.forEach(System.out::println);

//        temporadas.forEach(t -> {
//            if (t.episodios() != null) {
//                t.episodios().forEach(e -> System.out.println(e.titulo()));
//            } else {
//                System.out.println("Nenhum episódio encontrado para a temporada " + t.numero());
//            }
//        });
//
//        List<DadosEpisodio> dadosEpisodios = temporadas.stream()
//                .flatMap(t -> t.episodios().stream())
//                .toList();

//        System.out.println("\nTop 10 episodios");
//        dadosEpisodios.stream()
//                .filter(e -> !e.avaliacao().equalsIgnoreCase("N/A"))
//                .peek(e -> System.out.println("Primeiro Filtro (N/A): " + e))
//                .sorted(Comparator.comparing(DadosEpisodio::avaliacao).reversed())
//                .peek(e -> System.out.println("Ordenacao: " + e))
//                .limit(10)
//                .peek(e -> System.out.println("Filtro: " + e))
//                .map(e -> e.titulo().toUpperCase())
//                .forEach(System.out::println);
//
//        System.out.println(" ");

        List<Episodio> episodios = temporadas.stream()
                .filter(temporada -> temporada.episodios() != null)
                .flatMap(t -> t.episodios().stream()
                        .map(d -> new Episodio(t.numero(), d))
                ).toList();
        episodios.forEach(System.out::println);
//
//        System.out.println("A partir de que ano você deseja ver os episódios? ");
//        int ano = scanner.nextInt();
//
//        LocalDate dataBusca = LocalDate.of(ano,1,1);
//
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//
//        episodios.stream()
//                .filter(e -> e.getDataLancamento() != null && e.getDataLancamento().isAfter(dataBusca))
//                .forEach(e -> System.out.println(
//                        "Temporada: " + e.getTemporada() +
//                                " Episodio: " + e.getTitulo() +
//                                " Data Lançamento: " + e.getDataLancamento().format(formatter)
//                ));

//        System.out.print("Digite o trecho do titulo do episosio: ");
//        String trechoTitulo = scanner.nextLine();
//        Optional<Episodio> episodioBuscado = episodios.stream()
//                .filter(e -> e.getTitulo().contains(trechoTitulo)).findFirst();
//        if(episodioBuscado.isPresent()){
//            System.out.println("Episodio Encontrado!");
//            System.out.println("Temporada: " + episodioBuscado.get().getTemporada());
//        }else {
//            System.out.println("Episodio nao encotrado2");
//        }

        Map<Integer, Double> avaliacaoPorTemporada = episodios.stream()
                .filter(e -> e.getAvaliacao() > 0.0)
                .collect(Collectors.groupingBy(Episodio::getTemporada,
                        Collectors.averagingDouble(Episodio::getAvaliacao)));
        System.out.println(avaliacaoPorTemporada);

        System.out.println("Double Summary");
        DoubleSummaryStatistics est = episodios.stream()
                .filter(e -> e.getAvaliacao() > 0.0)
                .collect(Collectors.summarizingDouble(Episodio::getAvaliacao));

        System.out.printf("\nMédia: %.2f", est.getAverage());
        System.out.printf("\nMelhor: %.2f", est.getMax());
        System.out.printf("\nPior: %.2f", est.getMin());
        System.out.print("\nQuantidade: " + est.getCount());
    }
}
