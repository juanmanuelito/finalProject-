package com.ship.vide.game.attributes;

import com.ship.vide.game.models.Attribute;

public class Defence implements Attribute {

    private double defence = 0.01;

    private int priority = LOW_PRIORITY;

    public Defence(double percentage){
        this.defence = percentage;
    }

    public double getDefence(){
        return defence;
    }

    @Override
    public int getPriority() {
        return priority;
    }

    @Override
    public boolean needsToBeRemove() {
        return false;
    }

    @Override
    public double calculateDamage(double damage) {
        return damage-(damage*defence);
    }
}
