package HangmanGame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class hangmanwithswings {
    private final JFrame frame;
    private final JPanel keyboardPanel;
    private final JLabel wordLabel;
    private final String[] words = {"apple", "banana", "cherry", "grape", "lemon", "orange", "strawberry", "pineapple"};
    private String wordToGuess;
    private char[] guessedWord;
    private int remainingTries;

    public withswings() {
        frame = new JFrame("Hangman Game (Guess the fruit)");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        JPanel wordPanel = new JPanel();
        wordLabel = new JLabel();
        wordPanel.add(wordLabel);

        keyboardPanel = new JPanel(new GridLayout(4, 7));
        createKeyboardButtons();

        frame.add(wordPanel, BorderLayout.NORTH);
        frame.add(keyboardPanel, BorderLayout.CENTER);

        initializeGame();

        frame.setVisible(true);
    }

    public void createKeyboardButtons() {
        for (char letter = 'A'; letter <= 'Z'; letter++) {
            JButton button = new JButton(String.valueOf(letter));
            char finalLetter1 = letter;
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    handleLetterClick(finalLetter1);
                }
            });
            keyboardPanel.add(button);
        }
    }

    private void initializeGame() {
        wordToGuess = selectRandomWord(words);
        guessedWord = new char[wordToGuess.length()];
        remainingTries = 6;

        Arrays.fill(guessedWord, '_');

        updateWordLabel();

        frame.repaint();
    }

    private void handleLetterClick(char letter) {
        boolean letterFound = false;
        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == letter) {
                guessedWord[i] = letter;
                letterFound = true;
            }
        }

        if (!letterFound) {
            remainingTries--;
        }

        updateWordLabel();

        if (remainingTries == 0 || isWordGuessed()) {
            int option = JOptionPane.showConfirmDialog(null,
                    "Do you want to play again?", "Game Over",
                    JOptionPane.YES_NO_OPTION);

            if (option == JOptionPane.YES_OPTION) {
                initializeGame();
            } else {
                System.exit(0);
            }
        }
    }

    private void updateWordLabel() {
        StringBuilder word = new StringBuilder();
        for (char c : guessedWord) {
            word.append(c);
            word.append(' ');
        }
        wordLabel.setText("Word: " + word + "   Tries left: " + remainingTries);
    }

    private boolean isWordGuessed() {
        for (char c : guessedWord) {
            if (c == '_') {
                return false;
            }
        }
        return true;
    }

    private String selectRandomWord(String[] words) {
        int randomIndex = (int) (Math.random() * words.length);
        return words[randomIndex].toUpperCase();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new hangmanwithswings();
            }
        });
    }
}
