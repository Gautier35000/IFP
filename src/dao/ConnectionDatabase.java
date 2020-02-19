package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class ConnectionDatabase {
    public Connection getConnection() throws SQLException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/ifp?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
            String utilisateur = "root";
            String motDePasse = "";
            return DriverManager.getConnection(url, utilisateur, motDePasse);
        } catch (ClassNotFoundException e) {
            throw new SQLException(e);
        } catch (SQLException e) {
            throw e;
        }

    }
}
