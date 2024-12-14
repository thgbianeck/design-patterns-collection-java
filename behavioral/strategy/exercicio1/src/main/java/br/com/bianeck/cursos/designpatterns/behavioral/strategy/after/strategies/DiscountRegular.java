package br.com.bianeck.cursos.designpatterns.behavioral.strategy.after.strategies;

import br.com.bianeck.cursos.designpatterns.behavioral.strategy.after.Discount;
import br.com.bianeck.cursos.designpatterns.behavioral.strategy.after.Order;

public class DiscountRegular implements Discount{

    @Override
    public void applyDiscount(Order order) {
        if (order.getSubtotal() > 100) {
            order.setDiscount(order.getSubtotal() * 0.1);
        }
    }

}
