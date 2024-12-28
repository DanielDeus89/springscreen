package br.com.damin.springscreen.service;

import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;

public class TradutorLocal {

    // Método para traduzir textos usando a API do Google Translate
    public static String traduzir(String texto) {

        // Instancia o serviço de tradução com a chave de API
        Translate translate = TranslateOptions.newBuilder()
                .setApiKey(System.getenv("")) // Pega a chave da variável de ambiente
                .build()
                .getService();

        // Traduz o texto para português
        Translation translation = translate.translate(
                texto,
                Translate.TranslateOption.targetLanguage("pt") // Define o idioma de destino como português
        );

        return translation.getTranslatedText(); // Retorna o texto traduzido
    }
}
