package org.shcoobz.vehicle;

import java.util.UUID;

public class Truck implements Vehicle {
  private final String id;

  public Truck() {
    this.id = UUID.randomUUID().toString();
  }

  @Override
  public String getId() {
    return id;
  }
}
