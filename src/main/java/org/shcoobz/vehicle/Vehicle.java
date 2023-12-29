package org.shcoobz.vehicle;

/**
 * Interface representing a vehicle. This interface defines the essential methods
 * that any vehicle type (e.g., car, truck) should implement, providing a common
 * structure for different vehicle types in a parking system.
 */
public interface Vehicle {

  /**
   * Retrieves the unique identifier of the vehicle.
   * The ID is used to distinguish one vehicle from another within the parking system.
   *
   * @return A string representing the unique ID of the vehicle.
   */
  String getId();
}
