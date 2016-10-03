
package dist1.bo;

import dist1.ui.ItemView;
import dist1.ui.TokenView;

/**
 *
 * @author Gunnlaugur, Mats
 */
public class ItemFacade {
    
    /**
     * Returns an array of all items in the database, excluding those 
     * within the users basket.
     * 
     * @param tv the users TokenView.
     * @return the items represented as ItemViews.
     */
    public static ItemView[] getItemsRequest(TokenView tv) {
        ItemLogic il = new ItemLogic();
        Item[] items = il.getItems(tv);
        
        //TODO check what happens if items is empty
        ItemView[] iv = new ItemView[items.length];
        for(int i = 0; i < items.length; i++) {
            iv[i] = new ItemView(items[i].getName(),items[i].getType(),items[i].getPrice(),items[i].getQuantity(),items[i].getId());
        }
        
        return iv;
    }
}
