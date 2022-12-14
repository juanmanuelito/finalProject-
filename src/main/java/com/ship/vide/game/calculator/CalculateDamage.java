package com.ship.vide.game.calculator;

import com.ship.vide.game.ShipGenerator;
import com.ship.vide.game.models.Attribute;
import com.ship.vide.game.models.Power;
import com.ship.vide.game.models.Ship;
import java.util.Comparator;
import java.util.List;

public class CalculateDamage {
    public static int DEFAULT_DAMAGE = 100;
    private static double calculateDamage(Ship attacker) {
        double damagePercentage = calculateDamage(attacker.getPowers());
        return damagePercentage+(DEFAULT_DAMAGE*damagePercentage);
    }

    public static void impact(ShipGenerator shipGenerator, Ship attacker){
        double damage = calculateDamage(attacker);
        Ship target = shipGenerator.getFirstShip();
        damage = realImpact(target, damage);
        if(target.couldBeDestroy(damage)){
            shipGenerator.destroyFirstShip(attacker);
        }
        target.damage(damage);
    }

    private static double calculateDamage(List<Power> powers) {
        return powers.stream().map(Power::calculateDamage).reduce(Double::sum).orElse(0d);
    }

    private static double realImpact(Ship target, double damage){
        List<Attribute> attributes = target.getAttributes();
        attributes.sort(Comparator.comparing(Attribute::getPriority));
        double realDamage = damage;
        for(Attribute attribute: attributes){
            if(attribute.needsToBeRemove()){
                target.removeAttribute(attribute);
                continue;
            }
            realDamage = attribute.calculateDamage(realDamage);
            if(realDamage == 0){
                return 0;
            }
        }
        return realDamage;
    }
}
