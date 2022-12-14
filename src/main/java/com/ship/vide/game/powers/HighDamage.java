package com.ship.vide.game.powers;

import com.ship.vide.game.models.Power;

public class HighDamage implements Power {

    private int level;
    private double damage ;

    @Override
    public void evolve() {
        this.level++;
        this.damage = damage+0.05;
    }

    @Override
    public double calculateDamage() {
        return damage;
    }

}
