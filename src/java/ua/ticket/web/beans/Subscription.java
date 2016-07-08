/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.ticket.web.beans;

/**
 *
 * @author us9522
 */

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author us9522
 */
@ManagedBean
@SessionScoped
public class Subscription {
    public Subscription(){
        
    }
    
    private int id;
    private String PIP;
    private String season;
    private int placeId;
    private String aPlace;
    
    public Subscription(int id, String PIP, String season, int placeId){
        this.id = id;
        this.PIP = PIP;
        this.season = season;
        this.placeId = placeId;
    }
    
    public Subscription(int id, String PIP, String season, String aPlace){
        this.id = id;
        this.PIP = PIP;
        this.season = season;
        this.aPlace = aPlace;
    }
    
    public Integer getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getPIP(){
        return PIP;
    }
    
    public void setPIP(String PIP){
        this.PIP = PIP;
    }
    
    public String getSeason(){
        return season;
    }
    
    public void setSeason(String season){
        this.season = season;
    }
    
    public int getPlaceId(){
        return placeId;
    }
    
    public void setPlaceId(int placeId){
        this.placeId = placeId;
    }
    
    public String getAPlace(){
        return aPlace;
    }
    
    public void setAPlace(String aPlace){
        this.aPlace = aPlace;
    }
}
