
package dist1.bo;

import dist1.db.ItemGet;
import dist1.ui.TokenView;

/**
 *
 * @author Gunnlaugur, Mats
 */
public class ItemLogic {

    /**
     * gets items from the database
     * @param tv token containing user info
     * @return desiered item or items
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
