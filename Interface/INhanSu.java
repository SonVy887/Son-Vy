package Interface;
import java.util.*;
import Object.*;

public interface INhanSu {
    void addNhanSu(NhanSu ns);
    //them n nhan su
    void addSoLuongNhanSu();
    // them vao cuoi
    void addNhanSu(); 

    //sua nhan su theo ma
    void suaNhanSu(String maNhanSu);
    void suaNhanSu();

    //xoa nhan su
    void xoaNhanSu(String maNhanSu);
    void xoaNhanSu();

    //tim kiem nhan su
    void timKiem();
    NhanSu timKiem(String maNhanSu);

    //tim kiem theo ho
    void timKiemTheoHo();
    NhanSu[] timKiemTheoHo(String hoNhanSu);

    //tim kiem theo ten
    void timKiemTheoTen();
    NhanSu[] timKiemTheoTen(String tenNhanSu);

    //thong ke theo gioi tinh
    void thongKeGioiTinh();
    int[] thongKeGioiTinh(String gioiTinh);

    //thong ke theo tuoi
    int[] thongKeTuoi();

    void in();
    
}
