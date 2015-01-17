package ui;

import Model.Money;
import javax.swing.JLabel;


public class MoneyDisplayLabel extends JLabel {
    
    private String showResult (Money money){
        if (money.getAmount() == 0) {
            return null;
        }
        return money.getAmount() + "";
    }
}
