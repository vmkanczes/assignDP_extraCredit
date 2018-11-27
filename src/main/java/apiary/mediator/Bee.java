package main.java.apiary.mediator;

/**
File: Bee.java
Author: @author
Date: Nov 24, 2018

Description: Abstract class to be able to build different types of bees.
 */

import main.java.apiary.decorator.IBee;

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
    public void laidEggs(IBee bee, int eggs) {

        mediator.laidEggs(bee, eggs);
    }
    
    /**
     Method: feedEggs
     Inputs: BeeType, eggs that can be fed
     Returns: 
     
     Description: Notifies how many eggs can be fed.
     */
    public void feedEggs(IBee bee, int eggs) {

        mediator.feedEggs(bee, eggs);
    }
    
    /**
    Method: eatEggs
    Inputs: BeeType, eggs to be fertilized, code
    Returns: 
    
    Description: Notifies how many eggs have been eaten.
    */
    public void eatEggs(IBee bee, int eggs) {

        mediator.eatEggs(bee, eggs);
    }

}
