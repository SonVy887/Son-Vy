package Interface;
import Object.PhongBan;

public interface IPhongBan {
    //them n phong ban
    void addSoLuongPhongBan();// da test
    //them 1 phong ban
    void addPhongBan();// da test
    void addPhongBan(PhongBan pb);

    //sua phong ban theo ma
    void suaPhongBan(String maPhongBan);
    void suaPhongBan();

    //xoa phong ban
    void xoaPhongBan(String maPhongBan);
    void xoaPhongBan();//da test

    //tim kiem phong ban
    void timKiem();// da test
    PhongBan timKiem(String maPhongBan);

    //tim kiem theo ten
    void timKiemTheoTen();// da test
    PhongBan[] timKiemTheoTen(String tenPhongBan);

    void setTruongPhong();// da test

    // them nhan su vao pb
    void themNhanSuPb();// da test
    void themSoLuongNhanSuPb();

    //xoa nhan su phong ban
    void xoaNhanSuPb();

    void inThongTin();
    void inNhanSuPb();// da test
}
