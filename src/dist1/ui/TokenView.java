
package dist1.ui;

/**
 * The <code>TokenView class</code> consists of data concerning the item.
 * 
 * @author Gunnlaugur, Mats
 */
public class TokenView {

    private final int id;
    private final long timeStamp;
    private final boolean authorized;

    /**
     * Constructs an <code>TokenView</code> with given parameters.
     * 
     * @param id <code>int</code> user identifier.
     * @param timeStamp <code>long</code> containing a timestamp.
     * @param authorized <code>boolean</code>, contains information whether a authentication was successful or not.
     */
    public TokenView(int id, long timeStamp, boolean authorized) {
        this.id = id; this.timeStamp = timeStamp; this.authorized = authorized;
    }

    /**
     * Gets <code>TokeView</code> id.
     * 
     * @return <code>int</code> containing id.
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the <code>TokenView</code> timestamp.
     * 
     * @return <code>long</code> contains timestamp.
     */
    public long getTimeStamp() {
        return timeStamp;
    }

    /**
     * Gets authorization <code>boolean</code>.
     * 
     * @return <code>boolean</code>, <code>true</code> if the user was authorized.
     */
    public boolean getAuthorized() {
        return authorized;
    }
}
