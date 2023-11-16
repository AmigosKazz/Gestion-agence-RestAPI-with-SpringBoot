package fytech.group.Agence.de.voyage.service;

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

    public void sendConfirmationEmail(String to, String Object, String Content) throws MessagingException{
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,true);

        message.setFrom("kaznarahandrinarivo@gmail.com");
        helper.setTo(to);
        helper.setSubject(Object);
        helper.setText(Content,true);

        javaMailSender.send(message);

        System.out.println("Email envoyé...");

    }

}
