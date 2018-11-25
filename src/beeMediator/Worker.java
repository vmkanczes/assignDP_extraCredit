/**
File: Worker.java
Author: @author
Date: Nov 24, 2018

Description: 
 */
package beeMediator;

/**
Class:

Description:  Worker bee is a female that can lay eggs 
 */
public class Worker extends Bee {
    
    public Worker(INature newMediator) {
        super(newMediator);
        
        System.out.println("Worker signed up to lay the eggs");
    }

}
