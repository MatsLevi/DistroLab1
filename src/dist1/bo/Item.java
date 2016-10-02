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

    protected Item(String name, String type, int price, int quantity, int id){
        this.name = name;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
        this.id = id;
    }

    protected Item(){
        this.name = null;
        this.price = 0;
        this.type = null;
    }
    
    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

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
