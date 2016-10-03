package dist1.db;

import dist1.bo.Item;
import java.util.ArrayList;

/**
 *
 * @author Mats, Gunnlaugur
 */
public class ItemGet extends Item {

    /**
     * Constructor containing multiple variables
     * @param name String containing name of the item
     * @param type String containing item type
     * @param price int containing item price
     * @param quantity int containing quantity of intems in db
     * @param id int containing uniqe id of item
     */
    protected ItemGet(String name, String type, int price, int quantity, int id) {
        super(name, type, price, quantity, id);
    }

    protected ItemGet() {
        super();
    }

    /**
     * Tries to connect to db and get items
     * @param userId int containing uniqe ID of user
     * @return returns ItemGet array containing items
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