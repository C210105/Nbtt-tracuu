package nbtt.com.vn.nbtt_tracuu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NbttController {
    
    @GetMapping("/Tracuu")
    public String showTracuu(){
        return "Tracuu";
    }
}
