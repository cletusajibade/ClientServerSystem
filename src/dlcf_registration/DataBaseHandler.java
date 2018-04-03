/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dlcf_registration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ajibade
 */
public class DataBaseHandler
{
    public static  PreparedStatement pst ;
    public static  Connection con;
    
    public DataBaseHandler()
    {
        pst = null;
        con = null;
    }
    public static void loadDriver()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            System.out.println("Driver Loaded");
        }
        catch(Exception ex)
        {
            System.out.println("Error "+ ex.getMessage());
        }
    }
    public static void connectToDatabase(String dbName,String user,String pass)
    {
        try
        {
           con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbName, user, pass);
           System.out.println("Connected to database: "+ dbName);
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DataBaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public  static void createDataBase(String DBName)
    {
        connectToDatabase("mysql","root","");
        String query = "CREATE DATABASE IF NOT EXISTS "+DBName;
        try
        {
            pst = con.prepareStatement(query);
            int resp =  pst.executeUpdate();
            if(resp != -1)
            {
                System.out.println("Database \""+DBName+"\" created ");
            }

            pst.close();
            con.close();
        } 
        catch (SQLException ex)
        {
            System.out.println("Error "+ex.getMessage());
        }
    }
    public static void createTable(String tbName,String dbName)
    {
        String query = "CREATE TABLE IF NOT EXISTS "+ tbName+" (id INTEGER NOT NULL," +
                "sname VARCHAR( 30 ) NULL ," +
                "phone VARCHAR( 20 ) NULL ," +
                "email VARCHAR( 30 ) NULL ," +
                "dept VARCHAR( 30 )  NULL ," +
                "level VARCHAR( 20 ) NULL ," +
                "address VARCHAR( 60 ) NULL ," +
                "room VARCHAR( 20 ) NULL ," +
                "denom VARCHAR( 20 ) NULL ," +
                "sex VARCHAR( 10 ) NULL ," +
                "status VARCHAR( 50 ) NULL ," +
                "town VARCHAR( 60 ) NULL ," +
                "institution VARCHAR( 60 ) NULL ," +
                "PRIMARY KEY ( id )) ENGINE = InnoDB ";

        connectToDatabase(dbName,"root","");
        try
        {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbName, "root", "");
            pst = con.prepareStatement(query);
            int resp =  pst.executeUpdate();
            if(resp != -1)
            {
                System.out.println("Table \""+tbName+"\" created ");
            }

            pst.close();
            con.close();
        }
        catch (SQLException ex)
        {
            System.out.println("Error "+ex.getMessage());
        }
    }
}