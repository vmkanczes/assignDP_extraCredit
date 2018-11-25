package main.java.apiary.mediator;

/**
File: Queen.java
Author: @author
Date: Nov 24, 2018

Description: Queen bee who can lay eggs.
 */

/**
Class:

Description:  Queen bee is a female that can lay eggs both fertilized and non fertilized.
 */
public class Queen extends Bee {
    
    /**
     * Method: Constructor
     * Inputs: mediator
     * Returns:
     * 
     *  <p>Description: will lay eggs.
     */
    public Queen(INature newMediator) {
        super(newMediator);
        
        System.out.println("Queen signed up to lay the eggs");
    }

}
