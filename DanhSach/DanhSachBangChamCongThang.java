package DanhSach;
import Object.*;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;

public class DanhSachBangChamCongThang {
    private BangChamCongThang[] bcct;
    private int n;
    Scanner sc = new Scanner(System.in);


    public DanhSachBangChamCongThang() {
        bcct = new BangChamCongThang[0];
        this.n = 0; 
        docFileBangChamCongThang();
    }

    // kiem tra
    private boolean kiemTra(String machamcongthang) {
        for(int i = 0; i < n;i++) {
            if(bcct[i].getMaChamCongThang().equals(machamcongthang)) {
                return true;
            }
        }
        return false;
    }

    // them bang cham cong thang
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
    public void them() {
        System.out.print("Nhập n bảng chấm công đầu tiên: ");
        this.n = sc.nextInt();sc.nextLine();

        bcct = new BangChamCongThang[n];
        for(int i = 0; i < n;i++) {
            bcct[i] = new BangChamCongThang();
            bcct[i].nhap();
        }
    }
    public void themBangChamCongThang(BangChamCongThang b) {
        bcct = Arrays.copyOf(bcct, n + 1);
        bcct[n] = b;
        this.n++;
    }

    // sua
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
    public void suaBangChamCongThang(String machamcongthang) {

        for(int i = 0; i < n;i++) {
            if(bcct[i].getMaChamCongThang().equals(machamcongthang)) {
                sua(bcct[i]);
                return;
            }
        }
    }
    // xoa 
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
    public void timKiem() {
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
    public BangChamCongThang timKiem(String machamcongthang) {
        for(int i = 0; i < n;i++) {
            if(bcct[i].getMaChamCongThang().equals(machamcongthang)) {
                return bcct[i];
            }
        }
        return null;
    }
    // tim kiem nhan su tren bang cham cong thang
    public void timKiemNhanSuBCCT() {
        System.out.print("Nhập mã nhân sự cần tìm: ");
        String manhansu = sc.nextLine().toUpperCase();

        for(int i = 0; i < n;i++) {
            if(bcct[i].getMaNhanSu().equals(manhansu)) {
                bcct[i].in();
                return;
            }
        }
        System.out.println("Không tìm thấy nhân sự");
    }
    public BangChamCongThang timKiemNhanSuBCCT(String manhansu) {
        for(int i = 0; i < n;i++) {
            if(bcct[i].getMaNhanSu().equals(manhansu)) {
                return bcct[i];
            }
        }
        return null;
    }
    // in bang cham cong thang
    public void inBangChamCongThang() {
        System.out.println("=======================================================================");
        System.out.printf("|%-10s|%-8s|%-7s|%-7s|%-16s|%-16s|\n","Mã BCCT", "Mã NS", "Tháng", "Năm", "Số Ngày Làm", "Số Ngày Nghỉ");
        System.out.println("-----------------------------------------------------------------------");
        for(int i = 0; i < n;i++) {
            bcct[i].in();
        }
    }   
    // xuat file bang cham cong thang
    public void xuatFileBangChamCongThang() {
        try(PrintWriter write= new PrintWriter(new FileWriter("C:\\training\\QuanLyNhanSu\\File\\DanhSachBangChamCongThang.txt"))) {
            write.println("=======================================================================");
            write.printf("|%-10s|%-8s|%-7s|%-7s|%-16s|%-16s|\n","Mã BCCT", "Mã NS", "Tháng", "Năm", "Số Ngày Làm", "Số Ngày Nghỉ");
            write.println("-----------------------------------------------------------------------");
            for(int i = 0; i < n;i++) {
                write.printf("|%-10s|%-8s|%-7s|%-7s|%-16s|%-16s|\n", bcct[i].getMaChamCongThang(), bcct[i].getMaNhanSu() == "" ? "Trống" : bcct[i].getMaNhanSu(),
                bcct[i].getThang(), bcct[i].getNam(), bcct[i].getSoNgayLamViec(), bcct[i].getSoNgayNghi());
            }
        } catch (Exception e) {
            System.out.println("Lỗi xuất file bảng chấm công tháng" + e.getMessage());
        }
    }
    public void docFileBangChamCongThang() {
        try(BufferedReader br = new BufferedReader(new FileReader("C:\\training\\QuanLyNhanSu\\File\\DanhSachBangChamCongThang.txt"))) {
            br.readLine();
            br.readLine();
            br.readLine();

            String line;
            while((line = br.readLine()) != null) {
                String[] info = line.split("\\|");

                String machamcongt = info[1].trim();
                String manhansu = info[2].trim();
                int thang = Integer.parseInt(info[3].trim());
                int nam = Integer.parseInt(info[4].trim());
                int songaylamviec = Integer.parseInt(info[5].trim());
                int songaynghi = Integer.parseInt(info[6].trim());

                themBangChamCongThang(new BangChamCongThang(machamcongt, manhansu, thang, nam, songaylamviec, songaynghi));
            }
        }catch(IOException e) {
            System.out.println("Không có dữ liệu từ fiel" + e.getMessage());
        }
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
