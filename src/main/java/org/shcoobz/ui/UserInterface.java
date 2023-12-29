package org.shcoobz.ui;

/**
 * UserInterface class provides static methods to display various elements of the user interface,
 * such as the application logo and welcome message. This class is used for presenting
 * visual elements in the console.
 */
public class UserInterface {

  /**
   * Prints the application logo to the console.
   * The logo is displayed as ASCII art representing the name or theme of the application.
   */
  public static void printLogo(){
    System.out.println("   __      __         _       _          _                         ");
    System.out.println("   \\ \\    / /        | |     (_)        | |                        ");
    System.out.println("    \\ \\  / /    ___  | |__    _    ___  | |   ___                  ");
    System.out.println("     \\ \\/ /    / _ \\ | '_ \\  | |  / __| | |  / _ \\                 ");
    System.out.println("      \\  /    |  __/ | | | | | | | (__  | | |  __/                 ");
    System.out.println("       \\/      \\___| |_| |_| |_|  \\___| |_|  \\___|                 ");
    System.out.println("                                                                    ");
    System.out.println("                                                                    ");
    System.out.println("                               __      __                  _   _   ");
    System.out.println("                               \\ \\    / /                 | | | |  ");
    System.out.println("                                \\ \\  / /    __ _   _   _  | | | |_ ");
    System.out.println("                                 \\ \\/ /    / _` | | | | | | | | __|");
    System.out.println("                                  \\  /    | (_| | | |_| | | | | |_ ");
    System.out.println("                                   \\/      \\__,_|  \\__,_| |_|  \\__|");
    System.out.println("                                                                    ");
    System.out.println("                                                                    ");

  }

  /**
   * Prints a welcome message to the console when the application starts.
   * This message greets the users upon starting the Parking Garage Simulator.
   */
  public static void printWelcome() {
    System.out.println("\nWelcome to my parking garage simulator!");
  }
}
