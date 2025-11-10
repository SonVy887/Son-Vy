package DanhSach;
import Object.*;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;


public class DanhSachPhanCong {
    private PhanCong[] dspc;
    private int n;
    Scanner sc = new Scanner(System.in);

    public DanhSachPhanCong(){
        dspc = new PhanCong[0];
        this.n = 0;
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
        System.out.print("Vui lòng nhập mã phân công để kiểm tra (VD: PC001): ");
        if(kiemTra(sc.nextLine().toUpperCase())){
            System.out.println("Mã phân công đã tồn tại");
            return;
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
        System.out.print("Nhập mã phân công muốn xóa (VD: PC001): ");
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
        System.out.print("Nhập mã phân công (VD: PC001): ");
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
    // tim kiem ma phan cong
    public void timKiem(){
        System.out.print("Nhập mã phân công (VD: PC001): ");
        String maphancong = sc.nextLine().toUpperCase();

        for(int i = 0;i < n;i++){
            if(dspc[i].getMaPhanCong().equals(maphancong)){
                dspc[i].inThongTinPhanCong();
                return;
            }
        }
        System.out.println("Không tìm thấy");
    }
    public PhanCong timKiem(String maphancong){
        for (int i = 0; i < n; i++) {
            if(dspc[i].getMaPhanCong().equals(maphancong)){
                return dspc[i];
            }
        }
        return null;
    }
    // in
    public void in(){
        System.out.println("=====================================================================================");
        System.out.printf("|%-10s|%-10s|%-10s|%15s|%13s|%20s|\n","Mã PC","Mã NS","Mã DA","Thời Gian","Độ Khó","Thưởng");
        System.out.println("-------------------------------------------------------------------------------------");

        for (int i = 0; i < n; i++) {
            dspc[i].inThongTinPhanCong();
        }
    }
    // tim kiem theo do kho
    public void timKiemTheoDoKho() {
        System.out.print("Nhập độ khó tìm kiếm: ");
        String dokho = sc.nextLine();

        for(int i = 0; i < n;i++) {
            if(dspc[i].getDoKho().equalsIgnoreCase(dokho)) {
                dspc[i].inThongTinPhanCong();
            }
        }
    }
    public void timKiemTheoDoKho(String dokho) {
        for(int i = 0; i < n;i++) {
             if(dspc[i].getDoKho().equalsIgnoreCase(dokho)) {
                dspc[i].inThongTinPhanCong();
            }
        }
    }
    // tien thuong nhan su làm dự án
    public double tienThuong(String manhansu){
        for(int i = 0; i < n;i++) {
            if(dspc[i].getNhanSu().equals(manhansu)) {
                return dspc[i].getThuong();
            }
        }
        return 0.0;
    }
    // thống kê thời gian lamf dự án
    public void thongKePhanCongTG() {
        int max = 0;
        int tong = 0;
        int min = dspc[0].getThoiGian();

        for(int i = 0; i < n;i++) {
            tong += dspc[i].getThoiGian();

            if(dspc[i].getThoiGian() > max ) {
                max= dspc[i].getThoiGian();
            }else if(dspc[i].getThoiGian() < min ) {
                min = dspc[i].getThoiGian();
            }
        }
        System.out.println("\n========== THỐNG KÊ PHÂN CÔNG ==========");
        System.out.println("Tổng thời gian là: " + tong + " tháng");
        System.out.println("Thời gian lâu nhất của 1 dự án là: " + max + " tháng");
        System.out.println("Thời gian trung bình của 1 dự án là: " + tong/n + " tháng");
        System.out.println("Thời gian nhanh nhất của 1 dự án là: " + min + " tháng");

        for(int i = 0; i < n;i++) {
            if(dspc[i].getThoiGian() == max) {
                System.out.println("Dự án " + dspc[i].getDuAn() + " có thời gian lâu nhất");
            } else if(dspc[i].getThoiGian() == min) {
                System.out.println("Dự án " + dspc[i].getDuAn() + " có thời gian làm nhanh nhất");
            }
        }
    }
    // thống kê số tiền
    public void thongKeSoTien() {
        double max = 0;
        double tong = 0;
        double min = dspc[0].getThuong();

        for (int i = 0; i < n; i++) {
            tong += dspc[i].getThuong();

            if(dspc[i].getThuong() > max) {
                max = dspc[i].getThuong();
            }else if(dspc[i].getThuong() < min) {
                min = dspc[i].getThuong();
            }
        }

        System.out.println("\n========== THỐNG KÊ PHÂN CÔNG ==========");
        System.out.printf("Tổng số tiền thưởng là: %,.0f VNĐ%n", tong);
        System.out.printf("Thưởng dự án cao nhất là: %,.0f VNĐ%n", max);
        System.out.printf("Thưởng trung bình là: %,.0f VNĐ%n", tong/n);
        System.out.printf("Thưởng dự án thấp nhất là: %,.0f VNĐ%n", min);

        for (int i = 0; i < n; i++) {
            if(dspc[i].getThuong() == max) {
                System.out.println("Dự án " + dspc[i].getDuAn() + " có mức thưởng cao nhất");
            }else if(dspc[i].getThuong() == min) {
                System.out.println("Dự án " + dspc[i].getDuAn() + " có mức thưởng thấp nhất");
            }
        }
    }
    // xuat file phan cong
    public void xuatFilePhanCong() {
        try(PrintWriter write = new PrintWriter(new FileWriter("C:\\training\\QuanLyNhanSu\\File\\DanhSachPhanCong.txt"))) {
            write.println("=====================================================================================");
            write.printf("|%-10s|%-10s|%-10s|%-15s|%-13s|%20s|\n","Mã PC","Mã NS","Mã DA","Thời Gian","Độ Khó","Thưởng");
            write.println("-------------------------------------------------------------------------------------");
            for(PhanCong p : dspc) {
                write.printf("|%-10s|%-10s|%-10s|%-9s tháng|%-13s|%,17.0fVNĐ|\n",p.getMaPhanCong(),
                p.getNhanSu() == "" ? "Trống" : p.getNhanSu(),
                p.getDuAn() == "" ? "Trống" : p.getDuAn(),p.getThoiGian(),p.getDoKho(), p.getThuong());
            }
        }catch(IOException e) {
            System.out.println("Đã xảy ra lỗi khi xuất file: "+ e.getMessage());
        }
    }
    // doc file
    public void docFilePhanCong() {
        try(BufferedReader br = new BufferedReader(new FileReader("C:\\training\\QuanLyNhanSu\\File\\DanhSachPhanCong.txt"))) {
            br.readLine();
            br.readLine();
            br.readLine();

            String line;

            while((line = br.readLine()) != null) {
                String[] info = line.split("\\|");

                String maphancong = info[1].trim();
                String manhansu = info[2].trim();
                String maduan = info[3].trim();
                String[] info1 = info[4].split("");
                int thoigian = Integer.parseInt(info1[0].trim());
                String dokho = info[5].trim();
                double thuong = Double.parseDouble(info[6].trim().replace("VNĐ","").replace(",",""));

                addPhancong(new PhanCong(maphancong, manhansu, maduan, thoigian, thuong, dokho));
            }
        }catch(Exception e) {
            System.out.println("Không có dữ liệu từ file" + e.getMessage());
        } 
    }
    // sua phu
    public void sua(PhanCong pc) {
        while(true) {
            System.out.println("\n========== CHỨC NĂNG SỬA ==========");
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
