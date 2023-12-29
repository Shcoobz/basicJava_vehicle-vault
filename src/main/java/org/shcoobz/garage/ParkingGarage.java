package org.shcoobz.garage;

import org.shcoobz.parking.LargeSpot;
import org.shcoobz.parking.ParkingSpot;
import org.shcoobz.parking.SmallSpot;
import org.shcoobz.vehicle.Car;
import org.shcoobz.vehicle.Truck;
import org.shcoobz.vehicle.Vehicle;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Represents a parking garage with functionality to manage and reserve parking spots.
 * The garage maintains a collection of free and reserved parking spots.
 */
public class ParkingGarage {
  private final Map<String, ParkingSpot> freeSpots = new HashMap<>();
  private final Map<String, Vehicle> reservedSpots = new HashMap<>();

  /**
   * Constructs a ParkingGarage instance and initializes it with a specified number
   * of small and large parking spots.
   *
   * @param smallSpots The number of small parking spots to be created in the garage.
   * @param largeSpots The number of large parking spots to be created in the garage.
   */
  public ParkingGarage(int smallSpots, int largeSpots) {
    for (int i = 0; i < smallSpots; i++) {
      SmallSpot spot = new SmallSpot();
      freeSpots.put(spot.getId(), spot);
    }

    for (int i = 0; i < largeSpots; i++) {
      LargeSpot spot = new LargeSpot();
      freeSpots.put(spot.getId(), spot);
    }
  }

  /**
   * Checks if there is an available small parking spot in the garage.
   *
   * @return true if a small parking spot is available, false otherwise.
   */
  private boolean isSmallSpotAvailable() {
    return freeSpots.values().stream()
        .filter(spot -> spot instanceof SmallSpot)
        .anyMatch(spot -> !reservedSpots.containsKey(spot.getId()));
  }

  /**
   * Reserves a parking spot for a vehicle if a suitable spot is available.
   * The reservation is based on the type of the vehicle and the available parking spots.
   *
   * @param vehicle The vehicle for which the parking spot is to be reserved.
   * @param spotReservedTime The time at which the spot is being reserved.
   * @return A parking ticket if a spot is reserved successfully, null otherwise.
   */
  public Ticket reserveSpot(Vehicle vehicle, LocalDateTime spotReservedTime) {
    for (ParkingSpot spot : freeSpots.values()) {
      if (!reservedSpots.containsKey(spot.getId())) {
        if (vehicle instanceof Car && spot instanceof SmallSpot ||
            vehicle instanceof Truck && spot instanceof LargeSpot ||
            vehicle instanceof Car && spot instanceof LargeSpot && !isSmallSpotAvailable()) {

          reservedSpots.put(spot.getId(), vehicle);
          LocalDateTime reservationTime = LocalDateTime.now();

          return new Ticket(reservationTime, spotReservedTime,  spot, vehicle);
        }
      }
    }
    return null;
  }
}
