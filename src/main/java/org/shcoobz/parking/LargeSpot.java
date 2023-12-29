package org.shcoobz.parking;

import java.util.UUID;

/**
 * Represents a large parking spot in a parking garage. This class implements the ParkingSpot interface
 * and provides functionalities specific to a large parking spot, such as a unique identifier and a specific price.
 */
public class LargeSpot implements ParkingSpot {
  private final String id;
  private final double price;

  /**
   * Constructs a LargeSpot instance with a unique identifier and a predefined price.
   */
  public LargeSpot() {
    this.id = UUID.randomUUID().toString();
    this.price = 19.99;
  }

  /**
   * Gets the unique identifier of the large parking spot.
   *
   * @return A string representing the unique ID of the parking spot.
   */
  @Override
  public String getId() {
    return id;
  }

  /**
   * Gets the price for parking in the large spot.
   *
   * @return The price as a double.
   */
  @Override
  public double getPrice() {
    return price;
  }
}

