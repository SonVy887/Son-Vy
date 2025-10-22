package Manage;
import Interface.*;
import Manage.*;
import Object.*;
import java.util.Scanner;
import java.util.Arrays;

public class DanhSachBangLuong implements IBangLuong {
    private IBangChamCong cnbcc;
    private IPhanCong cnpc;
    private ILuongKhenThuong cnlkt;
    private INhanSu cnns;
    private BangLuong[] dsbl;
    private int n;
    Scanner sc = new Scanner(System.in);

    public DanhSachBangLuong(IBangChamCong cnbcc, IPhanCong cnpc, ILuongKhenThuong cnlkt, INhanSu cnns) {
        this.cnbcc = cnbcc;
        this.cnpc = cnpc;
        this.cnlkt = cnlkt;
        this.cnns = cnns;
        dsbl = new BangLuong[0];
        this.n = 0;
    }
    // kiem tra
    private boolean kiemTra(String mabangluong) {
        for(int i = 0; i < n;i++) {
            if(dsbl[i].getMaBangLuong().equalsIgnoreCase(mabangluong))
                return true;
        }
        return false;
    }
    @Override
    public void them() {
        System.out.print("Nhập n bảng lương đầu tiên: ");
        this.n = sc.nextInt();
        sc.nextLine();
        
        System.out.print("Vui lòng nhập mã bảng lương để kiểm tra: ");
        while(kiemTra(sc.nextLine())) {
            System.out.println("Bảng lương đã tồn tại ");
            System.out.print("Vui lòng nhập lại mã bảng lương: ");
        }

        dsbl = new BangLuong[n];
        for(int i = 0; i < n;i++){
            dsbl[i] = new BangLuong();
            dsbl[i].nhapBangLuong();
        }
    }
    @Override
    public void themBangLuong() {
        System.out.print("Vui lòng nhập mã bảng lương để kiểm tra: ");
        while(kiemTra(sc.nextLine())) {
            System.out.println("Bảng lương đã tồn tại ");
            System.out.print("Vui lòng nhập lại mã bảng lương: ");
        }
        dsbl = Arrays.copyOf(dsbl, n + 1);
        dsbl[n] = new BangLuong();
        dsbl[n].nhapBangLuong();
        this.n++;
    }
    @Override
    public void themBangLuong(BangLuong bl) {
        dsbl = Arrays.copyOf(dsbl, n + 1);
        dsbl[n] = bl;
        this.n++;
    }

    //xoa bang luong
    @Override
    public void xoaBangLuong() {
        System.out.print("Nhập mã bảng lương cần xóa: ");
        String mabangluong = sc.nextLine();
        
        for(int i = 0; i < n;i++) {
            if(dsbl[i].getMaBangLuong().equals(mabangluong)) {
                for(int j = i;j < n - 1;j++) {
                    dsbl[j] = dsbl[j + 1];
                }
                this.n--;
                dsbl = Arrays.copyOf(dsbl, n);
                return;
            }
        }
        System.out.println("Không tìm thấy bảng lương cần xóa");
    }
    @Override
    public void xoaBangLuong(String mabangluong) {
        for(int i = 0; i < n;i++) {
            if(dsbl[i].getMaBangLuong().equals(mabangluong)) {
                for(int j = i;j < n - 1;j++) {
                    dsbl[j] = dsbl[j + 1];
                }
                this.n--;
                dsbl = Arrays.copyOf(dsbl, n);
                return;
            }
        }
        System.out.println("Không tìm thấy bảng lương cần xóa");
    }
    @Override
    public void suaBangLuong() {
        System.out.print("Nhập mã bảng lương cần sửa: ");
        String mabangluong = sc.nextLine();

        for(int i = 0; i < n;i++) {
            if(dsbl[i].getMaBangLuong().equals(mabangluong)) {
                System.out.print("Nhập mã nhân sự: ");
                NhanSu ns = cnns.timKiem(sc.nextLine());
                    if(ns == null) {
                        System.out.println("Nhân sự chưa tồn tại");
                        return;
                    }
                dsbl[i].setNhanSu(ns);
                dsbl[i].setTongLuong(tinhLuongNhanSu(ns.getMaNhanSu()));
                System.out.println("Sửa thành công");
            }
        }
        System.out.println("Không tìm thấy bảng lương cần sửa");
    }
    @Override
    public void suaBangLuong(String mabangluong) {
        for(int i = 0; i < n;i++) {
            if(dsbl[i].getMaBangLuong().equals(mabangluong)) {
                System.out.print("Nhập mã nhân sự: ");
                NhanSu ns = cnns.timKiem(sc.nextLine());
                    if(ns == null) {
                        System.out.println("Nhân sự chưa tồn tại");
                        return;
                    }
                dsbl[i].setNhanSu(ns);
                dsbl[i].setTongLuong(tinhLuongNhanSu(ns.getMaNhanSu()));
                System.out.println("Sửa thành công");
            }
        }
        System.out.println("Không tìm thấy bảng lương cần sửa");
    }
    // tinh luong nhan su
    public double tinhLuongNhanSu(String manhansu){
        double tong = (cnpc.tienThuong(manhansu) + cnlkt.getLuong(manhansu) + cnns.timKiem(manhansu).getLuongCoban());//  20 * cnbcc.tongNgayCong(manhansu);
        if(cnbcc.tongNgayCong(manhansu) == 0) return tong;
        return tong / 20 * cnbcc.tongNgayCong(manhansu);
    }
    @Override
    public void timKiem() {
        System.out.print("Nhập mã bảng lương cần tìm: ");
        String mabangluong = sc.nextLine();

        for(int i = 0; i < n;i++){
            if(dsbl[i].getMaBangLuong().equals(mabangluong)){
                dsbl[i].inBangLuong();
                return;
            }
        }
        System.out.println("Không tìm thấy bảng lương");
    }
    @Override
    public BangLuong timKiem(String mabangluong) {
        for(int i = 0; i < n;i++){
            if(dsbl[i].getMaBangLuong().equals(mabangluong)){
                return dsbl[i];
            }
        }
        return null;
    }
    @Override
    public void tinhBangLuongNhanSu() {
        System.out.print("Nhập mã nhân sự: ");
        NhanSu ns = cnns.timKiem(sc.nextLine());
        if(ns == null) {
            System.out.println("Nhân sự chưa tồn tại");
            return;
        }
        System.out.print("Nhập mã bảng lương: ");
        BangLuong bl = timKiem(sc.nextLine());
        if(bl == null) {
            System.out.println("Bảng lương chưa tồn tại");
            return;
        }

        bl.setNhanSu(ns);
        bl.setTongLuong(tinhLuongNhanSu(ns.getMaNhanSu()));
    }
    @Override
    public void inThongTin() {
        for (int i = 0; i < n; i++) {
            dsbl[i].inBangLuong();
        }
    }
}
