package Persistency;

import Model.Currency;
import Model.ExchangeRate;

public class ExchangeRateLoader {
    private ExchangeRate exchangeRate;
    
    public ExchangeRate load(){
        exchangeRate = new ExchangeRate(new Currency("EUR", "Euro", "€"), 
                       new Currency("USD", "United State Dollar", "$"), 1.5, null);
        return exchangeRate;
    }

    
}
