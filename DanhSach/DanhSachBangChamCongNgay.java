package DanhSach;
import Object.*;

import java.util.Arrays;
import java.util.Scanner;

import DanhSach.*;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class DanhSachBangChamCongNgay {
    private BangChamCongNgay[] bccn;
    private int n; 
    Scanner sc = new Scanner(System.in);


    public DanhSachBangChamCongNgay() {
        bccn = new BangChamCongNgay[0];
        this.n = 0;
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
        System.out.print("Vui lòng nhập mã chấm công ngày (VD: CC001): ");
        if(kiemTra(sc.nextLine().toUpperCase())){
            System.out.println("Mã chấm công ngày đã tồn tại");
            return;
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
        System.out.print("Nhập mã chấm công ngày (VD: CC001): ");
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
        System.out.print("Nhập mã chấm công ngày (VD: CC001): ");
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
        System.out.print("Nhập mã chấm công ngày (VD: CC001): ");
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
    // tim kiem theo ma nhan su trong bang cham cong ngay
    public BangChamCongNgay timKiemNSCCN(String manhansu, int thang, int nam) {
        for(int i = 0; i < n;i++) {
            if(bccn[i].getMaNhanSu().equals(manhansu)
            && bccn[i].getThang() == thang && bccn[i].getNam() == nam) {
                return bccn[i];
            }
        }
        return null;
    }
    // tinh ngày làm và nghỉ
    public int[] tinhNgay(String manhansu, int thang, int nam) {
        int tongngaylam = 0;

        for(int i = 0; i < n;i++) {
            if(bccn[i].getMaNhanSu().equals(manhansu) 
            && bccn[i].getThang() == thang && bccn[i].getNam() == nam
            && bccn[i].getStatus().equalsIgnoreCase("Đi làm")) {
                tongngaylam++;
            }
        }
        return new int[] { tongngaylam, 26 - tongngaylam};
    }

    // thhong ke theo nam
    public void thongKeChamCongNgay() {
        int dilam = 0;
        int nghikhongphep = 0;
        int nghiphep = 0;
        int nghibenh = 0;

        for(int i = 0; i < n;i++) {
            if(bccn[i].getStatus().equals("Đi làm")) dilam++;
            else if(bccn[i].getStatus().equals("Nghỉ bệnh")) nghibenh++;
            else if(bccn[i].getStatus().equals("Nghỉ có phép")) nghiphep++;
            else if(bccn[i].getStatus().equals("Nghỉ không phép")) nghikhongphep++;
        }

        System.out.println("\n========== THỐNG KÊ BẢNG CHẤM CÔNG NGÀY ==========");
        System.out.println("Tổng số ngày đi làm trong 1 năm là: " + dilam);
        System.out.println("Tổng số ngày nghỉ không phép trong 1 năm là: " + nghikhongphep);
        System.out.println("Tổng số ngày nghỉ phép trong 1 năm là: " + nghiphep);
        System.out.println("Tổng số ngày nghỉ bệnh trong 1 năm là: " + nghibenh);
    }
    // xuat file bang cham cong
    public void xuatFileBangChamCongNgay() {
        try(PrintWriter write= new PrintWriter(new FileWriter("C:\\training\\QuanLyNhanSu\\File\\DanhSachBangChamCongNgay.txt"))) {
            write.println("===================================================================================");
            write.printf("|%-15s|%-15s|%-10s|%-10s|%-10s|%-16s|\n","Mã Chấm Công","Mã Nhân Sự","Ngày", "Tháng", "Năm","Trạng Thái");
            write.println("-----------------------------------------------------------------------------------");
            for(BangChamCongNgay c : bccn) {
                write.printf("|%-15s|%-15s|%-10s|%-10s|%-10s|%-16s|\n",
                c.getMaChamCong() == "" ? "Trống" : c.getMaChamCong(),
                c.getMaNhanSu() == "" ? "Trống" : c.getMaNhanSu(),
                c.getNgay(), c.getThang(), c.getNam(),
                c.getStatus() == "" ? "Trống" : c.getStatus());
            }
        }catch(IOException e) {
            System.out.println("Đã xảy ra lỗi khi xuất file: "+ e.getMessage());
        }
    }
    public void docFileBangChamCongNgay() {
        try(BufferedReader br = new BufferedReader(new FileReader("C:\\training\\QuanLyNhanSu\\File\\DanhSachBangChamCongNgay.txt"))) {
            br.readLine();
            br.readLine();
            br.readLine();

            String line;

            while((line = br.readLine()) != null) {
                String[] info = line.split("\\|");

                String machamcong = info[1].trim();
                String manhansu = info[2].trim();
                int ngay = Integer.parseInt(info[3].trim());
                int thang = Integer.parseInt(info[4].trim());
                int nam = Integer.parseInt(info[5].trim());
                String status = info[6].trim();

                themBangChamCongNgay(new BangChamCongNgay(machamcong, manhansu, ngay, thang, nam, status));

            }
        }catch(IOException e) {
            System.out.println("Không có dữ liệu trong file" + e.getMessage());
        }
    }
    // in
    public void inBangChamCongNgay() {
        System.out.println("\n===================================================================================");
        System.out.printf("|%-15s|%-15s|%-10s|%-10s|%-10s|%-16s|\n","Mã Chấm Công","Mã Nhân Sự","Ngày", "Tháng", "Năm", "Trạng Thái");
        System.out.println("-----------------------------------------------------------------------------------");

        for (int i = 0; i < n; i++) {
            bccn[i].in();
        }
    }
    // hàm phụ
    public void sua(BangChamCongNgay bccn) {
        while(true){
            System.out.println("1. Sửa ngày");
            System.out.println("2. Sửa tháng");
            System.out.println("3. Sửa năm");
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
                    System.out.print("Nhập ngày mới: ");
                    bccn.setNgay(sc.nextInt());sc.nextLine();
                    System.out.println("Sửa thành công");
                    break;
                case 2:
                    System.out.print("Nhập tháng mới: ");
                    bccn.setThang(sc.nextInt());sc.nextLine();
                    System.out.println("Sửa thành công");
                    break;
                case 3: 
                    System.out.print("Nhập năm mới: ");
                    bccn.setNam(sc.nextInt());sc.nextLine();
                    System.out.println("Sửa thành công");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
                    sua(bccn);break;
            }
        }
    }
}
