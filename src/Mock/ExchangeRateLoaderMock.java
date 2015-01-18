package Mock;

import Model.Currency;
import Model.ExchangeRate;

public class ExchangeRateLoaderMock {
    private ExchangeRate exchangeRate;
    
    public ExchangeRate load(Currency from, Currency to){
        exchangeRate = new ExchangeRate(from, to, getRate(from, to), null);
        return exchangeRate;
    }

    private double getRate(Currency from, Currency to) {
        return Math.random();
    }

}