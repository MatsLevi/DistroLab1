package dist1.ui;

import dist1.bo.SecureFacade;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by mats & Gunnlaugur on 10/1/16.
 */
@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("username") == null || request.getParameter("password") == null)
            return;

        System.out.println("In register: Username: " + request.getParameter("username") + "\nPassword: " + request.getParameter("password"));

        SecureFacade.authorizeRequest(request.getParameter("username"), request.getParameter("password"));
    }
}
