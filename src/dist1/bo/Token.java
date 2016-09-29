
package dist1.bo;

/**
 *
 * @author Gunnlaugur, Mats
 */
public class Token {
    
    private final String id;
    private final long timeStamp;
    
    protected Token(String id, long timeStamp) {
        this.id = id; this.timeStamp = timeStamp;
    }
    
    protected String getId() {
        return id;
    }
    
    protected long getTimeStamp() {
        return timeStamp;
    }
}
