package org.shcoobz.vehicle;

import java.util.UUID;

/**
 * Represents a truck in a parking system. This class implements the Vehicle interface
 * and provides a unique identifier for each truck instance.
 */
public class Truck implements Vehicle {
  private final String id;

  /**
   * Constructs a Truck instance with a unique identifier.
   * The identifier is generated using UUID to ensure uniqueness.
   */
  public Truck() {
    this.id = UUID.randomUUID().toString();
  }

  /**
   * Retrieves the unique identifier of the truck.
   *
   * @return A string representing the unique ID of the truck.
   */
  @Override
  public String getId() {
    return id;
  }
}
