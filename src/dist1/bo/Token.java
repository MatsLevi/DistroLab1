
package dist1.bo;

/**
 * The <code>Token</code> <code>class</code> consists of data concerning the 
 * <code>Token</code>.
 * 
 * @author Gunnlaugur, Mats
 */
public class Token {
    
    private final int id;
    private final long timeStamp;
    private final boolean authorized;

    /**
     * Constructs a <code>Token</code> to be used as an identifier in the system.
     * 
     * @param id <code>Token</code> id in a <code>int</code>.
     * @param timeStamp timestamps to know when token was issued.
     */
    protected Token(int id, long timeStamp) {
        this.id = id; this.timeStamp = timeStamp;
        this.authorized = true;
    }

    /**
     * Constructs a fail token.
     */
    protected Token() {
        id = -1;
        timeStamp = -1;
        authorized = false;
    }

    /**
     * Gets <code>Token</code> id.
     * 
     * @return <code>int</code> containing ID.
     */
    protected int getId() {
        return id;
    }

    /**
     * Gets <code>Token</code> timestamp.
     * 
     * @return <code>long</code> containing timestamp.
     */
    protected long getTimeStamp() {
        return timeStamp;
    }

    /**
     * Gets <code>Token</code> authorization.
     * 
     * @return <code>boolean</code>, <code>true</code> if the user was authorized.
     */
    protected boolean getAuthorized() {
        return authorized;
    }
}
