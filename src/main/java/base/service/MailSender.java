package base.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailSender {
    @Autowired
    private JavaMailSender mailSender;

    public void send(String emailTo, String subject, String message){
        SimpleMailMessage msg = new SimpleMailMessage();
        emailTo = "sbuigji@yandex.ru";
        subject = "Ваша заявка принята";
        message = "Мы начали искать вашего питомца";
        msg.setTo(emailTo);
        msg.setFrom("searchingpets@yandex.ru");
        msg.setSubject(subject);
        msg.setText(message);
        mailSender.send(msg);
    }
}
