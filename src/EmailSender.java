import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
//This class handles sending emails from users to foxtrack team. Uses 2fa for security
public class EmailSender {
    //sends email to users and return true if it was done successfully takes 5 parameters
    //users name for foxtrot email, password for email, a list of email addresses to send emails to, the subject of thr email and the body
    public static boolean sendEmail(String userName, String password, String[] toEmails, String subject, String body){
        //these connect it to gmail
        //gmail server
        String host = "smtp.gmail.com";
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        //the port for secure email transfers
        props.put("mail.smtp.port", "587");
        //these are for securley connecting
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        //this makes an email session and users the foxtrot credentials to log in
        //this is a built in methof
        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        });
        try{
            //this builds the email
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(userName));
            InternetAddress[] addresses=new InternetAddress[toEmails.length];
            for(int i=0; i<toEmails.length;i++){
                addresses[i]=new InternetAddress(toEmails[i]);
            }
            message.setRecipients(Message.RecipientType.TO, (Address[]) addresses);
            message.setSubject(subject);
            message.setText(body);
            // this connects to gmail session and sends the email
            Transport.send(message);
            return true;
        }catch(MessagingException e){
            e.printStackTrace();
            return false;
        }
    }
}
