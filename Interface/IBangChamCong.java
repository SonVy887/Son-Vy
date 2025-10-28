package Interface;
import Object.*;
public interface IBangChamCong {
    void themBangChamCong();
    void themBangChamCong(BangChamCong bcc1);
    void them();

    void xoaBangChamCong();
    void xoaBangChamCong(String machamcong);

    void suaBangChamCong();
    void suaBangChamCong(String machamcong);

    void timKiem();
    BangChamCong timKiem(String machamcong);

    void setNhanSuCc();
    void inBangChamCong();

    BangChamCong[] getBangChamCong();
    // xuat file bang cham cong
    void xuatFileBangChamCong();
    int tongNgayCong(String manhansu);
}
