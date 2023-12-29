package org.shcoobz.parking;

import java.util.UUID;

/**
 * Represents a small parking spot in a parking garage. This class implements the ParkingSpot interface
 * and provides specific functionalities for a small parking spot, such as a unique identifier and a fixed price.
 */
public class SmallSpot implements ParkingSpot {
  private final String id;
  private final double price;

  /**
   * Constructs a SmallSpot instance with a unique identifier and a fixed price.
   */
  public SmallSpot() {
    this.id = UUID.randomUUID().toString();
    this.price = 9.99;
  }

  /**
   * Gets the unique identifier of the small parking spot.
   *
   * @return A string representing the unique ID of the parking spot.
   */
  @Override
  public String getId() {
    return id;
  }

  /**
   * Gets the price for parking in the small spot.
   *
   * @return The price as a double.
   */
  @Override
  public double getPrice() {
    return price;
  }
}
