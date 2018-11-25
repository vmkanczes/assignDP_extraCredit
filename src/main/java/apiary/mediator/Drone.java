package main.java.apiary.mediator;

/**
File: Drone.java
Author: @author
Date: Nov 24, 2018

Description: Creates the bee as a mediator.
 */

/**
Class:

Description:  Drone is a male bee is from an unfertilized egg but can fertilize eggs.
 */
public class Drone extends Bee {
    
    /**
     * Method: Constructor
     * Inputs: mediator
     * Returns:
     * 
     *  <p>Description: will fertilize eggs.
     */
    public Drone(INature newMediator) {
        super(newMediator);
        
        System.out.println("Drone signed up to fertilize the eggs");
    }

}
