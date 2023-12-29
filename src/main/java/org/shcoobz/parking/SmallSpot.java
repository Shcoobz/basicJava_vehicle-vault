package org.shcoobz.parking;

import java.util.UUID;

public class SmallSpot implements ParkingSpot {
  private final String id; // unique identifier for the parking spot
  private final double price;

  // constructor
  public SmallSpot() {
    this.id = UUID.randomUUID().toString(); // generate unique ID
    this.price = 9.99; // fixed price
  }

  @Override
  public String getId() {
    return id;
  }

  @Override
  public double getPrice() {
    return price;
  }
}
