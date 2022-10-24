package nbtt.com.vn.nbtt_tracuu.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import nbtt.com.vn.nbtt_tracuu.beans.ThongTin;
import nbtt.com.vn.nbtt_tracuu.beans.TimKiem;

@Mapper
public interface ThongTinMapper {

    /**
     * 商品情報を検索条件で検索する
     * @param timKiem
     * @return
     */
    public List <ThongTin> selectByTimKiem(TimKiem timKiem);

    /**
     * 商品情報を主キーで検索する
     * @param soTT 商品順番の番号
     * @return　商品情報
     */
    public ThongTin selectBySTT(int sTT);


    /**
     * 商品情報変更
     * @param thongTin　商品情報
     * @return　変更件数
     */
    @Update("UPDATE tracuu_thongtin SET ten = #{ten}, hangSanXuat = #{hangSanXuat}, gia = #{gia}, maSP = #{maSP}, tacDung = #{tacDung}, tonKho = tonKho + 1 WHERE sTT = #{sTT}")
    public int update(ThongTin thongTin);
}
