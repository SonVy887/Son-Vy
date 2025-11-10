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

    //thong ke theo tuoi
    void thongKeTuoi();

    //thong ke theo nam kinh nghiem
    void thongKeNamKinhNghiem();

    // thong ke gpa
    void thongKeGPA();

    // in danh sach nhan su
    void in();
    // in chi tiet nhan su chinh thuc
    void inChiTietNhanSuChinhThuc();
    // in chi tiet nhan su thuc tap
    void inChiTietNhanSuThucTap();
    // xuat file danh sach nhan su
    void xuatFileDanhSachNhanSu();
    // doc file
    //void docFileDanhSachNhanSu();
    void docFileDanhSachNhanSu();
}
