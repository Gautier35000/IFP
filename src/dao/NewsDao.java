package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NewsDao {
    public void getAllNews() throws SQLException {
        ConnectionDatabase connectionDatabase = new ConnectionDatabase();
        PreparedStatement state = connectionDatabase.getConnection().prepareStatement("SELECT * FROM news inner join reporter on news.id_reporter = reporter.id_reporter");
        ResultSet result = state.executeQuery();
        while (result.next()) {
            System.out.println("Le nom du journaliste est "+result.getString("name")+" et le contenu de la news est: "+result.getString("contain"));
        }
        result.close();
        state.close();
    }

}
