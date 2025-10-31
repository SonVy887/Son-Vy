package Manage;
import Manage.*;
import Object.*;
import java.util.Scanner;
import java.util.Arrays;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DanhSachBangLuongThang {
    private DanhSachBangChamCongThang dscct;
    private DanhSachPhanCong dspc;
    private DanhSachNhanSu dsns;
    private DanhSachPhuCapThamNien dspctn;
    private DanhSachQuyDinhThuongLe dsqdtl;

    private BangLuongThang[] dsblt;
    private int n;
    Scanner sc = new Scanner(System.in);

    public DanhSachBangLuongThang(DanhSachBangChamCongThang dscct,  DanhSachPhanCong dspc, DanhSachNhanSu dsns, DanhSachPhuCapThamNien dspctn, DanhSachQuyDinhThuongLe dsqdtl) {
        this.dscct = dscct;
        this.dspc = dspc;
        this.dsns = dsns;
        this.dspctn = dspctn;
        this.dsqdtl = dsqdtl;
        dsblt = new BangLuongThang[0];
        this.n = 0;
    }
    // kiem tra
    private boolean kiemTra(String mabangluong) {
        for(int i = 0; i < n;i++) {
            if(dsblt[i].getMaBangLuongThang().equalsIgnoreCase(mabangluong))
                return true;
        }
        return false;
    }
    // them
    public void them() {
        System.out.print("Nhập n bảng lương đầu tiên: ");
        this.n = sc.nextInt();
        sc.nextLine();
        
        System.out.print("Vui lòng nhập mã bảng lương để kiểm tra: ");
        while(kiemTra(sc.nextLine())) {
            System.out.println("Bảng lương đã tồn tại ");
            System.out.print("Vui lòng nhập lại mã bảng lương: ");
        }

        dsblt = new BangLuongThang[n];
        for(int i = 0; i < n;i++){
            dsblt[i] = new BangLuongThang();
            dsblt[i].nhapBangLuong();
        }
    }
    public void themBangLuongThang() {
        System.out.print("Vui lòng nhập mã bảng lương để kiểm tra: ");
        while(kiemTra(sc.nextLine())) {
            System.out.println("Bảng lương đã tồn tại ");
            System.out.print("Vui lòng nhập lại mã bảng lương: ");
        }
        dsblt = Arrays.copyOf(dsblt, n + 1);
        dsblt[n] = new BangLuongThang();
        dsblt[n].nhapBangLuong();
        this.n++;
    }
    public void themBangLuongThang(BangLuongThang blt) {
        dsblt = Arrays.copyOf(dsblt, n + 1);
        dsblt[n] = blt;
        this.n++;
    }

    //xoa bang luong
    public void xoaBangLuongThang() {
        System.out.print("Nhập mã bảng lương cần xóa: ");
        String mabangluong = sc.nextLine();
        
        for(int i = 0; i < n;i++) {
            if(dsblt[i].getMaBangLuongThang().equals(mabangluong)) {
                for(int j = i;j < n - 1;j++) {
                    dsblt[j] = dsblt[j + 1];
                }
                this.n--;
                dsblt = Arrays.copyOf(dsblt, n);
                return;
            }
        }
        System.out.println("Không tìm thấy bảng lương cần xóa");
    }
    public void xoaBangLuongThang(String mabangluong) {
        for(int i = 0; i < n;i++) {
            if(dsblt[i].getMaBangLuongThang().equals(mabangluong)) {
                for(int j = i;j < n - 1;j++) {
                    dsblt[j] = dsblt[j + 1];
                }
                this.n--;
                dsblt = Arrays.copyOf(dsblt, n);
                return;
            }
        }
        System.out.println("Không tìm thấy bảng lương cần xóa");
    }
    // sua
    public void suaBangLuongThang() {
        System.out.print("Nhập mã bảng lương tháng cần sửa: ");
        String mabangluongthang = sc.nextLine();

        for(int i = 0; i < n;i++) {
            if(dsblt[i].getMaBangLuongThang().equals(mabangluongthang)) {
                sua(dsblt[i]);
                return;
            }
        }
        System.out.println("Sửa thất bại");
    }
    public void suaBangLuongThang(String mabangluongthang) {
        for(int i = 0; i < n;i++) {
            if(dsblt[i].getMaBangLuongThang().equals(mabangluongthang)) {
                sua(dsblt[i]);
                return;
            }
        }
        System.out.println("Sửa thất bại");
    }
    // tim kiem bang luong theo ma
    public void timKiem() {
        System.out.print("Nhập mã bảng lương tháng cần tìm: ");
        String mabangluongthang = sc.nextLine();

        for(int i = 0; i < n;i++) {
            if(dsblt[i].getMaBangLuongThang().equals(mabangluongthang)) {
                dsblt[i].in();
            }
        }
    }
    public BangLuongThang timKiem(String mabangluongthang) {
        for(int i = 0; i < n;i++) {
            if(dsblt[i].getMaBangLuongThang().equals(mabangluongthang)) {
                return dsblt[i];
            }
        }
        System.out.println("Tìm kiếm thất bại");
        return null;
    }
    // sua phu
    public void sua(BangLuongThang blt) {
        System.out.println("1. Sửa tháng");
        System.out.println("2. Sửa năm");
        System.out.println("3. Sửa lương cơ bản");
        System.out.println("4. Sửa thưởng lễ");
        System.out.println("5. Sửa thưởng dự án");
        System.out.println("6. Sửa phụ cấp");
        System.out.println("7. Sửa trừ lương");
        System.out.println("8. Sửa tổng lương");
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
                System.out.print("Nhập tháng mới: ");
                blt.setThang(sc.nextInt());
                System.out.println("Sửa thành công");break;
            case 2: 
                System.out.print("Nhập năm mới: ");
                blt.setNam(sc.nextInt());
                System.out.println("Sửa thành công");break;
            case 3: 
                System.out.print("Nhập mã lương cơ bản mới: ");
                blt.setLuongCoBan(sc.nextDouble());
                System.out.println("Sửa thành công");break;
            case 4: 
                System.out.print("Nhập thưởng lễ mới: ");
                blt.setThuongLe(sc.nextDouble());
                System.out.println("Sửa thành công");break;
            case 5:
                System.out.print("Nhập thưởng dự án mới: ");
                blt.setThuongDuAn(sc.nextDouble());
                System.out.println("Sửa thành công");break;
            case 6:
                System.out.print("Nhập phụ cấp mới: ");
                blt.setPhuCap(sc.nextDouble());
                System.out.println("Sửa thành công");break;
            case 7:
                System.out.print("Nhập lương trừ mới: ");
                blt.setTruLuong(sc.nextDouble());
                System.out.println("Sửa thành công");break;
            case 8:
                System.out.print("Nhập tổng lương mới: ");
                blt.setTongLuong(sc.nextDouble());sc.nextLine();
                System.out.println("Sửa thành công");break;
        }   

    }
    
}
