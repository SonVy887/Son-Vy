package Interface;
import Object.*;
public interface IBangChamCongNgay {
    void themBangChamCongNgay();
    void themBangChamCongNgay(BangChamCongNgay bcc1);
    void them();

    void xoaBangChamCongNgay();
    void xoaBangChamCongNgay(String machamcong);

    void suaBangChamCongNgay();
    void suaBangChamCongNgay(String machamcong);

    void timKiem();
    BangChamCongNgay timKiem(String machamcong);

    void chamCongNhanSu();
    void inBangChamCongNgay();

    BangChamCongNgay[] getBangChamCongNgay();
    // xuat file bang cham cong
    void xuatFileBangChamCongNgay();
    int tongNgayCong(String manhansu);
}
