
package dist1.ui;

import dist1.bo.SecureFacade;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * The <code>LoginServlet extends HttpServlet</code> and acts as 
 * a servlet.
 * 
 * @author Gunnlaugur, Mats
 * @see javax.servlet.http.HttpServlet
 */
@WebServlet("/loginservlet")
public class LoginServlet extends HttpServlet{

    /**
     * Receives data from jsp and redirects it.
     * 
     * @param request <code>HttpServletRequest</code> containing information from a jsp.
     * @param response <code>HttpServletResponse</code> needed when forwarding.
     * @throws ServletException thrown at servlet failures.
     * @throws IOException thrown at input output failures.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("username") == null || request.getParameter("password") == null || 
                request.getParameter("username").equals("") || request.getParameter("password").equals("")) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }
        
        System.out.println("In login: Username: " + request.getParameter("username") + "\nPassword: " + request.getParameter("password"));

        TokenView tv = SecureFacade.authorizeRequest(request.getParameter("username"), request.getParameter("password"));
        System.out.println("TokenView id: " + tv.getId() + "\nTokenView timestamp: " + tv.getTimeStamp() + "\nTokenView auth: " + tv.getAuthorized());

        if(tv.getAuthorized() == true){
            HttpSession session = request.getSession();
            session.setAttribute("Token", tv);

            request.getRequestDispatcher("availableItems.jsp").forward(request, response);
        }else{
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
