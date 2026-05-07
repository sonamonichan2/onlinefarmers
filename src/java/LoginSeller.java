import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.sql.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;
@WebServlet("/LoginSeller")
public class LoginSeller extends HttpServlet{ 
 public void service(HttpServletRequest request, HttpServletResponse response)
   throws ServletException,IOException{
  response.setContentType("text/html");
  PrintWriter out = response.getWriter();

 
  String url = "jdbc:oracle:thin:@localhost:1521:xe";
 
  String driver = "oracle.jdbc.driver.OracleDriver";
  String userName = "sathish"; 
  String password = "sathish";

  HttpSession session = request.getSession(true);
  
  try {
    Class.forName("oracle.jdbc.driver.OracleDriver");

  Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",userName,password);
 
 String username = request.getParameter("username");
  String password1 = request.getParameter("password");
  String strQuery="select * from registeruser where email='"+username+"' and  password='"+password1+"'";
 System.out.println(strQuery);
 Statement st = conn.createStatement();
 ResultSet rs = st.executeQuery(strQuery);
int active=1;
  int count=0;
  while(rs.next())
  {
  
    active=rs.getInt("isactive");
   System.out.println(active); 
   if(active==1)
   {
   session.setAttribute("username",rs.getString(1));
   session.setAttribute("email",rs.getString(3));
   session.setAttribute("pincode",rs.getString(8));
   }

  count++;
  }
  if(count>0 && active==1)
  {
      
  response.sendRedirect("product/productseller.jsp");
   String s= rs.getString("username");
 
  }
  else if(count>0&&active==0)
  {
      String error="Account is deactivated"; 
 response.sendRedirect("logn.jsp?error=account is deactivated contact admin");
  }
  else
  {
      
 String error="invalid username or password"; 
 response.sendRedirect("logn.jsp?error=invalid username or password");

  }
  }  catch (ClassNotFoundException ex) {
         Logger.getLogger(loginadmin.class.getName()).log(Level.SEVERE, null, ex);
     } catch (SQLException ex) {
         Logger.getLogger(loginadmin.class.getName()).log(Level.SEVERE, null, ex);
     }

 }
}

 
  