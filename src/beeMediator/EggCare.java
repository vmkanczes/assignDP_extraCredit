/**
File: EggCare.java
Author: @author
Date: Nov 24, 2018

Description: 
 */
package beeMediator;

import builder.BeeType;

/**
Class:

Description:
 */
public class EggCare {

    private int eggs = 0;
    private BeeType type;
    private int beeCode = 0;
    
    /* Constructor
     * 
     */
    public EggCare(BeeType beeType, int numberOfEggs, int code) {
        eggs = numberOfEggs;
        type = beeType;
        beeCode = code;
    }
    
    /**
     * 
     Method: getEggs
     Inputs: 
     Returns: eggs - number of eggs the queen will lay 
     
     Description:
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
