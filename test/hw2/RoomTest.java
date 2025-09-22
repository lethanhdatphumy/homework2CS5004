package hw2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for the {@link Room} class.
 */
public class RoomTest {

  /**
   * Tests the bookRoom method of the Room class. It checks if booking a room with a valid number of
   * guests returns true. Booking a room when it's already fully booked returns false.
   */
  @Test
  public void testBookRoom() {
    Room testRoom = new Room(RoomType.DOUBLE, 150.0);
    assertTrue(testRoom.bookRoom(2));
    assertFalse(testRoom.bookRoom(1)); // Room already booked
    assertFalse(testRoom.bookRoom(2));
  }

  /**
   * Tests the bookRoom method of the Room class. It checks if booking a room with invalid numbers
   * of guests returns IllegalArgumentException.
   */
  @Test
  public void testBookRoomInvalidGuests() {
    Room testRoom = new Room(RoomType.FAMILY, 250.0);
    assertThrows(IllegalArgumentException.class, () -> testRoom.bookRoom(-12));
    assertThrows(IllegalArgumentException.class, () -> testRoom.bookRoom(0));
    assertThrows(IllegalArgumentException.class, () -> testRoom.bookRoom(5));
  }

  /** Tests the getPricePerNight method. */
  @Test
  public void testGetPerNight() {
    Room testRoom = new Room(RoomType.FAMILY, 250.0);
    assertEquals(250, testRoom.getPricePerNight());
    assertNotEquals(350, testRoom.getPricePerNight());
  }

  /** Tests the getNumberOfGuests method. */
  @Test
  public void testGetNumberOfGuests() {
    Room testRoom = new Room(RoomType.FAMILY, 250.0);
    testRoom.bookRoom(3);
    assertEquals(3, testRoom.getNumberOfGuests());
  }

  /** Tests the isAvailable method. */
  @Test
  public void testIsAvailable() {
    Room testRoom = new Room(RoomType.SINGLE, 100);
    testRoom.bookRoom(1);
    assertFalse(testRoom.isAvailable());
    Room testOtherRoom = new Room(RoomType.FAMILY, 250);
    testOtherRoom.bookRoom(1);
    assertFalse(testOtherRoom.isAvailable());
  }
}
