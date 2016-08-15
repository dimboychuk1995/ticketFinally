/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.ticket.web.controllers;

import static com.sun.faces.util.CollectionsUtils.map;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static jdk.nashorn.internal.objects.NativeArray.map;
import ua.ticket.web.beans.GameOfTeam;
import ua.ticket.web.beans.Place;
import ua.ticket.web.db.Database;
/**
 *
 * @author us9522
 */
@ManagedBean
@ApplicationScoped
@WebServlet(name = "SaleController", urlPatterns = {"/SaleController"})
public class SaleController extends HttpServlet{
    
    private static int idRow;
    static int idGame;
    static public  ArrayList<Place> placeList = new ArrayList<Place>();
    static public  Set<Integer> sectorList = new LinkedHashSet<Integer>();
    static public  Set<Integer> rowList = new LinkedHashSet<Integer>();

    public void setIdRow(int idRow){
    this.idRow = idRow;
    }
    
    public int getIdGame(){
        return idGame;
    }

    protected void showPlaces(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String[] valueParamsGames = new String[0];
        String orderPlace = "";
        
        
        
        if (request.getParameterValues("selectGame")!= null){
            valueParamsGames = request.getParameterValues("selectGame");
        }
        
        if (request.getParameter("orderPlace") != null){
            orderPlace = request.getParameter("orderPlace");
        }
        
        String status2 = "orderPlace";
        if (status2.equals(orderPlace)){
            updatePlace(request,response);
            
        }

        if (valueParamsGames.length > 0){
            for (int i = 0; i < valueParamsGames.length; i++){
                idGame = Integer.parseInt(valueParamsGames[i]);
            }  
        }
        
        int size = request.getParameterMap().size();
        if (size == 1){
            updatePlaceL(request, response);
        }
        
        try {
            getPlaceDB();
            response.sendRedirect("pages/sale.jsp");
        } catch (SQLException ex) {
            Logger.getLogger(SaleController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void getPlace(String str){
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
    }  
    public ArrayList<Place> getAllPlace(){
             placeList.size();
             return placeList;
    }
    
    public void getPlaceDB() throws SQLException{ 
         placeList.clear();
        for (int idSector = 1; idSector <= 10; idSector++){      
        getPlace("select * from ticket_on_game"
                + " where id_sector = " + idSector
                + " and id_game = " + idGame);
        }
    }
    
    
    public Set<Integer> getListSector(){
        for (int i = 0; i< placeList.size(); i++){
            sectorList.add(placeList.get(i).getIdSector());
        }
        return sectorList;
    }
    
    public Set<Integer> getListRows(int idSector){
            getRows("select * from ticket_on_game"
                + " where id_sector = " + idSector
                + " and id_game = " + idGame);    
        return rowList; 
    }
    
    private void getRows(String str){
        Statement stmt = null;
        ResultSet rs = null;
        Connection conn = null;
        System.out.println(str);
        try {
            conn = Database.getConnection();

            stmt = conn.createStatement();
            rs = stmt.executeQuery(str);
            while (rs.next()) {
                rowList.add(rs.getInt("row"));
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
    }
     
    protected void updatePlace(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        try(Connection conn = Database.getConnection();
            Statement stmt = conn.createStatement();
            ){
            
            String status  = request.getParameter("status");
            System.out.println(status);
            int statusTicket = 0;
            if (status.equals("Free")){
                statusTicket = 0;
            }
            if (status.equals("Busy")){
                statusTicket = 1;
            }
            if (status.equals("Booked")){
                statusTicket = 2;
            }
            
            String id = request.getParameter("id");
            System.out.println(id);
            String row   = request.getParameter("row");
            System.out.println(row);
            String number   = request.getParameter("number");
            System.out.println(number);
            String id_sector  = request.getParameter("id_sector");
            System.out.println(id_sector);
            //String status  = request.getParameter("status"); 
            System.out.println(statusTicket);
            String pip = request.getParameter("PIP");
            System.out.println(pip);
            
                String orderGame = "UPDATE tickets.ticket_on_game"
                        + " set status = '" + statusTicket
                        + "',PIP = '" + pip
                        + "' where id = " + id;
                System.out.println(orderGame);
            stmt.executeUpdate(orderGame);
            
        }catch(SQLException ex){
            Logger.getLogger(SubscriptionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    protected void updatePlaceL(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        try(Connection conn = Database.getConnection();
            Statement stmt = conn.createStatement();
            ){
            
            String pip = request.getParameter("PIP");
            System.out.println(pip);
            
                String SQL = "insert into tickets.ticket_on_game "
                        + " (id_game, id_sector, PIP, status) "
                        + " values(" + idGame + ", " + 11 + "," + "'" + pip + "', " + 1 
                        + ") ";
                System.out.println(SQL);
            stmt.executeUpdate(SQL);
            
        }catch(SQLException ex){
            Logger.getLogger(SubscriptionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    public String getNameTeams(){
        String result = "";
        try(Connection conn = Database.getConnection();
            Statement stmt = conn.createStatement();
            ){
            ResultSet rs = null;

            String getTeams = "SELECT team1,team2 FROM tickets.games "
                + "WHERE id = " + getIdGame();
            rs = stmt.executeQuery(getTeams);
            while(rs.next()){
                String team1 = rs.getString("team1");
                String team2 = rs.getString("team2");
                result = team1 + " - " + team2;
            } 
            return result;
        }catch(Exception ex){  
            Logger.getLogger(SubscriptionController.class.getName()).log(Level.SEVERE, null, ex);
        }    
        return result;
    }
    
    public String getNameSector(int idSector){
        String result = "";
        try(Connection conn = Database.getConnection();
            Statement stmt = conn.createStatement();
            ){
            ResultSet rs = null;
            

            String getSector = "SELECT tickets.sector.name "
                              + "FROM tickets.sector "
                              + "join tickets.ticket_on_game "
                              + "on tickets.sector.id = " + idSector;
            
            rs = stmt.executeQuery(getSector);
            while(rs.next()){
                result = rs.getString("name");
            } 
            return result;
        }catch(Exception ex){  
            Logger.getLogger(SubscriptionController.class.getName()).log(Level.SEVERE, null, ex);
        }    
        return result;
    } 
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        showPlaces(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        showPlaces(request, response);
    }
}
