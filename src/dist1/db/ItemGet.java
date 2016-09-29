package dist1.db;

import dist1.bo.Item;

/**
 * Created by mats on 9/29/16.
 */
public class ItemGet extends Item {

    private ItemGet(String name, float price, String type){
        super(name, price, type);
    }

    private ItemGet(){super();}
    
    public static ItemGet getItem(){
        return new ItemGet();
    }
}
