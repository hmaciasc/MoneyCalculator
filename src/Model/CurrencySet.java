package Model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CurrencySet implements Iterable<Currency>{

    HashMap<String, Currency> map = new HashMap<>();
    @Override
    public Iterator<Currency> iterator() {
        return new Iterator<Currency>() {

            @Override
            public boolean hasNext() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Currency next() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
                
    }
    
    public void add(Currency currency){
        map.put(currency.getCode(), currency);
    }
    
}
