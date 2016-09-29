
package dist1.bo;

/**
 *
 * @author Gunnlaugur, Mats
 */
public class Token {
    
    private final String id;
    private final long timeStamp;
    private final boolean authorized;
    
    protected Token(String id, long timeStamp) {
        this.id = id; this.timeStamp = timeStamp;
        this.authorized = true;
    }
    
    protected Token() {
        id = null;
        timeStamp = -1;
        authorized = false;
    }
    
    protected String getId() {
        return id;
    }
    
    protected long getTimeStamp() {
        return timeStamp;
    }
    
    protected boolean getAuthorized() {
        return authorized;
    }
}
