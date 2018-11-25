/**
File: INature.java
Author: @author
Date: Nov 24, 2018

Description: 
 */
package main.java.apiary.mediator;

import main.java.apiary.builder.BeeType;

/**
Class: INature

Description:  Mediator interface manages the bee egg fertilization.
 */
public interface INature {

    public void layEggs(BeeType type, int numberOfEggs,  int code);
    public void fertilizeEggs(BeeType type, int eggs, int beeCode);
    public void addBee(Bee bee);
}
