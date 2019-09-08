package com.goose.game.kata.oggettiGioco;

import java.util.List;
import java.util.Random;

public class RollingDie {
    List<Die> dies;
    Integer result;

    public RollingDie launchDies(){
        this.result = 0;
        for (Die localdies : dies ){
            Random r = new Random();
            int low = 1;
            int high = 6;
            localdies.setValueDie(r.nextInt(high-low) + low);
            this.result = result  +localdies.getValueDie();
        }
        return this;
    }

    public List<Die> getDies() {
        return dies;
    }

    public void setDies(List<Die> dies) {
        this.dies = dies;
    }

    public String printValueDies(){
        String valuDies="";
        int count=1;
        for (Die localdies : dies ){
            valuDies= valuDies + Integer.toString(localdies.getValueDie());
            if(count != dies.size()){
                valuDies=  valuDies + ",";
            }
            count++;
        }

        return valuDies;
    }

    public Integer getResult() {
        return result;
    }
}
