package nbtt.com.vn.nbtt_tracuu.services;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import nbtt.com.vn.nbtt_tracuu.beans.ThongTin;

@SpringBootTest
public class ThongTinServiceTest {
    
    @Autowired
    ThongTinService service;

    @Test
    void test(){

        List <ThongTin> thongTins = service.getThongTin();
        assertThat(thongTins.size()).isEqualTo(4);

        ThongTin thongTin = thongTins.get(0);
        assertThat(thongTin).isNotNull();
        assertThat(thongTin.getSTT()).isEqualTo(1);
        assertThat(thongTin.getTen()).isEqualTo("Yamazaki");
        assertThat(thongTin.getTacDung()).isEqualTo("Rượu");
        assertThat(thongTin.getGia()).isEqualTo(2222222);
        assertThat(thongTin.getNhanHieu().getLoaiSP()).isEqualTo("Rượu");

    }
}
