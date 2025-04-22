import javax.swing.*;
import java.sql.*;
//handles connecting to database, validate log in attemps and register new users
public class logins {
    //the path to the database stored in final DB_URL
    private static final String DB_URL="jdbc:sqlite:expense_tracker.db";
    //Attempts to make a connection with the database
    public static Connection connect(){
        try{
            return DriverManager.getConnection(DB_URL);
        }
        //if connection can not be made throw an error
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
    //method to validate a log in
    public static boolean validateLogin(String username, String password, boolean isAdmin){
        //set role to appropriate rolde
        String role=isAdmin?"admin":"user";
        //this checks if a user is in the table called users
        String sql="select * FROM users WHERE username=? AND password=? AND role=?";
        //this attempts to make a datat base connection
        try(Connection conn=connect(); PreparedStatement pstmt= conn.prepareStatement(sql)){
            pstmt.setString(1,username);
            pstmt.setString(2, password);
            pstmt.setString(3, role);
            //if the user is found return true otherwise return false
            ResultSet rs=pstmt.executeQuery();
            return rs.next();
        }
        //if there is an error throw false
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }
    //registering users
    public static boolean registerUser(String username,String password, String role){
        String sql="INSERT INTO users(username, password, role) VALUES(?,?,?)";
        try(Connection conn=connect();
            PreparedStatement pstmt=conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, role);
            pstmt.executeUpdate();
            return true;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }
}
