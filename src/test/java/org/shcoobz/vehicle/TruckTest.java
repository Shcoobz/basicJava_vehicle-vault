package org.shcoobz.vehicle;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TruckTest {
  @Test
  public void testTruckGetId() { // also tests constructor
    Truck truck = new Truck();

    assertNotNull(truck.getId());
  }
}
