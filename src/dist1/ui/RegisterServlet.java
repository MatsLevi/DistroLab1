package dist1.ui;

import dist1.bo.SecureFacade;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * The <code>RegisterServlet extends HttpServlet</code> and acts as 
 * a servlet.
 * 
 * @author Mats, Gunnlaugur
 * @see javax.servlet.http.HttpServlet
 */
@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {

    private boolean regResult;

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
        if(request.getParameter("username") == null || request.getParameter("password") == null)
            return;

        System.out.println("In register: Username: " + request.getParameter("username") + "\nPassword: " + request.getParameter("password"));

        regResult = SecureFacade.registerUser(request.getParameter("username"), request.getParameter("password"));

        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}
