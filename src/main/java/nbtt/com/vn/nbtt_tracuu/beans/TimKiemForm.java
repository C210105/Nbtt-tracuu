package nbtt.com.vn.nbtt_tracuu.beans;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class TimKiemForm {
    
    //  検索条件
    @NotNull
    @Size(min=1)
    private String maSP; // 商品番号

    @NotNull
    @Size(min=1)
    private String key;
}
