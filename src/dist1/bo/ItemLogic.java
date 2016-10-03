
package dist1.bo;

import dist1.db.ItemGet;
import dist1.ui.TokenView;

/**
 * The <code>ItemLogic</code> contains logical methods to be performed on 
 * items.
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
     * Converts <code>TokenView</code> to token.
     * 
     * @param tv a <code>TokenView</code>.
     * @return converted <code>Token</code>.
     */
    private Token convertTokenView(TokenView tv) {
        return new Token(tv.getId(),tv.getTimeStamp());
    }
}
