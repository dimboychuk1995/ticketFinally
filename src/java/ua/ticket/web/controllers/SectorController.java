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
import ua.ticket.web.beans.Sector;
import ua.ticket.web.db.Database;

/**
 *
 * @author us9522
 */
@ManagedBean
@ApplicationScoped
@WebServlet(name = "SectorController", urlPatterns = {"/SectorController"})
public class SectorController extends HttpServlet{
    
    private ArrayList<Sector> sectorList = new ArrayList<Sector>();

    private ArrayList<Sector> getSector(String str) {
        
        Statement stmt = null;
        ResultSet rs = null;
        Connection conn = null;
        
        try {
            conn = Database.getConnection();

            stmt = conn.createStatement();
            rs = stmt.executeQuery(str);
            while (rs.next()) {
                Sector sector = new Sector();
                sector.setId(rs.getInt("id"));
                sector.setName(rs.getString("name"));
                sector.setPrice(rs.getInt("price"));
                
                sectorList.add(sector);
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

        return sectorList;
    }
    
    public ArrayList<Sector> getSectorAll() {
        if (!sectorList.isEmpty()) {
            return sectorList;
        } else {
            return getSector("select * from sector");
        }
    }
    
    protected void updateSector(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        
        try(Connection conn = Database.getConnection();
            Statement stmt = conn.createStatement();
            ){
            
            String sql = "update tickets.sector "
                    + "set id = '" + id
                    + "', name = '" + name
                    + "', price = " + price
                    + " where id=" + id;
            
            System.out.println(sql);
            
            stmt.executeUpdate(sql);
            
            response.sendRedirect("pages/sectors.jsp");
        }catch(SQLException ex){
            Logger.getLogger(SubscriptionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            updateSector(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            updateSector(request, response);
    }
    
    
}