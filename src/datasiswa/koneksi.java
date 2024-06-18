/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datasiswa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ithoib
 */
public class koneksi {
    private static Connection mysqlconfig;
    public static Connection configDB() throws SQLException{
        try {
            String url="jdbc:mysql://localhost:3306/aloomni"; //url database
            String user="root"; //user database
            String pass=""; //password database
            mysqlconfig=DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            System.err.println("koneksi gagal "+e.getMessage());
        }
        return mysqlconfig;
    }
}
