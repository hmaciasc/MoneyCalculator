package ui;

import Model.Currency;
import Model.CurrencySet;
import Model.Exchange;
import Model.Money;
import java.awt.FlowLayout;
import static java.awt.FlowLayout.LEFT;
import java.awt.PopupMenu;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ExchangeDialogPanel extends JPanel {
    
    private final CurrencySet currencySet;
    private JTextField amount;
    private JComboBox<Currency> toCurrency;
    private JComboBox<Currency> fromCurrency;

    public ExchangeDialogPanel(CurrencySet currencySet) {
        this.currencySet = currencySet;
        setLayout(new FlowLayout(LEFT));
        createComponents();
    }
    
    public  Exchange getExchange(){
        return new Exchange(new Money(getAmount(), getFromCurrency()), getToCurrency());
    }
    
    private double getAmount(){
        return Double.parseDouble(amount.getText());
    }
    
    private Currency getToCurrency(){
        return toCurrency.getItemAt(toCurrency.getSelectedIndex());
    }
    
    private Currency getFromCurrency(){
        return fromCurrency.getItemAt(fromCurrency.getSelectedIndex());
    }
    
    private void createComponents(){
        add(createAmount());
        add(createFromCurrency());
        add(createToCurrency());
    }

    private JTextField createAmount() {
        JTextField amount = new JTextField();
        amount.setColumns(20);
        this.amount = amount;
        return amount;
    }

    private JComboBox createFromCurrency() {
        Currency[] currencies = currencySet.toArray();
        JComboBox fromCurrencyBox = new JComboBox<>(currencies);
        this.fromCurrency = fromCurrencyBox;
        return fromCurrencyBox;
    }

    private JComboBox createToCurrency() {
        JComboBox<Currency> toCurrencyBox = new JComboBox<>();
        this.toCurrency = toCurrencyBox;
        for (Currency currencySet1 : currencySet) {
            toCurrencyBox.addItem(currencySet1);
        }
        return toCurrencyBox;
    }
    
}
