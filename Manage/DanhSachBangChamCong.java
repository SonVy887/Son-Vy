package Manage;

import Interface.*;
import Object.*;
import Manage.*;

import java.util.Arrays;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class DanhSachBangChamCong implements IBangChamCong {
    private BangChamCong[] bcc;
    private int n; 
    private INhanSu cnns;
    Scanner sc = new Scanner(System.in);


    public DanhSachBangChamCong(INhanSu cnns) {
        bcc = new BangChamCong[0];
        this.n = 0;
        this.cnns = cnns;
    }
    // kiem tra
    public boolean kiemTra(String machamcong){
        for(int i = 0; i < n;i++){
            if(bcc[i].getMaChamCong().equals(machamcong)){
                return true;
            }
        }
        return false;
    }
    // them 
    @Override
    public void themBangChamCong() {
        System.out.print("Vui lòng nhập mã chấm công: ");
        while(kiemTra(sc.nextLine())){
            System.out.println("Mã chấm công đã tồn tại");
            System.out.print("Vui lòng nhập lại: ");
        }

        bcc = Arrays.copyOf(bcc, n + 1);
        bcc[n] = new BangChamCong();
        bcc[n].nhap();
        this.n++;
    }
    @Override
    public void themBangChamCong(BangChamCong bcc1) {
        bcc = Arrays.copyOf(bcc, n + 1);
        bcc[n] = bcc1;
        this.n++;
    }
    @Override 
    public void them() {
        System.out.print("Nhập n chấm công đầu tiên: ");
        this.n = sc.nextInt();
        sc.nextLine();

        bcc = new BangChamCong[n];
        for(int i = 0; i < n;i++){
            bcc[i] = new BangChamCong();
            bcc[i].nhap();
        }
    }

    // xoa
    @Override
    public void xoaBangChamCong() {
        System.out.print("Nhập mã chấm công: ");
        String machamcong = sc.nextLine();

        for(int i = 0; i < n;i++){
            if(bcc[i].getMaChamCong().equals(machamcong)){
                for(int j = i; j < n - 1;j++)
                    bcc[j] = bcc[j + 1];
                this.n--;
                bcc = Arrays.copyOf(bcc, n);
                return;
            }
        }
        System.out.println("Xóa thất bại");
    }
    @Override 
    public void xoaBangChamCong(String machamcong) {
        for(int i = 0; i < n;i++){
            if(bcc[i].getMaChamCong().equals(machamcong)){
                for(int j = i; j < n - 1;j++)
                    bcc[j] = bcc[j + 1];
                this.n--;
                bcc = Arrays.copyOf(bcc, n);
                return;
            }
        }
        System.out.println("Xóa thất bại");
    }
    @Override
    public void suaBangChamCong() {
        System.out.print("Nhập mã chấm công: ");
        String machamcong = sc.nextLine();

        for (int i = 0; i < n; i++) {
            if(bcc[i].getMaChamCong().equals(machamcong)){
                sua(bcc[i]);
                return;
            }
        }
        System.out.println("Sửa thất bại");
    }
    @Override 
    public void suaBangChamCong(String machamcong){
        for(int i = 0; i < n; i++) {
            if(bcc[i].getMaChamCong().equals(machamcong)){
                sua(bcc[i]);
                return;
            }
        }
        System.out.println("Sửa thất bại");
    }
    @Override
    public void timKiem() {
        System.out.print("Nhập mã chấm công: ");
        String machamcong = sc.nextLine();

        for(int i = 0; i < n; i++) {
            if(bcc[i].getMaChamCong().equals(machamcong)){
                bcc[i].in();
                return;
            }
        }
        System.out.println("Tìm kiếm thất bại");
    }
    @Override 
    public BangChamCong timKiem(String machamcong) {
        for(int i = 0; i < n; i++) {
            if(bcc[i].getMaChamCong().equals(machamcong)){
                return bcc[i];
            }
        }
        return null;
    }
    @Override
    public void setNhanSuCc() {
        System.out.print("Nhập mã nhân sự: ");
        String manhansu = sc.nextLine().toUpperCase();

        NhanSu ns = cnns.timKiem(manhansu);
        if(ns == null) {
            System.out.println("Nhân sự chưa được tạo");
            return;
        }
        
        System.out.print("Nhập mã bảng chấm công: ");
        String machamcong = sc.nextLine();

        BangChamCong bcc = timKiem(machamcong);
        if(bcc == null) {
            System.out.println("Bảng chấm công chưa tồn tại");
            return;
        }
        bcc.setNhanSu(ns);
        System.out.print("Nhập tổng ngày công: ");
        bcc.setTongNgayCong(sc.nextInt());sc.nextLine();

        System.out.print("Nhập số ngày nghỉ phép: ");
        bcc.setNghiPhep(sc.nextInt());sc.nextLine();

        System.out.print("Nhập số ngày nghỉ ốm: ");
        bcc.setNghiOm(sc.nextInt());sc.nextLine();

        System.out.print("Nhập số ngày nghỉ không phép: ");
        bcc.setNghiKhongPhep(sc.nextInt());sc.nextLine();

    }
    // tra ve danh sach ban cham cong
    @Override
    public BangChamCong[] getBangChamCong() {
        return this.bcc;
    }
    // xuat file bang cham cong
    public void xuatFileBangChamCong() {
        try(PrintWriter write= new PrintWriter(new FileWriter("C:\\training\\QuanLyNhanSu\\File\\DanhSachBangChamCong.txt"))) {
            BangChamCong[] bcc = getBangChamCong();
            write.println("=============================================================================================================================");
            write.printf("|%-15s|%-20s|%-18s|%-20s|%-15s|%-15s|%-15s|\n","Mã NV", "Họ và tên", "Phòng ban", "Tổng ngày công", "Nghỉ Phép", "Nghỉ Ốm", "Nghỉ KP");
            write.println("------------------------------------------------------------------------------------------------------------------------------");
            for(BangChamCong c : bcc) {
                write.printf("|%-15s|%-20s|%-18s|%-15d Ngày|%-10d Ngày|%-10d Ngày|%-10d Ngày|\n",
                c.getNhanSu() == null ? "Trống" : c.getNhanSu().getMaNhanSu(),
                c.getNhanSu() == null ? "Trống" : c.getNhanSu().getHoNhanSu() + " " + c.getNhanSu().getTenNhanSu(),
                c.getNhanSu() == null ? "Trống" : c.getNhanSu().getPhongBan(),
                c.getTongNgayCong(), c.getNghiPhep(), c.getNghiOm(), c.getNghiKhongPhep());
            }
        }catch(IOException e) {
            System.out.println("Đã xảy ra lỗi khi xuất file: "+ e.getMessage());
        }
    }
    // in
    @Override
    public void inBangChamCong() {
        System.out.println("\n=============================================================================================================================");
        System.out.printf("|%-15s|%-20s|%-18s|%-20s|%-15s|%-15s|%-15s|\n","Mã NV", "Họ và tên", "Phòng ban", "Tổng ngày công", "Nghỉ Phép", "Nghỉ Ốm", "Nghỉ KP");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");

        for (int i = 0; i < n; i++) {
            bcc[i].in();
        }
    }
    // lấy ngày công
    public int tongNgayCong(String manhansu) {
        for(int i = 0; i < n;i++){
            if(bcc[i].getNhanSu().getMaNhanSu().equals(manhansu)){
                return bcc[i].getTongNgayCong();
            }
        }
        return 0;
    }
    // hàm phụ
    public void sua(BangChamCong bcc) {
        while(true){
            System.out.println("1. Sửa tổng ngày công");
            System.out.println("2. Sửa nghỉ phép");
            System.out.println("3. Sửa nghỉ ốm");
            System.out.println("4. Sửa nghỉ không phép");
            System.out.println("0. Để thoát");
            System.out.print("Lựa chọn: ");

            int choice = sc.nextInt();
            sc.nextLine(); 
            if(choice == 0) break;

            switch(choice){
                case 1:
                    System.out.print("Nhập tổng ngày công mới: ");
                    bcc.setTongNgayCong(sc.nextInt());
                    sc.nextLine();
                    System.out.println("Sửa thành công");
                    break;
                case 2:
                    System.out.print("Nhập số ngày nghỉ phép mới: ");
                    bcc.setNghiPhep(sc.nextInt());
                    sc.nextLine();
                    System.out.println("Sửa thành công");
                    break;
                case 3:
                    System.out.print("Nhập số ngày nghỉ ốm mới: ");
                    bcc.setNghiOm(sc.nextInt());
                    sc.nextLine();
                    System.out.println("Sửa thành công");
                    break;
                case 4:
                    System.out.print("Nhập số ngày nghỉ không phép mới: ");
                    bcc.setNghiKhongPhep(sc.nextInt());
                    sc.nextLine();
                    System.out.println("Sửa thành công");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}
