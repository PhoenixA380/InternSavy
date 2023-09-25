package HangmanGame;
import java.util.Arrays;
import java.util.Scanner;

public class hangman {

    private static final String[] WORDS = {"penguin", "elephant", "giraffe", "lion", "tiger", "kangaroo", "cheetah"};
    private static final int MAX_TRIES = 6;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String wordToGuess = selectRandomWord();
        char[] guessedWord = new char[wordToGuess.length()];
        int remainingTries = MAX_TRIES;
        boolean wordGuessed = false;

        initializeGuessedWord(guessedWord);

        System.out.println("Welcome to Hangman!");
        System.out.println("Try to guess the word.");

        while (remainingTries > 0 && !wordGuessed) {
            displayHangman(remainingTries);
            displayGuessedWord(guessedWord);

            System.out.print("Enter a letter: ");
            char guess = scanner.next().toLowerCase().charAt(0);

            if (isLetterInWord(guess, wordToGuess, guessedWord)) {
                System.out.println("Good guess!");
                wordGuessed = isWordGuessed(guessedWord);
            } else {
                System.out.println("Incorrect guess.");
                remainingTries--;
            }
        }

        if (wordGuessed) {
            System.out.println("Congratulations! You've guessed the word: " + wordToGuess);
        } else {
            System.out.println("Sorry, you're out of attempts. The word was: " + wordToGuess);
        }

        scanner.close();
    }

    private static String selectRandomWord() {
        int randomIndex = (int) (Math.random() * hangman.WORDS.length);
        return hangman.WORDS[randomIndex];
    }

    private static void initializeGuessedWord(char[] guessedWord) {
        Arrays.fill(guessedWord, '_');
    }

    private static void displayGuessedWord(char[] guessedWord) {
        for (char letter : guessedWord) {
            System.out.print(letter + " ");
        }
        System.out.println();
    }

    private static boolean isLetterInWord(char letter, String wordToGuess, char[] guessedWord) {
        boolean found = false;
        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == letter) {
                guessedWord[i] = letter;
                found = true;
            }
        }
        return found;
    }

    private static boolean isWordGuessed(char[] guessedWord) {
        for (char letter : guessedWord) {
            if (letter == '_') {
                return false;
            }
        }
        return true;
    }

    private static void displayHangman(int remainingTries) {
        String[] hangmanImages = {
                "  +---+\n  |   |\n      |\n      |\n      |\n      |\n=========",
                "  +---+\n  |   |\n  O   |\n      |\n      |\n      |\n=========",
                "  +---+\n  |   |\n  O   |\n  |   |\n      |\n      |\n=========",
                "  +---+\n  |   |\n  O   |\n /|   |\n      |\n      |\n=========",
                "  +---+\n  |   |\n  O   |\n /|\\  |\n      |\n      |\n=========",
                "  +---+\n  |   |\n  O   |\n /|\\  |\n / \\  |\n      |\n========="
        };

        System.out.println(hangmanImages[MAX_TRIES - remainingTries]);
    }
}
