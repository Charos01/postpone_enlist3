package gr.hua.dit.dis_sys.project.postpone_enlist.Controller;

import gr.hua.dit.dis_sys.project.postpone_enlist.Config.MailConfiguration;
import gr.hua.dit.dis_sys.project.postpone_enlist.Entity.User;
import gr.hua.dit.dis_sys.project.postpone_enlist.Service.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.print.attribute.standard.PresentationDirection;

@RestController
public class OpenEndpointsController {

    //We user the admin service just for the addUser method, So we dont make a User Service just for one method
    @Autowired
    private AdminServiceImpl service;
    @Autowired
    public JavaMailSender mailSender;

    //Will be the home page
    //Currently just shows a message to the / url
    @RequestMapping("/")
    String welcome() {
        return "Welcome";
    }

    //Register

    @PostMapping(value ="/register" , consumes = {"application/json"})
    User register(@RequestBody User user) {

        User newUser = service.addUser(user);
        service.makeUserCitizen(user.getADT());
        MailSubmissionController mail = new MailSubmissionController(mailSender);
        mail.send(user.getEmail());

        return newUser;
    }

    //Register Page
}
