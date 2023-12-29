package org.shcoobz.vehicle;

import java.util.UUID;

// Represents a car with a unique ID

public class Car implements Vehicle {
  private final String id;

  // constructor
  public Car() {
    this.id = UUID.randomUUID().toString();
  }

  public String getId() {
    return id;
  }
}
