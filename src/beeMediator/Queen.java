/**
File: Queen.java
Author: @author
Date: Nov 24, 2018

Description: 
 */
package beeMediator;

/**
Class:

Description:  Queen bee is a female that can lay eggs both fertilized and non fertilized
 */
public class Queen extends Bee {
    
    public Queen(INature newMediator) {
        super(newMediator);
        
        System.out.println("Queen signed up to lay the eggs");
    }

}
