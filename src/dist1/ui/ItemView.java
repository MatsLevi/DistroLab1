
package dist1.ui;

/**
 *
 * @author Gunnlaugur, Mats
 */
public class ItemView {
    
    private final String name;
    private final String type; //should prob be enum
    private final int price;
    private int quantity;
    private int id;

    /**
     * Constructor for ItemView contains the same information as item
     * @param name String name of item
     * @param type String item type
     * @param price int price of item
     * @param quantity int quantity of intem in db
     * @param id int identifier for items
     */
    public ItemView(String name, String type, int price, int quantity, int id){
        this.name = name;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
        this.id = id;
    }

    /**
     * Gets the item name
     * @return String containing name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets item type
     * @return String containing item type
     */
    public String getType() {
        return type;
    }

    /**
     * Gets item price
     * @return int containing the prie of the item
     */
    public int getPrice() {
        return price;
    }

    /**
     * gets the quantity of the item in the database
     * @return int containg item quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Gets item id
     * @return int containg item id
     */
    public int getId() {
        return id;
    }

    /**
     * Contains the information about the item
     * @return Sting Containg item information
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(",").append(type).append(",").append(price).append(",").append(quantity).append(",").append(id);
        return sb.toString();
    }
}
