package dist1.db;

import dist1.bo.Item;

/**
 *
 * @author Mats, Gunnlaugur
 */
public class ItemGet extends Item {

    protected ItemGet(String name, String type, int price, int quantity, int id) {
        super(name, type, price, quantity, id);
    }

    protected ItemGet() {
        super();
    }

    public static ItemGet getItem() {
        return new ItemGet();
    }
}