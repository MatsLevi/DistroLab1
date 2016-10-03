
package dist1.bo;

import dist1.ui.ItemView;
import dist1.ui.TokenView;
import java.util.ArrayList;

/**
 *
 * @author Gunnlaugur, Mats
 */
public class BasketFacade {

    public static ItemView[] getItemsRequest(TokenView tv) {
        BasketLogic bl = new BasketLogic();
        Item[] items = bl.getItems(tv);
        
        //TODO check what happens if items is empty
        ItemView[] iv = new ItemView[items.length];
        for(int i = 0; i < items.length; i++) {
            iv[i] = new ItemView(items[i].getName(),items[i].getType(),items[i].getPrice(),items[i].getQuantity(),items[i].getId());
        }
        
        return iv;
    }

    /**
     * adds items to basket
     * @param tv tokenview contining user information
     * @param itemIdValues item ids
     */
    public static void addItemsToBasketRequest(TokenView tv, ArrayList<Integer> itemIdValues) {
        BasketLogic bl = new BasketLogic();
        bl.addItemsToBasket(tv, itemIdValues);
    }
}
