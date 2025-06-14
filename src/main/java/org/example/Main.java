package org.example;
import java.sql.*;

public class Main {
    public static void main(String[] args) {

        //Connection String has format: jdbc:driver://hostname:port/nameOfDB you can add ?currentSchema=schema after the name of the DB to specify the Schema
        try{
            Connection con = DriverManager.getConnection("Won't tell you haha");

            System.out.println("Connected to database");

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT bestellnr, zeit FROM bestellung");

            while(rs.next()){ //Sets Cursor to the next row, returns True if there is a next row
                System.out.println("Bestellung: " + rs.getString("bestellnr") + "wurde aufgegeben um " + rs.getString("zeit"));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}