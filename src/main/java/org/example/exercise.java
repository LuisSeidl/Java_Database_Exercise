package org.example;
import java.sql.*;

//This was just an exercise for myself, the one for my UNI class is in the Main file
public class exercise {
    public static void main(String[] args) {

        //Connection String has format: jdbc:driver://hostname:port/nameOfDB you can add ?currentSchema=schema after the name of the DB to specify the Schema
        try{
            Connection con = DriverManager.getConnection("jdbc:postgresql://hera.hs-regensburg.de:5432/sel47223","sel47223","sel47223");

            con.setAutoCommit(true); //We have to commit/Rollback ourselves if we set it to false

            System.out.println("Connected to database");

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT DISTINCT 'Bundesland', 'Station' FROM bahnhoefe LIMIT 10");

            while(rs.next()){ //Sets Cursor to the next row, returns True if there is a next row
                System.out.println("Station: " + rs.getString(2) + " ist in " + rs.getString(1));
            }

            rs = stmt.executeQuery("SELECT COUNT(*) FROM bahnhoefe");
            rs.next(); //We have to call rs.next to actually get to the result of the Query
            System.out.println("Anzahl Bahnhoefe: " + rs.getInt(1)); //To get the Result of a Count query, we have to specify that we
            // want to get the integer of the first row as the result
            //(as there is only one row and column as result)



            rs.close();
            stmt.close();
            con.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
