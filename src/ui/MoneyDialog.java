package ui;

import java.awt.PopupMenu;
import javax.swing.JPanel;
import javax.swing.JTextField;

class MoneyDialog extends JPanel {

    public MoneyDialog() {
        super();
        add(createTextField());
        add(new CurrencyDialog());
    }

    private JTextField createTextField() {
        return new JTextField(10);
    }
    
}