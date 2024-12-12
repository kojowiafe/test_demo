import java.util.Objects;
import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner input = new Scanner(System.in);
        boolean continueConverting = true; // boolean or flag to control the conversion loop

        System.out.println("-----Welcome to Temperature Converter-----");

        // a while loop to allow multiple conversions
        while (continueConverting) {
            // Display conversion options
            System.out.println("---Options---");
            System.out.println("1. Convert Celsius to Fahrenheit.");
            System.out.println("2. Convert Fahrenheit to Celsius");
            System.out.print("Enter your preferred option or type 'quit' to Quit: ");

            // Read user input for option
            String userInput = input.nextLine();

            // Check if the user wants to quit
            if (Objects.equals(userInput, "quit")) {
                System.out.println("Thank you for using Temperature Converter!");
                break; // Exit the loop
            }

            // parsing the option as an integer
            int option;
            try {
                option = Integer.parseInt(userInput); // Convert userInput to integer
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number or 'quit' to exit.");
                continue; // Skip to the next iteration of the loop
            }

            // Validate the user option
            while (option < 1 || option > 2) {
                System.out.print("Please enter a valid option (1 or 2): ");
                option = input.nextInt(); // Read the option again
                input.nextLine(); // Consume the newline character
            }

            // Perform conversion based on user option
            if (option == 1) {
                // Celsius to Fahrenheit conversion
                System.out.println("-----Celcius to Fahrenheit-----");
                System.out.print("Enter your preferred temperature (in Celsius): ");
                double temperatureC = input.nextDouble(); // Read temperature in Celsius
                input.nextLine(); // Consume the newline character
                double convertedTemp = (temperatureC * 9 / 5) + 32; // Convert to Fahrenheit
                System.out.printf("Your temperature is %.2f degrees in Fahrenheit.%n", convertedTemp);
                if (convertedTemp >= 99.1 && convertedTemp <= 100.4) {
                    System.out.println("You have converted Celsius to Fahrenheit.");
                }

            } else {
                // Fahrenheit to Celsius conversion
                System.out.println("-----Fahrenheit to Celcius-----");
                System.out.print("Enter your preferred temperature (in Fahrenheit): ");
                double temperatureF = input.nextDouble(); // Read temperature in Fahrenheit
                input.nextLine(); // Consume the newline character
                double convertedTemp = (temperatureF - 32) * 5 / 9; // Convert to Celsius
                System.out.printf("Your temperature is %.2f degrees in Celsius.%n", convertedTemp);
            }

            // Ask the user if they want to perform another conversion
            System.out.print("Do you want to perform another conversion? (yes/no): ");
            String response = input.nextLine();
            continueConverting = response.equalsIgnoreCase("yes"); // Update the loop flag based on user response
        }

        // Close the scanner to free resources
        input.close();
    }
}