package dao;

import domain.News;
import domain.NewsTag;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class NewsDao {
    public void getAllNewsAndTags(News newsId) throws SQLException {
        getAllNews(newsId);
        NewsTagDao getAllTags = new NewsTagDao();
        getAllTags.getAllTag(newsId);
    }
    public void getAllNews(News newsId) throws SQLException {
        ConnectionDatabase connectionDatabase = new ConnectionDatabase();
        PreparedStatement state = connectionDatabase.getConnection().prepareStatement("SELECT * FROM news INNER JOIN reporter ON news.id_reporter = reporter.id_reporter WHERE id_news = ?");
        state.setInt(1, newsId.getId_news());
        ResultSet result = state.executeQuery();
        while (result.next()) {
            System.out.println("1/ Le titre de l'article est '" + result.getString("news.title") + "' et le contenu de la news est: '" + result.getString("news.contain") + "'");
            System.out.println("2/ Le reporter de l'article est '" + result.getString("reporter.name") + "'");
        }
        result.close();
        state.close();
    }
    public void createNews(News newsCreate)throws SQLException{
        ConnectionDatabase connectionDatabase = new ConnectionDatabase();
        PreparedStatement state = connectionDatabase.getConnection().prepareStatement("INSERT INTO news (title,contain,date_post,id_reporter,id_rating) VALUES(?,?,?,?,?)");
        state.setString(1, newsCreate.getTitle());
        state.setString(2, newsCreate.getContain());
        state.setDate(3,java.sql.Date.valueOf(java.time.LocalDate.now()));
        state.setInt(4,newsCreate.getId_reporter());
        state.setNull(5,java.sql.Types.INTEGER);
        state.executeUpdate();
        state.close();
        NewsTagDao newsTagCreate= new NewsTagDao();
        Scanner sc = new Scanner(System.in);


        try {
            System.out.print("Quel est le nom du tag?");
            String tag = sc.nextLine();
            NewsTag newsTag= new NewsTag();
            newsTag.setTag(tag);

            newsTagCreate.createTags(newsTag, newsCreate.getTitle());
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }


}
