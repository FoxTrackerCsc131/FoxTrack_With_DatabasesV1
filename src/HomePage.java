import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
//this is a simple home page with the fox image
public class HomePage extends JFrame{
    public HomePage(){
        super("Welcome to FoxTrack");
        DatabaseSetup.dataBaseSetup();
        setUndecorated(true);
        //opens maximized screen
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        //close the program when the window is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //set the background image to the fox
        ImageIcon backgroundIcon = new ImageIcon(getClass().getResource("/FoxTrackHomePage.jpg"));
        Image image=backgroundIcon.getImage();
        //actually putting the background
        JLabel backgroundLabel=new JLabel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }
        };

        backgroundLabel.setLayout(new BorderLayout());
        //when the screen is clicked go to logInPage
        backgroundLabel.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                dispose();
                SwingUtilities.invokeLater(()-> new LogInPage());
            }
        });

        setContentPane(backgroundLabel);
        setVisible(true);
    }
}
