
package ua.ticket.web.controllers;

import java.io.IOException;
import java.io.PrintWriter;
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

    public void showGames(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        Statement stmt = null;
        ResultSet rs = null;
        Connection conn = null;
       
        String valueParam = request.getParameter("allGame");
        String valueParam2 = request.getParameter("currentGame");
        String valueParam3 = request.getParameter("futureGame");
        
        String status1 = "showAllGame"; // all games
        String status2 = "showCurrentGame"; // current game
        String status3 = "showFutureGame"; // current game
        
        String moreCurrDate = "SELECT * FROM tickets.games "
                + "WHERE date >= curdate() "
                + "ORDER BY date";
        
        String currDate = "SELECT * FROM tickets.games "
                + "WHERE date = curdate()";
        String allTime = "SELECT * FROM tickets.games"
                        + " ORDER BY date";
        
        String sql = moreCurrDate;
        if (status1.equals(valueParam)){
            sql = allTime;
        }
        if(status2.equals(valueParam2)){
            sql = currDate;
        }
        if(status3.equals(valueParam3)){
            sql = moreCurrDate;
        }
        try{
 
            conn = Database.getConnection();
            stmt = conn.createStatement();
            rs   = stmt.executeQuery(sql);            
            
            gamesList.clear();
            while(rs.next()){
                GameOfTeam game = new GameOfTeam();
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
    public ArrayList<GameOfTeam> futureGame(){
        
        System.out.print(gamesList);
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

}
