package Manage;

import Interface.*;
import Object.*;
import Manage.*;

import java.util.Arrays;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class DanhSachBangChamCongNgay {
    private BangChamCongNgay[] bccn;
    private int n; 
    private DanhSachNhanSu cnns;
    Scanner sc = new Scanner(System.in);


    public DanhSachBangChamCongNgay(DanhSachNhanSu cnns) {
        bccn = new BangChamCongNgay[0];
        this.n = 0;
        this.cnns = cnns;
    }
    // kiem tra
    public boolean kiemTra(String machamcong){
        for(int i = 0; i < n;i++){
            if(bccn[i].getMaChamCong().equals(machamcong)){
                return true;
            }
        }
        return false;
    }
    // them 
    public void themBangChamCongNgay() {
        System.out.print("Vui lòng nhập mã chấm công ngày: ");
        while(kiemTra(sc.nextLine())){
            System.out.println("Mã chấm công ngày đã tồn tại");
            System.out.print("Vui lòng nhập lại: ");
        }

        bccn = Arrays.copyOf(bccn, n + 1);
        bccn[n] = new BangChamCongNgay();
        bccn[n].nhap();
        this.n++;
    }
    public void themBangChamCongNgay(BangChamCongNgay bccn1) {
        bccn = Arrays.copyOf(bccn, n + 1);
        bccn[n] = bccn1;
        this.n++;
    } 
    public void them() {
        System.out.print("Nhập n chấm công ngày đầu tiên: ");
        this.n = sc.nextInt();
        sc.nextLine();

        bccn = new BangChamCongNgay[n];
        for(int i = 0; i < n;i++){
            bccn[i] = new BangChamCongNgay();
            bccn[i].nhap();
        }
    }

    // xoa
    public void xoaBangChamCongNgay() {
        System.out.print("Nhập mã chấm công ngày: ");
        String machamcong = sc.nextLine().toUpperCase();

        for(int i = 0; i < n;i++){
            if(bccn[i].getMaChamCong().equals(machamcong)){
                for(int j = i; j < n - 1;j++)
                    bccn[j] = bccn[j + 1];
                this.n--;
                bccn = Arrays.copyOf(bccn, n);
                return;
            }
        }
        System.out.println("Xóa thất bại");
    } 
    public void xoaBangChamCongNgay(String machamcong) {
        for(int i = 0; i < n;i++){
            if(bccn[i].getMaChamCong().equals(machamcong)){
                for(int j = i; j < n - 1;j++)
                    bccn[j] = bccn[j + 1];
                this.n--;
                bccn = Arrays.copyOf(bccn, n);
                return;
            }
        }
        System.out.println("Xóa thất bại");
    }
    public void suaBangChamCongNgay() {
        System.out.print("Nhập mã chấm công ngày: ");
        String machamcong = sc.nextLine().toUpperCase();

        for (int i = 0; i < n; i++) {
            if(bccn[i].getMaChamCong().equals(machamcong)){
                sua(bccn[i]);
                return;
            }
        }
        System.out.println("Sửa thất bại");
    } 
    public void suaBangChamCongNgay(String machamcong){
        for(int i = 0; i < n; i++) {
            if(bccn[i].getMaChamCong().equals(machamcong)){
                sua(bccn[i]);
                return;
            }
        }
        System.out.println("Sửa thất bại");
    }
    public void timKiem() {
        System.out.print("Nhập mã chấm công ngày: ");
        String machamcong = sc.nextLine().toUpperCase();

        for(int i = 0; i < n; i++) {
            if(bccn[i].getMaChamCong().equals(machamcong)){
                bccn[i].in();
                return;
            }
        }
        System.out.println("Tìm kiếm thất bại");
    } 
    public BangChamCongNgay timKiem(String machamcong) {
        for(int i = 0; i < n; i++) {
            if(bccn[i].getMaChamCong().equals(machamcong)){
                return bccn[i];
            }
        }
        return null;
    }
    public void chamCongNhanSu() {
        System.out.print("Nhập mã nhân sự: ");
        String manhansu = sc.nextLine().toUpperCase();

        NhanSu ns = cnns.timKiem(manhansu);
        if(ns == null) {
            System.out.println("Nhân sự chưa được tạo");
            return;
        }
        
        System.out.print("Nhập mã bảng chấm công ngày: ");
        String machamcong = sc.nextLine().toUpperCase();

        BangChamCongNgay bccn = timKiem(machamcong);
        if(bccn == null) {
            System.out.println("Bảng chấm công chưa tồn tại");
            return;
        }

        bccn.nhap();
        System.out.print("Nhập ngày vào làm(dd/MM/yyyy): ");
        bccn.setNgayLamViec(sc.nextLine());
        bccn.bangTrangThai();
        bccn.setMaNhanSu(ns.getMaNhanSu());
        System.out.println("Chấm công thành công");
    }
    // xuat file bang cham cong
    public void xuatFileBangChamCongNgay() {
        try(PrintWriter write= new PrintWriter(new FileWriter("C:\\training\\QuanLyNhanSu\\File\\DanhSachBangChamCongNgay.txt"))) {
            write.println("\n=============================================================================================================================");
            write.printf("|%-15s|%-15s|%-18s|%-10s\n","Mã Chấm Công","Mã Nhân Sự","Ngày Làm Việc","Trạng Thái");
            write.println("------------------------------------------------------------------------------------------------------------------------------");
            for(BangChamCongNgay c : bccn) {
                write.printf("|%-15s|%-15s|%-18s|%-10s\n",
                c.getMaChamCong() == "" ? "Trống" : c.getMaChamCong(),
                c.getMaNhanSu() == "" ? "Trống" : c.getMaNhanSu(),
                c.getNgayLamViec() == "" ? "Trống" : c.getNgayLamViec(),
                c.getStatus() == "" ? "Trống" : c.getStatus());
            }
        }catch(IOException e) {
            System.out.println("Đã xảy ra lỗi khi xuất file: "+ e.getMessage());
        }
    }
    // in
    public void inBangChamCongNgay() {
        System.out.println("\n=============================================================================================================================");
        System.out.printf("|%-15s|%-15s|%-18s|%-10s\n","Mã Chấm Công","Mã Nhân Sự","Ngày Làm Việc","Trạng Thái");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");

        for (int i = 0; i < n; i++) {
            bccn[i].in();
        }
    }
    // lấy ngày công
    public int tongNgayCong(String manhansu) {
        int tongngaydilam = 0;
        for(int i = 0; i < n;i++){
            if(bccn[i].getMaNhanSu().equals(manhansu) && bccn[i].getStatus().equals("Đi làm")){
                tongngaydilam++;
            }
        }
        return tongngaydilam;
    }
    
    // hàm phụ
    public void sua(BangChamCongNgay bccn) {
        while(true){
            System.out.println("1. Sửa ngày làm việc");
            System.out.println("2. Sửa status");
            System.out.println("0. Để thoát");
            System.out.print("Lựa chọn: ");

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

            switch(choice){
                case 1:
                    System.out.print("Nhập ngày vào làm mới: ");
                    bccn.setNgayLamViec(sc.nextLine());
                    System.out.println("Sửa thành công");
                    break;
                case 2:
                    System.out.print("Chọn trạng thới mới để sửa: ");
                    bccn.bangTrangThai();
                    System.out.println("Sửa thành công");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}
