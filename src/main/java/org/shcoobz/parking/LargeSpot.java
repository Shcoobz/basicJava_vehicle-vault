package org.shcoobz.parking;

import java.util.UUID;

public class LargeSpot implements ParkingSpot {
  private final String id;
  private final double price;

  public LargeSpot() {
    this.id = UUID.randomUUID().toString();
    this.price = 19.99;
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

