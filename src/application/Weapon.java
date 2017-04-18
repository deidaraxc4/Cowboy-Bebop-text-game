package application;

import java.util.*;
import java.io.*;
/**
 * Write a description of class Weapon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Weapon
{
    // instance variables - replace the example below with your own
    private String description;
    private int minDamage;
    private int maxDamage;
    private Scanner reader;
    private File source;

    /**
     * Constructor for objects of class Weapon
     */
    public Weapon(String description, int minDamage, int maxDamage)
    {
        this.description = description;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
    }
    
    public int getMin() {
    	return minDamage;
    }
    
    public int getMax() {
    	return maxDamage;
    }
    
}