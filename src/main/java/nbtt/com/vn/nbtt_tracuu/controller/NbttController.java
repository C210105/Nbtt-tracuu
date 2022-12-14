package nbtt.com.vn.nbtt_tracuu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;
import nbtt.com.vn.nbtt_tracuu.beans.NhanHieu;
import nbtt.com.vn.nbtt_tracuu.beans.ThongTin;
import nbtt.com.vn.nbtt_tracuu.beans.TimKiemForm;
import nbtt.com.vn.nbtt_tracuu.services.ThongTinService;

@Controller
@Slf4j
public class NbttController {
    
    @Autowired
    ThongTinService service;

    @GetMapping("/showtracuu")
    public String showtracuu(TimKiemForm timKiemForm, Model model){

        log.info("呼ばれたよ！{}", timKiemForm);
        // List <NhanHieu> nhanHieus = new ArrayList<>();
        // nhanHieus = service.getNhanHieu();

        this.setNhanHieu(model);
        // nhanHieus.add(new NhanHieu("R1", "Rượu"));
        // nhanHieus.add(new NhanHieu("MP1", "Mỹ Phẩm"));
        // nhanHieus.add(new NhanHieu("TPCN1", "Thực Phẩm Chức Năng"));
        // nhanHieus.add(new NhanHieu("DDT", "Đồ Điện Tử"));
        
        List <ThongTin> thongTins = new ArrayList<>();
        // TimKiemForm timKiem = new TimKiemForm();
        thongTins = service.getThongTin(timKiemForm);
        // thongTins.add(new ThongTin(1, "Yamayaki", "Yamazaki", 2222222, "#", 1, new NhanHieu("R1", "Rượu")));
        // thongTins.add(new ThongTin(2, "Woman Method Triple", "Mtsukiyo", 240000 , "Dưỡng ẩm da mặt", 2, new NhanHieu("MP1", "My Phẩm")));
        // thongTins.add(new ThongTin(3, "Suntory Single Malt Whisky", "Yamazaki", 742500, "700ml", 1, new NhanHieu("R1", "Rượu")));
        // thongTins.add(new ThongTin(4, "Suntory Single Malt Whisky 12", "Yamazaki", 1700000, "700ml", 10, new NhanHieu("R1", "Rượu")));

        model.addAttribute("thongTins", thongTins);
        // model.addAttribute("nhanHieus", nhanHieus);

        // ログ出力 
        log.debug("thongTins: {}", thongTins);

        return "Tracuu";
    }
    
    
    /**
     * 
     * @param timKiemForm
     * @param model
     * @return
     */
    @GetMapping("/showtracuu/lammoi")
    public String showlammoi(TimKiemForm timKiemForm, Model model) {
        this.setNhanHieu(model);

        // 検索条件をリセットする
        timKiemForm = new TimKiemForm();
        return "Tracuu";
    }

    /**
     * 商品の番号、書類
     * @param model
     */
    private void setNhanHieu(Model model){
        
        List <NhanHieu> nhanHieus = new ArrayList<>();
        nhanHieus = service.getNhanHieu();
        model.addAttribute("nhanHieus", nhanHieus);
    }
}
