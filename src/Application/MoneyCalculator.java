package Application;

import Control.ExchangeOperation;
import Model.CurrencySet;
import Persistency.CurrencySetLoader;

public class MoneyCalculator {

    public static void main(String[] args) {
        // new currency Set
        // new exchange operation
        CurrencySet currencySet = new CurrencySetLoader().load();
        new ExchangeOperation(currencySet).execute();
    }
    
}