package br.com.damin.springscreen.service;

public interface IConverteDados {
    <T> T obterDados(String json, Class<T> classe);
}
