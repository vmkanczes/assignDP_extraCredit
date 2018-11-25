/**
File: IMediator.java
Author: @author
Date: Nov 24, 2018

Description: 
 */
package beeMediator;

import builder.BeeType;

/**
Class: IMediator

Description:  Mediator interface
 */
public interface IQueen {

    public void layEggs(BeeType type, int numberOfEggs,  int code);
    public void fertilizeEggs(BeeType type, int eggs, int beeCode);
    public void addBee(Bee bee);
}
