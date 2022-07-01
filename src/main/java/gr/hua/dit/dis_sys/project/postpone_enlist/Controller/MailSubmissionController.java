package gr.hua.dit.dis_sys.project.postpone_enlist.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailSubmissionController {

    private final JavaMailSender javaMailSender;

    @Autowired
    MailSubmissionController(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @RequestMapping("/mail")
    @ResponseStatus(HttpStatus.CREATED)
    SimpleMailMessage send(String maill) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(maill);
        mailMessage.setReplyTo("charos@mailhog.gr");
        mailMessage.setFrom("stratologia@mailhog.gr");
        mailMessage.setSubject("Welcome message");
        mailMessage.setText("Welcomee!Υour registration is complete");
        javaMailSender.send(mailMessage);
        return mailMessage;
    }
}
