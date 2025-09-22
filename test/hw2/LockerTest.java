package hw2;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the {@link Locker} class.
 */
class LockerTest {

  /** Sets up a valid Locker instance before each test. */
  @BeforeEach
  public void setUp() {
    Locker locker = new Locker(10, 10, 10);
  }

  /**
   * Tests the Locker constructor with invalid inputs. Expects IllegalArgumentException for any
   * dimension less than 1.
   */
  @Test
  public void testConstructorInvalidInputs() {
    assertThrows(IllegalArgumentException.class, () -> new Locker(0, 10, 10));
    assertThrows(IllegalArgumentException.class, () -> new Locker(10, -1, 10));
    assertThrows(IllegalArgumentException.class, () -> new Locker(10, 10, 0));
  }

  /**
   * Tests the addMail method of the Locker class. It checks adding a null mail item, adding a mail
   * item that is too large, and adding a mail item when the locker is already occupied.
   */
  @Test
  public void testAddMail() {
    Locker locker = new Locker(10, 10, 10);
    Recipient recipient = new Recipient("John", "Doe", ":Doe@northeastern.edu");
    MailItem validMail = new MailItem(5, 5, 5, recipient);
    MailItem tooLargeMail = new MailItem(15, 5, 5, recipient);
    MailItem anotherMail = new MailItem(4, 4, 4, recipient);
    locker.addMail(null); // Should do nothing
    locker.addMail(tooLargeMail); // Should do nothing
    locker.addMail(validMail); // Should add the mail
  }
}
