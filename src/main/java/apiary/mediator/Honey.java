package main.java.apiary.mediator;

/**
File: Honey.java
Author: @author
Date: Nov 24, 2018

Description: Create a honey bee mediator that can fertilize the eggs.
 */

/**
Class:

Description:  Male bees are created from unfertilized eggs but can fertilize eggs.
 */
public class Honey extends Bee {
    
    /**
     * Method: Constructor
     * Inputs: mediator
     * Returns:
     * 
     *  <p>Description: will fertilize eggs.
     */
    public Honey(INature newMediator) {
        super(newMediator);
        
        System.out.println("Honey bee signed up to fertilize the eggs");
    }

}
