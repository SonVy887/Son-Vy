package Interface;
import Object.*;
import Manage.*;

public interface IDuAn {

    void themDuAn();
    void themDuAn(DuAn da);
    void themSoLuongDuAn();

    void suaDuAn();
    void suaDuAn(String maduan);

    void timDuAn();
    DuAn timDuAn(String maduan);

    void xoaDuAn();
    void xoaDuAn(String maduan);

    void timKiemTheoTen();
    DuAn[] timKiemTheoTen(String tenduan);

    // tim do an chua co phong ban nao dam nhan
    void timDuAnChuaPb();
    DuAn[] searchDuAnChuaPb();

    void inThongTinDuAn();

    void ganPhongBanDa();
    DuAn[] getDuAn();
    // xuat file du an
    void xuatFileDuAn();

}
