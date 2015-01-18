package Mock;

import Model.Currency;
import Model.CurrencySet;
import Persistency.CurrencyLoader;

public class CurrencySetLoaderMock implements CurrencyLoader{

    
    @Override
    public CurrencySet load(){
        CurrencySet set = new CurrencySet();
        set.add(new Currency("EUR", "Euro", "€"));
        set.add(new Currency("USD", "United State Dollar", "$"));
        return set;
    }
    
    
}
