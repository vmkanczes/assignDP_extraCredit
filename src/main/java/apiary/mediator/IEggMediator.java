package main.java.apiary.mediator;

/**
File: INature.java
Author: @author
Date: Nov 24, 2018

Description: Used to manage the eggs.
 */

import main.java.apiary.decorator.IBee;

/**
Class: INature

Description:  Mediator interface manages the bee egg fertilization.
 */
public interface IEggMediator {

    public boolean laidEggs(IBee bee, int eggsLaid);
    
    public boolean feedEggs(IBee bee, int eggsFed);
    
    public boolean eatEggs(IBee bee, int eggsEaten);

    public void addBee(IBee bee);
}
