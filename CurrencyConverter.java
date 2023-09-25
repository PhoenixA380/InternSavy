package CurrencyConverter;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.*;

public class currconv {
    private final JTextField amountField;
    private final JComboBox<String> fromCurrencyComboBox;
    private final JComboBox<String> toCurrencyComboBox;
    private final JLabel resultLabel;

    private Map<String, Double> exchangeRates;

    public currconv() {
        JFrame frame = new JFrame("Currency Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 300);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        JLabel fromLabel = new JLabel("From Currency:");
        fromCurrencyComboBox = new JComboBox<>();
        fromCurrencyComboBox.addItem("USD");
        fromCurrencyComboBox.addItem("EUR");
        fromCurrencyComboBox.addItem("GBP");
        fromCurrencyComboBox.addItem("JPY");
        fromCurrencyComboBox.addItem("CAD");
        fromCurrencyComboBox.addItem("INR"); // Added INR

        JLabel toLabel = new JLabel("To Currency:");
        toCurrencyComboBox = new JComboBox<>();
        toCurrencyComboBox.addItem("USD");
        toCurrencyComboBox.addItem("EUR");
        toCurrencyComboBox.addItem("GBP");
        toCurrencyComboBox.addItem("JPY");
        toCurrencyComboBox.addItem("CAD");
        toCurrencyComboBox.addItem("INR"); // Added INR

        amountField = new JTextField();
        amountField.setToolTipText("Enter amount");

        JButton convertButton = new JButton("Convert");
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertCurrency();
            }
        });

        resultLabel = new JLabel();

        panel.add(fromLabel);
        panel.add(fromCurrencyComboBox);
        panel.add(toLabel);
        panel.add(toCurrencyComboBox);
        panel.add(new JLabel("Amount:"));
        panel.add(amountField);
        panel.add(convertButton);
        panel.add(resultLabel);

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);

        ExchangeRates();
    }

    private void ExchangeRates() {
        exchangeRates = new HashMap<>();
        exchangeRates.put("USD", 1.0);
        exchangeRates.put("EUR", 0.85);
        exchangeRates.put("GBP", 0.74);
        exchangeRates.put("JPY", 110.44);
        exchangeRates.put("CAD", 1.26);
        exchangeRates.put("INR", 73.0);
    }

    private void convertCurrency() {
        String fromCurrency = (String) fromCurrencyComboBox.getSelectedItem();
        String toCurrency = (String) toCurrencyComboBox.getSelectedItem();

        try {
            double amount = Double.parseDouble(amountField.getText());
            double exchangeRateFrom = exchangeRates.get(fromCurrency);
            double exchangeRateTo = exchangeRates.get(toCurrency);
            double result = (amount / exchangeRateFrom) * exchangeRateTo;

            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            resultLabel.setText(decimalFormat.format(amount) + " " + fromCurrency + " = " +
                    decimalFormat.format(result) + " " + toCurrency);
        } catch (NumberFormatException e) {
            resultLabel.setText("Please enter a valid amount.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new currconv();
            }
        });
    }
}
