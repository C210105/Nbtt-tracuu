package nbtt.com.vn.nbtt_tracuu.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import nbtt.com.vn.nbtt_tracuu.beans.NhanHieu;

@Mapper
public interface NhanHieuMapper {
    
    /**
     * 
     * @return
     */
    public List <NhanHieu> selectAll();
}
