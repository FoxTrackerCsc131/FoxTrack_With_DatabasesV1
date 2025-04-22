import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//temp window for contact
public class Contact extends JFrame {
    // Contact form fields

    private JTextField nameField;
    private JTextField emailField;
    private JTextField phoneField;
    private JTextArea messageArea;

    public Contact() {
        // Set up the frame
        super("Contact Us");
        setLayout(new BorderLayout());
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel for form fields
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(5, 2));

        // Name Field
        formPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        formPanel.add(nameField);

        // Email Field
        formPanel.add(new JLabel("Email:"));
        emailField = new JTextField();
        formPanel.add(emailField);

        // Phone Number Field
        formPanel.add(new JLabel("Phone Number:"));
        phoneField = new JTextField();
        formPanel.add(phoneField);

        // Message Field
        formPanel.add(new JLabel("Message:"));
        messageArea = new JTextArea(4, 20);
        JScrollPane scrollPane = new JScrollPane(messageArea);
        formPanel.add(scrollPane);

        // Submit Button
        JButton submitButton = new JButton("Submit");
        formPanel.add(submitButton);

        // Add form panel to the frame
        add(formPanel, BorderLayout.CENTER);

        // Action listener for submit button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get user input
                String name = nameField.getText();
                String email = emailField.getText();
                String phone = phoneField.getText();
                String message = messageArea.getText();

                // Format the message content to send
                String subject="FOXTRACK: New Contact Form Request From: "+name;
                String body="New Contact Form Request from: "+name+"\n"
                        +"Email: "+email+"\n"
                        +"Phone: "+phone+"\n"
                        +"Message: "+message+"\n";
                String fromEmail="foxtrotteam08@gmail.com";
                String password="onycyfsotgkkfkxo";
                String[] toEmails={"nikkocastillo@csus.edu","ryanhendricks@csus.edu","dstepanyuk@csus.edu","dcaceres@csus.edu","gyang5@csus.edu","ivalerio@csus.edu","alexistrejoguerrero@csus.edu"};

                try{
                    EmailSender.sendEmail(fromEmail,password,toEmails,subject,body);
                    JOptionPane.showMessageDialog(null,"Contact submitted");
                }catch(Exception ex){
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null,"Failed to send email"+ex.getMessage());
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new Contact();
    }
}
