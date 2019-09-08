package com.goose.game.kata.impostazioni;

import com.goose.game.kata.oggettiGioco.Die;
import com.goose.game.kata.oggettiGioco.Player;
import com.goose.game.kata.oggettiGioco.RollingDie;
import com.goose.game.kata.oggettiGioco.PosizioniTabellone;
import com.goose.game.kata.utility.Constant;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SettingOggettiGioco {

    public static List<Player> insertPlayer() {
        List<Player>  listaGiocatori = new ArrayList<Player>();

        boolean stopInsertPlayer = false;
        int i = 1;
        String printPlayers=Constant.PLAYERS;

        while (!stopInsertPlayer){
            String nomeGiocatore ="";
            Scanner nomeGiocatoreInput = new Scanner(System.in);
            nomeGiocatore =  nomeGiocatoreInput.nextLine();
            // nomeGiocatore = nomeGiocatoreInput.next();

            if (nomeGiocatore.startsWith(Constant.ADD_PLAYER)){
                nomeGiocatore = nomeGiocatore.replace(Constant.ADD_PLAYER,"");
                if (newPlayer(nomeGiocatore,listaGiocatori)){
                    Player p = new Player(nomeGiocatore);
                    if (listaGiocatori.size()>Constant.MAX_PLAYERS_NUMBER){
                        System.out.println(Constant.MAX_PLAYER_MSG);
                    }else{
                        if (listaGiocatori.size()>0){
                            printPlayers = printPlayers + ",";
                        }
                        printPlayers=printPlayers +" "+ p.getName();
                        System.out.println(printPlayers);
                        listaGiocatori.add(p);
                    }

                }else{
                    System.out.println(nomeGiocatore + ": already existing player");
                }

            }else if (nomeGiocatore.startsWith(Constant.START)){
                if (listaGiocatori.size()<2){
                    System.out.println(Constant.MIN_PLAYER_MSG);
                }else{
                    stopInsertPlayer =true;
                }
            }
        }
        return listaGiocatori;
    }

    private static boolean newPlayer(String namePlayer, List<Player>  listaGiocatori ){
        for (Player p : listaGiocatori){
            if (p.getName().equals(namePlayer)){
                return false;
            }
        }

        return true;
    }

    public static RollingDie initNumberOfDie(Integer numberOfDies ){
        RollingDie r = new RollingDie();
        List<Die> dies = new ArrayList<Die>();
        for (int i= 0 ; i<numberOfDies;i++){
            Die die = new Die();
            dies.add(die);
        }
        r.setDies(dies);
        return r;
    }
    public PosizioniTabellone initPosizioniTabellone(){
        return new PosizioniTabellone();
    }
}
