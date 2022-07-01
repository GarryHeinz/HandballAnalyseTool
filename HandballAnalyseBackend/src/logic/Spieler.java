package logic;

import logic.statistik.SpielerStatistik;

import java.util.List;

public class Spieler {

    private String name;

    private Integer nummer;

    private List<Position> moeglichePositionen;

    private Verein aktuellerVerein;

    private List<Verein> vorherigeVereine;

    private List<Spiel> spiele;

    private SpielerStatistik statistik;
}
