package Interface;
import Object.*;

public interface IPhanCong {
    // them bang phan cong
    void addPhanCong();
    void addPhancong(PhanCong pc);
    void addSoLuongPhanCong();


    // xoa bang phan cong
    void xoaPhanCong();
    void xoaPhanCong(String maPhanCong);
    
    // phan cong do an cho nhan su
    void phanCongDoAn();

    // sua bang phan cong 
    void suaPhanCong();
    void suaPhanCong(String maPhanCong);
    
    // tim ma phan cong
    void timKiem();
    PhanCong timKiem(String maPhanCong);
    
    void in();

    double tienThuong(String maNhanSu);
}
