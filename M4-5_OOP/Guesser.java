import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Guesser {
    
    private Employee employee;
    private int numberOfGuesses;

    public Guesser(Employee employee){
        this.employee = employee;
        this.numberOfGuesses = 0;
    }

    public void guessGame(int lowerLimit, int upperLimit) throws IOException{
        System.out.println("Welcome to the Number Guessing Game, " + this.employee.getName() + "!");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Set the lower limit:");
        lowerLimit = scanner.nextInt();
        System.out.println("Set the upper limit:");
        upperLimit = scanner.nextInt();
        int randomNumber = generateRandomNumber(lowerLimit, upperLimit);

        System.out.println("Limits are set as:" + lowerLimit + " and " + upperLimit);

        int guess;

        while(true) {
            numberOfGuesses++;
            System.out.println("Enter your guess:");
            guess = scanner.nextInt();

            if (guess == randomNumber) {
                System.out.println("Congrats" + employee.getName() + "! You guessed the number in " + numberOfGuesses + " guesses!");
                break;
            }else if (guess < randomNumber) {
                System.out.println("Go up!");
            }else if (guess > randomNumber) {
                System.out.println("Go down!");
            }
        }
        saveGameResult(numberOfGuesses, employee);
        System.out.println("Game result saved to file!");
    }

    public int generateRandomNumber(int lowerLimit, int upperLimit){
        Random random = new Random();
        return random.nextInt(upperLimit - lowerLimit) + lowerLimit;
    }

    public void saveGameResult(int numberOfGuesses, Employee employee) throws IOException{
        FileWriter fileWriter = new FileWriter("game_results.txt", true);
        fileWriter.write(employee.getName() + " guessed the number in " + numberOfGuesses + " guesses");
        fileWriter.close();
    }
}


