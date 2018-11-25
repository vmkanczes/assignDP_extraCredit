/**
File: Drone.java
Author: @author
Date: Nov 24, 2018

Description: 
 */
package main.java.apiary.mediator;

/**
Class:

Description:  Drone is a male bee is from an unfertilized egg but can fertilize eggs
 */
public class Drone extends Bee {
    
    public Drone(INature newMediator) {
        super(newMediator);
        
        System.out.println("Drone signed up to fertilize the eggs");
    }

}
