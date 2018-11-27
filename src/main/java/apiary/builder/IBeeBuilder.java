/**
File: IBeeBuilder.java
Author: vkanczes
Date: Nov 26, 2018

Description: interface to build the bee with type (species) and role (queen, worker, etc).
 */
package main.java.apiary.builder;

import main.java.apiary.decorator.BeeRole;
import main.java.apiary.decorator.GermanWorkerBee;

/**
Class: IBeeBuilder

Description: interface to build the bee with type (species) and role (queen, worker, etc).
 */
public interface IBeeBuilder {
    
    Bee buildBee();

    /**
     Method:
     Inputs: 
     Returns: 
     
     Description: 
     */
     Bee getBee();

    /**
     Method:
     Inputs: 
     Returns: 
     
     Description: 
     */
    IBeeBuilder setBee(GermanWorkerBee bee);

    
}
