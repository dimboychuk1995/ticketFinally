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
import ua.ticket.web.beans.GameOfTeam;
import ua.ticket.web.db.Database;

/**
 *
 * @author us9546
 * 07.07.2016
 */
@ManagedBean
@ApplicationScoped
@WebServlet(name = "GamesController", urlPatterns = {"/GamesController"})
public class GamesController extends HttpServlet {
    
    private static ArrayList<GameOfTeam> gamesList = new ArrayList<GameOfTeam>();
    
    Statement stmt = null;
    ResultSet rs = null;
    Connection conn = null;

    public void showGames(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 

       
        String[] valueParam = new String[0];
        String insertParam  = "";
        String updateParam  = "";
        String editGames    = "";
        String deleteGame  = "";
        
        if(request.getParameterValues("sortGames") != null){
            valueParam = request.getParameterValues("sortGames");
        }
        if (request.getParameter("insertGame") != null){
            insertParam = request.getParameter("insertGame");
        }
        if (request.getParameter("updateGame") != null){
            updateParam = request.getParameter("updateGame");
        }
        if (request.getParameter("editGames") != null){
            editGames = request.getParameter("editGames");
        }
        if (request.getParameter("deleteGame") != null){
            deleteGame = request.getParameter("deleteGame");
        }
        
 
        String status1 = "showAllGame"; // all games
        String status2 = "showCurrentGame"; // current game
        String status3 = "showFutureGame"; // future game
        String status4 = "insertGame"; // insert games to db
        String status5 = "updateGame";
        String status6 = "editGames"; // edit games
        String status7 = "deleteGame"; // edit games
        
        
        String moreCurrDate = "SELECT * FROM tickets.games "
                + "WHERE date >= curdate() "
                + "ORDER BY date";
        
        String currDate = "SELECT * FROM tickets.games "
                + "WHERE date = curdate()";
        
        String allTime = "SELECT * FROM tickets.games"
                        + " ORDER BY date";

        String sql = moreCurrDate;//defoult

        if ( valueParam.length > 0){
            for (int i = 0; i < valueParam.length; i++){  
                if (status1.equals(valueParam[i])){
                    sql = allTime;
                    }
                if(status2.equals(valueParam[i])){
                    sql = currDate;
                }
                if(status3.equals(valueParam[i])){
                    sql = moreCurrDate;
                }
            }
        }
        
        if (status4.equals(insertParam)){
            insertGame (request,response);
        }
        if (status5.equals(updateParam)){
            updateGame(request, response);
        }
        if (status6.equals(editGames)){
            sql = moreCurrDate;
        }
        if (status7.equals(deleteGame)){
            deleteGame(request, response);
        }
        try{
            conn = Database.getConnection();
            stmt = conn.createStatement();
            rs   = stmt.executeQuery(sql);     
            
            gamesList.clear();
            while(rs.next()){
                GameOfTeam game = new GameOfTeam();
                game.setId(rs.getInt("id"));
                game.setDateGame(rs.getString("date"));
                game.setTimeGame(rs.getString("time"));
                game.setNameTeam1(rs.getString("team1"));
                game.setNameTeam2(rs.getString("team2"));
                game.setPlaceGame(rs.getString("place"));
                gamesList.add(game);
            }      
            response.sendRedirect("pages/GamesPage.jsp");
    
        }catch(Exception ex){
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
    }
    public ArrayList<GameOfTeam> getListGame(){
        return gamesList;
    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        showGames(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        showGames(request, response);
    }
    
       public  ArrayList<GameOfTeam>  showFutureGame()
            throws ServletException, IOException{
        try(Connection conn = Database.getConnection();
            Statement stmt = conn.createStatement();
            ){
      
            String moreCurrDate = "SELECT * FROM tickets.games "
                + "WHERE date >= curdate() "
                + "ORDER BY date";

            rs = stmt.executeQuery(moreCurrDate);
            
            gamesList.clear();
            while(rs.next()){
                GameOfTeam game = new GameOfTeam();
                game.setId(rs.getInt("id"));
                game.setDateGame(rs.getString("date"));
                game.setTimeGame(rs.getString("time"));
                game.setNameTeam1(rs.getString("team1"));
                game.setNameTeam2(rs.getString("team2"));
                game.setPlaceGame(rs.getString("place"));
                gamesList.add(game);
            } 
        }catch(SQLException ex){
            try {
                rs.close();
            } catch (SQLException ex1) {
                Logger.getLogger(GamesController.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(SubscriptionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return getListGame();
    } 
    
    protected void deleteGame(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        try(Connection conn = Database.getConnection();
            Statement stmt = conn.createStatement();
            ){
            
            String id = request.getParameter("id");
            System.out.println(id);

            String deleteGame = "DELETE FROM tickets.games "
                        + "WHERE " 
                        + "id = " + id; 

            stmt.executeUpdate(deleteGame);
                       
        }catch(SQLException ex){
            Logger.getLogger(SubscriptionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        super.service(req, resp); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    protected void updateGame(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        try(Connection conn = Database.getConnection();
            Statement stmt = conn.createStatement();
            ){
            
            String id = request.getParameter("id");
            System.out.println(id);
            String time   = request.getParameter("time");
            System.out.println(time);
            String date   = request.getParameter("date");
            System.out.println(date);
            String team1  = request.getParameter("owner");
            System.out.println(team1);
            String team2  = request.getParameter("guest"); 
            System.out.println(team2);
            String place = request.getParameter("place");
            System.out.println(place);
            
            
                String sql = "UPDATE games "
                        + "set "
                        + "time = '" + time
                        + "', date = '" + date
                        + "', team1 = '" + team1
                        + "', team2 = '" + team2
                        + "', place = '" + place
                        + "' where id = " + id;

            System.out.println(sql);
            stmt.executeUpdate(sql);
            
        }catch(SQLException ex){
            System.out.println("Запит не виконався");
            Logger.getLogger(SubscriptionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    protected void insertGame(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String time   = request.getParameter("time");
        //System.out.println(time);
        String date   = request.getParameter("date");
        //System.out.println(date);
        String team1  = request.getParameter("owner");
        System.out.println(request.getParameter("owner"));
        String team2  = request.getParameter("guest"); 
        //System.out.println(team2);
        String place = request.getParameter("place");
        //System.out.println(place);
        
        try(Connection conn = Database.getConnection();
            Statement stmt = conn.createStatement();
            ){
            
                String insertGame = "INSERT INTO tickets.games"
                    + "(team1,team2,date,time,place)"
                    + " VALUES"
                    + "('"  +  team1
                    + "','" +  team2
                    + "','" +  date
                    + "','" +  time
                    + "','" +  place
                    + "')";
            stmt.executeUpdate(insertGame);
            
                String insertPlacesToMatch = "INSERT into ticket_on_game"
                    + "(id_game,row,number,id_sector,status)"
                    + "SELECT (SELECT id FROM games ORDER BY id DESC LIMIT 1),"
                    + "row, number, idSector,0 "
                    + " from place"; 
                
                stmt.executeUpdate(insertPlacesToMatch);
           
                String updateSubscripInMatch = "update ticket_on_game"
                    + " join place on  ticket_on_game.row = place.row"
                    + " and ticket_on_game.number = place.number"
                    + " and ticket_on_game.id_sector = place.idSector"
                    + " join subscription on  place.id = subscription.placeId"
                    + " set ticket_on_game.status = 2, ticket_on_game.PIP = subscription.PIP";
                
                stmt.executeUpdate(updateSubscripInMatch);
            
        }catch(SQLException ex){
            Logger.getLogger(SubscriptionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    

}