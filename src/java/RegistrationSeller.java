
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/homeb")
public class RegistrationSeller extends HttpServlet

{
    @Override
    public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException
    {
        PrintWriter out=res.getWriter();
     
        String fname=req.getParameter("fname");
        String lname=req.getParameter("lname");
        String password=req.getParameter("pass");
        String city=req.getParameter("city");
        String address=req.getParameter("address");
        String email=req.getParameter("email");
        String pincode=req.getParameter("pincode");
         String phone=req.getParameter("phone");  
         String id="sathish";
         String pass="sathish";
        {  
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con=DriverManager.getConnection(
                        "jdbc:oracle:thin:@localhost:1521:xe",id,pass);
                
                PreparedStatement ps=con.prepareStatement(
                        "insert into registeruser values(?,?,?,?,?,?,?,?,?)");
                
                ps.setString(1,fname);
                ps.setString(2,lname);
                ps.setString(3,email);
                ps.setString(4,password);
                ps.setString(5,phone);
                ps.setString(6,city);
                ps.setString(7,address);
                ps.setString(8,pincode);
                ps.setString(9,"1");
                int i=0;
                try
                    
                { i=ps.executeUpdate();}
                catch(SQLIntegrityConstraintViolationException e)
                {
                  out.println("already a registered user");  
                }
                if(i>0)  
                {
                    out.println("You are successfully registered..., redirecting you to home page");
                HttpSession ses=req.getSession();
                //ses.setAttribute("email",email);
                //ses.setAttribute("password",pass);
                res.setHeader("Refresh","3;index.jsp");
                
                
                }
                else
                out.println("registration failed");
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(RegistrationSeller.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    }
 }


