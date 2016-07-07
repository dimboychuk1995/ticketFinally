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
import java.util.Enumeration;
import java.util.Map;
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
                subscription.setPlaceId(rs.getInt("placeId"));
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
            return getSubscription("select * from subscription");
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
        String placeId = request.getParameter("placeId");
        
        String[] v = request.getParameterValues("id");
        for(String s : v){
            System.out.println(s);
        }
        
       
        try(Connection conn = Database.getConnection();
            Statement stmt = conn.createStatement();
            ){
            
            String sql = "update tickets.subscription "
                    + "set PIP = '" + PIP
                    + "', season = " + season
                    + ", placeId = " + placeId
                    + " where id=" + id;
            
            
            System.out.println(sql);
            
            stmt.executeUpdate(sql);
            
            
            
            response.sendRedirect("pages/sub.jsp");
            
            
        }catch(SQLException ex){
            Logger.getLogger(SubscriptionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        updateSubscription(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        updateSubscription(request, response);
    }
    
}

