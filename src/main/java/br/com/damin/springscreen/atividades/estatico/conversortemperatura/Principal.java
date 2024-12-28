package br.com.damin.springscreen.atividades.estatico.conversortemperatura;

public class Principal {
    public static void main(String[] args) {
        double celsius = 25;
        double fahrenheit = ConversorTemperatura.celsiusParaFahrenheit(celsius);
        System.out.println(celsius + "°C em Fahrenheit: " + fahrenheit);

        double fahrenheit2 = 77;
        double celsius2 = ConversorTemperatura.fahrenheitParaCelsius(fahrenheit2);
        System.out.println(fahrenheit2 + "°F em Celsius: " + celsius2);
    }
}
