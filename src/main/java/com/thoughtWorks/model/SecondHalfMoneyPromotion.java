package com.thoughtWorks.model;

public class SecondHalfMoneyPromotion extends Promotion{
    @Override
    public double calculate(CartItem cartItem, double discount) {
        double promotionNumber = ((int) cartItem.getNumber())/2;
        double actualNumber = (cartItem.getNumber() - promotionNumber) + promotionNumber/2;
        return actualNumber * cartItem.getItem().getPrice();
    }
}
