package QuanLy;
import Object.*;
import java.util.Scanner;
import DanhSach.*;

public abstract class QuanLy {
    protected static DanhSachNhanSu danhsachnhansu = new DanhSachNhanSu();
    protected static DanhSachPhongBan danhsachphongban = new DanhSachPhongBan();
    protected static DanhSachDuAn danhsachduan = new DanhSachDuAn();
    protected static DanhSachPhanCong danhsachphancong = new DanhSachPhanCong();
    protected static DanhSachBangChamCongNgay danhsachbangchamcongngay = new DanhSachBangChamCongNgay();
    protected static DanhSachBangChamCongThang danhsachbangchamcongthang = new DanhSachBangChamCongThang();
    protected static DanhSachQuyDinhThuongLe danhsachquydinhthuongle = new DanhSachQuyDinhThuongLe();
    protected static DanhSachPhuCapThamNien danhsachphucapthamnien = new DanhSachPhuCapThamNien();
    protected static DanhSachBangLuongThang danhsachbangluongthang = new DanhSachBangLuongThang();
    protected static DanhSachChucVu danhsachchucvu = new DanhSachChucVu();
    Scanner sc = new Scanner(System.in);

    public static void docFile() {
        // đọc file
        danhsachnhansu.docFileDanhSachNhanSu();
        danhsachphongban.docFilePhongBan();
        danhsachduan.docFileDanhSachDuAn();
        danhsachphancong.docFilePhanCong();
        danhsachbangchamcongngay.docFileBangChamCongNgay();
        danhsachbangchamcongthang.docFileBangChamCongThang();
        danhsachquydinhthuongle.docFileDanhSachThuongLe();
        danhsachphucapthamnien.docFilePhuCapThamNien();
        danhsachbangluongthang.docFileBangLuongThang();
        danhsachchucvu.docFileBangChucVu();
    }

    public static void xuatFile() {
        danhsachnhansu.xuatFileDanhSachNhanSu();
        danhsachphongban.xuatFilePhongBan();
        danhsachduan.xuatFileDanhSachDuAn();
        danhsachphancong.xuatFilePhanCong();
        danhsachbangchamcongngay.xuatFileBangChamCongNgay();
        danhsachbangchamcongthang.xuatFileBangChamCongThang();
        danhsachquydinhthuongle.xuatFileThuongLe();
        danhsachphucapthamnien.xuatFilePhuCapThamNien();
        danhsachbangluongthang.xuatFileBangLuongThang();
        danhsachchucvu.xuatFileBangChucVu();
    }

    public abstract void menuChinh();
}
