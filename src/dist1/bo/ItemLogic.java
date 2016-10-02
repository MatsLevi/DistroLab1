
package dist1.bo;

import dist1.db.ItemGet;

/**
 *
 * @author Gunnlaugur, Mats
 */
public class ItemLogic {
    
    public Item[] getItems() {
        return ItemGet.getItem();
    }
}
