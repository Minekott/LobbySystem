package me.letshacks.lobby.mysql;

import me.letshacks.lobby.main.Main;
import org.bukkit.configuration.file.FileConfiguration;

import java.sql.*;

public class MySQL {


    public static String HOST = "178.238.230.242";
    public static String DATABASE = "Lobby";
    public static String USER = "root";
    public static String PASSWORD = "contabo2018";
    public static int port = 3306;
    public static Connection con;

    public static void connect()
    {
        try
        {
            con = DriverManager.getConnection("jdbc:mysql://" + HOST + ":" + port + "/" + DATABASE + "?autoReconnect=true", USER, PASSWORD);
            System.out.println("[MySQL] Die Verbindung zur MySQL wurde hergestellt!");
        }
        catch (SQLException e)
        {
            System.out.println("[MySQL] Die Verbindung zur MySQL ist fehlgeschlagen! Fehler: " + e.getMessage());
        }
    }

    public static void close()
    {
        try
        {
            if (con != null)
            {
                con.close();
                System.out.println("[MySQL] Die Verbindung zur MySQL wurde Erfolgreich beendet!");
            }
        }
        catch (SQLException e)
        {
            System.out.println("[MySQL] Fehler beim beenden der Verbindung zur MySQL! Fehler: " + e.getMessage());
        }
    }

    public static void update(String qry)
    {
        try
        {
            Statement st = con.createStatement();
            st.executeUpdate(qry);
            st.close();
        }
        catch (SQLException e)
        {
            connect();
            System.err.println(e);
        }
    }

    public static ResultSet query(String qry)
    {
        ResultSet rs = null;
        try
        {
            Statement st = con.createStatement();
            rs = st.executeQuery(qry);
        }
        catch (SQLException e)
        {
            connect();
            System.err.println(e);
        }
        return rs;
    }

}