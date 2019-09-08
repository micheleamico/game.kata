package com.goose.game.kata.oggettiGioco;

import java.util.HashMap;

public class PosizioniTabellone {
    HashMap<Integer,Player> posizioneGiocatori;

    public PosizioniTabellone() {
        posizioneGiocatori = new HashMap<Integer,Player>();
    }

    public HashMap<Integer, Player> getPosizioneGiocatori() {
        return posizioneGiocatori;
    }

    public void setPosizioneGiocatori(HashMap<Integer, Player> posizioneGiocatori) {
        this.posizioneGiocatori = posizioneGiocatori;
    }


}
