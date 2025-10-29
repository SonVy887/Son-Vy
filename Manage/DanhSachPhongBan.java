package Manage;
import java.util.*;
import Object.*;
import Interface.*;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class DanhSachPhongBan implements IPhongBan {
    private PhongBan[] dspb;
    private int n;
    Scanner sc = new Scanner(System.in);

    public DanhSachPhongBan() {
        dspb = new PhongBan[0];
        n = 0;
    }

    //them n phong ban dau tien
    @Override
    public void addSoLuongPhongBan(){
        System.out.println("Nhập n phòng ban đầu tiên: ");
        this.n = sc.nextInt();
        sc.nextLine();

        dspb = new PhongBan[n];
        for(int i = 0; i < n; i++){
            dspb[i] = new PhongBan();
            dspb[i].nhapThongTinPhongBan();
        }
    }
    @Override 
    public void addPhongBan(){// da test

        System.out.print("Vui lòng nhập mã phòng ban để kiểm tra: ");
        while(kiemTraPb(sc.nextLine())){
            System.out.println("Mã phòng ban đã tồn tại");
            System.out.print("Vui lòng nhập lại mã phòng ban: ");
        }

        dspb = Arrays.copyOf(dspb, n + 1);
        dspb[n]= new PhongBan();
        dspb[n].nhapThongTinPhongBan();
        this.n++;
    }
    @Override
    public void addPhongBan(PhongBan pb){
        dspb = Arrays.copyOf(dspb, n + 1);
        dspb[n] = pb;
        n++;
    }
    //sua phong ban
    @Override
    public void suaPhongBan(String maphongban){// chua
        for(int i = 0; i < n;i++){
            if(dspb[i].getMaPhongBan().equals(maphongban)){
                System.out.print("Vui lòng nhập tên mới: ");
                dspb[i].setTenPhongBan(sc.nextLine());
                System.out.print("Vui lòng nhập ngày nhận chức mới: ");
                dspb[i].setNgayNhanChuc(sc.nextLine());
                System.out.println("Sửa thành công");
                return;
            }
        }
        System.out.println("Không tìm thấy phòng ban");
    }
    @Override
    public void suaPhongBan(){
        System.out.print("Nhập mã phòng ban cần sửa: ");
        String maphongban = sc.nextLine().toUpperCase();

        for(int i = 0; i < n;i++){
            if(dspb[i].getMaPhongBan().equals(maphongban)){
                System.out.print("Vui lòng nhập tên mới: ");
                dspb[i].setTenPhongBan(sc.nextLine());
                System.out.print("Vui lòng nhập ngày nhận chức mới: ");
                dspb[i].setNgayNhanChuc(sc.nextLine());
                System.out.println("Sửa thành công");
                return;
            }
        }
        System.out.println("Không tìm thấy phòng ban");
    }
    //xoa phong ban
    @Override
    public void xoaPhongBan(String maphongban){//chua
        for(int i = 0; i < n;i++){
            if(dspb[i].getMaPhongBan().equals(maphongban)){
                for(int j = i; j < n - 1;j++)
                    dspb[j] = dspb[j + 1];
                this.n--;
                dspb = Arrays.copyOf(dspb, n); 
                return;
            }
       }
       System.out.println("Không tìm thấy phòng ban");
    }
    @Override
    public void xoaPhongBan(){// chua test
        System.out.println("Nhập mã phòng ban muốn xóa: ");
        String maphongban = sc.nextLine().toUpperCase();

        for(int i = 0; i < n;i++){
            if(dspb[i].getMaPhongBan().equals(maphongban)){
                for(int j = i; j < n - 1;j++)
                    dspb[j] = dspb[j + 1];
                this.n--;
                dspb = Arrays.copyOf(dspb, n);
                return;
            }
       }
       System.out.println("Không tìm thấy phòng ban");

    }
    // tim phong ban
    @Override
    public void timKiem(){
        System.out.print("Nhập mã phòng ban muốn tìm: ");
        String maphongban = sc.nextLine().toUpperCase();

        for(int i = 0; i < n;i++){
            if(dspb[i].getMaPhongBan().equals(maphongban)){
                dspb[i].inThongTinPhongBan();
                return;
            }
        }
        System.out.println("không tìm thấy phòng ban");
    }
    @Override
    public PhongBan timKiem(String maphongban){

        for(int i = 0; i < n;i++){
            if(dspb[i].getMaPhongBan().equals(maphongban)){
                return dspb[i];
            }
        }
        return null;
    }
    // tim theo ten
    @Override
    public void timKiemTheoTen(){
        System.out.println("Nhập tên phòng ban: ");
        String tenphongban = sc.nextLine();
        boolean found = false;

        for(int i = 0; i < n;i++){
            if(dspb[i].getTenPhongBan().contains(tenphongban)){
                dspb[i].inThongTinPhongBan();
                found = true;
            }
        }
        if(!found) {
            System.out.println("Không tìm thấy tên");
        }
    }
    @Override
    public PhongBan[] timKiemTheoTen(String tenphongban){
        PhongBan[] kq = new PhongBan[0];
        int j = 0;

        for(int i = 0; i < n;i++){
            if(dspb[i].getTenPhongBan().contains(tenphongban)){
                kq = Arrays.copyOf(kq, j + 1);
                kq[j++] = dspb[i];
            }
        }
        return kq;
        
    }
    @Override
    public void setTruongPhong() {
        System.out.print("Nhập mã phòng ban cần có trưởng phòng: ");
        String maphongban = sc.nextLine().toUpperCase();
        PhongBan pb = timKiem(maphongban);// day
        if(pb == null){
            System.out.println("Không tìm thấy phòng ban");
            return;
        }
        System.out.print("Nhập mã nhân sự làm trưởng phòng: ");
        String manhansu = sc.nextLine().toUpperCase();
        NhanSu ns = cnns.timKiem(manhansu);//day
        if(ns == null){
            System.out.println("Không tìm thấy nhân sự");
            return;
        }
        pb.setTruongPhong(ns.getMaNhanSu());
        System.out.print("Nhập ngày nhận chức(dd-MM-yyyy): ");
        pb.setNgayNhanChuc(sc.nextLine());
    }

    // in
    @Override
    public void inThongTin(){
        System.out.println("\n========================================================================================");
        System.out.printf("|%-17s|%-18s|%-14s|%-16s|%-17s|\n","Mã Phòng Ban", "Tên Phòng Ban", "Trưởng Phòng", "Ngày Nhận Chức","Số lượng Nhân Sự");
        System.out.printf("----------------------------------------------------------------------------------------\n");

        for (int i = 0; i < n; i++) {
            dspb[i].inThongTinPhongBan();
        }
    }
    // kiem tra phong ban ton tai
    public boolean kiemTraPb(String maphongban){
        for(int i = 0; i < n;i++){
            if(dspb[i].getMaPhongBan().equals(maphongban)){
                return true;
            }
        }
        return false;
    }
    @Override
    public PhongBan[] getPhongBan() {
        return this.dspb;
    }
    @Override
    public void xuatFilePhongBan() {
        try(PrintWriter write = new PrintWriter(new FileWriter("C:\\training\\QuanLyNhanSu\\File\\DanhSachPhongBan.txt"))) {
            PhongBan[] pb = getPhongBan();
            write.println("========================================================================================");
            write.printf("|%-17s|%-18s|%-14s|%-16s|%-17s|\n","Mã Phòng Ban", "Tên Phòng Ban", "Trưởnng Phòng", "Ngày Nhận Chức");
            write.printf("----------------------------------------------------------------------------------------\n");
            for(PhongBan p : pb) {
                write.printf("|%-17s|%-18s|%-14s|%-16s|\n",
                p.getMaPhongBan(), p.getTenPhongBan(), (p.getTruongPhong() == "" ? "Trong" : p.getTruongPhong()),
                p.getNgayNhanChuc());
            }
        }catch(IOException e) {
            System.out.println("Đã xảy ra lỗi khi xuất file: "+ e.getMessage());
        }
    }
}
