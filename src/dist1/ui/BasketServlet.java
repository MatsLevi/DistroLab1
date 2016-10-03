
package dist1.ui;

import dist1.bo.BasketFacade;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * The <code>BasketServlet extends HttpServlet</code> and acts as 
 * a servlet.
 * 
 * @author Gunnlaugur, Mats
 * @see javax.servlet.http.HttpServlet
 */
@WebServlet("/basketservlet")
public class BasketServlet extends HttpServlet{

    /**
     * Gets the items in the user basket specified by the <code>TokenView</code>.
     * 
     * @param tv <code>TokenView</code> containing authentication information of a user.
     * @return <code>ItemView</code> array containing item information.
     */
    public static ItemView[] getItems(TokenView tv){

        ItemView[] items = BasketFacade.getItemsRequest(tv);
        return items;
    }

    /**
     * Removes items from a users basket.
     * 
     * @param request <code>HttpServletRequest</code> containing information from a jsp.
     * @param response <code>HttpServletResponse</code> needed when forwarding.
     * @throws ServletException thrown at servlet failures.
     * @throws IOException thrown at input output failures.
     */
    private void removeItems(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int size = (int)session.getAttribute("basketArraySize");
        ArrayList<Integer> itemValues = new ArrayList<>();

        System.out.println("In basketServlet: ");
        for(int i = 0; i < size; i++){
            try{ 
                itemValues.add(Integer.parseInt(request.getParameter(Integer.toString(i))));
            } catch(NumberFormatException e) {}
        }
        
        TokenView tv = (TokenView)session.getAttribute("Token");
        
        BasketFacade.removeItemsFromBasketRequest(tv, itemValues);
        
        request.getRequestDispatcher("basket.jsp").forward(request, response);
    }

    /**
     * Receives data from a jsp.
     * 
     * @param request HttpServletRequest containing information from a jsp.
     * @param response HttpServletResponse an argument of the doPost method.
     * @throws ServletException thrown at servlet failures.
     * @throws IOException thrown at input output failures.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("button2") != null){
            request.getRequestDispatcher("availableItems.jsp").forward(request, response);
        }

        removeItems(request, response);
    }
}
