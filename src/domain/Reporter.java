package domain;

public class Reporter {

   public int credit;
   public String name;
   public int id_reporter;

   public Reporter() {

   }

   public int getId_reporter() {
      return id_reporter;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public void setId_reporter(int id_reporter) {
      this.id_reporter = id_reporter;
   }
}
