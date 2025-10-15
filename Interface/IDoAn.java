package Interface;
import Object.*;
import Manage.*;

public interface IDoAn {

    void themDoAn();
    void themDoAn(DoAn da);
    void themSoLuongDoAn();

    void suaDoAn();
    void suaDoAn(String maDoAn);

    void timDoAn();
    DoAn timDoAn(String maDoAn);

    void xoaDoAn();
    void xoaDoAn(String maDoAn);

    void timKiemTheoTen();
    DoAn[] timKiemTheoTen(String tenDoAn);

    // tim do an chua co phong ban nao dam nhan
    void timDoAnChuaPb();
    DoAn[] searchDoAnChuaPb();

    void inThongTinDoAn();

    void ganPhongBanDa();

}
