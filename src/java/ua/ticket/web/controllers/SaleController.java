/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.ticket.web.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    
    public ArrayList<Place> getPlaceSectorFutureGame() throws SQLException{ 
            
        ResultSet rs = null;
        String idFutureMatch = null;
        
        try(Connection conn = Database.getConnection();
            Statement stmt = conn.createStatement();
            ){
            
            String sql = ""
                    + "Select id "
                    + " from games "
                    + " where `date` >= current_date()"
                    + " order by `date` limit 1 ";
            
            
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                idFutureMatch = rs.getString("id");
            }
            rs.close();
        }catch(SQLException ex){
            Logger.getLogger(SubscriptionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        placeList.clear();
        for (int idSector = 1; idSector <= 10; idSector++){
        getPlace("select * from ticket_on_game"
                + " where id_sector = " + idSector
                + " and id_game = " + idFutureMatch);
        }
        return placeList;

    }
    
}
