package Manage;
import Interface.*;
import Object.*;

import java.util.Arrays;
import java.util.Scanner;


public class DanhSachPhanCong implements IPhanCong {
    private PhanCong[] dspc;
    private int n;
    private INhanSu cnns; // chuc nang nhan su
    private IDoAn cnda; // chuc nang do an
    private final double thuong = 500_000;
    Scanner sc = new Scanner(System.in);

    public DanhSachPhanCong(INhanSu cnns, IDoAn cnda){
        dspc = new PhanCong[0];
        this.n = 0;
        this.cnns = cnns;
        this.cnda = cnda;
    }
    // kiem tra duy nhat
    public boolean kiemTra(String maphancong){
        for (int i = 0; i < n; i++) {
            if(dspc[i].getMaPhanCong().equals(maphancong)){
                return true;
            }
        }
        return false;
    }
    // them bang phan cong
    @Override
    public void addPhanCong(){
        System.out.print("Vui lòng nhập mã phân công để kiểm tra: ");
        while(kiemTra(sc.nextLine())){
            System.out.println("Mã phân công đã tồn tại");
            System.out.print("Vui lòng nhập lại: ");
        }
        
        dspc = Arrays.copyOf(dspc, n + 1);
        dspc[n] = new PhanCong();
        dspc[n].nhapPhanCong();
        this.n++;
    }
    @Override
    public void addPhancong(PhanCong pc){
        dspc = Arrays.copyOf(dspc, n + 1);
        dspc[n] = pc;
        this.n++;
    }
    // them n phan cong dau tien
    @Override
    public void addSoLuongPhanCong(){
        System.out.print("Nhập n phân công đầu tiên: ");
        this.n = sc.nextInt();
        sc.nextLine();

        dspc = new PhanCong[n];
        for (int i = 0; i < n; i++) {
            dspc[i] = new PhanCong();
            dspc[i].nhapPhanCong();
        }
    }
    // xoa bang phan cong
    @Override
    public void xoaPhanCong(){
        System.out.print("Nhập mã phân công muốn xóa: ");
        String maphancong = sc.nextLine().toUpperCase();

        for (int i = 0; i < n; i++) {
            if(dspc[i].getMaPhanCong().equals(maphancong)){
                for (int j = i; j < n - 1; j++) 
                    dspc[j] = dspc[j + 1];
                dspc = Arrays.copyOf(dspc, n);
                return;
            }
        }
        System.out.println("Xóa thất bại");
    }
    @Override
    public void xoaPhanCong(String maphancong){
        for (int i = 0; i < n; i++) {
            if(dspc[i].getMaPhanCong().equals(maphancong)){
                for (int j = i; j < n - 1; j++) 
                    dspc[j] = dspc[j + 1];
                dspc = Arrays.copyOf(dspc, n);
                return;
            }
        }
        System.out.println("Xóa thất bại");
    }
    // sua phan cong 
    @Override
    public void suaPhanCong(){
        System.out.print("Nhập mã phân công: ");
        String maphancong = sc.nextLine().toUpperCase();

        for (int i = 0; i < n; i++) {
            if(dspc[i].getMaPhanCong().equals(maphancong)){
                System.out.print("Vui lòng nhập thời gian mới: ");
                dspc[i].setThoiGian(sc.nextLine());
                System.out.println("Sửa thành công");
            }
        }
    }
    @Override
    public void suaPhanCong(String maphancong){
        for (int i = 0; i < n; i++) {
            if(dspc[i].getMaPhanCong().equals(maphancong)){
                System.out.print("Vui lòng nhập thời gian mới: ");
                dspc[i].setThoiGian(sc.nextLine());
                System.out.println("Sửa thành công");            
            }
        }
    }
    // phan cong nhan su lam do an
    @Override
    public void phanCongDoAn(){
        System.out.print("Nhập mã nhân sự: ");
        String manhansu = sc.nextLine().toUpperCase();

        NhanSu ns = cnns.timKiem(manhansu);
        if(ns == null){
            System.out.println("Nhân sự chưa tồn tại");
            return;
        }

        System.out.print("Nhập mã đồ án: ");
        String madoan = sc.nextLine().toUpperCase();

        DoAn da = cnda.timDoAn(madoan);
        if(da == null){
            System.out.println("Đồ án chưa tồn tại");
            return;
        }

        System.out.print("Nhập thời gian: ");
        String thoigian = sc.nextLine();

        System.out.print("Nhập mã phân công: ");
        String maphancong = sc.nextLine();
        PhanCong pc = timKiem(maphancong);

        pc.setDoAn(da);
        pc.setNhanSu(ns);
        pc.setThoiGian(thoigian);
    }

    // tim kiem ma phan cong
    @Override
    public void timKiem(){
        System.out.print("Nhập mã phân công: ");
        String maphancong = sc.nextLine().toUpperCase();

        for(int i = 0;i < n;i++){
            if(dspc[i].getMaPhanCong().equals(maphancong)){
                dspc[i].inThongTinPhanCong();
            }
        }
        System.out.println("Không tìm thấy");
        return;
    }
    @Override
    public PhanCong timKiem(String maphancong){
        for (int i = 0; i < n; i++) {
            if(dspc[i].getMaPhanCong().equals(maphancong)){
                return dspc[i];
            }
        }
        return null;
    }
    // tien thuong
    @Override
    public double tienThuong(String manhansu){
        int count = 0;
        for(int i = 0; i < n;i++){
            if(dspc[i].getNhanSu().getMaNhanSu().equals(manhansu)){
                count++;
            }
        }
        return count * thuong;
    }
    @Override
    public void in(){
        for (int i = 0; i < n; i++) {
            dspc[i].inThongTinPhanCong();
        }
    }
}
