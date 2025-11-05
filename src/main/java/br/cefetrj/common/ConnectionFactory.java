package br.cefetrj.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3307/aula202502", "root", "Marca.texto126");
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}