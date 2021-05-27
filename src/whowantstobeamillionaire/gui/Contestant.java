/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whowantstobeamillionaire.gui;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Admin
 */
public class Contestant implements Serializable {
    
    String name;
    Integer money;

   
    int hint;
    String date;
    int fiftyFifty;
    
    
    public Contestant(String name, Integer money, String date) {
        this.name = name;
        this.money = money;
        this.date = date;
        this.hint = 0;
        this.fiftyFifty = 0;
    }
    public Contestant(String name) {
        this.name = name;
        this.money = 0;
        this.hint = 1;
        this.fiftyFifty = 1;
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        this.date = formatter.format(calendar.getTime());
    }
     @Override
    public String toString() {
        return "Contestant{" + "name=" + name + ", money=" + money + ", hint=" + hint + ", date=" + date + ", fiftyFifty=" + fiftyFifty + '}';
    }
    
}
