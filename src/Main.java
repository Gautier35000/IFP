import dao.NewsDao;
import dao.ReporterDao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {
        ArrayList<String> programme = new ArrayList<String>(3);
        programme.add("1");
        programme.add("2");
        programme.add("3");
        Scanner sc = new Scanner(System.in);
        String selectProgram = "";
        String verifMessage = "ok";

        do {
            if (verifMessage.equals("ko")) {
                System.out.println("Le résultat n'est pas celui attendu \n Veuillez sélectionner un programme valide:");
            } else {
                System.out.println("1/ Lire les informations du reporter par son id");
                System.out.print("Veuillez sélectionner un programme:");
            }
            selectProgram = sc.nextLine();
            verifMessage = "ko";
        } while (!programme.contains(selectProgram));

        switch (selectProgram) {
            case "1":
                System.out.print("Quel est l'ID du reporter souhaité?");
                int selectId = sc.nextInt();
                ReporterDao reporteDao = new ReporterDao();
                reporteDao.getAllReporter(selectId);
                break;
            case "2":
                NewsDao newsDao = new NewsDao();
                try {
                    newsDao.getAllNews();
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.exit(-1);
                }
                break;
            case "3":
                System.out.println("Wednesday");
                break;
        }


    }
}
