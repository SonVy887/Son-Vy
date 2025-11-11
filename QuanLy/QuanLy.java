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
    static Scanner sc = new Scanner(System.in);


    public abstract void menuChinh();

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

    // xuất file
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

    public static void thongKeTheoQuy() {
        System.out.print("Vui lòng nhập quý từ (1-4): ");
        int quy = sc.nextInt();sc.nextLine();
        System.out.print("Nhập năm: ");
        int nam = sc.nextInt();sc.nextLine();
        danhsachbangluongthang.thongKeTheoQuy(quy, nam);
    }

}
