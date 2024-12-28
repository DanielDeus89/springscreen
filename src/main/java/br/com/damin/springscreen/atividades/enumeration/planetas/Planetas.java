package br.com.damin.springscreen.atividades.enumeration.planetas;

public enum Planetas {
    MERCURIO,
    VENUS,
    TERRA,
    MARTE,
    JUPITER,
    SATURNO,
    URANO,
    NETUNO;


    public void qualPlaneta(Planetas planeta){
        switch (planeta){
            case MERCURIO:
                System.out.println("Mercurio");
                break;
            default:
                System.out.println("Nenhum planeta encontrado");
        }
    }
}

