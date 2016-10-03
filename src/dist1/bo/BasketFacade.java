
package dist1.bo;

import dist1.ui.ItemView;
import dist1.ui.TokenView;
import java.util.ArrayList;

/**
 *
 * @author Gunnlaugur, Mats
 */
public class BasketFacade {

    /**
     * Returns an array of the items in the database, excluding those that 
     * within the users basket.
     * 
     * @param tv the users TokenView.
     * @return the items represented as ItemViews.
     */
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
     * Adds items to basket.
     * 
     * @param tv TokenView containing user information.
     * @param itemIdValues the items id values to be added.
     */
    public static void addItemsToBasketRequest(TokenView tv, ArrayList<Integer> itemIdValues) {
        BasketLogic bl = new BasketLogic();
        bl.addItemsToBasket(tv, itemIdValues);
    }

    /**
     * Removes items from basket.
     * 
     * @param tv TokenView containing user information.
     * @param itemIdValues the items id values to be removed.
     */
    public static void removeItemsFromBasketRequest(TokenView tv, ArrayList<Integer> itemIdValues) {
        BasketLogic bl = new BasketLogic();
        bl.removeItemsFromBasket(tv, itemIdValues);
    }
}
