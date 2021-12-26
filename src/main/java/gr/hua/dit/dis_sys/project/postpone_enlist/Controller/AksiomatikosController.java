package gr.hua.dit.dis_sys.project.postpone_enlist.Controller;

import gr.hua.dit.dis_sys.project.postpone_enlist.Entity.Application;
import gr.hua.dit.dis_sys.project.postpone_enlist.Service.AksiomatikosServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aks")
public class AksiomatikosController {

    @Autowired
    private AksiomatikosServiceImpl aksiomatikosService;

    @GetMapping("/apps")
    List<Application> all() {
        return aksiomatikosService.findAll();
    }

    @GetMapping("/apps/{id}")
    Application app (@PathVariable int id) {
        return aksiomatikosService.getApplication(id);
    }

    @PutMapping("/apps/{id}")
    Application approve (@PathVariable int id) {
        return aksiomatikosService.approveApplication(id);
    }
}