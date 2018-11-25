/**
File: GermanWorker.java
Author: @author
Date: Nov 24, 2018

Description: 
 */
package beeMediator;

/**
Class:

Description:
 */
public class Worker extends Bee {
    
    public Worker(IQueen newMediator) {
        super(newMediator);
        
        System.out.println("Worker signed up to fertilize the eggs");
    }

}
