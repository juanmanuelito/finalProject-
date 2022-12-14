package com.ship.vide.game;

import com.ship.vide.game.models.Ship;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Game {
    public static int ENEMY_SHIPS_NUMBER = 20;
    public static int EVOLVE_NUMBER = 20;
    private ShipGenerator shipGenerator = new ShipGenerator(ENEMY_SHIPS_NUMBER, EVOLVE_NUMBER);

    public Game(){


    }


    public void Start(){

    }
}
