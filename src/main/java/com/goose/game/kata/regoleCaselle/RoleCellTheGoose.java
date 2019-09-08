package com.goose.game.kata.regoleCaselle;

import com.goose.game.kata.oggettiGioco.Player;
import com.goose.game.kata.oggettiGioco.PosizioniTabellone;
import com.goose.game.kata.oggettiGioco.RollingDie;

import java.util.ArrayList;
import java.util.List;

public class RoleCellTheGoose implements RoleCell  {

    Player player;
    PosizioniTabellone posttabellone;
    RollingDie rolllingDie;

    Boolean mosso;

    List<Integer> cellGoose = new ArrayList<Integer>();

    public RoleCellTheGoose() {
        cellGoose.add(5);
        cellGoose.add(9);
        cellGoose.add(14);
        cellGoose.add(18);
        cellGoose.add(23);
        cellGoose.add(27);
    }

    public void calcolaNuovaPosizione(Player p, PosizioniTabellone t, RollingDie r){
        player=p;
        posttabellone = t;
        rolllingDie = r;
        mosso = false;
        if(cellGoose.contains(player.getPositionDie())){
            player.setPositionDie(player.getPositionDie()+r.getResult());
            mosso=true;
        }

    }

    public String printMessage(){
        String message="";
        if (mosso ){
            message=", The Goose. "+player.getName()+ " moves again and goes to "+ player.getPositionDie();
        }
        return message;
    }

    public Boolean isRoleImpact(){
        return mosso;
    }

}
