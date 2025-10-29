package Manage;
import Interface.*;
import Object.*;
import java.util.Arrays;
import java.util.Scanner;

public class DanhSachBangChamCongThang implements IBangChamCongThang {
    private BangChamCongThang[] bcct;
    private int n;
    private IBangChamCongThang bcct;
    private INhanSu cnns;
    Scanner sc = new Scanner(System.in);


    public BangChamCongThang(IBangChamCongThang bcct, INhanSu cnns) {
        bcct = new BangChamCongThang[0];
        this.n = 0;
        this.bcct = bcct;
        this.cnns = cnns;
    }

    private boolean kiemTra(String mabangchamcongthang) {
        for(int i = 0; i < n;i++) {
            if(bcct[i].getMaChamCongThang().equals(machamcongthang)) {
                return true;
            }
        }
        return false;
    }

    // them bang cham cong thang
    @Override
    public void themBangChamCongThang() {
        System.out.print("Vui lòng nhâp mã bảng chấm công tháng để kiểm tra: ");
        while(kiemTra(sc.nextLine())) {
            System.out.print("Mã bảng châm công tháng đã tồn tại. Vui lòng nhập mã mới: ");
        }
        bcct = Arrays.copyOf(bcct, n + 1);
        bcct[n] = new BangChamCongThang();
        bcct[n].nhap();
        this.n++;
    }
    // thêm n bảng châm công đầu tiên
    @Override
    public void them() {
        System.out.print("Nhập n bảng chấm công đầu tiên: ");
        this.n = sc.nextInt();sc.nextLine();

        bcct = new BangChamCongThang[n];
        for(int i = 0; i < n;i++) {
            bcct[i] = new BangChamCongThang();
            bcct[i].nhap();
        }
    }
    @Override
    public void themBangChamCongThang(BangChamCongThang bcct) {
        bcct = Arrays.copyOf(bcct, n + 1);
        bcct[n] = bctt;
        this.n++;
    }

    // sua
    @Override
    public void suaBangChamCongThang() {
        System.out.print("Vui lòng nhập mã bảng chấm công tháng để sửa: ");
        String machamcongthang = sc.nextLine().toUpperCase();

        for(int i = 0; i < n;i++) {
            if(bcct[i].getMaChamCongThang().equals(machamcongthang)) {
                sua(bcct[i]);
                return;
            }
        }
    }
    @Override
    public void suaBangChamCongThang(String machamcongthang) {

        for(int i = 0; i < n;i++) {
            if(bcct[i].getMaChamCongThang().equals(machamcongthang)) {
                sua(bcct[i]);
                return;
            }
        }
    }
    // xoa
    @Override 
    public void xoaBangChamCongThang() {
        System.out.print("Vui lòng nhập mã chấm công tháng để xóa: ");
        String machamcongthang = sc.nextLine();

        for(int i = 0; i < n; i++) {
            if(bcct[i].getMaChamCongThang().equals(machamcongthang)) {
                for(int j = i ; j < n - 1;j++) {
                    bcct[j] = bcct[j+1];
                }
                this.n--;
                bcct = Arrays.copyOf(bcct, n);
                return;
            }
        }
        System.out.println("Xóa không thành công");
    }
    @Override 
    public void xoaBangChamCongThang(String machamcongthang) {

        for(int i = 0; i < n; i++) {
            if(bcct[i].getMaChamCongThang().equals(machamcongthang)) {
                for(int j = i ; j < n - 1;j++) {
                    bcct[j] = bcct[j+1];
                }
                this.n--;
                bcct = Arrays.copyOf(bcct, n);
                return;
            }
        }
        System.out.println("Xóa không thành công");
    }
    // tim kiem
    @Override
    void timKiem() {
        System.out.print("Nhập mã bảng chấm công tháng để tìm kiếm: ");
        String machamcongthang = sc.nextLine();

        for(int i = 0; i < n;i++) {
            if(bcct[i].getMaChamCongThang().equals(machamcongthang)) {
                bcct[i].in();
                return;
            }
        }
        System.out.println("Không tìm thấy bảng chấm công tháng");
    }
    @Override
    BangChamCongThang timKiem(String machamcongthang) {
        for(int i = 0; i < n;i++) {
            if(bcct[i].getMaChamCongThang().equals(machamcongthang)) {
                return bcct[i];
            }
        }
        return null;
    }
    // in bang cham cong thang
    @Override
    void inBangChamCongThang() {
        System.out.printf("|%-10s|%-8s|%-7s|%-7s|%-16s|%-16s|\n","Mã BCCT", "Mã NS", "Tháng", "Năm", "Số Ngày Làm", "Số Ngày Nghỉ");
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        for(int i = 0; i < n;i++) {
            bcct[i].in();
        }
    }
    // cham cong thang cho nhan su
    @Override
    public void chamCongThangChoNhanSu() {
        System.out.print("Nhập mã nhân sự: ");
        String manhansu = sc.nextLine().toUpperCase();

        NhanSu ns = cnns.timKiem(manhansu);
        if(ns == null) {
            System.out.println("Mã nhân sự không tồn tại.");
            return;
        }
        System.out.print("Nhập mã bảng chấm công tháng: ");
        String machamcongthang = sc.nextLine().toUpperCase();

        BangChamCongThang bcct = timKiem(machamcongthang);
        if(bcct == null) {
            System.out.println("Mã bảng chấm công tháng không tồn tại.");
            return;
        }
        System.out.print("Nhập tháng: ");
        bcct.setThang(sc.nextInt());sc.nextLine();

        System.out.print("Nhập năm: ");
        bcct.setNam(sc.nextInt());sc.nextLine();
        
        int[] ngaylamviec_nghi = tinhToanNgayLamViec(manhansu);
        bcct.setSoNgayLamViec(ngaylamviec_nghi[0]);
        bcct.setSoNgayNghi(ngaylamviec_nghi[1]);

        bcct.setMaNhanSu(manhansu);

    }
    // tính toán số ngày làm việc và số ngày nghỉ
    private int[] tinhToanNgayLamViec(String manhansu) {
        int songaylamviec = 0;
        int songaynghi = 0;

        songaylamviec = bcct.tongNgayCong(manhansu);
        songaynghi = 20 - songaylamviec;

        return new int[] {songaylamviec, songaynghi};
        
    }
    // sửa phụ
    public void sua(BangChamCongThang bcct) {
        while(true) {
            System.out.println("1. Sửa tháng");
            System.out.println("2. Sửa năm");
            System.out.println("3. Sửa số ngày làm việc");
            System.out.println("4. Sửa số ngày nghỉ");
            System.out.println("0. Để thoát");
            System.out.println("Lựa chọn: ");

            int choice = sc.nextInt();sc.nextLine();
            if(choice == 0) return;

            switch(choice) {
                case 1: System.out.print("Nhập tháng mới: ");
                bcct.setThang(sc.nextInt());sc.nextLine();break;
                case 2: System.out.print("Nhập năm mới: ");
                bcct.setNam(sc.nextInt());sc.nextLine();break;
                case 3: System.out.print("Nhập số ngày làm việc mới: ");
                bcct.setSoNgayLamViec(sc.nextInt());sc.nextLine();break;
                case 4: System.out.print("Nhập số ngày nghỉ mới: ");
                bcct.setSoNgayNghi(sc.nextInt());sc.nextLine();break;
                default: 
                    System.out.println("Lựa chọn không hợp lệ.Vui lòng chọn lại");
                    break;
            }
        }
    }

}
