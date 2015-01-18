package ui;

import Model.Money;
import javax.swing.JLabel;


public class MoneyDisplayLabel extends JLabel {
    
    public void showResult (Money money){
        super.setText(money.getAmount() + " " + money.getCurrency().getName());
    }
}