package Persistency;

import Model.Currency;
import Model.CurrencySet;

public class CurrencySetLoader {

    // Mock
    
    public CurrencySet load(){
        CurrencySet set = new CurrencySet();
        set.add(new Currency("EUR", "Euro", "€"));
        set.add(new Currency("USD", "United State Dollar", "$"));
        return set;
    }
    
}
