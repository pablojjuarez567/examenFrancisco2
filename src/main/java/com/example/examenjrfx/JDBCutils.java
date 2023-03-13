package com.example.examenjrfx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCutils {
    static private Connection con = null;

    static {
        //TODO: Cambiar el usuario y contraseña si es necesario
        String url = "jdbc:mysql://localhost:3306/alumnado";
        String user = "root";
        String password = "root";
        try {
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Conexion Satisfactoria");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public static Connection getConnection() {
        return con;
    }
}
