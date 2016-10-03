
package dist1.bo;

import dist1.db.BasketGet;

/**
 *
 * @author Gunnlaugur, Mats
 */
public class BasketLogic {
    
    public Item[] getItems(int[] idValues) {
        return BasketGet.getItem(idValues);
    }
}
