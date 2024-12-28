package br.com.damin.springscreen.service.traducao;

import br.com.damin.springscreen.service.ConsumoApi;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URLEncoder;

public class ConsultaMyMemory {
    public static String obterTraducao(String text){
        ConsumoApi consumoApi = new ConsumoApi();

        ObjectMapper mapper = new ObjectMapper();

        String texto = URLEncoder.encode(text);
        String langpair = URLEncoder.encode("en|pt-br");
        String url = "https://api.mymemory.translated.net/get?q=" + texto + "&langpair=" + langpair;
        String json = consumoApi.obterDados(url);

        DadosTraducao traducao;
        try {
            traducao = mapper.readValue(json, DadosTraducao.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return traducao.dadosResposta().textoTraduzido();
    }
}
