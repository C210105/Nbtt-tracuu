package nbtt.com.vn.nbtt_tracuu.services;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import nbtt.com.vn.nbtt_tracuu.beans.ThongTin;
import nbtt.com.vn.nbtt_tracuu.beans.TimKiem;

@SpringBootTest
public class ThongTinServiceTest {
    
    @Autowired
    ThongTinService service;

    // @Test
    // void test(){

    //     TimKiem timKiem = new TimKiem();
    //     List <ThongTin> thongTins = service.getThongTin(timKiem);
    //     assertThat(thongTins.size()).isEqualTo(4);

    //     ThongTin thongTin = thongTins.get(0);
    //     assertThat(thongTin).isNotNull();
    //     assertThat(thongTin.getSTT()).isEqualTo(1);
    //     assertThat(thongTin.getTen()).isEqualTo("Yamazaki");
    //     assertThat(thongTin.getTacDung()).isEqualTo("Rượu");
    //     assertThat(thongTin.getGia()).isEqualTo(2222222);
    //     assertThat(thongTin.getNhanHieu().getLoaiSP()).isEqualTo("Rượu");
    // }

    // @DisplayName("商品番号")
    // @Test
    // void test1(){

    //     TimKiem timKiem = new TimKiem();
    //     timKiem.setMaSP("TPCN");

    //     List <ThongTin> thongTins = service.getThongTin(timKiem);
    //     for(ThongTin thongTin : thongTins){
    //         assertThat(thongTin.getNhanHieu().getLoaiSP()).isEqualTo("Thực Phẩm Chức Năng");
    //     }
    // }

    @DisplayName("商品番号")
    @ParameterizedTest
    @CsvSource({"R, Rượu", "MP, Mỹ Phẩm", "TPCN, Thực Phẩm Chức Năng", "DDT, Đồ Điện Tử"})
    void test2(String maSP, String loaiSP){

        TimKiem timKiem = new TimKiem();
        timKiem.setMaSP(maSP);

        List <ThongTin> thongTins = service.getThongTin(timKiem);
        assertThat(thongTins.size()).isGreaterThanOrEqualTo(1); //1以上
        for(ThongTin thongTin : thongTins){
            assertThat(thongTin.getNhanHieu().getLoaiSP()).isEqualTo(loaiSP);
        }
    }

    @DisplayName("商品番号 該当なし")
    @Test
    void test3(){

        TimKiem timKiem = new TimKiem();
        timKiem.setMaSP("AA");

        List <ThongTin> thongTins = service.getThongTin(timKiem);
        assertThat(thongTins.size()).isEqualTo(0); //1以上
    }

    @DisplayName("商品名完全一致")
    @ParameterizedTest
    @CsvSource({"Peleus 2.5ml", "Woman Method Triple", "Peleus 2.5ml"})
    void test4(String ten){

        TimKiem timKiem = new TimKiem();
        timKiem.setKey(ten);

        List <ThongTin> thongTins = service.getThongTin(timKiem);
        assertThat(thongTins.size()).isGreaterThanOrEqualTo(1); //1以上
        for(ThongTin thongTin : thongTins){
            assertThat(thongTin.getTen()).isEqualTo(ten);
        }
    }

    @DisplayName("商品名該当なし")
    @Test
    void test5(){

        TimKiem timKiem = new TimKiem();
        timKiem.setKey("AAA");

        List <ThongTin> thongTins = service.getThongTin(timKiem);
        assertThat(thongTins.size()).isEqualTo(0);
    }

    @DisplayName("商品名完全 商品番号, 商品名")
    @ParameterizedTest
    @CsvSource({"R, Yama, Yamazaki", "MP, Kate, Kate Lip Monster 10 3g", "TPCN, Peleus, Peleus 2.5ml", "DDT, TUF, TUF Gaming A15 FA506ICB"})
    void test6(String maSP, String key, String ten){

        TimKiem timKiem = new TimKiem();
        timKiem.setMaSP(maSP);
        timKiem.setKey(key);

        List <ThongTin> thongTins = service.getThongTin(timKiem);
        assertThat(thongTins.size()).isGreaterThanOrEqualTo(1); //1以上
        for(ThongTin thongTin : thongTins){
            assertThat(thongTin.getTen()).startsWith(ten);
        }
    }

    @DisplayName("商品番号、Key 該当なし")
    @ParameterizedTest
    @CsvSource({"R, B", "MP, 5"})
    void test7(String maSP, String key){

        TimKiem timKiem = new TimKiem();
        timKiem.setMaSP(maSP);
        timKiem.setKey(key);
        
        List <ThongTin> thongTins = service.getThongTin(timKiem);
        assertThat(thongTins.size()).isEqualTo(0);
    }

    @DisplayName("全件該当")
    @Test
    void test8(){

        TimKiem timKiem = new TimKiem();

        List <ThongTin> thongTins = service.getThongTin(timKiem);
        assertThat(thongTins.size()).isEqualTo(10);
    }

    @DisplayName("商品順番の番号")
    @ParameterizedTest
    @CsvSource({"1, Yamazaki", "2, Woman Method Triple"})
    void test9(int sTT, String ten){

        ThongTin thongTin = service.getThongTin(sTT);
        assertThat(thongTin.getTen()).isEqualTo(ten);
        
    }

    @DisplayName("商品順番の番号 全目確認")
    @Test
    void test10(){

        ThongTin thongTin = service.getThongTin(1);
        assertThat(thongTin.getSTT()).isEqualTo(1);
        assertThat(thongTin.getTen()).isEqualTo("Yamazaki");
        assertThat(thongTin.getHangSanXuat()).isEqualTo("Yamazaki");
        assertThat(thongTin.getGia()).isEqualTo(2222222);
        assertThat(thongTin.getMaSP()).isEqualTo("R");
        assertThat(thongTin.getTacDung()).isEqualTo("Rượu");
        assertThat(thongTin.getTonKho()).isEqualTo(1);

    }

    @DisplayName("商品情報変更")
    @Test
    @Transactional
    @Rollback
    void test11(){

        ThongTin thongTinBefore = service.getThongTin(1);
        thongTinBefore.setTen("山崎");
        thongTinBefore.setGia(10);


        service.save(thongTinBefore);
        ThongTin thongTinAfter = service.getThongTin(1);
        assertThat(thongTinAfter.getTen()).isEqualTo("山崎");
        assertThat(thongTinAfter.getTonKho()).isEqualTo(thongTinBefore.getTonKho() + 1);
    }

}
