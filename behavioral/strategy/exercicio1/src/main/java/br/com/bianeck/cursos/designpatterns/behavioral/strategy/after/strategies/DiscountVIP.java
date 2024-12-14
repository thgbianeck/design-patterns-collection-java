package br.com.bianeck.cursos.designpatterns.behavioral.strategy.after.strategies;

import br.com.bianeck.cursos.designpatterns.behavioral.strategy.after.Discount;
import br.com.bianeck.cursos.designpatterns.behavioral.strategy.after.Order;

public class DiscountVIP implements Discount{

    @Override
    public void applyDiscount(Order order) {
        order.setDiscount(order.getSubtotal() * 0.20);
    }

}
