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

Description: Creates the methods used for the egg laying and fertilizing.
 */
public class EggCare {

    private int eggs = 0;
    private BeeType type;
    private int beeCode = 0;
    
    /**
     * Method: Constructor
     * Inputs: mediator
     * Returns:
     * 
     *  <p>Description: creates new object for eggs by beetype.
     */
    public EggCare(BeeType beeType, int numberOfEggs, int code) {
        eggs = numberOfEggs;
        type = beeType;
        beeCode = code;
    }
    
    /**
     Method: getEggs
     Inputs: 
     Returns: eggs - number of eggs the queen will lay 
     
     Description: Get the number of eggs laid.
     */
    public int getEggs() {
        return eggs;
    }
    
    public BeeType getType() {
        return type;
    }
    
    public int getCode() {
        return beeCode;
    }
    
}
