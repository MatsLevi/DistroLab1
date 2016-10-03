
package dist1.db;

import java.util.ArrayList;

/**
 * The <code>BasketGet</code> acts as a connector between the <code>BasketLogic</code> 
 * and the <code>DBConnector</code>.
 * 
 * @author Gunnlaugur, Mats
 * @see dist1.bo.BasketLogic
 * @see dist1.db.DBConnector
 */
public class BasketGet {

    /**
     * Sets up a <code>DBConnector</code> and tries to get the users items from 
     * the database.
     * 
     * @param userId <code>int</code> containing the users id.
     * @return <code>ItemGet</code> array containing the items.
     */
    public static ItemGet[] getItem(int userId) {
        DBConnector db = null;
        
        try{
            db = new DBMYSQLConnector();
            db.connect("store", "item_user", "123");
            
            ArrayList<ItemGet> items = db.getBasketItems(userId);
            db.disconnect();
            
            ItemGet[] ig = new ItemGet[items.size()];
            for(int i = 0; i < items.size(); i++)
                ig[i] = items.get(i);
            
            return ig;
        } catch(Exception ex) {
            System.out.println("getItem2: " + ex.toString());
            if(db != null) 
                db.disconnect();
            
            return new ItemGet[1];
        }
    }

    /**
     * Adds items into the basket in the database.
     * 
     * @param userId <code>int</code> containing user id.
     * @param itemIdValues <code>int</code> array containing ids of the items to be added.
     */
    public static void addItems(int userId, int[] itemIdValues) {
        DBConnector db = null;
        
        try{
            db = new DBMYSQLConnector();
            db.connect("store", "item_user", "123");
            
            db.addToBasket(userId, itemIdValues);
            db.disconnect();
        } catch(Exception ex) {
            System.out.println("addItem5: " + ex.toString());
            if(db != null) 
                db.disconnect();
        }
    }

    /**
     * Connects to the database and removes one or more items from a users basket.
     * 
     * @param userId <code>int</code> identifier for the user.
     * @param itemIdValues <code>int</code> array containing item identifiers.
     */
    public static void removeItems(int userId, int[] itemIdValues) {
        DBConnector db = null;
        
        try{
            db = new DBMYSQLConnector();
            db.connect("store", "item_user", "123");
            
            db.removeFromBasket(userId, itemIdValues);
            db.disconnect();
        } catch(Exception ex) {
            System.out.println("removeItems: " + ex.toString());
            if(db != null) 
                db.disconnect();
        }
    }
}
