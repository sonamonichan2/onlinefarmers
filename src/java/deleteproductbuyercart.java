
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/deleteproductbuyercart")
public class deleteproductbuyercart extends HttpServlet
{
public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException
{
    
    PrintWriter out=res.getWriter();
    HttpSession session=req.getSession();
    int itemid=Integer.parseInt(req.getParameter("itemid"));
    String email=(String)session.getAttribute("email");
    out.println(itemid);
     try {
        String id="sathish";
        String pass="sathish";
        String date=req.getParameter("date");
        String query="delete from productbuyer where itemid='"+itemid+"'and emailid='"+email+"'";
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con=DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe",id,pass);
        Statement st=con.createStatement();


        int rs=st.executeUpdate(query);
                out.println(date);
        if(rs==1)
        {
       
            res.sendRedirect("buyer/buyer.jsp?status=Product deletion successful");
        }
        else
        {
            String status="unable to delete, contact admin";
             res.sendRedirect("buyer/buyer.jsp?status="+status);
        }
     
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(productsellerdeleteitem.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(productsellerdeleteitem.class.getName()).log(Level.SEVERE, null, ex);
    }
}
}



