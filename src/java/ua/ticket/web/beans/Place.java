/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.ticket.web.beans;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author us9522
 */
@ManagedBean
@ApplicationScoped
@WebServlet(name = "Place", urlPatterns = {"/Place"})
public class Place {
    
    private int id;
    private int row;
    private int number;
    private int idSector;
    private String PIP;
    private int status;
    
    public Place(){
        
    }
    
    public Place(int id, int row, int number, int idSector, String PIP, int status){
        this.id = id;
        this.row = row;
        this.number = number;
        this.idSector = idSector;
        this.PIP = PIP;
        this.status = status;
        
    }
    
    public int getId(){
        return id;
    }
    
    public int getRow(){
        return row;
    }
    
    public int getNumber(){
        return number;
    }
    
    public int getIdSector(){
        return idSector;
    }
    
    public String getPIP(){
        return PIP;
    }
    
    public int getStatus(){
        return status;
    }
    
    public void setId(int id){
        this.id = id; 
    }
    
    public void setRow(int row){
        this.row = row; 
    }
    
    public void setNumber(int number){
        this.number = number; 
    }
    
    public void setIdSector(int idSector){
        this.idSector = this.idSector; 
    }
    
    public void setPIP(String PIP){
        this.PIP = PIP;
    }
    
    public void setStatus(int status){
        this.status = status;
    }
}
