package UI;

import Model.Currency;
import Model.CurrencySet;
import Model.Exchange;
import Model.Money;

public class ExchangeDialog {
    
    private Exchange exchange;
    private CurrencySet set;

    public ExchangeDialog(CurrencySet set) {
        this.exchange = exchange;
        this.set = set;
    }

    public void execute() {
        this.exchange = new Exchange(new Money(100, set.get("EUR")), set.get("USD"));
    }

    public Exchange getExchange() {
        return exchange;
    }
    
    
}
