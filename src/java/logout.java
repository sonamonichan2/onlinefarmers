
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class logout extends  HttpServlet
{
    public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException
    {
        PrintWriter out=res.getWriter();
        HttpSession session=req.getSession();
        session.setAttribute("username",null);
        session.setAttribute("email",null);
        session.setAttribute("pincode",null);
        res.sendRedirect("index.jsp");
        out.println("server error occured");
    }
}
