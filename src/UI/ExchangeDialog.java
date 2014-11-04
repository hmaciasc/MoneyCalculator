package UI;

import Model.Currency;
import Model.CurrencySet;
import Model.Exchange;

public class ExchangeDialog {
    
    private Exchange exchange;
    private CurrencySet set;

    public ExchangeDialog(Exchange exchange, CurrencySet set) {
        this.exchange = exchange;
        this.set = set;
    }

    public void execute() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Exchange getExchange() {
        return exchange;
    }
    
    
}
