package application;

import java.util.*;

public class Damage
{
    // instance variables - replace the example below with your own
    private int damage;
    private Math randomGen;
    
    public Damage()
    {
        
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public static int rollDamage(int minDamage, int maxDamage)
    {
        double doubMinDamage = (double)minDamage;
        double doubMaxDamage = (double)maxDamage;
        
        int range = (int)(doubMaxDamage - doubMinDamage) + 1;     
        int damage = (int)(Math.random() * range) + minDamage;
        return damage;
    }
}