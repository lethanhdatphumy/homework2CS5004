package hw2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class RecipientTest {
  /**
   * Tests the constructor of Recipient class.
   */
  @Test
  public void testConstructor() {
    Recipient recipient = new Recipient("John", "Doe", "Doe@northeastern.edu");
    assertEquals("John", recipient.toString().split(" ")[0]);
    assertEquals("Doe", recipient.toString().split(" ")[1]);
    assertEquals("Email:Doe@northeastern.edu", recipient.toString().split(" ")[2]);
  }

  /**
   * Tests the constructor of Recipient class with invalid inputs.
   */
  @Test
  public void testConstructorInvalidInputs() {
    assertThrows(
        IllegalArgumentException.class, () -> new Recipient(null, "Doe", "Doe@northeastern.edu"));
    assertThrows(
        IllegalArgumentException.class, () -> new Recipient("John", null, "Doe@northeastern.edu"));
    assertThrows(IllegalArgumentException.class, () -> new Recipient("John", "Doe", null));
    assertThrows(
        IllegalArgumentException.class, () -> new Recipient("", "Doe", "Doe@northeastern.edu"));
  }

  /**
   * Tests the setEmail method of Recipient class.
   */
  @Test
  public void testSetEmail() {
    Recipient recipient = new Recipient("John", "Doe", "le.thanhd@northeastern.edu");
    recipient.setEmail("Doe@northeastern.edu");
    assertEquals("Email:Doe@northeastern.edu", recipient.toString().split(" ")[2]);
  }

  /**
   * Tests the setEmail method of Recipient class with invalid inputs.
   */
  @Test
  public void testSetEmailInvalidInputs() {
    Recipient recipient = new Recipient("John", "Doe", "Doe@northeastern.edu");
    assertThrows(IllegalArgumentException.class, () -> recipient.setEmail(null));
    assertThrows(IllegalArgumentException.class, () -> recipient.setEmail(""));
  }
}
