package dao;


import domain.Reporter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReporterDao {

    public void readReporter(Reporter idReporter) throws SQLException {
        ConnectionDatabase connectionDatabase = new ConnectionDatabase();
        PreparedStatement state = connectionDatabase.BddConnection().prepareStatement("SELECT * FROM reporter WHERE id_reporter = ?");
        state.setInt(1, idReporter.getId_reporter());
        ResultSet result = state.executeQuery();
        while (result.next()) {
            System.out.println("Le reporter " + (result.getString(2) + " a pour id " + result.getInt(1) + " et pour crédit " + result.getInt(3)));
        }
        result.close();
        state.close();
    }


}
