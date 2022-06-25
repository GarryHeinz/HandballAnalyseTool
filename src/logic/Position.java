package logic;

public enum Position {
    LA("Links Außen"),
    RL("Rückraum Links"),
    RM("Rückraum Mitte"),
    RR("Rückraum Rechts"),
    RA("Rechts Außen"),
    KM("Kreisläufer"),
    TW("Torwart");

    private String langForm;

    private Position(String langform){
        this.langForm = langform;
    }
}
