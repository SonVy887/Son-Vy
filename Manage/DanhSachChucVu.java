package Manage;
import Interface.*;
import Object.*;
import java.util.Scanner;
import java.util.Arrays;

public class DanhSachChucVu implements IChucVu {
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
    @Override 
    public void themBangChucVu() {
        System.out.print("Vui lòng nhập mã để kiểm tra: ");
        while(kiemTra(sc.nextLine())) {
            System.out.println("Mã chức vụ đã tồn tại!");
            System.out.print("Vui lòng nhập lại: ");
        }

        dscv = Arrays.copyOf(dscv, n + 1);
        dscv[n] = new ChuVu();
        dscv[n].nhapChucVu();
        this.n++;
    }
    @Override 
    public void themBangChucVu(ChucVu cv) {
        dscv = Arrays.copyOf(dscv, n + 1);
        dscv[n] = cv;
        this.n++;
    }
    @Override 
    public void them() {
        System.out.print("Vui lòng nhập n chức vụ đầu tiên: ");
        this.n = sc.nextInt();

        dscv[n] = new ChuVu[n];
        for(int i = 0; i < n;i++) {
            dscv[i]= new ChucVu();
            dscv[i].nhapChucVu();
        }
    }
    // xoa 
    @Override
    public void xoaBangChucVu() {
        System.out.print("Vui nhập mã chức vụ để xóa: ");
        String machucvu = sc.nextLine();

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
    @Override
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
    @Override 
    public void suaBangChucVu() {
        System.out.print("Vui lòng nhập mã chức vụ để xóa: ")
        String machucvu = sc.nextLine();

        for(int i = 0; i < n;i++) {
            if(dscv[i].getMaChucVu().equals(machucvu)) {
                sua(dscv[i]);
                return;
            }
        }
    }
    @Override
    public void suaBangChucVu(String machucvu) {
        

        for(int i = 0; i < n;i++) {
            if(dscv[i].getMaChucVu().equals(machucvu)) {
                sua(dscv[i]);
                return;
            }
        }
    }
    // tim kiem
    @Override
    public void timKiem() {
        System.out.print("Vui lòng nhập mã chức vụ để tìm kiếm: ");
        String machucvu = sc.nextLine();

        for(int i = 0; i < n;i++) {
            if(dscv[i].getMaChucVu().equals(machucvu)) {
                dscv[i].inChucVu();
            }
        }
    }
    @Override
    public ChucVu timKiem(String machucvu) {
        for(int i = 0; i < n;i++) {
            if(dscv[i].getMaChucVu().equals(machucvu)) {
                return dscv[i];
            }
        }
    }
    // in bang chuc vu
    public void inThongTinChucVu() {
        System.out.printf("|%-15s|%-15s|%-15s|\n","Mã Chức Vụ", "Tên Chức Vụ", "Phụ Cấp Thưởng");

        for(int i = 0; i < n;i++) {
            dscv[i].inChucVu();
        }
    }
    // sua phu
    public void sua(ChucVu cv) {
        while(true) {
            System.out.println("1. Sửa tên chức vụ");
            System.out.println("2. Sửa thưởng phụ cấp")
            System.out.println("0. Để thoát");
            System.out.print("Lựa chọn: ");

            int choice = sc.nextInt();sc.nextLine();

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
