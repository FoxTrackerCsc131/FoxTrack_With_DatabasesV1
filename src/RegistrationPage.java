//import libraries for user interface
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationPage extends JFrame{
    //this allows users to enter their desired username
    private JTextField txtUsernameWanted;
    //this allows users to enter their desired username
    private JPasswordField txtPasswordWanted;
    //similiar to the submit button
    private JButton btnRegister;
    //a dropdown box so users can choose between a user or admin account
    private JComboBox cmboUserType;
    private JPanel RegistrationPage;
    //a button to return to log in page
    private JButton backButton;

    public RegistrationPage(){
        setContentPane(RegistrationPage);
        setTitle("Registration");
        setSize(400,400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        //this happens if register button is clicked
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //set username, password, and role
                String username = txtUsernameWanted.getText();
                String password = new String(txtPasswordWanted.getPassword());
                String role = cmboUserType.getSelectedItem().toString();
                //if registration is successfull say it was a success
                if(logins.registerUser(username, password, role)){
                    JOptionPane.showMessageDialog(RegistrationPage, "User registered successfully");
                    dispose();
                }
                //if the registration didnt work tell the user
                else{
                    JOptionPane.showMessageDialog(RegistrationPage, "Username already taken");
                }
            }
        });
        //if back button is pressed return user to action event
        backButton.addActionListener(e -> dispose());
    }

    public static void main(String[] args) {
        RegistrationPage introRegistrationPage = new RegistrationPage();
    }


}
