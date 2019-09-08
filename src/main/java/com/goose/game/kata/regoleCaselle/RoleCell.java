package com.goose.game.kata.regoleCaselle;

import com.goose.game.kata.oggettiGioco.Player;
import com.goose.game.kata.oggettiGioco.PosizioniTabellone;
import com.goose.game.kata.oggettiGioco.RollingDie;

public interface RoleCell {

    void calcolaNuovaPosizione(Player p, PosizioniTabellone t, RollingDie r);

    String printMessage();

    Boolean isRoleImpact();
}
