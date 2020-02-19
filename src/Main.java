import dao.NewsDao;
import dao.NewsTagDao;
import dao.ReporterDao;
import domain.NewsTag;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {
        ArrayList<String> programme = new ArrayList<String>(3);
        programme.add("1");
        programme.add("2");
        programme.add("3");
        programme.add("4");
        Scanner sc = new Scanner(System.in);
        String selectProgram = "";
        String verifMessage = "ok";

        do {
            if (verifMessage.equals("ko")) {
                System.out.println("Le résultat n'est pas celui attendu \n Veuillez sélectionner un programme valide:");
            } else {
                System.out.println("Menu principal");
                System.out.println("1/ Lire les informations d'un reporter par son id");
                System.out.println("2/ Lire une news par rapport à un paramètre (id de la news), récupere le nom du journaliste, récupère la liste des tags");
                System.out.println("3/ Ecriture des news en gérant l'id du reporter et l'id des tags");
                System.out.println("4/ Fin du programme");
                System.out.print("Veuillez sélectionner un programme:");
            }
            selectProgram = sc.nextLine();
            verifMessage = "ko";
        } while (!programme.contains(selectProgram));

        switch (selectProgram) {
            case "1":
                System.out.print("Quel est l'ID du reporter souhaité?");
                int selectIdReporter = sc.nextInt();
                ReporterDao reporteDao = new ReporterDao();
                try {
                    reporteDao.getAllReporter(selectIdReporter);
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.exit(-1);
                }
                break;
            case "2":
                System.out.print("Quel est l'ID de la news souhaité?");
                int selectIdNews = sc.nextInt();
                NewsDao newsDao = new NewsDao();
                NewsTagDao newsTagsDao = new NewsTagDao();
                try {
                    newsDao.getAllNews(selectIdNews);
                    newsTagsDao.getAllTag(selectIdNews);
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.exit(-1);
                }
                break;

            case "3":
                NewsDao newsDaoCreate = new NewsDao();

                System.out.print("Quel est le titre de la news?");
                String title = sc.nextLine();
                System.out.print("Quel est le contenu de la news?");
                String contain = sc.nextLine();
                System.out.print("Quel est l'id du reporter?");
                int id_reporter = sc.nextInt();

                try {
                    newsDaoCreate.createNews(title, contain, id_reporter);
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.exit(-1);
                }
                break;
            case "4":
                System.out.print("Fin du programme");
                break;
        }


    }
}
