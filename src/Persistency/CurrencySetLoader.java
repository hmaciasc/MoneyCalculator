package Persistency;

import Model.Currency;
import Model.CurrencySet;

public class CurrencySetLoader {

    // Mock
    private CurrencySet set;
    
    private void load(){
        set.add(new Currency("EUR", "Euro", "€"));
        set.add(new Currency("USD", "United State Dollar", "$"));
    }
    
}
