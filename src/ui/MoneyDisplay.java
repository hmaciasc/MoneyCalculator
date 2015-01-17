package ui;

import Model.Money;

public class MoneyDisplay {

    public static void show() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private Money money;

    public MoneyDisplay(Money money) {
        this.money = money;
    }

    public void execute() {
        System.out.println(money);
    }

    public Money getMoney() {
        return money;
    }
    
}
