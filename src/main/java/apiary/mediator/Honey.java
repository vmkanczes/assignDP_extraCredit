/**
File: Honey.java
Author: @author
Date: Nov 24, 2018

Description: 
 */
package beeMediator;

/**
Class:

Description:  Male bees are created from unfertilized eggs but can fertilize eggs
 */
public class Honey extends Bee {
    
    public Honey(INature newMediator) {
        super(newMediator);
        
        System.out.println("Honey bee signed up to fertilize the eggs");
    }

}
