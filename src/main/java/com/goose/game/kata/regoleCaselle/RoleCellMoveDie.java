package com.goose.game.kata.regoleCaselle;

import com.goose.game.kata.oggettiGioco.Player;
import com.goose.game.kata.oggettiGioco.PosizioniTabellone;
import com.goose.game.kata.oggettiGioco.RollingDie;
import com.goose.game.kata.utility.Constant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RoleCellMoveDie implements RoleCell {
    Player player;
    PosizioniTabellone posttabellone;
    RollingDie rolllingDie;

    boolean overCell = false;
    boolean isCellBridge=false;
    HashMap<Integer,Integer> cellBridge = new HashMap<Integer,Integer>();

    public RoleCellMoveDie() {
         cellBridge.put(4,12);
    }

    public void calcolaNuovaPosizione(Player p, PosizioniTabellone t, RollingDie r){
        player=p;
        posttabellone = t;
        rolllingDie = r;

        Integer newPosition = p.getPositionDie() + rolllingDie.getResult();
        isCellBridge=false;
        if (cellBridge.get(newPosition)!=null){
            isCellBridge=true;
            newPosition= cellBridge.get(newPosition);
        }

        overCell=false;
        if (newPosition > Constant.FINAL_CELL){
            Integer delta = newPosition - Constant.FINAL_CELL  ;
            newPosition = Constant.FINAL_CELL - delta;
            overCell = true;
        }
        p.setPositionDie(newPosition);
    }

    public String printMessage(){
        String message="";



        message = player.getName() + " rolls " +rolllingDie.printValueDies()+" "+ player.getName()+ " moves from "
                +(player.getPosition().equals(0)? "Start": player.getPosition()) + " to "+ player.getPositionDie();

        if (isCellBridge){
            message = player.getName() + " rolls " +rolllingDie.printValueDies()+" "+ player.getName()+ " moves from "
                    +(player.getPosition().equals(0)? "Start": player.getPosition()) + " to The Bridge. Pippo jumps to 12";

        }


        if (overCell){
            message = player.getName() + " rolls " +rolllingDie.printValueDies()+" "+ player.getName()+ " moves from "
                    +(player.getPosition().equals(0)? "Start": player.getPosition()) + " to "+ Constant.FINAL_CELL
                    + " " +player.getName() +" bounces! "+ player.getName() +" returns to " +player.getPositionDie();
        }

        if (player.getPositionDie().equals(Constant.FINAL_CELL)){
            message=message +"." +player.getName()+" Wins!!";
        }
        return message;
    }

    public Boolean isRoleImpact(){
        return true;
    }
}
