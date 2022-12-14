package com.ship.vide.game;

import com.ship.vide.game.models.Power;
import com.ship.vide.game.models.Ship;
import java.util.LinkedList;
import java.util.Queue;

public class ShipGenerator{

    private Queue<Ship> shipList = new LinkedList<>();
    private int maxShips;
    private int destroyedShip;
    private int evolveNum;

    public ShipGenerator(int maxShips, int evolveNum){
        this.maxShips = maxShips;
        this.evolveNum = evolveNum;
        for (int i = 0; i < maxShips; i++){
            shipList.add(new Ship("Enemy ship "));
        }
    }

    public void generateNewShip(){
        if(shipList.size() < maxShips){
            shipList.add(new Ship("Generated ship"));
        }
    }

    public Ship getFirstShip(){
        return shipList.peek();
    }

    public void destroyFirstShip(Ship attacker){
        if(!shipList.isEmpty()){
            shipList.poll();
            destroyedShip++;
        }
        if(destroyedShip == evolveNum){
            attacker.getPowers().forEach(Power::evolve);
            evolveNum = 0;
        }
    }

}
