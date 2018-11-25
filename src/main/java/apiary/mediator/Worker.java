package main.java.apiary.mediator;

/**
File: Worker.java
Author: @author
Date: Nov 24, 2018

Description: Worker bee to lay eggs.
 */

/**
Class:

Description:  Worker bee is a female that can lay eggs.
 */
public class Worker extends Bee {
    
    /**
     * Method: Constructor
     * Inputs: mediator
     * Returns:
     * 
     *  <p>Description: will lay eggs.
     */
    public Worker(INature newMediator) {
        super(newMediator);
        
        System.out.println("Worker signed up to lay the eggs");
    }

}
