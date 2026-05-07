
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
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

@WebServlet("/deactivateuser")
public class admindeactivate extends HttpServlet
{
public void service(HttpServletRequest req,HttpServletResponse res)
{
    try {
        PrintWriter out=res.getWriter();
        String email=req.getParameter("email");
        String usertype=req.getParameter("usertype");
        String id="sathish";
        String pass="sathish";
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con=DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe",id,pass);
        Statement st=con.createStatement();
        String sq;
        String status;
        int s;
        
        if(usertype.equals("seller"))
        {
           sq="update registeruser set isactive=0 where email='"+email+"'"; 
     

        }
        else if(usertype.equals("Buyer"))
        {
            
             sq="update registeruserbuyer set isactive=0 where email='"+email+"'"; 
        
        }
        
        else if(usertype.equals("delivery boy"))
        {
             sq="update registeruserdelivery set isactive=0 where email='"+email+"'"; 
        }
        else
        {
          sq="update registeruseradmin set isactive=0 where email='"+email+"'"; 
        }
              s=st.executeUpdate(sq);
        if(s==1)
{
           status="account deactivation successful";
}
else
{
    status="no such user exists or internal error occured";
}
        int i=st.executeUpdate(sq);
        res.sendRedirect("admindeactivateuser.jsp?status="+status);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(admindeactivate.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(admindeactivate.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
        Logger.getLogger(admindeactivate.class.getName()).log(Level.SEVERE, null, ex);
    }
}
}
