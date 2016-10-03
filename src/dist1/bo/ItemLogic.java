
package dist1.bo;

import dist1.db.ItemGet;
import dist1.ui.TokenView;

/**
 *
 * @author Gunnlaugur, Mats
 */
public class ItemLogic {
    
    public Item[] getItems(TokenView tv) {
        Token t = convertTokenView(tv);
        
        return ItemGet.getItem(t.getId());
    }

    private Token convertTokenView(TokenView tv) {
        return new Token(tv.getId(),tv.getTimeStamp());
    }
}
