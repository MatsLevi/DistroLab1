package dist1.bo;

/**
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
     * Constructor containing multiple variables
     * @param name String containing name of the item
     * @param type String containing item type
     * @param price int containing item price
     * @param quantity int containing quantity of intems in db
     * @param id int containing uniqe id of item
     */
    protected Item(String name, String type, int price, int quantity, int id){
        this.name = name;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
        this.id = id;
    }

    /**
     * constructor
     */
    protected Item(){
        this.name = null;
        this.price = 0;
        this.type = null;
    }

    /**
     * getter for item name
     * @return String containing name
     */
    public String getName() {
        return name;
    }

    /**
     * getter for item type
     * @return String containing type
     */
    public String getType() {
        return type;
    }

    /**
     * getter for price
     * @return int containing price
     */
    public int getPrice() {
        return price;
    }

    /**
     * getter for quantity
     * @return int containing quantity of an item
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * getter for id
     * @return int containing item id
     */
    public int getId() {
        return id;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(",").append(type).append(",").append(price).append(",").append(quantity).append(",").append(id);
        return sb.toString();
    }
}
