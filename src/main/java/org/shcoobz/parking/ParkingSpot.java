package org.shcoobz.parking;

/**
 * Interface representing a parking spot. This interface defines the essential methods that
 * any type of parking spot (e.g., small, large) should implement, providing a common
 * structure for different parking spot types in a parking garage.
 */
public interface ParkingSpot {

  /**
   * Retrieves the unique identifier of the parking spot.
   * The ID is used to distinguish one parking spot from another.
   *
   * @return A string representing the unique ID of the parking spot.
   */
  String getId();

  /**
   * Retrieves the price for parking in this spot.
   * The price may vary based on the type and size of the parking spot.
   *
   * @return The price as a double value.
   */
  double getPrice();
}
