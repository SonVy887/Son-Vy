package Interface;
import Object.*;
public interface IBangLuong {
    void themBangLuong();
    void them();
    void themBangLuong(BangLuongThang bl);

    void xoaBangLuong();
    void xoaBangLuong(String mabangluong);

    void suaBangLuong();
    void suaBangLuong(String mabangluong);

    void timKiem();
    BangLuongThang timKiem(String mabangluong);

    void tinhBangLuongNhanSu();
    void inThongTin();
}
