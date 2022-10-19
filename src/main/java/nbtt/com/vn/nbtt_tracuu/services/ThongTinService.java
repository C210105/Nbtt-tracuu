package nbtt.com.vn.nbtt_tracuu.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nbtt.com.vn.nbtt_tracuu.beans.NhanHieu;
import nbtt.com.vn.nbtt_tracuu.beans.ThongTin;
import nbtt.com.vn.nbtt_tracuu.mappers.NhanHieuMapper;
import nbtt.com.vn.nbtt_tracuu.mappers.ThongTinMapper;

@Service
public class ThongTinService {
    
    @Autowired
    ThongTinMapper thongTinMapper;

    @Autowired
    NhanHieuMapper nhanHieuMapper;
    
    public List <ThongTin> getThongTin(){
        return thongTinMapper.selectAll();
    }

    public List <NhanHieu> getNhanHieu(){
        return nhanHieuMapper.selectAll();
    }
}
