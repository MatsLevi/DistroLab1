
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
    
    public ItemView(String name, String type, int price, int quantity, int id){
        this.name = name;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
        this.id = id;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(",").append(type).append(",").append(price).append(",").append(quantity).append(",").append(id);
        return sb.toString();
    }
}
