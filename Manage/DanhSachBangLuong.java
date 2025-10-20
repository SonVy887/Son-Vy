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
    public double tinhLuongNhanSu(String manhansu){
        double tong = (cnpc.tienThuong(manhansu) + cnlkt.getLuong(manhansu) + cnns.timKiem(manhansu).getLuongCoban());//  20 * cnbcc.tongNgayCong(manhansu);
        if(cnbcc.tongNgayCong(manhansu) == 0) return tong;
        return tong / 20 * cnbcc.tongNgayCong(manhansu);
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
    public void themNhanSu() {
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
