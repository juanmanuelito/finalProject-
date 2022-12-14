package com.ship.vide.game.models;

import java.util.LinkedList;
import java.util.List;

public class Ship {
    private String name;
    private double life = 100;
    private int positionX, positionY;
    private List<Power>         powers = new LinkedList<>();
    private List<Attribute> attributes = new LinkedList<>();

    public Ship(String name){
        this.positionY = this.positionX = 0;
        this.name = name;
    }

    public void fire(){

    }

    public void damage(double life){
        this.life = this.life-life;
    }

    public void removeAttribute(Attribute attribute){
        attributes.remove(attribute);
    }

    public List<Attribute> getAttributes(){
        return List.copyOf(attributes);
    }

    public void addAttribute(Attribute attribute){
        attributes.add(attribute);
    }

    public void addPower(Power power){
        powers.add(power);
    }

    public List<Power> getPowers(){
        return List.copyOf(powers);
    }

    public boolean couldBeDestroy(double damage){
        return life <= damage;
    }
}
