
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
 *
 * @author Gunnlaugur, Mats
 */
@WebServlet("/basketservlet")
public class BasketServlet extends HttpServlet{
    
    public static ItemView[] getItems(TokenView tv){
        ItemView[] items = BasketFacade.getItemsRequest(tv);
        
        System.out.println("\nBasket items: ");
        for(ItemView it: items){
            System.out.println(it.toString());
        }

        return items;
    }
    
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
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(request.getParameter("button2") != null){
            request.getRequestDispatcher("availableItems.jsp").forward(request, response);
        }

        removeItems(request, response);

    }
}
