package Application;

import Control.ExchangeOperation;
import Model.CurrencySet;
import Persistency.CurrencySetLoaderMock;

public class MoneyCalculator {

    public static void main(String[] args) {
        // new currency Set
        // new exchange operation
        CurrencySet currencySet = new CurrencySetLoaderMock().load();
        new ExchangeOperation(currencySet).execute();
    }
    
}