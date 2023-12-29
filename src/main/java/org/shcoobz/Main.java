package org.shcoobz;

import org.shcoobz.garage.ParkingGarage;
import org.shcoobz.garage.Ticket;
import org.shcoobz.ui.UserInterface;
import org.shcoobz.vehicle.Car;
import org.shcoobz.vehicle.Truck;
import org.shcoobz.vehicle.Vehicle;

import java.time.LocalDateTime;

/**
 * The Main class of the parking system. This class is responsible for initializing
 * the parking garage and processing vehicles.
 */
public class Main {

  /**
   * The main method that serves as the entry point of the application.
   * It creates a parking garage and processes a series of vehicle reservations.
   *
   * @param args Command line arguments (not used).
   */
  public static void main(String[] args) {
    UserInterface.printLogo();
    UserInterface.printWelcome();

    // Create a parking garage with a certain number of small and large spots
    int smallSpots = 10;
    int largeSpots = 5;
    ParkingGarage garage = new ParkingGarage(smallSpots, largeSpots);
    System.out.println("\nCreated a parking garage with " + smallSpots + " small spots and " + largeSpots + " large spots.");

    // Process vehicles
    processVehicles(garage, "car", 3);
    processVehicles(garage, "truck", 2);
  }

  /**
   * Processes a specified number of vehicles of a certain type, creating them and attempting
   * to reserve parking spots for them in the garage.
   *
   * @param garage The parking garage where spots are to be reserved.
   * @param vehicleType The type of vehicle to be processed (e.g., "car", "truck").
   * @param numVehicles The number of vehicles to process.
   */
  public static void processVehicles(ParkingGarage garage, String vehicleType, int numVehicles) {
    System.out.println("\n***** Processing " + numVehicles + " " + vehicleType + "(s):");

    for (int i = 0; i < numVehicles; i++) {
      Vehicle vehicle;

      // Determine the type of vehicle to create
      if (vehicleType.equalsIgnoreCase("car")) {
        vehicle = new Car();
      } else if (vehicleType.equalsIgnoreCase("truck")) {
        vehicle = new Truck();
      } else {
        System.out.println("Invalid vehicle type: " + vehicleType);
        return;
      }

      // Attempt to reserve a parking spot for the vehicle
      LocalDateTime spotReservedTime = LocalDateTime.now().plusHours(1);
      Ticket ticket = garage.reserveSpot(vehicle, spotReservedTime);

      // Print ticket information or no availability message
      if (ticket != null) {
        System.out.println("\nSuccessfully reserved a spot for " + vehicleType + " with ID: " + vehicle.getId());
        System.out.println("Reservation details: " + ticket);
      } else {
        System.out.println("\nNo parking spot available for " + vehicleType + " with ID: " + vehicle.getId());
      }
    }
  }
}