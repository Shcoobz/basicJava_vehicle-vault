package org.shcoobz.parking;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class SmallSpotTest {
  @Test
  public void testSmallSpotGetId() { // also tests constructor
    SmallSpot spot = new SmallSpot();

    assertNotNull(spot.getId());
  }

  @Test
  public void testSmallSpotGetPrice() {
    SmallSpot spot = new SmallSpot();

    assertEquals(9.99, spot.getPrice(), 0.001);
  }
}
