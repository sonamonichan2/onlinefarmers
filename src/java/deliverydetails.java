
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/details")
public class deliverydetails extends HttpServlet
{
public void service(HttpServletRequest req,HttpServletResponse res) throws IOException
{
    String fromemail=req.getParameter("fromemail");
    String toemail=req.getParameter("toemail");
    int itemid=Integer.parseInt(req.getParameter("itemid"));
    PrintWriter out=res.getWriter();
  String url = "jdbc:oracle:thin:@localhost:1521:xe";
 
  String driver = "oracle.jdbc.driver.OracleDriver";
  String userName = "sathish"; 
  String password = "sathish";

  
  
  try {
    Class.forName("oracle.jdbc.driver.OracleDriver");

  Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",userName,password);
  String strQuery="select * from registeruser where email='"+fromemail+"'";
 Statement st = conn.createStatement();
 ResultSet rs = st.executeQuery(strQuery);
 while(rs.next())
 {
     out.println("address:"+rs.getString(7));
     out.println("pincode:"+rs.getString(8));
     out.println("phone number:"+rs.getInt(5));
     out.println("");
 }
String strQuery2="select * from registeruserbuyer where email='"+toemail+"'";
String strQuery3="select sum(totalprice) from productbuyer where selleremail='"+fromemail+"'and iscart=0";

rs = st.executeQuery(strQuery2);
  while(rs.next())
 {
     out.println("address:"+rs.getString(7));
     out.println("pincode:"+rs.getString(8));
     out.println("phone number:"+rs.getInt(5));
 }
rs=st.executeQuery(strQuery3);
{
  while(rs.next())
  {
      out.println("total price:"+rs.getInt(1));
      
  }
  out.println("<button type='button' value='pick up'/>");
}
      
}   
  catch(Exception e)
  {
      out.println(e);
  }
    
    
}
}
