package Persistency;

import Model.Currency;
import Model.CurrencySet;

public class CurrencySetLoaderMock implements CurrencyLoader{

    // Mock
    
    @Override
    public CurrencySet load(){
        CurrencySet set = new CurrencySet();
        set.add(new Currency("EUR", "Euro", "€"));
        set.add(new Currency("USD", "United State Dollar", "$"));
        return set;
    }
    
    
}
