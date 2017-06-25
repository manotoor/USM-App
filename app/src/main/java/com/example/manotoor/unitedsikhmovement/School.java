package com.example.manotoor.unitedsikhmovement;

import java.io.Serializable;

/**
 * Created by Mano Toor on 6/19/2017.
 * School.java
 *
 * This class holds the name of the school along with the image resource ids for the:
 * - School Picture
 * - Logo
 * - Taskbar
 * - Seal
 */

public class School implements Serializable{
    private String name;
    private String logo;
    private String acry;
    private String taskbar;
    private String seal;
    private int path;

    //CONSTRUCTOR
    School(){
        name = null;
        logo = null;
        taskbar = null;
        seal = null;
        acry = null;
        path = 0;
    }
    //OVERLOADED CONSTRUCTOR
    School(String name, String logo, String taskbar, String seal, int path){
        this.name = name;
        this.logo = logo;
        this.taskbar = taskbar;
        this.seal = seal;
        this.path = path;
    }

    //GETTERS
    public String getName(){
        return name;
    }
    public String getLogo(){
        return logo;
    }
    public String getTaskbar(){
        return taskbar;
    }
    public String getSeal(){
        return seal;
    }
    public int getPath(){
        return path;
    }
    public String getAcry(){return acry;}

    //SETTERS
    public void setName(String name){
        this.name = name;
    }
    public void setLogo(String logo){
        this.logo = logo;
    }
    public void setTaskbar(String taskbar){
        this.taskbar = taskbar;
    }
    public void setSeal(String seal){
        this.seal = seal;
    }
    public void setPath(int path){
        this.path = path;
    }
    public void setAcry(String acry){ this.acry = acry; }
}
