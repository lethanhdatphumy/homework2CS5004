package hw2;

/**
 * Represent the Locker class with maximum width, height, and depth in inch. Also provides mail
 * item.
 */
public class Locker {
  private final int maxWidth;
  private final int maxHeight;
  private final int maxDepth;
  private MailItem mailItem;

  /**
   * Locker's constructor takes the parameters maxWidth, maxHeight, and maxDepth (in that order). If
   * any of those parameters is less than 1, you should raise an IllegalArgumentException. When a
   * locker is created, the mail item should be set to null by default.
   */
  public Locker(int maxWidth, int maxHeight, int maxDepth) {
    if (maxWidth < 1 || maxHeight < 1 || maxDepth < 1) {
      throw new IllegalArgumentException(
          "maxWidth, maxHeight, maxDepth must be equal or greater than 1.");
    }
    this.maxWidth = maxWidth;
    this.maxHeight = maxHeight;
    this.maxDepth = maxDepth;
    this.mailItem = null;
  }

  /**
   * The add method for adding a mail item to the locker. If the mail item is null, do nothing. If
   * the mail item is too large
   */
  public void addMail(MailItem mailItem) {
    if (mailItem == null) {
      return;
    }
    if (this.mailItem != null) {
      return; // Locker already occupied
    }
    if (mailItem.getWidth() > maxWidth
        || mailItem.getHeight() > maxHeight
        || mailItem.getDepth() > maxDepth) {
      return; // Mail item too large
    }
    this.mailItem = mailItem;
  }

  /** The pickup method for picking up the mail item from the locker. */
  public MailItem pickupMail(Recipient recipient) {
    if (this.mailItem == null) {
      return null;
    }
    if (!this.mailItem.getRecipient().equals(recipient)) {
      return null; // the recipient does not match.
    }
    MailItem item = this.mailItem;
    this.mailItem = null;
    return item;
  }
}
