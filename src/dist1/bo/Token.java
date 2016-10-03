
package dist1.bo;

/**
 *
 * @author Gunnlaugur, Mats
 */
public class Token {
    
    private final int id;
    private final long timeStamp;
    private final boolean authorized;

    /**
     * token constructor used as an identifier in the system
     * @param id token id in a int
     * @param timeStamp timestams to know when token was issued
     */
    protected Token(int id, long timeStamp) {
        this.id = id; this.timeStamp = timeStamp;
        this.authorized = true;
    }

    /**
     * construktor to create fail token
     */
    protected Token() {
        id = -1;
        timeStamp = -1;
        authorized = false;
    }

    /**
     * getter for token ID
     * @return int containing ID
     */
    protected int getId() {
        return id;
    }

    /**
     * getter for timestamp
     * @return long conatining timestamp
     */
    protected long getTimeStamp() {
        return timeStamp;
    }

    /**
     * getts authorized succes or not
     * @return boolean
     */
    protected boolean getAuthorized() {
        return authorized;
    }
}
