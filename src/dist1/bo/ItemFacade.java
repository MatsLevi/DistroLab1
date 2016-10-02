
package dist1.bo;

import dist1.ui.ItemView;

/**
 *
 * @author Gunnlaugur, Mats
 */
public class ItemFacade {
    
    public static ItemView[] getItemsRequest() {
        ItemLogic ig = new ItemLogic();
        Item[] items = ig.getItems();
        
        ItemView[] iv = new ItemView[items.length];
        for(int i = 0; i < items.length; i++) {
            iv[i] = new ItemView(items[i].getName(),items[i].getType(),items[i].getPrice(),items[i].getQuantity(),items[i].getId());
        }
        
        return iv;
    }
}
