package dao;

import Exceptions.NoDataDBException;
import domain.News;
import domain.NewsTag;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class NewsDao {
    public void readNewsAndTags(News newsId) throws SQLException, NoDataDBException {
        readNews(newsId);
        NewsTagDao getAllTags = new NewsTagDao();
        getAllTags.readAllTag(newsId);
    }

    public void readNews(News newsId) throws SQLException, NoDataDBException {
        ConnectionDatabase connectionDatabase = new ConnectionDatabase();

        PreparedStatement statement = connectionDatabase.BddConnection().prepareStatement("SELECT * FROM news INNER JOIN reporter ON news.id_reporter = reporter.id_reporter WHERE id_news = ?");

        statement.setInt(1, newsId.getId_news());
        ResultSet result = statement.executeQuery();

        if (result.next()) {
                System.out.println("1/ Le titre de l'article est '" + result.getString("news.title") + "' et le contenu de la news est: '" + result.getString("news.contain") + "'");
                System.out.println("2/ Le reporter de l'article est '" + result.getString("reporter.name") + "'");
        } else {
            throw new NoDataDBException("Aucun résultat en base de donnée");
        }
        result.close();
        statement.close();

    }

    public void createNews(News newsCreate) throws SQLException {
        ConnectionDatabase connectionDatabase = new ConnectionDatabase();
        PreparedStatement statement = connectionDatabase.BddConnection().prepareStatement("INSERT INTO news (title,contain,date_post,id_reporter,id_rating) VALUES(?,?,?,?,?)");
        statement.setString(1, newsCreate.getTitle());
        statement.setString(2, newsCreate.getContain());
        statement.setDate(3, java.sql.Date.valueOf(java.time.LocalDate.now()));
        statement.setInt(4, newsCreate.getId_reporter());
        statement.setNull(5, java.sql.Types.INTEGER);
        statement.executeUpdate();
        statement.close();
        NewsTagDao newsTagCreate = new NewsTagDao();
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Quel est le nom du tag?");
            String tag = sc.nextLine();
            NewsTag newsTag = new NewsTag();
            newsTag.setTag(tag);

            newsTagCreate.createTags(newsTag, newsCreate.getTitle());
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }


}
