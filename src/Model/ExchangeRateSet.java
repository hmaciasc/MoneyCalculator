package Model;

import java.util.HashMap;
import java.util.Map;

public class ExchangeRateSet {
    private Map<String, ExchangeRate> map;

    public ExchangeRateSet() {
        this.map = new HashMap<>();
    }

    public ExchangeRate get(Currency from, Currency to){
        if (from.getCode().equals(to.getCode())) {
            return new ExchangeRate(from, to, 1.0, null);
        }
        ExchangeRate rate = map.get(from.getCode()+"-"+to.getCode());
        return new ExchangeRate(from, to, rate.getRate(), rate.getDate());
    }
    
    public void add(ExchangeRate rate){
        map.put(rate.getFrom().getCode() + "-" + rate.getTo().getCode(), rate);
    }
    
    private ExchangeRate get(Currency currency){
        return map.get(currency.getCode() + "-EUR");
    }
    
    
}