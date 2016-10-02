
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
@WebServlet("/itemservlet")
public class ItemServlet extends HttpServlet{

    protected void getItems(){

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*if(request.getParameter("username") == null || request.getParameter("password") == null)
            return;*/

        System.out.println("In item:" + request.getParameter("Kyckling") + "\nSecond item:: " + request.getParameter("Oliver"));

        request.getRequestDispatcher("basket.jsp").forward(request, response);

    }
}
