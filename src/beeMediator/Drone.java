/**
File: Drone.java
Author: @author
Date: Nov 24, 2018

Description: 
 */
package beeMediator;

/**
Class:

Description:  Drone
 */
public class Drone extends Bee {
    
    public Drone(IQueen newMediator) {
        super(newMediator);
        
        System.out.println("German Drone signed up to fertilize the eggs");
    }

}
