package Interface;

public Interface IChucVu {
    // them
    void themBangChucVu();
    void themBangChucVu(ChucVu cv);
    void them();

    // xoa 
    void xoaBangChucVu();
    void xoaBangChucVu(String machucvu);

    // sua
    void suaBangChucVu();
    void suaBangChucVu(String machucvu);

    // tim kiem
    void tiemKiem();
    ChucVu tiemKiem(String machucvu);

    // in bang chuc vu
    void inThongTinChucVu();
}
