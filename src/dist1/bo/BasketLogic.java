
package dist1.bo;

import dist1.db.BasketGet;
import dist1.ui.TokenView;
import java.util.ArrayList;

/**
 *
 * @author Gunnlaugur, Mats
 */
public class BasketLogic {
    
    public Item[] getItems(int[] idValues) {
        return BasketGet.getItem(idValues);
    }
    
    public void addItemsToBasket(TokenView tv, ArrayList<Integer> itemIdValues) {
        BasketGet.addItem(tv.getId(), IntegerArrayListToIntArray(itemIdValues));
    }
    
    private int[] IntegerArrayListToIntArray(ArrayList<Integer> integers) {
        int[] ints = new int[integers.size()];
        
        for(int i = 0; i < integers.size(); i++) {
            ints[i] = integers.get(i);
        }
        return ints;
    }
}
