package org.shcoobz.parking;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class LargeSpotTest {
  @Test
  public void testLargeSpotGetId() { // also tests constructor
    LargeSpot spot = new LargeSpot();

    assertNotNull(spot.getId());
  }

  @Test
  public void testLargeSpotGetPrice() {
    LargeSpot spot = new LargeSpot();

    assertEquals(19.99, spot.getPrice(), 0.001);
  }
}
