package nbtt.com.vn.nbtt_tracuu.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import nbtt.com.vn.nbtt_tracuu.beans.ThongTin;

@Mapper
public interface ThongTinMapper {
    
    public List <ThongTin> selectAll();
}
