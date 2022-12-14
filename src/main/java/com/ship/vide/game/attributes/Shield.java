package com.ship.vide.game.attributes;

import com.ship.vide.game.models.Attribute;

public class Shield implements Attribute {

    private int priority = HIGHER_PRIORITY;
    private int impactsLeft = 0;

    public Shield(int maxImpacts){
        this.impactsLeft = maxImpacts;
    }

    public int getImpactsLeft() {
        return impactsLeft;
    }

    public void decreaseImpacts(){
        impactsLeft--;
    }

    @Override
    public int getPriority(){
        return priority;
    }

    @Override
    public boolean needsToBeRemove() {
        return impactsLeft <= 0 ;
    }

    @Override
    public double calculateDamage(double damage) {
        decreaseImpacts();
        return 0;
    }

}
