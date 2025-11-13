package DanhSach;
import java.util.*;
import Object.*;
import Interface.*;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class DanhSachPhongBan {
    private PhongBan[] dspb;
    private int n;
    Scanner sc = new Scanner(System.in);

    public DanhSachPhongBan() {
        dspb = new PhongBan[0];
        n = 0;
    }

    //them n phong ban dau tien
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
    public void addPhongBan(){// da test

        System.out.print("Vui lòng nhập mã phòng ban để kiểm tra (VD: PB001): ");
        if(kiemTraPb(sc.nextLine().toUpperCase())){
            System.out.println("Mã phòng ban đã tồn tại");
            return;
        }

        dspb = Arrays.copyOf(dspb, n + 1);
        dspb[n]= new PhongBan();
        dspb[n].nhapThongTinPhongBan();
        this.n++;
    }
    public void addPhongBan(PhongBan pb){
        dspb = Arrays.copyOf(dspb, n + 1);
        dspb[n] = pb;
        n++;
    }
    //sua phong ban
    public void suaPhongBan(String maphongban){// chua
        for(int i = 0; i < n;i++){
            if(dspb[i].getMaPhongBan().equals(maphongban)){
                sua(dspb[i]);
                return;
            }
        }
        System.out.println("Không tìm thấy phòng ban");
    }
    public void suaPhongBan(){
        System.out.print("Nhập mã phòng ban cần sửa (VD: PB001): ");
        String maphongban = sc.nextLine().toUpperCase();

        for(int i = 0; i < n;i++){
            if(dspb[i].getMaPhongBan().equals(maphongban)){
               sua(dspb[i]);
                return;
            }
        }
        System.out.println("Không tìm thấy phòng ban");
    }
    //xoa phong ban
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
    public void xoaPhongBan(){// chua test
        System.out.print("Nhập mã phòng ban muốn xóa (VD: PB001): ");
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
    public void timKiem(){
        System.out.print("Nhập mã phòng ban muốn tìm (VD: PB001): ");
        String maphongban = sc.nextLine().toUpperCase();

        System.out.println("\n======================================================================");
        System.out.printf("|%-17s|%-18s|%-14s|%-16s|\n","Mã Phòng Ban", "Tên Phòng Ban", "Trưởng Phòng", "Ngày Nhận Chức");
        System.out.printf("----------------------------------------------------------------------\n");

        for(int i = 0; i < n;i++){
            if(dspb[i].getMaPhongBan().equals(maphongban)){
                dspb[i].inThongTinPhongBan();
                System.out.println("======================================================================");
                return;
            }
        }
        System.out.println("không tìm thấy phòng ban");
    }
    public PhongBan timKiem(String maphongban){

        for(int i = 0; i < n;i++){
            if(dspb[i].getMaPhongBan().equals(maphongban)){
                return dspb[i];
            }
        }
        return null;
    }
    // tim theo ten
    public void timKiemTheoTen(){
        System.out.print("Nhập tên phòng ban: ");
        String tenphongban = sc.nextLine();
        boolean found = false;

        System.out.println("\n======================================================================");
        System.out.printf("|%-17s|%-18s|%-14s|%-16s|\n","Mã Phòng Ban", "Tên Phòng Ban", "Trưởng Phòng", "Ngày Nhận Chức");
        System.out.printf("----------------------------------------------------------------------\n");

        for(int i = 0; i < n;i++){
            if(dspb[i].getTenPhongBan().contains(tenphongban)){
                dspb[i].inThongTinPhongBan();
                found = true;
            }
        }
        System.out.println("======================================================================");
        if(!found) {
            System.out.println("Không tìm thấy tên");
        }
    }
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
    // tim kiem truong phong
    public void tiemKiemTruongPhong() {
        System.out.println("Nhập mã trưởng phòng (VD:NS001): ");
        String matrp = sc.nextLine().toUpperCase();

        for(int i = 0; i < n;i++) {
            if(dspb[i].getTruongPhong().equals(matrp)) {
                dspb[i].inThongTinPhongBan();
            }
        }
    }
    public PhongBan tiemKiemTRP(String matrp) {
        for(int i = 0; i < n;i++) {
            if(dspb[i].getTruongPhong().equals(matrp)) {
                return dspb[i];
            }
        }
        return null;
    }
    // in
    public void inThongTin(){
        System.out.println("\n======================================================================");
        System.out.printf("|%-17s|%-18s|%-14s|%-16s|\n","Mã Phòng Ban", "Tên Phòng Ban", "Trưởng Phòng", "Ngày Nhận Chức");
        System.out.printf("----------------------------------------------------------------------\n");

        for (int i = 0; i < n; i++) {
            dspb[i].inThongTinPhongBan();
        }
        System.out.println("======================================================================");
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
    // thong ke pb chua co trp 
    public void thongKePhongBan() {
        System.out.println("\n========== THỐNG KÊ PHÒNG BAN ===========");
        System.out.println("\n======================================================================");
        System.out.printf("|%-17s|%-18s|%-14s|%-16s|\n","Mã Phòng Ban", "Tên Phòng Ban", "Trưởng Phòng", "Ngày Nhận Chức");
        System.out.printf("----------------------------------------------------------------------\n");
        
        for(int i = 0; i < n;i++) {
            if(dspb[i].getTruongPhong().equals("Trống")) {
                dspb[i].inThongTinPhongBan();
            }
        }
    }
    // xuat file phong ban
    public void xuatFilePhongBan() {
        try(PrintWriter write = new PrintWriter(new FileWriter("C:\\training\\QuanLyNhanSu\\File\\DanhSachPhongBan.txt"))) {
            write.println("======================================================================");
            write.printf("|%-17s|%-18s|%-14s|%-16s|\n","Mã Phòng Ban", "Tên Phòng Ban", "Trưởnng Phòng", "Ngày Nhận Chức");
            write.printf("----------------------------------------------------------------------\n");
            for(PhongBan p : dspb) {
                write.printf("|%-17s|%-18s|%-14s|%-16s|\n",
                p.getMaPhongBan(), p.getTenPhongBan(), (p.getTruongPhong() !=null ? p.getTruongPhong() : "Trống"),
                p.getNgayNhanChuc() != null ? p.getNgayNhanChuc() : "Trống");
            }
        }catch(IOException e) {
            System.out.println("Đã xảy ra lỗi khi xuất file: "+ e.getMessage());
        }
    }
    // doc file
    public void docFilePhongBan() {
        try(BufferedReader br = new BufferedReader(new FileReader("C:\\training\\QuanLyNhanSu\\File\\DanhSachPhongBan.txt"))) {
            br.readLine();
            br.readLine();
            br.readLine();

            String line;
            while((line = br.readLine()) != null) {
                String[] info = line.split("\\|");
                String maphongban = info[1].trim();
                String tenphongban = info[2].trim();
                String matruongphong = info[3].trim();
                String ngaynhanchuc = info[4].trim();

                addPhongBan(new PhongBan(maphongban, tenphongban, matruongphong, ngaynhanchuc));
            }

        }catch(IOException e) {
            System.out.println("Không có dữ liệu từ file" + e.getMessage());
        }
    }
    // sua phu
    public void sua(PhongBan pb) {
        while(true) {
            System.out.println("\n========== CHỨC NĂNG SỬA =========");
            System.out.println("1. Sửa tên phòng ban");
            System.out.println("2. Sửa ngày nhận chức");
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

            switch(choice) {
                case 1: System.out.print("Nhập tên phòng ban mới: ");
                    pb.setTenPhongBan(sc.nextLine());
                    System.out.println("Sửa thành công");break;
                case 2: System.out.println("Nhập ngày nhận chức mới(dd/MM/yyyy): ");
                    pb.setNgayNhanChuc(sc.nextLine());
                    System.out.println("Sửa thành công");break;
            }
        }
    }
}
