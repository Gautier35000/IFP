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
            Connection connection = DriverManager.getConnection(url, utilisateur, motDePasse);
            return connection;
        } catch (ClassNotFoundException e) {
            throw new SQLException(e);
        } catch (SQLException e) {
            throw e;
        }
        //PreparedStatement state = connection.prepareStatement("INSERT INTO news(titre,contenu,datepost,tags)VALUES (?,?,?,?)");
        //state.setString(1, "Titre1");
        //state.setString(2, "Contenu1");
        //state.setTimestamp(3, Timestamp.valueOf("2013-09-04 13:30:00"));
        //state.setString(4, "tags1");
        //state.executeUpdate();
        //state.close();

        //PreparedStatement state = connection.prepareStatement("SELECT * FROM news WHERE id = ?");
        //state.setInt(1, 1);

        //ResultSet result = state.executeQuery();
        //while (result.next()) {
        //    System.out.println(result.getString(1));
        //}
        //result.close();
        //state.close();
    }
}
