/*
 * 
 *
 */
package de.softgames.en.mylittlefarm2.model;


/**
 * Simple Entity class to setup the Notification with the needed attributes
 * 
 * @author rolandcastillo
 * 
 */
public class SGNotification {

    /** The id. */
    public int id;

    /** The title. */
    public String title;

    /** The message. */
    public String message;

    /** The extra info. */
    public String extraInfo;

    /** The small icon */
    public int iconDrawableId;

    /** The large icon. */
    public int largeIconDrawableId;


    /**
     * Instantiates a new softgames notification.
     * 
     * @param title
     *            the title
     * @param message
     *            the message
     * @param iconDrawableId
     *            the drawable id of the small notification icon
     * @param largeIcon
     *            the large icon drawable id
     */
    public SGNotification(int id, String title, String message,
            String extraInfo,
            int iconDrawableId, int largeIcon) {
        super();
        this.id = id;
        this.title = title;
        this.message = message;
        this.extraInfo = extraInfo;
        this.iconDrawableId = iconDrawableId;
        this.largeIconDrawableId = largeIcon;
    }

    /**
     * Instantiates a new softgames notification with the mandatory fields
     * 
     * @param title
     * @param message
     */
    public SGNotification(String title, String message) {
        super();
        this.title = title;
        this.message = message;
    }


    /**
     * Gets the title.
     * 
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title.
     * 
     * @param title
     *            the new title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the message.
     * 
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the message.
     * 
     * @param message
     *            the new message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets the icon drawable id.
     * 
     * @return the icon drawable id
     */
    public int getIconDrawableId() {
        return iconDrawableId;
    }

    /**
     * Sets the icon drawable id.
     * 
     * @param iconDrawableId
     *            the new icon drawable id
     */
    public void setIconDrawableId(int iconDrawableId) {
        this.iconDrawableId = iconDrawableId;
    }

    /**
     * Gets the large icon.
     * 
     * @return the large icon
     */
    public int getLargeIcon() {
        return largeIconDrawableId;
    }

    /**
     * Sets the large icon.
     * 
     * @param largeIcon
     *            the new large icon
     */
    public void setLargeIcon(int largeIcon) {
        this.largeIconDrawableId = largeIcon;
    }

    /**
     * Gets the extra info.
     * 
     * @return the extra info
     */
    public String getExtraInfo() {
        return extraInfo;
    }

    /**
     * Sets the extra info.
     * 
     * @param extraInfo
     *            the new extra info
     */
    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }

    /**
     * Gets the id.
     * 
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the id.
     * 
     * @param id
     *            the new id
     */
    public void setId(int id) {
        this.id = id;
    }

}
