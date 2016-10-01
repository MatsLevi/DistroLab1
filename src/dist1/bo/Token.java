
package dist1.bo;

/**
 *
 * @author Gunnlaugur, Mats
 */
public class Token {
    
    private final int id;
    private final long timeStamp;
    private final boolean authorized;
    
    protected Token(int id, long timeStamp) {
        this.id = id; this.timeStamp = timeStamp;
        this.authorized = true;
    }
    
    protected Token() {
        id = -1;
        timeStamp = -1;
        authorized = false;
    }
    
    protected int getId() {
        return id;
    }
    
    protected long getTimeStamp() {
        return timeStamp;
    }
    
    protected boolean getAuthorized() {
        return authorized;
    }
}
