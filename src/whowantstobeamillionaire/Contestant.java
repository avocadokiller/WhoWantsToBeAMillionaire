/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whowantstobeamillionaire;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Admin
 */
public class Contestant implements Serializable {

    String name;
    int money;
    int hint;
    String date;
    int fiftyFifty;

    public Contestant(String name) {
        this.name = name;
        this.money = 0;
        this.hint = 1;
        this.fiftyFifty = 1;
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        this.date = formatter.format(calendar.getTime());
    }

}
