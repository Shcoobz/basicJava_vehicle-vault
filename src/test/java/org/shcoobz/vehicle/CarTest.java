package org.shcoobz.vehicle;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CarTest {
  @Test
  public void testCarGetId() { // also tests constructor
    Car car = new Car();

    assertNotNull(car.getId());
  }
}

