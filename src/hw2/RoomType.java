package hw2;

/**
 * Represents the type of a hotel room.
 */
public enum RoomType {
  SINGLE(1),
  DOUBLE(2),
  FAMILY(4);

  private final int maxOccupancy;

  RoomType(int maxOccupancy) {
    this.maxOccupancy = maxOccupancy;
  }

  public int getMaxOccupancy() {
    return maxOccupancy;
  }
}
