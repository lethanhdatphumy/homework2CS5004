package hw2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for the {@link MailItem} class.
 */
class MailItemTest {

  /**
   * Tests the constructor and getter methods of MailItem with valid inputs.
   */
  @Test
  public void testConstructorAndGetters() {
    Recipient recipient = new Recipient("Jane", "Smith", "jane.smith@example.com");
    MailItem mailItem = new MailItem(3, 4, 5, recipient);
    assertEquals(3, mailItem.getWidth());
    assertEquals(4, mailItem.getHeight());
    assertEquals(5, mailItem.getDepth());
    assertEquals(recipient, mailItem.getRecipient());
  }

  /**
   * Tests the MailItem constructor with invalid dimensions (zero or negative).
   * Expects IllegalArgumentException.
   */
  @Test
  public void testConstructorInvalidDimensions() {
    Recipient recipient = new Recipient("Jane", "Smith", "jane.smith@example.com");
    assertThrows(IllegalArgumentException.class, () -> new MailItem(0, 4, 5, recipient));
    assertThrows(IllegalArgumentException.class, () -> new MailItem(3, 0, 5, recipient));
    assertThrows(IllegalArgumentException.class, () -> new MailItem(3, 4, 0, recipient));
    assertThrows(IllegalArgumentException.class, () -> new MailItem(-1, 4, 5, recipient));
    assertThrows(IllegalArgumentException.class, () -> new MailItem(3, -2, 5, recipient));
    assertThrows(IllegalArgumentException.class, () -> new MailItem(3, 4, -3, recipient));
  }

  /**
   * Tests the MailItem constructor with a null recipient. Expects IllegalArgumentException.
   */
  @Test
  public void testConstructorNullRecipient() {
    assertThrows(IllegalArgumentException.class, () -> new MailItem(3, 4, 5, null));
  }
}
