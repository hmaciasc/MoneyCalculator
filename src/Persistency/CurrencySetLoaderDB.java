package Persistency;

import Model.Currency;
import Model.CurrencySet;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CurrencySetLoaderDB implements CurrencyLoader{
    private static final int DIVISA_INDEX = 1;

    private final Connection connection;

    public CurrencySetLoaderDB (Connection connection) {
        this.connection = connection;
    }
    
    @Override
    public CurrencySet load() {
        try {
            return processCurrencySet(connection.createStatement().executeQuery("SELECT DIVISA FROM CAMBIO_EUR_A"));
        } catch (SQLException ex) {
            //return new CurrencySet();
            CurrencySet set = new CurrencySet();
            set.add(new Currency("ERR", "ERROR", "E"));
            return set;
        }
    }

    private CurrencySet processCurrencySet(ResultSet resultSet) throws SQLException {
        CurrencySet set = new CurrencySet();
        while(resultSet.next())
            set.add(processCurrency(resultSet));
        return set;
    }

    private Currency processCurrency(ResultSet resultSet) throws SQLException {
        return new Currency(
                resultSet.getString(DIVISA_INDEX), 
                resultSet.getString(DIVISA_INDEX), 
                resultSet.getString(DIVISA_INDEX));
    }
    
}
