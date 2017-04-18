package src.application;

import java.util.*;
import java.io.*;
public class Weapon
{
    private String description;
    private int minDamage;
    private int maxDamage;
    private static ArrayList<Weapon> x = new ArrayList<Weapon>();

    /**
     * Constructor for objects of class Weapon
     */
    public Weapon(String description, int minDamage, int maxDamage)
    {
        this.description = description;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
    }
   
}