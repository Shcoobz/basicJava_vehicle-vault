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

// Represents a parking garage with functionality to reserve parking spots

public class ParkingGarage {
  // map: collection that maps keys to values; no duplicates; stores key-value pairs -> adding, removing etc based on keys
  // hashmap: implements map; uses hash table to store map -> mapping of jey-value pairs, order is not important
  private final Map<String, ParkingSpot> freeSpots = new HashMap<>();
  private final Map<String, Vehicle> reservedSpots = new HashMap<>();

  // constructor, generates small and large Spots and adds to the map
  public ParkingGarage(int smallSpots, int largeSpots) {
    for (int i = 0; i < smallSpots; i++) {
      SmallSpot spot = new SmallSpot(); // creates spot
      freeSpots.put(spot.getId(), spot); // add to list, with id
    }

    for (int i = 0; i < largeSpots; i++) {
      LargeSpot spot = new LargeSpot();
      freeSpots.put(spot.getId(), spot);
    }
  }

  // check if small spot is available
  private boolean isSmallSpotAvailable() {
    return freeSpots.values().stream() //gets all freespots, converts to java stream
        .filter(spot -> spot instanceof SmallSpot) // filtering only small spots
        .anyMatch(spot -> !reservedSpots.containsKey(spot.getId()));
    // checks whether any elements of stream match given condition;
    // checks if spot's ID is not present in reservedSpots map, indicating the spot is not reserved
    // if it finds small spot not reserved: true, else false
  }

  // reserve logic
  public Ticket reserveSpot(Vehicle vehicle, LocalDateTime spotReservedTime) {
    for (ParkingSpot spot : freeSpots.values()) {
      if (!reservedSpots.containsKey(spot.getId())) {
        if (vehicle instanceof Car && spot instanceof SmallSpot ||
            vehicle instanceof Truck && spot instanceof LargeSpot ||
            vehicle instanceof Car && spot instanceof LargeSpot && !isSmallSpotAvailable()) {

          // if there is a spot, it is reserved
          reservedSpots.put(spot.getId(), vehicle);
          LocalDateTime reservationTime = LocalDateTime.now();

          return new Ticket(reservationTime, spotReservedTime,  spot, vehicle);
        }
      }
    }
    return null; // no available spot
  }
}
