package org.shcoobz.garage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.shcoobz.vehicle.Car;
import org.shcoobz.vehicle.Truck;
import org.shcoobz.vehicle.Vehicle;

import java.time.LocalDateTime;

public class ParkingGarageTest {
  @Test
  public void testParkingGarageConstructor() {
    ParkingGarage garage = new ParkingGarage(10, 5);

    assertNotNull(garage);
  }

  @ParameterizedTest
  @CsvSource({
      "1, 1, Car, SmallSpot, true",
      "1, 1, Truck, LargeSpot, true",
      "0, 1, Car, LargeSpot, true",
      "0, 0, Car, SmallSpot, false",
      "1, 0, Truck, LargeSpot, false"
  })

  public void testReserveSpot(int smallSpots, int largeSpots, String vehicleType, String spotType, boolean shouldSucceed) {
    ParkingGarage garage = new ParkingGarage(smallSpots, largeSpots);
    Vehicle vehicle = vehicleType.equals("Car") ? new Car() : new Truck();
    LocalDateTime spotReservedTime = LocalDateTime.now().plusHours(1);
    Ticket ticket = garage.reserveSpot(vehicle, spotReservedTime);

    if (shouldSucceed) {
      assertNotNull(ticket);
      assertEquals(spotType, ticket.spot().getClass().getSimpleName());
      assertEquals(vehicleType, ticket.vehicle().getClass().getSimpleName());
    } else {
      assertNull(ticket);
    }
  }
}
