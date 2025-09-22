package hw2;


/**
 * Represents a hotel room with a specific type, occupancy, and price per night.
 */
public class Room {
  private final int maxOccupancy; // comes from RoomType
  private int numberOfGuests; // starts at 0
  private final double pricePerNight;


  /**
   * Constructs a Room with the given type and nightly price.
   *
   * @param roomType the type of room (SINGLE, DOUBLE, FAMILY)
   * @param pricePerNight the nightly price (must be >= 0)
   * @throws IllegalArgumentException if pricePerNight < 0
   */
  public Room(RoomType roomType, double pricePerNight) {
    if (pricePerNight < 0) {
      throw new IllegalArgumentException("Price per night cannot be negative");
    }
    if (numberOfGuests < 0) {
      throw new IllegalArgumentException("Number of guests cannot be negative");
    }
    this.pricePerNight = pricePerNight;
    this.numberOfGuests = 0;
    this.maxOccupancy = roomType.getMaxOccupancy();
  }

  /** Returns true if the room is available (no guests assigned). */
  public boolean isAvailable() {
    return numberOfGuests == 0;
  }

  /** Returns the number of guests currently assigned to the room. */
  public int getNumberOfGuests() {
    return numberOfGuests;
  }

  /** Returns the price per night for the room. */
  public double getPricePerNight() {
    return pricePerNight;
  }

  /**
   * Attempts to book the room for the given number of guests.
   *
   * @param guests number of guests to book
   * @return true if booking succeeded, false otherwise
   */
  public boolean bookRoom(int guests) {
    if (guests <= 0 || guests > maxOccupancy) {
      return false;
    }
    if (isAvailable()) {
      numberOfGuests = guests;
      return true;
    }
    return false;
  }
}
