package com.goose.game.kata;

import com.goose.game.kata.impostazioni.SettingOggettiGioco;
import com.goose.game.kata.oggettiGioco.Player;
import com.goose.game.kata.oggettiGioco.PosizioniTabellone;
import com.goose.game.kata.oggettiGioco.RollingDie;
import com.goose.game.kata.regoleCaselle.RoleCell;
import com.goose.game.kata.regoleCaselle.RoleCellMoveDie;
import com.goose.game.kata.regoleCaselle.RoleCellPrank;
import com.goose.game.kata.regoleCaselle.RoleCellTheGoose;
import com.goose.game.kata.utility.Constant;

import java.util.ArrayList;
import java.util.List;

public class StartGame {


    public static void main(String[] args) {

        System.out.println(Constant.FASE1_TITLE);
        System.out.println(Constant.FASE1_DESCRIPTION);
        System.out.println(Constant.START_GAME);
        // Inerimento giocatori

        List<Player>  listaGiocatori = SettingOggettiGioco.insertPlayer();
        // Fine inserimento giocatori

        // Inserimento numero dadi
        RollingDie diesPlay = SettingOggettiGioco.initNumberOfDie(Constant.DIES_NUMEBER);

        PosizioniTabellone posizioniTabellone = new PosizioniTabellone();
        // Fine inserimento numero dadi
        String giocatoriStart ="";
        int count =1;
        for (Player player : listaGiocatori){
              giocatoriStart= giocatoriStart +"\""+player.getName()+"\"";
              if (count != listaGiocatori.size()){
                  giocatoriStart = giocatoriStart + " end ";
              }
              count++;
        }
        List<RoleCell> listRoleCell = new ArrayList<RoleCell>();
        listRoleCell.add(new RoleCellTheGoose());
        listRoleCell.add(new RoleCellPrank());

        System.out.println(giocatoriStart +" on space \"Start\"");
        boolean endGame = false;
        RoleCellMoveDie roleCellMovieDie = new RoleCellMoveDie();
        while (!endGame){
            // Stampo posizione dei giocatori
            for (Player player : listaGiocatori){
                diesPlay.launchDies();
                System.out.println("move "+ player.getName() + " "+diesPlay.printValueDies());
                roleCellMovieDie.calcolaNuovaPosizione(player,posizioniTabellone,diesPlay);
                String msg = roleCellMovieDie.printMessage();
                boolean impactCell=true;
                while(impactCell){
                    impactCell=false;
                    for(RoleCell r : listRoleCell){
                        r.calcolaNuovaPosizione(player,posizioniTabellone,diesPlay);
                        msg = msg +r.printMessage();
                        impactCell= r.isRoleImpact();
                        if (impactCell) break;
                    }
                }
                System.out.println(msg);
                posizioniTabellone.getPosizioneGiocatori().remove(player.getPosition());
                posizioniTabellone.getPosizioneGiocatori().put(player.getPositionDie(),player);
                player.setPosition(player.getPositionDie());
                if (player.getPosition().equals(Constant.FINAL_CELL)){
                    endGame=true;
                    break;
                }
            }
        }


    }


}

