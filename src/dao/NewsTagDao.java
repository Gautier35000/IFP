package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class NewsTagDao {
    public void getAllTag(int id) throws SQLException {
        ConnectionDatabase connectionDatabase = new ConnectionDatabase();
        PreparedStatement state = connectionDatabase.getConnection().prepareStatement("SELECT * FROM `newstag` INNER JOIN tag ON newstag.id_tag = tag.id_tag WHERE id_news=?");
        state.setInt(1, id);
        ResultSet result = state.executeQuery();
        System.out.println("3/ Les tags sont: ");
        while (result.next()) {
            System.out.println(result.getString("tag"));
        }
        result.close();
        state.close();
    }

    public void createTags(String tag, String title) throws SQLException {
        ConnectionDatabase connectionDatabase = new ConnectionDatabase();
        PreparedStatement state = connectionDatabase.getConnection().prepareStatement("INSERT INTO `tag` (tag) VALUES(?)", Statement.RETURN_GENERATED_KEYS);

        state.setString(1, tag);
        state.executeUpdate();
        ResultSet rs = state.getGeneratedKeys();
        while (rs.next()) {
           int id_tag =rs.getInt(1);
        }
        PreparedStatement state2 = connectionDatabase.getConnection().prepareStatement("SELECT `id_news` FROM `news` WHERE `title`=?");
        state2.setString(1, title);
        ResultSet result = state2.executeQuery();
        while (result.next()) {
            int id_news = result.getInt(1);
        }

//        PreparedStatement state3 = connectionDatabase.getConnection().prepareStatement("INSERT INTO `newstag` (id_news,id_tag) VALUES(?,?)");
//        state3.setInt(1, id_news);
//        state3.setInt(2, id_tag);


    }
}