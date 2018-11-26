package main.java.apiary.mediator;

/**
File: Bee.java
Author: @author
Date: Nov 24, 2018

Description: Abstract class to be able to build different types of bees.
 */

import main.java.apiary.builder.BeeType;

/**
 * Class: Bee
 * 
 * <p>Description: Used to determine the bee gender.
 */
public abstract class Bee {

    private IEggMediator mediator;

    public Bee(IEggMediator newMediator) {
        mediator = newMediator;
    }

    /**
    Method: layEggs
    Inputs: BeeType, eggs laid
    Returns: 
    
    Description: Notifies how many eggs have been laid.
    */
    public void laidEggs(BeeType type, int eggsLaid) {

        mediator.laidEggs(type, eggsLaid);
    }
    
    /**
     Method: feedEggs
     Inputs: BeeType, eggs that can be fed
     Returns: 
     
     Description: Notifies how many eggs can be fed.
     */
    public void feedEggs(BeeType type, int eggsThatCanBeFed) {

        mediator.feedEggs(type, eggsThatCanBeFed);
    }
    
    /**
    Method: eatEggs
    Inputs: BeeType, eggs to be fertilized, code
    Returns: 
    
    Description: Notifies how many eggs have been eaten.
    */
    public void eatEggs(BeeType type, int eggsEaten) {

        mediator.eatEggs(type, eggsEaten);
    }

}
