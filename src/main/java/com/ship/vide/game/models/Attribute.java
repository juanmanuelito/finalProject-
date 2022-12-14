package com.ship.vide.game.models;

public interface Attribute {
    int HIGHER_PRIORITY = 3;
    int MIDDLE_PRIORITY = 2;
    int LOW_PRIORITY = 1;

    int getPriority();

    boolean needsToBeRemove();

    double calculateDamage(double damage);
}
