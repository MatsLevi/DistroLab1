
package dist1.ui;

/**
 *
 * @author Gunnlaugur, Mats
 */
public class TokenView {

    private final String id;
    private final long timeStamp;
    private final boolean authorized;
    
    public TokenView(String id, long timeStamp, boolean authorized) {
        this.id = id; this.timeStamp = timeStamp; this.authorized = authorized;
    }
    
    public String getId() {
        return id;
    }
    
    public long getTimeStamp() {
        return timeStamp;
    }
    
    public boolean getAuthorized() {
        return authorized;
    }
}
