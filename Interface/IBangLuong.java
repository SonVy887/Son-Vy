package Interface;
import Object.*;
public interface IBangLuong {
    void themBangLuong();
    void them();
    void themBangLuong(BangLuong bl);

    void xoaBangLuong();
    void xoaBangLuong(String mabangluong);

    void suaBangLuong();
    void suaBangLuong(String mabangluong);

    void timKiem();
    BangLuong timKiem(String mabangluong);

    void tinhBangLuongNhanSu();
    void inThongTin();
}
