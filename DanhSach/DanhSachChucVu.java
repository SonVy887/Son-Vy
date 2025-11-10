package DanhSach;
import Object.*;
import java.util.Scanner;
import java.util.Arrays;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;


public class DanhSachChucVu {
    private ChucVu[] dscv;
    private int n;
    Scanner sc = new Scanner(System.in);


    public DanhSachChucVu(){
        dscv = new ChucVu[0];
        this.n = 0;
    }


    boolean kiemTra(String machucvu) {
        for(int i = 0; i < n;i++) {
            if(dscv[i].getMaChucVu().equals(machucvu)) {
                return true;
            }
        }
        return false;
    }
    // them
    public void themBangChucVu() {
        System.out.print("Vui lòng nhập mã để kiểm tra (VD: CV001): ");
        if(kiemTra(sc.nextLine().toUpperCase())) {
            System.out.println("Mã chức vụ đã tồn tại!");
            return;
        }

        dscv = Arrays.copyOf(dscv, n + 1);
        dscv[n] = new ChucVu();
        dscv[n].nhapChucVu();
        this.n++;
    }
    public void themBangChucVu(ChucVu cv) {
        dscv = Arrays.copyOf(dscv, n + 1);
        dscv[n] = cv;
        this.n++;
    }

    public void them() {
        System.out.print("Vui lòng nhập n chức vụ đầu tiên: ");
        this.n = sc.nextInt();

        dscv = new ChucVu[n];

        for(int i = 0; i < n;i++) {
            dscv[i]= new ChucVu();
            dscv[i].nhapChucVu();
        }
    }
    // xoa 
    public void xoaBangChucVu() {
        System.out.print("Vui nhập mã chức vụ để xóa: ");
        String machucvu = sc.nextLine().toUpperCase();

        for(int i = 0; i < n;i++) {
            if(dscv[i].getMaChucVu().equals(machucvu)) {
                for(int j = i; j < n - 1; j++) {
                    dscv[j] = dscv[j++];
                }
                this.n--;
                dscv = Arrays.copyOf(dscv, n);
                return;
            }
        }
    }
    public void xoaBangChucVu(String machucvu) {
        for(int i = 0; i < n;i++) {
            if(dscv[i].getMaChucVu().equals(machucvu)) {
                for(int j = i; j < n - 1; j++) {
                    dscv[j] = dscv[j++];
                }
                this.n--;
                dscv = Arrays.copyOf(dscv, n);
                return;
            }
        }
    }
    // sua
    public void suaBangChucVu() {
        System.out.print("Vui lòng nhập mã chức vụ để sửa: ");
        String machucvu = sc.nextLine().toUpperCase();

        for(int i = 0; i < n;i++) {
            if(dscv[i].getMaChucVu().equals(machucvu)) {
                sua(dscv[i]);
                return;
            }
        }
    }
    public void suaBangChucVu(String machucvu) {
        
        for(int i = 0; i < n;i++) {
            if(dscv[i].getMaChucVu().equals(machucvu)) {
                sua(dscv[i]);
                return;
            }
        }
    }
    // tim kiem
    public void timKiem() {
        System.out.print("Vui lòng nhập mã chức vụ để tìm kiếm: ");
        String machucvu = sc.nextLine().toUpperCase();

        for(int i = 0; i < n;i++) {
            if(dscv[i].getMaChucVu().equals(machucvu)) {
                dscv[i].inChucVu();
            }
        }
    }
    public ChucVu timKiem(String machucvu) {
        for(int i = 0; i < n;i++) {
            if(dscv[i].getMaChucVu().equals(machucvu)) {
                return dscv[i];
            }
        }
        return null;
    }
    // tim kiếm theo tên
    public void timKiemTheoTen() {
        String tenchucvu = sc.nextLine();

        for(int i = 0; i < n;i++) {
            if(dscv[i].getTenChucVu().equalsIgnoreCase(tenchucvu)) {
                dscv[i].inChucVu();
                return;
            }
        }
        System.out.println("Tìm kiếm thất bại");
    }
    public ChucVu timKiemTheo(String tenchucvu) {
        for(int i = 0; i < n;i++) {
            if(dscv[i].getTenChucVu().equalsIgnoreCase(tenchucvu)) {
                return dscv[i];
            }
        }
        return null;

    }
    // in bang chuc vu
    public void inThongTinChucVu() {
        System.out.println("\n======================================================");
        System.out.printf("|%-15s|%-15s|%21s|\n","Mã Chức Vụ", "Tên Chức Vụ", "Phụ Cấp Thưởng");
        System.out.println("------------------------------------------------------");
        for(int i = 0; i < n;i++) {
            dscv[i].inChucVu();
        }
    }
    // xuat file bang chuc vu
    public void xuatFileBangChucVu() {
        try(PrintWriter write = new PrintWriter(new FileWriter("C:\\training\\QuanLyNhanSu\\File\\DanhSachChucVu.txt"))) {
            write.println("=======================================================");
            write.printf("|%-15s|%-15s|%21s|\n","Mã Chức Vụ", "Tên Chức Vụ", "Phụ Cấp Thưởng");
            write.println("-------------------------------------------------------");
            for(ChucVu cv : dscv) {
                write.printf("|%-15s|%-15s|%,18.2fVNĐ|\n",cv.getMaChucVu(),cv.getTenChucVu(),cv.getPhuCapChucVu());
            }
        }catch(IOException e) {
            System.out.println("Không thể ghi xuống file: "+ e.getMessage());
        }
    }
    // doc file
    public void docFileBangChucVu() {
        try(BufferedReader br = new BufferedReader(new FileReader("C:\\training\\QuanLyNhanSu\\File\\DanhSachChucVu.txt"))) {
            br.readLine();
            br.readLine();
            br.readLine();

            String line;

            while((line = br.readLine()) != null) {
                String[] info = line.split("\\|");
                String machucvu = info[1].trim();
                String tenchucvu = info[2].trim();
                Double phucapchucvu = Double.parseDouble(info[3].trim().replace("VNĐ","").replace(",",""));

                themBangChucVu(new ChucVu(machucvu, tenchucvu, phucapchucvu));
            }
        }catch(IOException e) {
            System.out.println("Không có dữ liệu từ fie" + e.getMessage());
        }
    }
    // lay phu cap nhan su
    public double tienPhuCapChucVu(String machucvu) {
        for(int i = 0; i < n;i++) {
            if(dscv[i].getMaChucVu().equals(machucvu)) {
                return dscv[i].getPhuCapChucVu();
            }
        }
        return 0.0;
    }
    // thong ke chuc vu
    public void thongKeChucVu(){
        if(n==0){
            System.out.println("Chua co chuc vu nao trong danh sach"); return;
        }

        double tong=0;
        double maxphucap=0;
        for( int i=0; i<n; i++){
            tong+=dscv[i].getPhuCapChucVu();
            
            if(dscv[i].getPhuCapChucVu()>maxphucap)
                maxphucap=dscv[i].getPhuCapChucVu();
        }
        double phucaptrungbinh=tong/n;

        System.out.println("=====THONG KE CHUC VU====");
        System.out.println("Tong phu cap chuc vu: "+tong);
        System.out.println("Trung Binh Phu Cap Chuc Vu: "+phucaptrungbinh);
        System.out.println("Phu Cap Nhieu Nhat: "+maxphucap);

        for(int i=0; i<n; i++){
            if(dscv[i]!= null && dscv[i].getPhuCapChucVu()==maxphucap){
                System.out.println("Ten Chuc Vu: "+dscv[i].getTenChucVu());
            }
        }
    }
    // sua phu
    public void sua(ChucVu cv) {
        while(true) {
            System.out.println("\n========== BẢNG CHỨC NĂNG SỬA ==========");
            System.out.println("1. Sửa tên chức vụ");
            System.out.println("2. Sửa thưởng phụ cấp");
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
                case 1: 
                    System.out.print("Vui lòng nhập tên chức vụ mới: ");
                    cv.setTenChucVu(sc.nextLine());break;
                case 2: 
                    System.out.print("Vui lòng nhập thưởng phụ cấp mới: ");
                    cv.setPhuCapChucVu(sc.nextDouble());sc.nextLine();break;
            }
        }
    }
}
