package main.java.apiary.builder;

import main.java.apiary.decorator.BeeRole;

public class Bee {

    private BeeType type;
    private BeeRole role;

    public BeeType getType() {
        return type;
    }
    
    public BeeRole getRole() {
        return role;
    }

    public void setType(BeeType beeType) {
        this.type = beeType;
    }
    
    public void setRole(BeeRole beeRole) {
        this.role = beeRole;
    }
    
    @Override public String toString() {
        
        String bees = "";
        StringBuffer buf = new StringBuffer();
        buf.append("Bee type: " + getType());
        buf.append("Bee role: " + getType());
        bees = buf.toString();
        return bees;
    }

    /**
     Method:
     Inputs: 
     Returns: 
     
     Description: 
     */
    public void setBee() {
        // TODO Auto-generated method stub
        
    }
    
}
