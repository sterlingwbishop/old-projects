import java.util.*;

public class GuessingGame {


    // This method creates and returns an integer array of the given length.
    // The rand instance must be used to generate digits between 0 and 9
    // to fill the array starting with element 0
    //
    // Throw an IllegalArgumentException with the message, "Null rand",
    // if rand is null.
    //
    // Throw an IllegalArgumentException with the message, "Invalid length",
    // if length < 1
    //
    // You must check for these error conditions in the order given above.
    public static int[] getSecretCode(Random rand, int length) { 
        int temp = 0;
        int[] secretCode = new int[length];
        for (int i = 0; i < length; i++) {
            temp = (rand.nextInt(10));
            secretCode[i] = temp;
        }
        return secretCode;
    }

    // Returns the number of digits in the guess array that are also in
    // the code array.
    //
    // Throw an IllegalArgumentException with the message, "Null code",
    // if code is null.
    //
    // Throw an IllegalArgumentException with the message, "Null guess",
    // if guess is null.
    //
    // Throw an IllegalArgumentException with the message, "Different lengths",
    // if the lengths of the code and guess are arrays are different.
    //
    // Throw an IllegalArgumentException with the message, "Invalid digit",
    // if the code or guess array contains an integer that is less than 0
    // or greater than 9.
    //
    // You must check for these error conditions in the order given above.
    public static int getCorrectDigits(int[] code, int[] guess) {
        int codeLength = code.length;
        int correctDigits = 0;
        for (int i = 0; i < codeLength; i++) {

            for (int j = 0; j < codeLength; j++) {
                if (code[i] == guess[j])
                ++correctDigits;
                }
            }

            if(((code[0] == code[1]) || (code[0] == code[2]) || (code[0] == code[3])) || ((code[1] == code[2]) || (code[1] == code[3])) || (code[2] == code[3])) {
                correctDigits -= 1;
            }

            else if ((code[0] == code[1] && code[1] == code[2]) || (code[0] == code[2] && code[2] == code[3]) || (code[0] == code[1] && code[1] == code[3]) || (code[1] == code[2] && code[2] == code[3])) {
                correctDigits -= 2;
            }

            else if (code[0] == code[1] && code[1] == code[2] && code[2] == code[3]) {
                correctDigits -= 3;
            }

            return correctDigits;
    }
        

    // Returns the number of digits in the guess array that are in the same
    // position in the code array. 
    //
    // Throw an IllegalArgumentException with the message, "Null code",
    // if code is null.
    //
    // Throw an IllegalArgumentException with the message, "Null guess",
    // if guess is null.
    //
    // Throw an IllegalArgumentException with the message, "Different lengths",
    // if the lengths of the code and guess are arrays are different.
    //
    // Throw an IllegalArgumentException with the message, "Invalid digit",
    // if the code or guess array contains an integer that is less than 0
    // or greater than 9.
    //
    // You must check for these error conditions in the order given above.
    public static int getCorrectDigitsInCorrectPlace(int[] code, int[] guess) {
        int codeLength = code.length;
        int correctDigits = 0;
        for (int i = 0; i < codeLength; i++) {
                if (guess[i] == code[i]) {
                    correctDigits += 1;
                }
        }
        return correctDigits;

    }
    public static void main(String[]args) {
        Random rand = new Random();
            if (args.length == 1) {
                try {
                    int seed = Integer.parseInt(args[0]);
                        rand.setSeed(seed);
                }
                catch (NumberFormatException e) {
                System.out.println("Usage: java -cp bin GuessingGame <seed>");
                System.exit(1);
                }
            }

            Scanner scnr = new Scanner(System.in);
            System.out.print(          "Welcome to the Guessing Game!\n" + 
            "You must try to guess a secret code consiting of 4 digits.\n" +
            "After each guess, the total number of correct digits (CD)\n)" +
            "and the number of correct digits in the correct place (CP)\n" +
            "for the guess and all preceding guesses will be output. You\n" +
            "will have 10 chances to guess the secret code, which will\n" +
            "be revealed, if you do not guess it!\n" + "\n");
            int[] guess = new int[4];
            int[] code = getSecretCode(rand, 4);
            String secretCode = Arrays.toString(code);
            int[][] storeGuess = new int[10][4];
            int temp = 0;

            for (int numGuess = 1; numGuess < 11; ++numGuess) {
            System.out.print("Guess " + numGuess + ":");
            for (int i = 0; i < 4; ++i) {
                guess[i] = scnr.nextInt();
                if (guess[i] < 1 || guess[i] > 9) {
                    System.out.print("Invalid Guess, please try again.");
                    i = 0;
                }
            }
            System.out.println("You have " + getCorrectDigits(code, guess) + " correct digits");
            System.out.println("You have " + getCorrectDigitsInCorrectPlace(code, guess) + " correct digits in the correct place");

            if (getCorrectDigitsInCorrectPlace(code, guess) == 4) {
                System.out.println("You Win!");
                System.exit(0);
            } 

           
        }
    
            System.out.println("You lose. The correct code was " + secretCode + ".\n");
        }
    }