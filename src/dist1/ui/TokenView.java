
package dist1.ui;

/**
 *
 * @author Gunnlaugur, Mats
 */
public class TokenView {

    private final int id;
    private final long timeStamp;
    private final boolean authorized;
    
    public TokenView(int id, long timeStamp, boolean authorized) {
        this.id = id; this.timeStamp = timeStamp; this.authorized = authorized;
    }
    
    public int getId() {
        return id;
    }
    
    public long getTimeStamp() {
        return timeStamp;
    }
    
    public boolean getAuthorized() {
        return authorized;
    }
}
