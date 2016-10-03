package dist1.db;

import dist1.bo.Item;
import java.util.ArrayList;

/**
 * The <code>ItemGet</code> acts as a connector between the <code>ItemLogic</code> 
 * and the <code>DBConnector</code>.
 * 
 * @author Mats, Gunnlaugur
 * @see dist1.bo.ItemLogic
 * @see dist1.db.DBConnector
 */
public class ItemGet extends Item {

    /**
     * Constructs an <code>ItemGet</code> taking multiple variables.
     * 
     * @param name <code>String</code> containing name of the item.
     * @param type <code>String</code> containing item type.
     * @param price <code>int</code> containing item price.
     * @param quantity <code>int</code> containing quantity of items in db.
     * @param id <code>int</code> containing unique id of item.
     */
    protected ItemGet(String name, String type, int price, int quantity, int id) {
        super(name, type, price, quantity, id);
    }

    /**
     * Constructs an empty <code>ItemGet</code>.
     */
    protected ItemGet() {
        super();
    }

    /**
     * Tries to connect to the db and get all items that are not in the user basket.
     * 
     * @param userId <code>int</code> containing unique id of the user.
     * @return returns <code>ItemGet</code> array containing the retrieved items.
     */
    public static ItemGet[] getItem(int userId) {
        DBConnector db = null;
        
        try{
            db = new DBMYSQLConnector();
            db.connect("store", "item_user", "123");
            
            ArrayList<ItemGet> items = db.getItems(userId);
            db.disconnect();
            
            ItemGet[] ig = new ItemGet[items.size()];
            for(int i = 0; i < items.size(); i++)
                ig[i] = items.get(i);
            
            return ig;
        } catch(Exception ex) {
            System.out.println("getItem: " + ex.toString());
            if(db != null) 
                db.disconnect();
            
            return new ItemGet[1];
        }
    }
}