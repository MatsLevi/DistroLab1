
package dist1.bo;

import dist1.db.BasketGet;
import dist1.ui.TokenView;
import java.util.ArrayList;

/**
 *
 * @author Gunnlaugur, Mats
 */
public class BasketLogic {
    
    public Item[] getItems(TokenView tv) {
        return BasketGet.getItem(tv.getId());
    }

    /**
     * adds items to a users basket
     * @param tv TokenView containing user info
     * @param itemIdValues items IDs
     */
    public void addItemsToBasket(TokenView tv, ArrayList<Integer> itemIdValues) {
        BasketGet.addItems(tv.getId(), IntegerArrayListToIntArray(itemIdValues));
    }
    
    public void removeItemsFromBasket(TokenView tv, ArrayList<Integer> itemIdValues) {
        BasketGet.removeItems(tv.getId(), IntegerArrayListToIntArray(itemIdValues));
    }
    
    private int[] IntegerArrayListToIntArray(ArrayList<Integer> integers) {
        int[] ints = new int[integers.size()];
        
        for(int i = 0; i < integers.size(); i++) {
            ints[i] = integers.get(i);
        }
        return ints;
    }
}
