package fytech.group.Agence.de.voyage.service;

import fytech.group.Agence.de.voyage.model.Reserve;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendConfirmationEmail(Reserve reserve) throws MessagingException{
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,true);

        String to = reserve.getEmail_utilisateur();
        String subject = "Confirmation de réservation";
        String content = "Votre réservation pour " + reserve.getDestination() + " a été confirmée.";

        message.setFrom("kaznarahandrinarivo@gmail.com");
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(content,true);

        javaMailSender.send(message);

        System.out.println("Email envoyé...");
    }
}
