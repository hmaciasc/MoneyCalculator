package ui;

import Control.ExchangeOperation;
import Model.CurrencySet;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MoneyCalculatorFrame extends JFrame{

    private ExchangeOperation command;
    private ExchangeDialogPanel exchangeDialog;
    private CurrencyDialog currencyDialog;
    private CurrencySet currencySet;
    private MoneyDisplayLabel moneyDisplayLabel;
    
    public MoneyCalculatorFrame(CurrencySet currencySet) throws SQLException {
        this.currencySet = currencySet;
        setTitle("MoneyCalculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(600, 300));
        createComponents();
        setVisible(true);
        add(createMoneyDisplay(), NORMAL);
    }

    private void createComponents() throws SQLException {
        add(createExchangeDialog());
        add(createToolbar(), BorderLayout.SOUTH);
    }

    private JPanel createExchangeDialog() {
        ExchangeDialogPanel panel = new ExchangeDialogPanel(currencySet);
        this.exchangeDialog = panel;
        return panel;
        //panel.add(new MoneyDialog());
        //panel.add(new CurrencyDialog());
    }

    private JPanel createToolbar() {
        JPanel toolbar = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        toolbar.add(createCalculateButton());
        toolbar.add(createCancelButton());
        return toolbar;
    }
    
    private JLabel createMoneyDisplay(){
        MoneyDisplayLabel label = new MoneyDisplayLabel();
        this.moneyDisplayLabel = label;
        return label;
    }

    /*    private JPanel createCurrencyDialogPanel() throws SQLException {
    CurrencyDialogPanel panel = new CurrencyDialogPanel("USD");
    this.currencyDialog = panel;
    return panel;
    }*/
    
    public void register(ExchangeOperation command) {
        this.command = command;
    }

    public CurrencyDialog getCurrencyDialog() {
        return currencyDialog;
    }

    public ExchangeDialogPanel getExchangeDialog() {
        return exchangeDialog;
    }

    public MoneyDisplayLabel getMoneyDisplayLabel() {
        return moneyDisplayLabel;
    }
    
    private JButton createCalculateButton() {
        JButton button = new JButton("Calculate");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                command.execute();
            }
        });
        return button;
    }

    private JButton createCancelButton() {
        JButton button = new JButton("Close");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                MoneyCalculatorFrame.this.dispose();
            }
        });
        return button;
    }
    
}