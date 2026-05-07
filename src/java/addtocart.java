
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/addtocart")
public class addtocart extends HttpServlet
{
public void service(HttpServletRequest req,HttpServletResponse res) throws IOException
{
    HttpSession session=req.getSession();
    String id="sathish";
    String pass="sathish";
    String item=req.getParameter("item");
    String selleremail=req.getParameter("selleremail");
    String email=(String)session.getAttribute("email");
    int quantity=Integer.parseInt(req.getParameter("quantity"));
    int price=Integer.parseInt(req.getParameter("price"));
    int totalprice=price*quantity;
    int pincode=Integer.parseInt(req.getParameter("pincode"));
    int sid=Integer.parseInt(req.getParameter("id"));
    PrintWriter out=res.getWriter();
    out.println("item:"+item+"\nquantity:"+quantity+"\nprice:"+price+"\npincode:"+pincode);
    out.println("item-id:"+sid);
    
   
    out.println("email"+email);
    try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe", id, pass);

            PreparedStatement ps = con.prepareStatement(
                    "insert into productbuyer values(?,?,?,?,?,?,?,?)");
            
            ps.setInt(1, sid);
            ps.setString(2, email);
            ps.setString(3, item);
            ps.setInt(4, quantity);
            ps.setInt(5, totalprice);
            ps.setInt(6,pincode);
            ps.setInt(7,1);
            ps.setString(8,selleremail);
            int i = 0;

            try 
            {
                i = ps.executeUpdate();
                System.out.println("exe");
                
            } 
            catch (SQLException ex) {
             out.println(ex);
            }
            if(i>0)
                {
                    out.println("successfully updated");
                    res.sendRedirect("buyer/buyer.jsp");
                }
                else 
                {
                    out.println("updation failed f");
                }
            
        } 
    catch(Exception e)
    {
        out.println (e);
    }
    }
}

