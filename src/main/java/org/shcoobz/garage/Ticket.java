package org.shcoobz.garage;

import org.shcoobz.vehicle.Car;
import org.shcoobz.parking.ParkingSpot;
import org.shcoobz.parking.SmallSpot;
import org.shcoobz.vehicle.Vehicle;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Record representing a parking ticket with reservation time, spot, and vehicle details
public record Ticket(LocalDateTime reservationTime, LocalDateTime spotReservedTime, ParkingSpot spot, Vehicle vehicle) {
  private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy, HH:mm:ss");

  @Override
  public String toString() {
    String spotType = spot instanceof SmallSpot ? "Small Spot" : "Large Spot";
    String vehicleType = vehicle instanceof Car ? "Car" : "Truck";

    return "\n * Ticket [" +
        "\n - Reservation Time: " + reservationTime.format(formatter) +
        "\n - Spot Reserved Time: " + spotReservedTime.format(formatter) +
        "\n - Spot Type: " + spotType +
        "\n - Spot ID: " + spot.getId() +
        "\n - Spot Price: " + spot.getPrice() + " €" +
        "\n - Vehicle Type: " + vehicleType +
        "\n - Vehicle ID: " + vehicle.getId() +
        "\n ]";
  }
}
