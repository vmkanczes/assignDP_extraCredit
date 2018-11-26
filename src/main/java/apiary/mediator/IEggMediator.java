package main.java.apiary.mediator;

/**
File: INature.java
Author: @author
Date: Nov 24, 2018

Description: Used to manage the eggs.
 */

import main.java.apiary.builder.BeeType;

/**
Class: INature

Description:  Mediator interface manages the bee egg fertilization.
 */
public interface IEggMediator {

    public void laidEggs(BeeType type, int eggsLaid);
    
    public void feedEggs(BeeType type, int eggsFed);
    
    public void eatEggs(BeeType type, int eggsEaten);

    
    public void addBee(Bee bee);
}
