
package dist1.ui;

import dist1.bo.BasketFacade;
import dist1.bo.ItemFacade;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * The <code>ItemServlet extends HttpServlet</code> and acts as 
 * a servlet.
 * 
 * @author Gunnlaugur, Mats
 * @see javax.servlet.http.HttpServlet
 */
@WebServlet("/itemservlet")
public class ItemServlet extends HttpServlet{

    /**
     * Gets all items from the database except those within the user basket.
     * 
     * @param tv <code>TokenView</code> user information.
     * @return <code>ItemView</code> containing item data.
     */
    public static ItemView[] getItems(TokenView tv){
        ItemView[] items = ItemFacade.getItemsRequest(tv);
        return items;
    }

    /**
     * Able to receive information from a jsp and redirect it.
     * 
     * @param request <code>HttpServletRequest</code> containing information from a jsp.
     * @param response <code>HttpServletResponse</code> needed when forwarding.
     * @throws ServletException thrown at servlet failures.
     * @throws IOException thrown at input output failures.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int size = (int)session.getAttribute("arraySize");
        ArrayList<Integer> itemValues = new ArrayList<>();

        System.out.println("In itemServlet: ");
        for(int i = 0; i < size; i++){
            try{ 
                itemValues.add(Integer.parseInt(request.getParameter(Integer.toString(i))));
            } catch(NumberFormatException e) {}
        }
        
        TokenView tv = (TokenView)session.getAttribute("Token");
        
        BasketFacade.addItemsToBasketRequest(tv, itemValues);

        request.getRequestDispatcher("basket.jsp").forward(request, response);
    }
}
