
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/orderconfirmation")
public class orderconfirmation extends HttpServlet
{
   @Override
   public void service(HttpServletRequest req,HttpServletResponse res) throws IOException
   {
       PrintWriter out=res.getWriter();
          String id = "sathish";
        String pass = "sathish";
        String item = req.getParameter("item");
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("email");
        int totalfinal = Integer.parseInt(req.getParameter("totalfinal"));
     
        Random rand = new Random(); 
 
       int uid = rand.nextInt(1000000);
       int trackid=rand.nextInt(1000000);
        Date date = (Date) Calendar.getInstance().getTime();  
DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
String date1 = dateFormat.format(date);  
out.println("total:"+totalfinal+"username:"+username+"transid:"+uid+"trackid:"+trackid+"date:"+date1);
       // out.println("item:"+item+"price"+price+"quantity:"+quantity+"\titemid:"+uid+"\tpincode:"+pincode+"mail:"+username);
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe", id, pass);

            PreparedStatement ps = con.prepareStatement(
                    "insert into payment values(?,?,?,?,?)");
            ps.setString(1, date1);
            ps.setInt(2, uid);
            ps.setString(3, username);
            ps.setInt(4, totalfinal);
            ps.setInt(5, 1);
            int i = 0;
            try 
            {
                i = ps.executeUpdate();
                System.out.println("exe");
                
            } 
 
            catch (Exception e) {
                out.println("exception 1"+e);
            }
 String strQuery="select * from productbuyer where emailid='"+username+"' and iscart=1";
 String query2= "update productbuyer set iscart=0";
 System.out.println(strQuery);
 Statement st = con.createStatement();
 ResultSet rs = st.executeQuery(strQuery);
 
 while(rs.next())
      {
int itemid=rs.getInt(1);
int quantity=rs.getInt(4);
String Strqueryupdate="update productseller set sold=sold+"+quantity+"where id="+itemid+"";
 
  PreparedStatement ps1 = con.prepareStatement("insert into checkpayment values(?,?,?)");
  ps1.setInt(1,trackid);
  ps1.setInt(2,uid);
  ps1.setInt(3,itemid);
  ResultSet rs1=st.executeQuery(Strqueryupdate);
  try
  {
      int i2=ps1.executeUpdate();
      ResultSet rs2=st.executeQuery(query2);
  }
  
  catch(Exception e)
  {
      out.println("occured in payment"+e);} 
   }
            if(i>0)
                {
                    out.println("successfully processed and your order transaction id is"+uid);
                    //res.sendRedirect("buyer/confirmation.jsp");
                }
                else 
                {
                    out.println("updation failed");
                }
            
        } catch (ClassNotFoundException e) {
            out.println(e);
        } 
       catch (SQLException e) {
out.println("exception last:"+e);
        }
    }
}
       
