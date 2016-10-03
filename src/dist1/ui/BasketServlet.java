
package dist1.ui;

import dist1.bo.BasketFacade;
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
@WebServlet("/basketservlet")
public class BasketServlet extends HttpServlet{
    
    public static ItemView[] getItems(){
        ItemView[] items = BasketFacade.getItemsRequest();
        
        System.out.println("\nBasket items: ");
        for(ItemView it: items){
            System.out.println(it.toString());
        }

        return items;
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }
}
