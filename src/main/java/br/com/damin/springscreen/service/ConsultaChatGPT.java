package br.com.damin.springscreen.service;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class ConsultaChatGPT {

    public static String obterTraducao(String texto) {

        OpenAiService service =
                new OpenAiService("");


        CompletionRequest requisicao = CompletionRequest.builder()
                .model("gpt-4o-mini-2024-07-18")
                .prompt("traduza para o português o texto: " + texto)
                .maxTokens(1000)
                .temperature(0.7)
                .build();

        var resposta = service.createCompletion(requisicao);
        return resposta.getChoices().get(0).getText();
    }
}