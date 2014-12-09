package Model;

import java.util.HashMap;
import java.util.Map;

public class ExchangeRateSet {
    private Map<String, ExchangeRate> map;

    public ExchangeRate get(Currency from, Currency to){
        map = new HashMap<>();
        ExchangeRate rate1 = get(from);
        ExchangeRate rate2 = get(to);
        return new ExchangeRate(from, to, rate2.getRate() / rate1.getRate(), rate1.getDate());
    }
    
    public void add(ExchangeRate rate){
        map.put(rate.getFrom().getCode() + "-" + rate.getTo().getCode(), rate);
    }
    
    private ExchangeRate get(Currency currency){
        return map.get(currency.getCode() + "-EUR");
    }
    
    
}
