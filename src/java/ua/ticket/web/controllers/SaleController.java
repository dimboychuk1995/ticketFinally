/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.ticket.web.controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import ua.ticket.web.beans.Place;
import ua.ticket.web.db.Database;

/**
 *
 * @author us9522
 */
@ManagedBean
@ApplicationScoped
@WebServlet(name = "SectorController", urlPatterns = {"/SectorController"})
public class SaleController extends HttpServlet{
    
    private ArrayList<Place> placeList = new ArrayList<Place>();
        
    
    private ArrayList<Place> getPlace(String str){
        Statement stmt = null;
        ResultSet rs = null;
        Connection conn = null;
        System.out.println(str);
        try {
            conn = Database.getConnection();

            stmt = conn.createStatement();
            rs = stmt.executeQuery(str);
            while (rs.next()) {
                Place place = new Place();
                place.setId(rs.getInt("id"));
                place.setRow(rs.getInt("row"));
                place.setNumber(rs.getInt("number"));
                place.setIdSector(rs.getInt("id_sector"));
                place.setStatus(rs.getInt("status"));
                place.setPIP(rs.getString("PIP"));
                
                placeList.add(place);
            }
            

        } catch (SQLException ex) {
            Logger.getLogger(SectorController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (stmt!=null) stmt.close();
                if (rs!=null)rs.close();
                if (conn!=null)conn.close();
                
            } catch (SQLException ex) {
                Logger.getLogger(SectorController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        

        return placeList;
    }
    
    public ArrayList<Place> getAllPlace(){
        if (!placeList.isEmpty()) {
            return placeList;
        } else {
            return getPlace("select * from ticket_on_game");
        }
    }
    
    public ArrayList<Place> getPlaceSectorA(){

            placeList.clear();

            for (int i_sector =1; i_sector <= 10; i_sector++){
            getPlace("select * from ticket_on_game"
                    + " where id_sector = " + i_sector);
            }
            return placeList;

    }
}
