
package dist1.bo;

import dist1.db.ItemGet;
import dist1.ui.TokenView;

/**
 *
 * @author Gunnlaugur, Mats
 */
public class ItemLogic {

    /**
     * Returns an array of all items in the database, excluding those 
     * within the users basket.
     * 
     * @param tv the users TokenView.
     * @return the items represented as <code>Item</code> array.
     */
    public Item[] getItems(TokenView tv) {
        Token t = convertTokenView(tv);
        
        return ItemGet.getItem(t.getId());
    }

    /**
     * converts tokenview to token
     * @param tv a tokenview
     * @return token
     */
    private Token convertTokenView(TokenView tv) {
        return new Token(tv.getId(),tv.getTimeStamp());
    }
}
