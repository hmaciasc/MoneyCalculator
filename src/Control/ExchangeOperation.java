package Control;

import Model.Currency;
import Model.CurrencySet;
import Model.Exchange;
import Model.ExchangeRate;
import Model.Money;
import Model.ExchangeRateSet;
import Persistency.ExchangeRateLoaderDB;
import ui.ExchangeDialogPanel;
import ui.MoneyDisplayLabel;

public class ExchangeOperation {
    
    private ExchangeDialogPanel exchangeDialog;
    private MoneyDisplayLabel moneyDisplayLabel;

    public ExchangeOperation(ExchangeDialogPanel exchangeDialog, MoneyDisplayLabel moneyDisplayLabel) {
        this.exchangeDialog = exchangeDialog;
        this.moneyDisplayLabel = moneyDisplayLabel;
    }

    public void execute (){
        Exchange exchange = readExchange();
        ExchangeRate rate = readExchangeRate(exchange.getMoney().getCurrency(), exchange.getCurrency());
        Money money = calculate(exchange.getMoney(), rate);
        show(money);
    }

    private Exchange readExchange(){
        return exchangeDialog.getExchange();
    }

    private ExchangeRate readExchangeRate(Currency from, Currency to) {
        CurrencySet currencySet = new CurrencySet();
        currencySet.add(from);
        currencySet.add(to);
        ExchangeRateSet rateSet = new ExchangeRateLoaderDB(currencySet).load();
        return rateSet.get(from, to);
    }

    private Money calculate (Money money, ExchangeRate exchangeRate){
        return new Money(money.getAmount()*exchangeRate.getRate(), exchangeRate.getTo());
    }
    
    private void show(Money money) {
        moneyDisplayLabel.showResult(money);
    }
    
}
