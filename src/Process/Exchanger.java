package Process;

import Model.ExchangeRate;
import Model.Money;

public class Exchanger {

    private ExchangeRate exchangeRate;
    private Money money;

    public Exchanger(ExchangeRate exchangeRate, Money money) {
        this.exchangeRate = exchangeRate;
        this.money = money;
    }
    
    public Money exchange() {
        return calculate(money, exchangeRate);
    }

    public Money getMoney() {
        return money;
    }

    public ExchangeRate getExchangeRate() {
        return exchangeRate;
    }
    
    private Money calculate(Money money, ExchangeRate exchangeRate){
        return new Money(money.getAmount()*exchangeRate.getRate(), exchangeRate.getTo());
    }
    
}
