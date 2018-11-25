/**
File: Worker.java
Author: @author
Date: Nov 24, 2018

Description: 
 */
package beeMediator;

import beeAttributeDecorator.BeeRole;
import builder.BeeType;
import builder.RoomType;

/**
Class: Used to fertilize the eggs

Description: 
 */
public abstract class Bee {
    
    private IQueen mediator;
    private BeeType type;
    private int eggs = 0;
    private int beeCode = 0;
    
    public Bee(IQueen newMediator) {
        mediator = newMediator;
    }
    
    public void layEggs(BeeType type, int eggs) {
        
        mediator.layEggs(type, eggs, this.beeCode);
    }
    
public void fertilizeEggs(BeeType type, int eggs, int code) {
        
        mediator.fertilizeEggs(type, eggs, beeCode);
    }
    
public void setCode(int code) {
    beeCode = code;
}  

public void setType(BeeType type) {
    type = type;
} 

}
