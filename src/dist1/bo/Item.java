
package dist1.bo;

/**
 * The <code>Item class</code> consists of data concerning the item.
 * 
 * @author Mats, Gunnlaugur
 */
public class Item {

    private final String name;
    private final String type; //should prob be enum
    private final int price;
    private int quantity;
    private int id;

    /**
     * Constructs an Item based on given parameters.
     * 
     * @param name <code>String</code> containing name of the item.
     * @param type <code>String</code> containing item type.
     * @param price <code>int</code> containing item price.
     * @param quantity <code>int</code> containing quantity of items in db.
     * @param id <code>int</code> containing a unique id of the item.
     */
    protected Item(String name, String type, int price, int quantity, int id){
        this.name = name;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
        this.id = id;
    }

    /**
     * Constructs an empty Item.
     */
    protected Item(){
        this.name = null;
        this.price = 0;
        this.type = null;
    }

    /**
     * Gets item name.
     * 
     * @return <code>String</code> containing name.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets item type.
     * 
     * @return <code>String</code> containing type.
     */
    public String getType() {
        return type;
    }

    /**
     * Gets item price.
     * 
     * @return <code>int</code> containing the item price.
     */
    public int getPrice() {
        return price;
    }

    /**
     * Gets item quantity.
     * 
     * @return <code>int</code> containing the quantity of the item.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Gets item id.
     * 
     * @return <code>int</code> containing item id.
     */
    public int getId() {
        return id;
    }
    
    /**
     * Returns a string containing the item information.
     * 
     * @return the item information.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(",").append(type).append(",").append(price).append(",").append(quantity).append(",").append(id);
        return sb.toString();
    }
}
