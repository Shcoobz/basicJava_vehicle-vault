package org.shcoobz.garage;

import org.shcoobz.vehicle.Car;
import org.shcoobz.parking.ParkingSpot;
import org.shcoobz.parking.SmallSpot;
import org.shcoobz.vehicle.Vehicle;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Record representing a parking ticket. It includes reservation time, spot reserved time, parking spot details,
 * and vehicle details. This record is used to track parking reservations within the parking garage.
 */
public record Ticket(LocalDateTime reservationTime, LocalDateTime spotReservedTime, ParkingSpot spot, Vehicle vehicle) {
  private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy, HH:mm:ss");

  /**
   * Returns a string representation of the Ticket record, including formatted reservation time,
   * spot reserved time, spot type, spot ID, spot price, vehicle type, and vehicle ID.
   *
   * @return A formatted string representing the details of the parking ticket.
   */
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
