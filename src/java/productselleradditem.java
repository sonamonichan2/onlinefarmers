import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
@WebServlet("/selleraddproduct")
public class productselleradditem extends HttpServlet {

    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
        PrintWriter out = res.getWriter();
        String id = "sathish";
        String pass = "sathish";
        String item = req.getParameter("item");
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("email");
       String pncode = (String) session.getAttribute("pincode");
       int pincode=Integer.parseInt(pncode);
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        int price = Integer.parseInt(req.getParameter("price"));
        Random rand = new Random(); 
  
        // Generate random integers in range 0 to 999 
        int uid = rand.nextInt(10000); 
        int remaining = quantity;
        
            Date date = (Date) Calendar.getInstance().getTime();  
            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
            String date1 = dateFormat.format(date);  
            out.println("item:"+item+"price"+price+"quantity:"+quantity+"\titemid:"+uid+"\tpincode:"+pincode+"mail:"+username);
             try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe", id, pass);

            PreparedStatement ps = con.prepareStatement(
                    "insert into productseller values(?,?,?,?,?,?,?,?,?)");
            
            ps.setInt(1, uid);
            ps.setString(2, username);
            ps.setString(3, item);
            ps.setInt(4, quantity);
            ps.setInt(5, price);
            ps.setInt(6, 1);
            ps.setString(7, date1);
            ps.setInt(8, 0);
            ps.setInt(9, pincode);
            int i = 0;

            try 
            {
                i = ps.executeUpdate();
                System.out.println("exe");
                
            } 
            catch (SQLException ex) {
                Logger.getLogger(productselleradditem.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(i>0)
                {
                    out.println("successfully updated");
                    res.sendRedirect("product/productseller.jsp");
                }
                else 
                {
                    out.println("updation failed");
                }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(productselleradditem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(productselleradditem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
