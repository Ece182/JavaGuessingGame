import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println("Welcome to the Number Guessing Game!");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Set the lower limit:");
        int lowerLimit = scanner.nextInt();
        System.out.print("Set the upper limit:");
        int upperLimit = scanner.nextInt();
        int randomNumber = generateRandomNumber(lowerLimit, upperLimit);

        System.out.println("Limits are set as:" + lowerLimit + " and " + upperLimit + ".");

        int guess;
        int numberOfGuesses = 0;

        // Get employee information
        Employee employee = getEmployeeInformation();

        // Start the game
        while (true) {
            numberOfGuesses++;
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();

            if (guess == randomNumber) {
                System.out.println("Congratulations, " + employee.getName() + ", you guessed the number in " + numberOfGuesses + " guesses!");
                break;
            } else if (guess > randomNumber) {
                System.out.println("Go down.");
            } else {
                System.out.println("Go up.");
            }
        }

        saveGameResult(employee, numberOfGuesses);
        System.out.println("Game result saved to file.");
    }

    private static Employee getEmployeeInformation() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your ID number: ");
        int idNumber = scanner.nextInt();
        scanner.nextLine(); // consume new line character
        System.out.print("Enter your department: ");
        String department = scanner.nextLine();
        System.out.print("Enter your position: ");
        String position = scanner.nextLine();
        return new Employee(name, idNumber, department, position);
    }

    private static int generateRandomNumber(int lowerLimit, int upperLimit) {
        Random random = new Random();
        return random.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;
    }

    private static void saveGameResult(Employee employee, int numberOfGuesses) throws IOException {
        FileWriter fileWriter = new FileWriter("game_results.txt", true);
        fileWriter.write("Employee: " + employee.getName() + ", ID: " + employee.getIdNumber() + ", Position: " + employee.getPosition() + ", Department: " + employee.getDepartment() + ", Guesses: " + numberOfGuesses + ", Range: " + employee.getPosition() + "\n");
        fileWriter.close();
    }
}

