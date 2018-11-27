package main.java.apiary.mediator;

/**
File: EggCare.java
Author: @author
Date: Nov 24, 2018

Description: Stores the concrete class used in mediator.
 */

import main.java.apiary.decorator.IBee;

/**
Class:

Description: Creates the methods used for the egg laying and feeding and eating.
 */
public class EggCare {

    private int eggs = 0;
    private IBee bee;
    
    /**
     * Method: Constructor
     * Inputs: mediator
     * Returns:
     * 
     *  <p>Description: keeps track of the eggs.
     */
    public EggCare(IBee ibee, int numberOfEggs) {
        eggs = numberOfEggs;
        bee = ibee;
    }
    
    /**
     Method: getEggs
     Inputs: 
     Returns: eggs - number of eggs laid 
     
     Description: Get the number of eggs laid.
     */
    public int getEggs() {
        return eggs;
    }
    
    public IBee getBee() {
        return bee;
    }
    
}
