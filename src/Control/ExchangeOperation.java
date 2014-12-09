package Control;

import Model.CurrencySet;
import Model.Exchange;
import Model.ExchangeRate;
import Model.Money;
import Persistency.ExchangeRateLoaderMock;
import Process.Exchanger;
import UI.ExchangeDialog;
import UI.MoneyDisplay;

public class ExchangeOperation {
    
    private CurrencySet currencySet;

    public ExchangeOperation(CurrencySet currencySet) {
        this.currencySet = currencySet;
    }
    
    public void execute (){
        Exchange exchange = readExchange();
        ExchangeRate rate = readExchangeRate(exchange);
        Money money = calculate(exchange.getMoney(), rate);
        show(money);
    }

    private Exchange readExchange(){
        ExchangeDialog exchangeDialog = new ExchangeDialog(currencySet);
        exchangeDialog.execute();
        return exchangeDialog.getExchange();
    }

    private ExchangeRate readExchangeRate(Exchange exchange) {
        return new ExchangeRateLoaderMock().load();
    }

    private Money calculate (Money money, ExchangeRate exchangeRate){
        return new Money(money.getAmount()*exchangeRate.getRate(), exchangeRate.getTo());
    }
    
    private void show(Money money) {
        new MoneyDisplay(money).execute();//duda
    }
    
}
