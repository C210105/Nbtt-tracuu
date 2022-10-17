package nbtt.com.vn.nbtt_tracuu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import nbtt.com.vn.nbtt_tracuu.beans.NhanHieu;
import nbtt.com.vn.nbtt_tracuu.beans.ThongTin;

@Controller
public class NbttController {
    
    @GetMapping("/Tracuu")
    public String showTracuu(Model model){

        List <NhanHieu> nhanHieus = new ArrayList<>();
        nhanHieus.add(new NhanHieu("R1", "Rượu"));
        
        List <ThongTin> thongTins = new ArrayList<>();
        thongTins.add(new ThongTin(1, "Yamayaki", "yama", 2222222, "#", 1, new NhanHieu("R1", "Rượu")));
        
        model.addAttribute("thongTins", thongTins);
        model.addAttribute("nhanHieus", nhanHieus);

        return "Tracuu";
    }
}
