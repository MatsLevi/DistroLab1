package dist1.ui;

import dist1.bo.SecureFacade;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author Mats, Gunnlaugur
 */
@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {

    private boolean regResult;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("username") == null || request.getParameter("password") == null)
            return;

        System.out.println("In register: Username: " + request.getParameter("username") + "\nPassword: " + request.getParameter("password"));

        regResult = SecureFacade.registerUser(request.getParameter("username"), request.getParameter("password"));


        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}
