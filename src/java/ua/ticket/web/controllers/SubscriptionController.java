/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.ticket.web.controllers;

/**
 *
 * @author us9522
 */
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
import ua.ticket.web.beans.Subscription;
import ua.ticket.web.db.Database;

/**
 *
 * @author us9522
 */
@ManagedBean
@ApplicationScoped
@WebServlet(name = "SubscriptionController", urlPatterns = {"/SubscriptionController"})
public class SubscriptionController extends HttpServlet{
        
    private ArrayList<Subscription> subscriptionsList = new ArrayList<Subscription>();

    private ArrayList<Subscription> getSubscription(String str) {
        
        Statement stmt = null;
        ResultSet rs = null;
        Connection conn = null;
        
        try {
            conn = Database.getConnection();

            stmt = conn.createStatement();
            rs = stmt.executeQuery(str);
            while (rs.next()) {
                Subscription subscription = new Subscription();
                subscription.setId(rs.getInt("id"));
                subscription.setPIP(rs.getString("PIP"));
                subscription.setSeason(rs.getString("season"));
                subscription.setSector(rs.getString("name"));
                subscription.setRow(rs.getInt("row"));
                subscription.setNumber(rs.getInt("number"));
                subscriptionsList.add(subscription);
            }

        } catch (SQLException ex) {
            Logger.getLogger(SubscriptionController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (stmt!=null) stmt.close();
                if (rs!=null)rs.close();
                if (conn!=null)conn.close();
                
            } catch (SQLException ex) {
                Logger.getLogger(SubscriptionController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return subscriptionsList;
    }

    public ArrayList<Subscription> getSubscriptionAll() {
        if (!subscriptionsList.isEmpty()) {
            return subscriptionsList;
        } else {
            return getSubscription("SELECT subscription.id, PIP, season, place.row, place.number, sector.name "
                                    +"FROM tickets.subscription "
                                    +"join tickets.place on "
                                    +"subscription.placeId = place.id "
                                    +"join sector on place.idSector = sector.id");
        }
    }
    
    public ArrayList<Subscription> getCountSubscription(){
        if (!subscriptionsList.isEmpty()) {
            return subscriptionsList;
        } else {
            return getSubscription("select count(1) from subscription ");
        }
    }
    
    protected void updateSubscription(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        
        String id = request.getParameter("id");
        String PIP = request.getParameter("PIP");
        String season = request.getParameter("season");
        String sector = request.getParameter("sector");
        String row = request.getParameter("row");
        String number = request.getParameter("number");
        
        System.out.println("method update");
        
        try(Connection conn = Database.getConnection();
            Statement stmt = conn.createStatement();
            ){
            
            String sql = "update tickets.subscription "
                    + "set PIP = '" + PIP
                    + "', season = '" + season
                    + "', placeId = ( "
                    + "select place.id  from place join sector on place.idSector = sector.id  "
                    + "where row =  " + row
                    + " and number =  " + number
                    + " and sector.name = '" + sector
                    + "') "
                    + " where id=" + id;
            
            System.out.println(sql);
            
            stmt.executeUpdate(sql);
            
            response.sendRedirect("pages/sub.jsp");
        }catch(SQLException ex){
            Logger.getLogger(SubscriptionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    protected void addSubscription(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String PIP = request.getParameter("PIP");
        String season = request.getParameter("season");
        String sector = request.getParameter("sector");
        String row = request.getParameter("row");
        String number = request.getParameter("number");
        ResultSet rs = null;

        System.out.println("method add");
        
        try(Connection conn = Database.getConnection();
            Statement stmt = conn.createStatement();
            ){
            
            String sql = "INSERT INTO tickets.subscription "
                    + "(`PIP`, `season`)"
                    + "VALUES"
                    + "('" + PIP 
                    + "','" + season
                    + "');";
            
            String sqlMax = "select max(id) as id from tickets.subscription";
            String id = "";

            stmt.executeUpdate(sql);
            
            rs = stmt.executeQuery(sqlMax);
            while(rs.next()){
                id = rs.getString("id");
            }
            rs.close();
            
            String sqlSec = "update tickets.subscription "
                    + "set placeId = ( "
                    + "select place.id  from place join sector on place.idSector = sector.id  "
                    + "where row =  " + row
                    + " and number =  " + number
                    + " and sector.name = '" + sector
                    + "') "
                    + "where id = " + id;
            
            
            stmt.executeUpdate(sqlSec);
            
            response.sendRedirect("pages/sub.jsp");
            
        }catch(SQLException ex){
            Logger.getLogger(SubscriptionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    protected void deleteSubscription(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String id = request.getParameter("id");

        System.out.println("method delete");
        
        try(Connection conn = Database.getConnection();
            Statement stmt = conn.createStatement();
            ){
            
            String sql = "delete from tickets.subscription "
                    + " where id=" + id;
            
            stmt.executeUpdate(sql);
            
            response.sendRedirect("pages/sub.jsp");
            
        }catch(SQLException ex){
            Logger.getLogger(SubscriptionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameterMap().size() == 6){
            updateSubscription(request, response);
        } else if(request.getParameterMap().size() == 1){
            deleteSubscription(request, response);   
        } else{
            addSubscription(request, response);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameterMap().size() == 6){
            updateSubscription(request, response);
        } else if(request.getParameterMap().size() == 1){
            deleteSubscription(request, response);   
        } else{
            addSubscription(request, response);
        }
    }
    
    
    
    
}

