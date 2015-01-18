package Persistency;

import Model.Currency;
import Model.CurrencySet;
import Model.ExchangeRate;
import Model.ExchangeRateSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class ExchangeRateLoaderDB implements ExchangeRateLoader{
    
    private Connection connection;
    private final CurrencySet currencySet;

    public ExchangeRateLoaderDB (CurrencySet currencySet) {
        this.currencySet = currencySet;
        currencySet.add(new Currency("EUR", "Euro", "€"));
    }

    @Override
    public ExchangeRateSet load() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:money");
            return processExchangeRateSet(connection.createStatement().executeQuery("SELECT * FROM HISTORICO_CAMBIOS"));
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
        String from = resultSet.getString(1);
        String to = resultSet.getString(2);
        return new ExchangeRate(new Currency(from, from, from), 
                new Currency(to, to, to),
                resultSet.getDouble(3),
                null
        );
    }

    private Date processDate(ResultSet resultSet) throws SQLException {
        String[] date = resultSet.getString(5).split(" ")[0].split("/");
        return new Date(Integer.parseInt(date[2]),Integer.parseInt(date[1]), Integer.parseInt(date[0]));
    }
}
