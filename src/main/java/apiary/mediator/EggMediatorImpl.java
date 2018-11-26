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
 * <p>Description: Keeps track of the eggs and know what is happening.
 */
public class EggMediatorImpl implements IEggMediator {

    private ArrayList<Bee> bees;
    private ArrayList<EggCare> hungryEggs;
    private ArrayList<EggCare> fullEggs;
    private ArrayList<EggCare> pollinatedBees;
    private ArrayList<EggCare> deadEggs;

    /**
     * Constructor.
     */
    public EggMediatorImpl() {

        bees = new ArrayList<Bee>();
        hungryEggs = new ArrayList<EggCare>();
        fullEggs = new ArrayList<EggCare>();
        pollinatedBees = new ArrayList<EggCare>();
        deadEggs = new ArrayList<EggCare>();
    }

    /**
     * Method: addBee 
     * Inputs: Bee 
     * Returns:
     * 
     * <p>Description: updates the new bee.
     * @return 
     */
    public void addBee(Bee newBee) {

        bees.add(newBee);

    }

    /**
     * Method: laidEggs 
     * Inputs: Bee type, eggs laid and hungry 
     * Returns:
     * 
     * <p>Description: Updates the eggs to know there more to be fed.
     */
    public boolean laidEggs(BeeType type, int eggs) {

        boolean eggFed = false;

        // check if there are some bees to feed the egg
        for (EggCare egg : pollinatedBees) {

            // check that they are the right type and have exactly the same amount of food
            if ((egg.getType() == type) && (egg.getEggs() == eggs)) {

                // if the bee fed the egg then it can't feed another egg
                pollinatedBees.remove(egg);
                fullEggs.add(egg);

                // egg was fed by the worker bee
                eggFed = true;
                break;
            }          
        }

        // no worker bee to feed the egg
        if (!eggFed) {

            // notify that the egg still needs to be fed
            EggCare newRequest = new EggCare(type, eggs);

            // egg wasn't feed so asking again..
            hungryEggs.add(newRequest);

        }
        return eggFed;
    }

    /**
     * Method: feedEggs 
     * Inputs: bee type, bees have pollen to feed the eggs
     * 
     * <p>Description: queen will request to have the eggs fed.
     */
    public boolean feedEggs(BeeType type, int eggs) {

        boolean eggFed = false;

        for (EggCare egg : hungryEggs) {

            if ((egg.getType() == type) && (egg.getEggs() == eggs)) {

                // if egg was fed then no longer hungry so full
                hungryEggs.remove(egg);
                fullEggs.add(egg);
                
                eggFed = true;
                break;
            }
            
        }

        if (!eggFed) {

            EggCare newRequest = new EggCare(type, eggs);
            pollinatedBees.add(newRequest);
        }
        return eggFed;
    }

    /**
     * Method: eatEggs 
     * Inputs: bee type, eggs that may be eaten
     * 
     * <p>Description: queen may eat the eggs of worker bee.
     */
    public boolean eatEggs(BeeType type, int eggs) {

        boolean eggEaten = false;

        for (EggCare egg : hungryEggs) {

            if ((egg.getType() == type) && (egg.getEggs() == eggs)) {

                hungryEggs.remove(egg);
                deadEggs.add(egg);

                eggEaten = true;
                break;
            }
          
        }

        if (!eggEaten) {
            System.out.println("Queen didn't eat the egg");
        }
        
        return eggEaten;

    }

    /**
     * Method: getEggStatus 
     * Inputs: 
     * Returns:
     * 
     * <p>Description: Gets the status of how many eggs are hungry, full, or killed.
     */
    public String getEggStatus() {
        
        StringBuffer buf = new StringBuffer();
        
        System.out.println("\nEGG STATUS:  ");
        
        

        for (EggCare egg : hungryEggs) {

            
            System.out.println("Hungry eggs " + egg.getEggs() + " of type " + egg.getType());
            buf.append(" Hungry eggs " + egg.getEggs() + " of type " + egg.getType());
            
        }

        for (EggCare egg : fullEggs) {

            System.out.println("Full eggs " + egg.getEggs() + " of type " + egg.getType());
            buf.append(" Full eggs " + egg.getEggs() + " of type " + egg.getType());

        }
        
        for (EggCare egg : pollinatedBees) {

            System.out.println("Pollinated bees " + egg.getEggs() + " of type " + egg.getType());
            buf.append(" Pollinated bees " + egg.getEggs() + " of type " + egg.getType());

        }

        for (EggCare egg : deadEggs) {

            System.out.println("Eggs killed " + egg.getEggs() + " of type " + egg.getType());
            buf.append(" Eggs killed " + egg.getEggs() + " of type " + egg.getType());

        }
        System.out.println("");
        
        String eggStatus = buf.toString(); 
        
        System.out.println("XX: " + eggStatus);
        
        return eggStatus;
        
    }

}
