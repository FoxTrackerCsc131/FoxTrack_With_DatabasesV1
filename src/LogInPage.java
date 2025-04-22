//importation of useful libraries
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogInPage extends JFrame {
    //The panel where all buttons are displayed
    private JPanel mainPanel;
    //where the user enters their username
    private JTextField txtUsername;
    //where the user enters their password
    private JPasswordField txtPassword;
    //button that cleares txtUsername and txtPassword
    private JButton btnClear;
    //a submit button for txtUsername and txtPassword
    private JButton btnSubmit;
    //a check box that a user will toggle if they are an admin trying to sign in
    private JCheckBox chkAdmin;
    //simple labels
    private JLabel lblTitle;
    private JLabel lblUsername;
    private JLabel lblPassword;
    //a register button for new users
    private JButton btnRegister;

    //constructor for log in page
    public LogInPage() {
        //opens up the main panel
        setContentPane(mainPanel);
        //set the window name to Log in
        setTitle("Log In");
        //set size of the window
        setSize(500, 500);
        //if the window is closed the code will close aswell
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //make sure the window is visible
        setVisible(true);
        //a listeneer that setes txtUsername and txtPassword to "" if clicked on
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtUsername.setText("");
                txtPassword.setText("");
            }
        });
        //This happens when submit button is pressed
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //create a string for username and password
                String username = txtUsername.getText();
                String password = new String(txtPassword.getPassword());
                //check if the user signing in is an admin
                boolean isAdmin = chkAdmin.isSelected();
                //calls validate login if the user exists and the password is entered correctly set to true
                boolean valid = logins.validateLogin(username, password,isAdmin);
                //if true set user role and tell them the log in was successful
                if(valid){
                    String role=isAdmin?"Admin":"User";
                    JOptionPane.showMessageDialog(null,"Login Successful");
                    dispose();
                }
                //if the user is not found tell them the username or password was wrong
                else{
                    JOptionPane.showMessageDialog(null,"Invalid Username or Password");
                }
            }
        });
        //if register button is clicked open up registrationPage
        btnRegister.addActionListener(e->new RegistrationPage());
    }
    //run the program
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->new HomePage());
    }
}
