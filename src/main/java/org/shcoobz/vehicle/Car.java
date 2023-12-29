package org.shcoobz.vehicle;

import java.util.UUID;

/**
 * Represents a car in a parking system. This class implements the Vehicle interface
 * and provides a unique identifier for each car instance.
 */
public class Car implements Vehicle {
  private final String id;

  /**
   * Constructs a Car instance with a unique identifier.
   */
  public Car() {
    this.id = UUID.randomUUID().toString();
  }

  /**
   * Retrieves the unique identifier of the car.
   *
   * @return A string representing the unique ID of the car.
   */
  @Override
  public String getId() {
    return id;
  }
}
