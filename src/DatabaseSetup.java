import javax.swing.*;
//libraries to help setup database
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
//setups the database this includes making the table
public class DatabaseSetup {
    public static void dataBaseSetup() {
        //this will either create a database called expense_tracker or open it if it exists
        String url="jdbc:sqlite:expense_tracker.db";
        //this is preppinf a command to create a table called users which has the following columns id, username, password and role

        String sql="CREATE TABLE IF NOT EXISTS users (\n"
                +"   id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                +"   username TEXT NOT NULL UNIQUE,\n"
                +"   password TEXT NOT NULL,\n"
                +"   role TEXT NOT NULL CHECK(role IN ('admin','user'))\n"
                +");";
        //we set conn as our connection DraverManager.getConnection url attempst to connect to the
        //expense_tracker file
        try(Connection conn = DriverManager.getConnection(url);
            //this creates like a statement/command to send to the data base
            //it currently is storing our sql command to stmt to send to data base
            Statement stmt=conn.createStatement()){
            //it is sending the statement to the database
            stmt.execute(sql);
            //system says database created if successful
            System.out.println("Database created");
        }
        //if an error happens it is caught
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
