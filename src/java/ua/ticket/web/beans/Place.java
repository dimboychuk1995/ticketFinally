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
    
    public Place(){
        
    }
    
    public Place(int id, int row, int number, int idSector){
        this.id = id;
        this.row = row;
        this.number = number;
        this.idSector = idSector;
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
}
