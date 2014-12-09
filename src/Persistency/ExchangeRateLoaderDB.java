package Persistency;

import Model.Currency;
import Model.CurrencySet;
import Model.ExchangeRate;
import Model.ExchangeRateSet;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class ExchangeRateLoaderDB implements ExchangeRateLoader{
    
    private final Connection connection;
    private final CurrencySet currencySet;

    public ExchangeRateLoaderDB (Connection connection, CurrencySet currencySet) {
        this.connection = connection;
        this.currencySet = currencySet;
    }
    
    @Override
    public ExchangeRateSet load() {
        try {
            return processExchangeRateSet(connection.createStatement().executeQuery("SELECT * FROM CAMBIO_EUR_A"));
        } catch (SQLException ex) {
            return new ExchangeRateSet();
        }
    }

    private ExchangeRateSet processExchangeRateSet(ResultSet resultSet) throws SQLException {
        ExchangeRateSet set = new ExchangeRateSet();
        while(resultSet.next())
            set.add(processExchangeRate(resultSet));
        return set;
    }
    
    private ExchangeRate processExchangeRate(ResultSet resultSet) throws SQLException{
        return new ExchangeRate(currencySet.get(resultSet.getString(1)), 
                currencySet.get("EUR"),
                resultSet.getDouble(2),
                processDate(resultSet)
        );
    }

    private Date processDate(ResultSet resultSet) throws SQLException {
        String[] date = resultSet.getString(5).split(" ")[0].split("/");
        return new Date(Integer.parseInt(date[2]),Integer.parseInt(date[1]), Integer.parseInt(date[0]));
    }
}
