package main.java.apiary.mediator;

/**
File: EggMediatorImpl.java
Author: @author
Date: Nov 24, 2018

Description:  Mediator implementation for the eggs to know egg status
 */

import java.util.ArrayList;

import main.java.apiary.builder.BeeType;

/**
 * Class: EggMediatorImpl
 * 
 * Description: Mediator to keep track of the eggs and know what is happening.
 */
public class EggMediatorImpl implements IEggMediator {

    private ArrayList<Bee> bees;
    private ArrayList<EggCare> eggsThatNeedToBeFed;
    private ArrayList<EggCare> happyEggs;
    private ArrayList<EggCare> eggsThatCanBeFed;
    private ArrayList<EggCare> eggsEaten;

    /**
     * Constructor.
     */
    public EggMediatorImpl() {

        bees = new ArrayList<Bee>();
        eggsThatNeedToBeFed = new ArrayList<EggCare>();
        happyEggs = new ArrayList<EggCare>();
        eggsThatCanBeFed = new ArrayList<EggCare>();
        eggsEaten = new ArrayList<EggCare>();
    }

    /**
     * Method: addBee Inputs: Bee Returns:
     * 
     * <p>
     * Description: updates the new bee.
     */
    public void addBee(Bee newBee) {

        bees.add(newBee);

    }

    /**
     * Method: laidEggs Inputs: Bee type, eggs laid, code Returns:
     * 
     * 
     * <p>
     * Description: Updates the eggs to know there more to be fed.
     */
    public void laidEggs(BeeType type, int eggs) {

        System.out.println("Laying eggs: " + eggs + " of type " + type);


        boolean eggFed = false;

        // check if there are some bees to feed the egg
        for (EggCare egg : eggsThatCanBeFed) {

            // check that they are the right type and have exactly the same amount of food
            if ((egg.getType() == type) && (egg.getEggs() == eggs)) {

                // if the bee fed the egg then it can't feed another egg
                eggsThatCanBeFed.remove(egg);
                happyEggs.add(egg);


                System.out.println("Fed the egg");

                // egg was fed by the worker bee
                eggFed = true;
                break;
            }

          
        }

        // no worker bee to feed the egg
        if (!eggFed) {

            System.out.println("Eggs still needs to be fed");

            // notify that the egg still needs to be fed
            EggCare newRequest = new EggCare(type, eggs);

            // egg wasn't feed so asking again..
            eggsThatNeedToBeFed.add(newRequest);

        }
    }

    /**
     * Method: feedEggs Inputs: bee type, eggs to be fed
     * 
     * <p>
     * Description: queen will request to have the eggs fed.
     */
    public void feedEggs(BeeType type, int eggs) {

        boolean eggFed = false;
        
        System.out.println("Feeding eggs: " + eggs + " of type " + type);


        for (EggCare egg : eggsThatNeedToBeFed) {

            if ((egg.getType() == type) && (egg.getEggs() == eggs)) {

                eggsThatNeedToBeFed.remove(egg);
                happyEggs.add(egg);
                
                System.out.println("Fed the egg");

                eggFed = true;
                break;
            }
            
        }

        if (!eggFed) {

            System.out.println("Didn't feed the eggs..");

            EggCare newRequest = new EggCare(type, eggs);

            eggsThatCanBeFed.add(newRequest);

        }
    }

    /**
     * Method: eatEggs Inputs: bee type, eggs that may be eaten
     * 
     * <p>
     * Description: queen may eat the eggs for worker bee.
     */
    public void eatEggs(BeeType type, int eggs) {

        boolean eggEaten = false;
        
        System.out.println("Eating eggs: " + eggs + " of type " + type);


        for (EggCare egg : eggsThatNeedToBeFed) {

            if ((egg.getType() == type) && (egg.getEggs() == eggs)) {

                System.out.println("Eggs eaten: " + eggs + " of type " + type);

                eggsThatNeedToBeFed.remove(egg);
                eggsEaten.add(egg);


                eggEaten = true;
                break;
            }
          
        }

        if (!eggEaten) {

            System.out.println("Yay! Egg not eaten: " + eggs + " of type " + type);

            EggCare newRequest = new EggCare(type, eggs);

            eggsThatNeedToBeFed.add(newRequest);

        }

    }

    /**
     * Method: getEggStatus Inputs: Returns:
     * 
     * <p>
     * Description: Gets the status of how many eggs were laid, fed and eaten.
     */
    public void getEggStatus() {
        System.out.println("\nEGG STATUS:  ");

        for (EggCare egg : eggsThatNeedToBeFed) {

            System.out.println("Hungry Egg " + egg.getEggs() + " of type " + egg.getType());
        }

        System.out.println("Happy Egg");

        for (EggCare egg : happyEggs) {

            System.out.println("Happy Eggs " + egg.getEggs() + " of type " + egg.getType());
        }
        
        System.out.println("Eggs that can be fed:");

        for (EggCare egg : eggsThatCanBeFed) {

            System.out.println("Eggs that can be fed " + egg.getEggs() + " of type " + egg.getType());
        }

        System.out.println("Eggs Eaten");

        for (EggCare egg : eggsEaten) {

            System.out.println("Eggs eaten " + egg.getEggs() + " of type " + egg.getType());
        }
        System.out.println("");

        
    }

}
