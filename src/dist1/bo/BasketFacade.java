
package dist1.bo;

import dist1.ui.ItemView;
import dist1.ui.TokenView;
import java.util.ArrayList;

/**
 *
 * @author Gunnlaugur, Mats
 */
public class BasketFacade {
    
    public static ItemView[] getItemsRequest(int[] idValues) {
        BasketLogic bl = new BasketLogic();
        Item[] items = bl.getItems(idValues);
        
        //TODO check what happens if items is empty
        ItemView[] iv = new ItemView[items.length];
        for(int i = 0; i < items.length; i++) {
            iv[i] = new ItemView(items[i].getName(),items[i].getType(),items[i].getPrice(),items[i].getQuantity(),items[i].getId());
        }
        
        return iv;
    }
    
    public static void addItemsToBasketRequest(TokenView tv, ArrayList<Integer> itemIdValues) {
        BasketLogic bl = new BasketLogic();
        bl.addItemsToBasket(tv, itemIdValues);
    }
}
