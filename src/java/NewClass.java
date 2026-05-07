
import java.sql.*;

public class NewClass {
   public static void main(String[] args) {
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
      } catch(ClassNotFoundException e) {
         System.out.println("Class not found "+ e);
      }
      try {
         Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sathish","sathish");
         
         Statement stmt = con.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT * FROM admin");
         System.out.println("id  name    job");
         
         while (rs.next()) {
            String id = rs.getString("username");
            String name = rs.getString("password");
            String job = rs.getString("email");
            System.out.println(id+"   "+name+"    "+job);
         }
      } catch(SQLException e) {
         System.out.println("SQL exception occured" + e);
      }
   }
}