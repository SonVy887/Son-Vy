package Interface;

import Object.LuongKhenThuong;

public interface ILuongKhenThuong {
    void themLuongKhen();// da test
    void themNhieuLuongKhen();
    void themLuongKhen(LuongKhenThuong lkt);

    void xoaLuongKhen();// da test
    void xoaLuongKhen(String maLuongKhen);

    void suaLuongKhen();// da test
    void suaLuongKhen(String maLuongKhen);

    void timKiemLuongKhen();//da test
    LuongKhenThuong timKiemLuongKhen(String maLuongKhen);

    // nhan su dc khen thuong
    void ganNhanSu();//da test
    
    void in();// da test
    double getLuong(String manhansu);
    
} 
