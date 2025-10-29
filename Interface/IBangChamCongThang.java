package Interface;

public interface IBangChamCongThang {
    // them 
    void themBangChamCongThang();
    void them();
    void themBangChamCongThang(BangChamCongThang bcct);

    // sua
    void suaBangChamCongThang();
    void suaBangChamCongThang(String machamcongthang);

    // xoa
    void xoaBangChamCongThang();
    void xoaBangChamCongThang(String machamcongthang);

    // tim kiem
    void timKiem();
    BangChamCongThang timKiem(String machamcongthang);

    // in 
    void inBangChamCongThang();
    // cham cong thang cho nhan su
    void chamCongThangChoNhanSu();


}
