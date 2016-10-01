
package dist1.ui;

import dist1.bo.SecureFacade;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gunnlaugur, Mats
 */
@WebServlet("/loginservlet")
public class LoginServlet extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("username") == null || request.getParameter("password") == null)
            return;
        
        System.out.println("Username: " + request.getParameter("username") + "\nPassword: " + request.getParameter("password"));
        
        SecureFacade sf = new SecureFacade();
        sf.authorizeRequest(request.getParameter("username"), request.getParameter("password"));
    }
}
