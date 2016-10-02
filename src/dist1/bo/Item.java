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
}
