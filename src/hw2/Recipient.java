package hw2;

/**
 * Represents a recipient with a first name, last name, and email address.
 */
public class Recipient {
  /** Represents a recipient with a first name, last name, and email address. */
  private final String firstName;

  private final String lastName;
  private String email;

  /** Constructs a hw2.Recipient object with the given first name, last name, and email. */
  public Recipient(String firstName, String lastName, String email) {
    if (firstName == null
        || lastName == null
        || email == null
        || firstName.isEmpty()
        || lastName.isEmpty()
        || email.isEmpty()) {
      throw new IllegalArgumentException("First name, last name and email cannot be null or empty");
    }
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }

  /**
   * Copy constructor for Recipient.
   */
  public Recipient(Recipient other) {
    if (other == null) {
      throw new IllegalArgumentException("Cannot copy null Recipient");
    }
    this.firstName = other.firstName;
    this.lastName = other.lastName;
    this.email = other.email;
  }

  /** Returns the first name of the recipient. */
  public void setEmail(String email) {
    if (email == null || email.isEmpty()) {
      throw new IllegalArgumentException("Email cannot be null or empty");
    }
    this.email = email;
  }

  /** Returns the first name of the recipient. */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Recipient recipient = (Recipient) o;
    return email.equals(recipient.email);
  }

  /** Returns the first name of the recipient. FirstName LastName Email:xxx@yyyy.com */
  @Override
  public String toString() {
    return firstName + " " + lastName + " Email:" + email;
  }
}
