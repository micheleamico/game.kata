package com.goose.game.kata.regoleCaselle;

import com.goose.game.kata.oggettiGioco.Player;
import com.goose.game.kata.oggettiGioco.PosizioniTabellone;
import com.goose.game.kata.oggettiGioco.RollingDie;

public class RoleCellPrank implements RoleCell {
    Player player;
    PosizioniTabellone posttabellone;
    RollingDie rolllingDie;

    boolean prank = false;
    Player playerPrank ;

    public void calcolaNuovaPosizione(Player p, PosizioniTabellone t, RollingDie r){
        player=p;
        posttabellone = t;
        rolllingDie = r;
        prank=false;
        Player playerInTabelllone = posttabellone.getPosizioneGiocatori().get(player.getPositionDie());
        if (playerInTabelllone!=null && !playerInTabelllone.getName().equals(player.getName())){
            playerPrank = posttabellone.getPosizioneGiocatori().get(player.getPositionDie());
            player.setPositionDie(player.getPosition());
            prank=true;
        }
    }

    public String printMessage(){
        String message="";
        if (prank){
            message= ". On "+ playerPrank.getPosition() +" there is " +playerPrank.getName()+" who returns to " + (player.getPosition()==0?"Start":player.getPosition());
        }
        return message;
    }

    public Boolean isRoleImpact(){
        return false;
    }
}
