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

    private INature mediator;
    private int beeCode = 0;
    private BeeType type;

    public Bee(INature newMediator) {
        mediator = newMediator;
    }

    /**
    Method: layEggs
    Inputs: BeeType, eggs laid, code
    Returns: 
    
    Description: Notifies how many eggs have been laid.
    */
    public void layEggs(BeeType type, int eggs) {

        System.out.println("Type: " + type + " eggs laid: " + eggs);
        mediator.layEggs(type, eggs, this.beeCode);
    }
    
    /**
     Method: fertilizeEggs
     Inputs: BeeType, eggs to be fertilized, code
     Returns: 
     
     Description: Notifies how many eggs have been fertilized.
     */
    public void fertilizeEggs(BeeType type, int eggs, int code) {

        System.out.println("Type: " + type + " eggs fertilized: " + eggs + " code: " + code);

        mediator.fertilizeEggs(type, eggs, beeCode);
    }

    public void setCode(int code) {
        beeCode = code;
    }

    public void setType(BeeType beeType) {
        type = beeType;
    }

}
