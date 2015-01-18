package ui;

import Model.Currency;
import Model.CurrencySet;
import Persistency.CurrencySetLoaderDB;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class CurrencyDialogPanel extends JPanel implements CurrencyDialog{

    private String currency;
    private CurrencySetLoaderDB currencyDialog;
    
    public CurrencyDialogPanel(String currency) throws SQLException {
        super(new FlowLayout(FlowLayout.LEFT));
        this.currency = currency;
        createComponents();
    }
    
    @Override
    public Currency getCurrency() {
        return new Currency(currency, currency, currency);
    }

    private void createComponents() {
        add(createDisplay());
    }

    private JComboBox createDisplay() {
        CurrencySet currencySet = currencyDialog.load();
        JComboBox comboBox = new JComboBox(currencySet.toArray());
        comboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent event) {
                if (event.getStateChange() != ItemEvent.SELECTED)
                    return;
                currency = event.getItem().toString();
            }
        });
        return comboBox;
    }
    
    
}
