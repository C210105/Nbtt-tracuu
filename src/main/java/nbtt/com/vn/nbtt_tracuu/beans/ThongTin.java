package nbtt.com.vn.nbtt_tracuu.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ThongTin {
    
    private Integer sTT; // 順番
    private String ten; // 名
    private String hangSanXuat; // 製
    private Integer gia; // 価格
    private String maSP; // 商品番号
    private String tacDung; // 用
    private Integer tonKho; // 残り
    NhanHieu nhanHieu;
}
