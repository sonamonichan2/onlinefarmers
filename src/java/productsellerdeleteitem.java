
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

@WebServlet("/deleteproduct")
public class productsellerdeleteitem extends HttpServlet
{
public void service(HttpServletRequest req,HttpServletResponse res) throws IOException
{
    try {
        String id="sathish";
        String pass="sathish";
        String date=req.getParameter("date");
        String query="update productseller set isavailable=0 where selldate='"+date+"'";
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con=DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe",id,pass);
        Statement st=con.createStatement();
        PrintWriter out=res.getWriter();

        int rs=st.executeUpdate(query);
                out.println(date);
        if(rs==1)
        {
       
            res.sendRedirect("product/productseller.jsp?status=Product deletion successful");
        }
        else
        {
            String status="unable to delete, contact admin";
             res.sendRedirect("product/productseller.jsp?status="+status);
        }
     
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(productsellerdeleteitem.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(productsellerdeleteitem.class.getName()).log(Level.SEVERE, null, ex);
    }
}
}
