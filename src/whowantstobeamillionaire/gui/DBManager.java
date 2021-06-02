/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whowantstobeamillionaire.gui;

/**
 *
 * @author Sasha Buskin
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public final class DBManager {//Class to establish and control database connectivity

   
    private static final String URL = "jdbc:derby://localhost:1527/WWTBAM";
    private static final String USER_NAME = "sasha"; 
    private static final String PASSWORD = "sasha"; 
    
    Connection conn;

    public DBManager() {
        establishConnection();
    }   

    public Connection getConnection() {
        return this.conn;
    }
    
    //Method to connect to WWTBAM database
    public void establishConnection() {
        if (this.conn == null) {
            try {
                conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
                System.out.println(URL + "Connected to question database....");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public void closeConnections() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

}

