package QuanLy;
import Object.*;
import java.util.Scanner;
import DanhSach.*;

public abstract class QuanLy {
    protected static DanhSachNhanSu danhsachnhansu;
    protected static DanhSachPhongBan danhsachphongban;
    protected static DanhSachDuAn danhsachduan;
    protected static DanhSachPhanCong danhsachphancong;
    protected static DanhSachBangChamCongNgay danhsachbangchamcongngay;
    protected static DanhSachBangChamCongThang danhsachbangchamcongthang;
    protected static DanhSachQuyDinhThuongLe danhsachquydinhthuongle;
    protected static DanhSachPhuCapThamNien danhsachphucapthamnien;
    protected static DanhSachBangLuongThang danhsachbangluongthang;
    protected static DanhSachChucVu danhsachchucvu;
    Scanner sc = new Scanner(System.in);

    public QuanLy() {
        danhsachnhansu = new DanhSachNhanSu();
        danhsachphongban = new DanhSachPhongBan();
        danhsachchucvu = new DanhSachChucVu();
        danhsachduan = new DanhSachDuAn();
        danhsachphancong = new DanhSachPhanCong();
        danhsachbangchamcongngay = new DanhSachBangChamCongNgay();
        danhsachbangchamcongthang = new DanhSachBangChamCongThang();
        danhsachquydinhthuongle = new DanhSachQuyDinhThuongLe();
        danhsachphucapthamnien = new DanhSachPhuCapThamNien();
        danhsachbangluongthang = new DanhSachBangLuongThang();
    }

    public abstract void menuChinh();
}
