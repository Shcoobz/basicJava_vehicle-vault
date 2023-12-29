package org.shcoobz;

import org.shcoobz.garage.ParkingGarage;
import org.shcoobz.garage.Ticket;
import org.shcoobz.vehicle.Car;
import org.shcoobz.vehicle.Truck;
import org.shcoobz.vehicle.Vehicle;

import java.time.LocalDateTime;

public class Main {
  public static void main(String[] args) {
    // create a parking garage with a certain number of small and large spots
    ParkingGarage garage = new ParkingGarage(10, 5); // 10 small spots, 5 large spots

    processVehicles(garage, "car", 3); // create and reserve 3 cars with specified reservation time
    processVehicles(garage, "truck", 2);
  }

  public static void processVehicles(ParkingGarage garage, String vehicleType, int numVehicles) {
    System.out.println("\n***** " + vehicleType + "s parked:");

    for (int i = 0; i < numVehicles; i++) {
      Vehicle vehicle;

      if (vehicleType.equalsIgnoreCase("car")) {
        vehicle = new Car();
      } else if (vehicleType.equalsIgnoreCase("truck")) {
        vehicle = new Truck();
      } else {
        System.out.println("Invalid vehicle type: " + vehicleType);
        return;
      }

      // reserve spot with specified reservation time
      LocalDateTime spotReservedTime = LocalDateTime.now().plusHours(1);
      Ticket ticket = garage.reserveSpot(vehicle, spotReservedTime);

      if (ticket != null) {
        System.out.println("\nReservation: " + ticket);
      } else {
        System.out.println("\nNo parking spot available for: " + vehicleType + ".");
      }
    }
  }
}