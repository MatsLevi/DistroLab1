package dist1.bo;

/**
 * Created by mats & Gunnlaugur on 9/29/16.
 */
public class Item {

    private final String name;
    private final String type; //should prob be enum
    private final float price;
    private int quantity;
    private int id;

    protected Item(String name, float price, String type){
        this.name = name;
        this.price = price;
        this.type = type;
    }

    protected Item(){
        this.name = null;
        this.price = 0;
        this.type = null;
    }

}
