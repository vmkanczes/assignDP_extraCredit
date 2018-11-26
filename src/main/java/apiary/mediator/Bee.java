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
    private BeeType type;

    public Bee(IEggMediator newMediator) {
        mediator = newMediator;
    }

    /**
    Method: layEggs
    Inputs: BeeType, eggs laid
    Returns: 
    
    Description: Notifies how many eggs have been laid.
    */
    public void layEggs(BeeType type, int eggs) {

        System.out.println("Type: " + type + " eggs laid: " + eggs);
        mediator.layEggs(type, eggs);
    }
    
    /**
     Method: feedEggs
     Inputs: BeeType, eggs to be fed
     Returns: 
     
     Description: Notifies how many eggs have been fed.
     */
    public void feedEggs(BeeType type, int eggs) {

        System.out.println("Type: " + type + " eggs fed: " + eggs);

        mediator.feedEggs(type, eggs);
    }
    
    /**
    Method: eatEggs
    Inputs: BeeType, eggs to be fertilized, code
    Returns: 
    
    Description: Notifies how many eggs have been eaten.
    */
    public void eatEggs(BeeType type, int eggs) {

        System.out.println("Type: " + type + " eggs eaten: " + eggs);

        mediator.eatEggs(type, eggs);
    }

    public void setType(BeeType beeType) {
        type = beeType;
    }

}
