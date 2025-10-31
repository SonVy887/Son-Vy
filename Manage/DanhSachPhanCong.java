package Manage;
import Interface.*;
import Object.*;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;


public class DanhSachPhanCong {
    private PhanCong[] dspc;
    private int n;
    private DanhSachNhanSu cnns; // chuc nang nhan su
    private DanhSachDuAn cnda; // chuc nang do an
    Scanner sc = new Scanner(System.in);

    public DanhSachPhanCong(DanhSachNhanSu cnns, DanhSachDuAn cnda){
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
    public void addPhancong(PhanCong pc){
        dspc = Arrays.copyOf(dspc, n + 1);
        dspc[n] = pc;
        this.n++;
    }
    // them n phan cong dau tien
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
    public void xoaPhanCong(){
        System.out.print("Nhập mã phân công muốn xóa: ");
        String maphancong = sc.nextLine().toUpperCase();

        for (int i = 0; i < n; i++) {
            if(dspc[i].getMaPhanCong().equals(maphancong)){
                for (int j = i; j < n - 1; j++) 
                    dspc[j] = dspc[j + 1];
                this.n--;
                dspc = Arrays.copyOf(dspc, n);
                return;
            }
        }
        System.out.println("Xóa thất bại");
    }
    public void xoaPhanCong(String maphancong){
        for (int i = 0; i < n; i++) {
            if(dspc[i].getMaPhanCong().equals(maphancong)){
                for (int j = i; j < n - 1; j++) 
                    dspc[j] = dspc[j + 1];
                this.n--;
                dspc = Arrays.copyOf(dspc, n);
                return;
            }
        }
        System.out.println("Xóa thất bại");
    }
    // sua phan cong 
    public void suaPhanCong(){
        System.out.print("Nhập mã phân công: ");
        String maphancong = sc.nextLine().toUpperCase();

        for (int i = 0; i < n; i++) {
            if(dspc[i].getMaPhanCong().equals(maphancong)){
                sua(dspc[i]);
                return;
            }
        }
        System.out.println("Sửa thất bại");
    }
    
    public void suaPhanCong(String maphancong){
        for (int i = 0; i < n; i++) {
            if(dspc[i].getMaPhanCong().equals(maphancong)){
                sua(dspc[i]);
                return;            
            }
        }
        System.out.println("Sửa thất bại");
    }
    // phan cong nhan su lam do an
    public void phanCongDoAn(){
        System.out.print("Nhập mã phân công: ");
        String maphancong = sc.nextLine().toUpperCase();
        PhanCong pc = timKiem(maphancong);
        if(pc == null){
            System.out.println("Phân công chưa tồn tại");
            return;
        }

        System.out.print("Nhập mã nhân sự: ");
        String manhansu = sc.nextLine().toUpperCase();

        NhanSu ns = cnns.timKiem(manhansu);
        if(ns == null){
            System.out.println("Nhân sự chưa tồn tại");
            return;
        }

        System.out.print("Nhập mã đồ án: ");
        String maduan = sc.nextLine().toUpperCase();

        DuAn da = cnda.timDuAn(maduan);
        if(da == null){
            System.out.println("Đồ án chưa tồn tại");
            return;
        }

        System.out.print("Nhập thời gian: ");
        int thoigian = sc.nextInt();sc.nextLine();

        pc.bangDoKho();
        pc.setDuAn(da.getMaDuAn());
        pc.setNhanSu(ns.getMaNhanSu());
        pc.setThoiGian(thoigian);
    }

    // tim kiem ma phan cong
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
    public PhanCong timKiem(String maphancong){
        for (int i = 0; i < n; i++) {
            if(dspc[i].getMaPhanCong().equals(maphancong)){
                return dspc[i];
            }
        }
        return null;
    }
    // tien thuong nhan su làm nhiều dự án
    public double tienThuong(String manhansu){
        int count = 0;
        for(int i = 0; i < n;i++){
            if(dspc[i].getNhanSu().equals(manhansu)){
                count++;
            }
        }
        return count * 500_000;
    }
    public void in(){
        System.out.println("=================================================================");
        System.out.printf("|%-15s|%-15s|%-15s|%15s|%-13s|%-20s|\n","Mã PC","Mã NS","Mã DA","Thời Gian","Độ Khó","Thưởng");
        System.out.println("-----------------------------------------------------------------");

        for (int i = 0; i < n; i++) {
            dspc[i].inThongTinPhanCong();
        }
    }
    // xuat file phan cong
    public void xuatFilePhanCong() {
        try(PrintWriter write = new PrintWriter(new FileWriter("C:\\training\\QuanLyNhanSu\\File\\DanhSachPhanCong.txt"))) {
            write.println("=================================================================");
            write.printf("|%-15s|%-15s|%-15s|%15s|-13s|%-20s\n","Mã PC","Mã NS","Mã DA","Thời Gian","Độ Khó","Thưởng");
            write.println("-----------------------------------------------------------------");
            for(PhanCong p : dspc) {
                write.printf("|%-15s|%-15s|%-15s|%15s|%-13s|%-20.2f|\n",p.getMaPhanCong(),
                p.getNhanSu() == "" ? "Trống" : p.getNhanSu(),
                p.getDuAn() == "" ? "Trống" : p.getDuAn(),p.getThoiGian(),p.getDoKho(), p.getThuong());
            }
        }catch(IOException e) {
            System.out.println("Đã xảy ra lỗi khi xuất file: "+ e.getMessage());
        }
    }
    // sua phu
    public void sua(PhanCong pc) {
        while(true) {
            System.out.println("\n");
            System.out.println("1. Sửa thời gian");
            System.out.println("2. Sửa độ khó");
            System.out.println("0. Để thoát");
            System.out.println("Lựa chọn: ");

            int choice;

            try {
                choice = sc.nextInt();
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Vui lòng nhập số!");
                sc.nextLine();
                continue;
            }

            if(choice == 0) break;

            switch(choice) {
                case 1:    
                    System.out.print("Nhập thời gian mới: ");
                    pc.setThoiGian(sc.nextInt());sc.nextLine();
                    System.out.println("Sửa thành công");break;
                case 2:
                    System.out.print("Chọn độ khó mới: ");
                    pc.bangDoKho();
                    System.out.println("Sửa thành công");break;
            }
        }
    }
}
