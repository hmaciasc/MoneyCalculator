package Application;

import Control.ExchangeOperation;
import Model.CurrencySet;
import Persistency.CurrencySetLoaderDB;
import Mock.CurrencySetLoaderMock;
import java.sql.SQLException;
import ui.MoneyCalculatorFrame;

public class MoneyCalculator {

    public static void main(String[] args) throws SQLException {
        // new currency Set
        // new exchange operation
        CurrencySet currencySet = new CurrencySetLoaderDB().load();
        MoneyCalculatorFrame frame = new MoneyCalculatorFrame(currencySet);
        frame.register(new ExchangeOperation(frame.getExchangeDialog(), frame.getMoneyDisplayLabel()));
    }
    
}