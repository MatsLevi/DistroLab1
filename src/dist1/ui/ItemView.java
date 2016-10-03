
package dist1.ui;

/**
 * The <code>ItemView class</code> consists of data concerning the 
 * <code>ItemView</code>.
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
     * Constructs an ItemView with given parameters.
     * 
     * @param name <code>String</code> name of item.
     * @param type <code>String</code> item type.
     * @param price <code>int</code> price of item.
     * @param quantity <code>int</code> quantity of item in database.
     * @param id <code>int</code> identifier for item.
     */
    public ItemView(String name, String type, int price, int quantity, int id){
        this.name = name;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
        this.id = id;
    }

    /**
     * Gets the item name.
     * 
     * @return <code>String</code> containing name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets item type.
     * 
     * @return <code>String</code> containing item type.
     */
    public String getType() {
        return type;
    }

    /**
     * Gets item price.
     * 
     * @return <code>int</code> containing the price of the item.
     */
    public int getPrice() {
        return price;
    }

    /**
     * Gets the quantity of the item in the database.
     * 
     * @return <code>int</code> containing item quantity.
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
     * Returns information about the item.
     * 
     * @return <code>Sting</code> Containing item information.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(",").append(type).append(",").append(price).append(",").append(quantity).append(",").append(id);
        return sb.toString();
    }
}
