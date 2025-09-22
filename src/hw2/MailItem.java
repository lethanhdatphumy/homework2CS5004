package hw2;

/**
 * Represents the MailItem class with width, height, and depth in inch; Also provides a Recipient
 * object.
 */
public class MailItem {

  private final int width;
  private final int height;
  private final int depth;
  private final Recipient recipient;

  /**
   * MailItem's constructor takes the parameters: width, height, depth, and Recipient (in that
   * order). If width, height or depth is less than 1, you should raise an IllegalArgumentException.
   */
  public MailItem(int width, int height, int depth, Recipient recipient) {
    if (width < 1 || height < 1 || depth < 1) {
      throw new IllegalArgumentException(
          "width, height, and depth must be equal or greater than 1 ");
    } else if (recipient == null) {
      throw new IllegalArgumentException("Recipient must be provided");
    }
    this.width = width;
    this.height = height;
    this.depth = depth;
    // Defensive copy to preserve immutability
    this.recipient = new Recipient(recipient);
  }

  /**
   * The getter method for Recipient object. Returns the object of Recipient.
   */
  public Recipient getRecipient() {
    // Return a defensive copy to preserve immutability
    return new Recipient(this.recipient);
  }

  /**
   * The getter method for width. Returns the width of the mail item.
   */
  public int getWidth() {
    return width;
  }

  /**
   * The getter method for height. Returns the height of the mail item.
   */
  public int getHeight() {
    return height;
  }

  /**
   * The getter method for depth. Returns the depth of the mail item.
   */
  public int getDepth() {
    return depth;
  }
}
