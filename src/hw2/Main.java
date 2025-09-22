package hw2;

/**
 * Demonstrates the usage of Recipient, MailItem, and Locker classes.
 */
public class Main {
  /**
   * The main method to run the demonstration.
   *
   * @param args command-line arguments
   */
  public static void main(String[] args) {
    // Create a recipient
    Recipient recipient = new Recipient("John", "Doe", "john.doe@example.com");
    System.out.println("Recipient: " + recipient);

    // Create a mail item
    MailItem mailItem = new MailItem(5, 4, 3, recipient);
    System.out.println("MailItem created for: " + mailItem.getRecipient());

    // Create a locker
    Locker locker = new Locker(10, 10, 10, null);

    // Add mail to locker
    locker.addMail(mailItem);
    System.out.println("Mail added to locker.");

    // Attempt to pick up mail with correct recipient
    MailItem pickedUp = locker.pickupMail(recipient);
    if (pickedUp != null) {
      System.out.println("Mail picked up by: " + pickedUp.getRecipient());
    } else {
      System.out.println("No mail picked up.");
    }
  }
}
