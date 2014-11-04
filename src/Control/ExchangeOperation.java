package Control;

import Model.CurrencySet;
import Model.Exchange;
import Model.ExchangeRate;
import Model.Money;
import Persistency.ExchangeRateLoader;
import Process.Exchanger;
import UI.ExchangeDialog;
import UI.MoneyDisplay;

public class ExchangeOperation {
    
    private CurrencySet currencySet;

    public ExchangeOperation(CurrencySet currencySet) {
        this.currencySet = currencySet;
    }
    
    private void execute (){
        Exchange exchange = readExchange();
        ExchangeRate rate = readExchangeRate(exchange);
        Exchanger.exchange();
        MoneyDisplay.show();
    }

    private Exchange readExchange(){
        ExchangeDialog exchangeDialog = new ExchangeDialog(, currencySet);
        exchangeDialog.execute();
        return exchangeDialog.getExchange();
    }

    private ExchangeRate readExchangeRate(Exchange exchange) {
        return new ExchangeRateLoader().load();
    }


    
}
