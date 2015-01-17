package ui;

import java.awt.PopupMenu;
import javax.swing.JPanel;
import javax.swing.JComboBox;

public class CurrencyDialog extends JPanel {

    public CurrencyDialog() {
        super();
        add(createCombobox());
    }

    private JComboBox createCombobox() {
        return new JComboBox(new String[] {"EUR", "USD", "GBP"});
    }
    
}