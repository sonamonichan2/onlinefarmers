import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.sql.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;
@WebServlet("/LoginAdmin")
public class loginadmin extends HttpServlet{ 
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
  String strQuery="select * from admin where username='"+username+"' and  password='"+password1+"'";
 System.out.println(strQuery);
 Statement st = conn.createStatement();
 ResultSet rs = st.executeQuery(strQuery);

  int count=0;
  while(rs.next())
  {
  session.setAttribute("username",rs.getString(1));
   
  count++;
  }
  if(count>0)
  {
      
  response.sendRedirect("adminreport.jsp");
   String s= rs.getString("username");
 
  }
  else
  {
      
      //out.println(<"input type="hidden" name="error"value="invalid login details">);
 response.sendRedirect("adminhome.jsp?error='invalid username or password'");
 

  }
  }  catch (ClassNotFoundException ex) {
         Logger.getLogger(loginadmin.class.getName()).log(Level.SEVERE, null, ex);
     } catch (SQLException ex) {
         Logger.getLogger(loginadmin.class.getName()).log(Level.SEVERE, null, ex);
     }

 }
}

 
  