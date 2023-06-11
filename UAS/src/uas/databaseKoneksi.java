/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class databaseKoneksi {
    private static Connection conn;
    public static Connection getKoneksi() throws SQLException{
        String host = "jdbc:mysql://localhost:3306/dbmobil";
        String username = "username_mysql";
        String password = "password_mysql";
        conn = DriverManager.getConnection(host, username, password);
        return conn;
    }
}
