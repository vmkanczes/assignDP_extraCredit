package main.java.apiary.mediator;

/**
File: EggCare.java
Author: @author
Date: Nov 24, 2018

Description: Stores the concrete class used in mediator.
 */

import main.java.apiary.builder.BeeType;

/**
Class:

Description: Creates the methods used for the egg laying and feeding and eating.
 */
public class EggCare {

    private int eggs = 0;
    private BeeType type;
    
    /**
     * Method: Constructor
     * Inputs: mediator
     * Returns:
     * 
     *  <p>Description: keeps track of the eggs.
     */
    public EggCare(BeeType beeType, int numberOfEggs) {
        eggs = numberOfEggs;
        type = beeType;
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
    
    public BeeType getType() {
        return type;
    }
    
}
