package br.com.damin.springscreen.atividades.enumeration.planetas2;

public enum Planetas {
    MERCURIO(3.303e+23, 2439.7),
    VENUS(4.869e+24, 6051.8),
    TERRA(5.976e+24, 6378.1),
    MARTE(6.421e+23, 3397.2);

    private final double massa;
    private final double raio;

    Planetas(double massa, double raio) {
        this.massa = massa;
        this.raio = raio;
    }

    public double gravidade() {
        double G = 6.67430e-11; // Constante gravitacional
        return (G * massa) / (raio * raio);
    }
}
