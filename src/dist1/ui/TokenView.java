
package dist1.ui;

/**
 *
 * @author Gunnlaugur, Mats
 */
public class TokenView {

    private final int id;
    private final long timeStamp;
    private final boolean authorized;

    /**
     * Constructor creating the TokenView
     * @param id int user identifier
     * @param timeStamp long containing a timestamp
     * @param authorized boolean contains information weather a authentication was successful or not
     */
    public TokenView(int id, long timeStamp, boolean authorized) {
        this.id = id; this.timeStamp = timeStamp; this.authorized = authorized;
    }

    /**
     * Gets TokeView id
     * @return int containing id
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the TokenView timestamp
     * @return long contains timestamp
     */
    public long getTimeStamp() {
        return timeStamp;
    }

    /**
     * Gets authorization
     * @return boolean true or false
     */
    public boolean getAuthorized() {
        return authorized;
    }
}
