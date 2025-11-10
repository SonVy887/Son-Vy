package DanhSach;
import Object.*;
import java.util.Scanner;
import java.util.Arrays;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DanhSachPhuCapThamNien {
    private QuyDinhPhuCapThamNien[] dsqdpc;
    private int n;
    Scanner sc = new Scanner(System.in);

    public DanhSachPhuCapThamNien() {
        dsqdpc = new QuyDinhPhuCapThamNien[0];
        this.n = 0;
    }

    // kiem tra
    public boolean kiemTra(String mapcthamnien) {
        for(int i = 0; i < n;i++) {
            if(dsqdpc[i].getMaPCThamNien().equals(mapcthamnien)) {
                return true;
            }
        }
        return false;
    }

    // thêm
    public void themQuyDinhPCTN() {
        System.out.print("Vui lòng nhập mã thâm niên để kiểm tra (VD: PCTN01): ");
        if(kiemTra(sc.nextLine().toUpperCase())) {
            System.out.println("Mã này đã tồn tại!");
            return;
        }

        dsqdpc = Arrays.copyOf(dsqdpc, n + 1);
        dsqdpc[n] = new QuyDinhPhuCapThamNien();
        dsqdpc[n].nhap();
        this.n++;
    }

    public void themQuyDinhPCTN(QuyDinhPhuCapThamNien a) {
        dsqdpc = Arrays.copyOf(dsqdpc, n + 1);
        dsqdpc[n] = a;
        this.n++;
    }
    // them n phu cap tham nien đầu tiên
    public void them() {
        System.out.print("Nhập n quy định phụ cấp thâm niên đầu tiên");
        this.n = sc.nextInt();
        sc.nextLine();

        dsqdpc = new QuyDinhPhuCapThamNien[n];
        for(int i = 0; i < n;i++) {
            dsqdpc[i] = new QuyDinhPhuCapThamNien();
            dsqdpc[i].nhap();
        }
    }

    // xoa
    public void xoaQuyDinhPCTN() {
        System.out.print("Nhập mã phụ cấp thâm niên để xóa: ");
        String mapcthamnien = sc.nextLine().toUpperCase();

        for(int i = 0; i < n;i++) {
            if(dsqdpc[i].getMaPCThamNien().equals(mapcthamnien)) {
                for(int j = i; j < n - 1;j++) {
                    dsqdpc[j] = dsqdpc[j + 1];
                }
                this.n--;
                dsqdpc = Arrays.copyOf(dsqdpc, n);
                return;
            }
        }
        System.out.println("Xóa thất bại");
    }
    public void xoaQuyDinhPCTN(String mapcthamnien) {
        for(int i = 0; i < n;i++) {
            if(dsqdpc[i].getMaPCThamNien().equals(mapcthamnien)) {
                for(int j = i; j < n - 1;j++) {
                    dsqdpc[j] = dsqdpc[j + 1];
                }
                this.n--;
                dsqdpc = Arrays.copyOf(dsqdpc, n);
                return;
            }
        }
        System.out.println("Xóa thất bại");
    }

    // sua
    public void suaQuyDinhPCTN() {
        System.out.print("Nhập mã quy định phụ cấp thâm niên muốn sửa: ");
        String mapcthamnien = sc.nextLine().toUpperCase();

        for(int i  = 0; i < n;i++) {
            if(dsqdpc[i].getMaPCThamNien().equals(mapcthamnien)) {
                sua(dsqdpc[i]);
                return;
            }
        }
        System.out.println("Sửa thất bại");
    }
    public void suaQuyDinhPCTN(String mapcthamnien) {
        for(int i  = 0; i < n;i++) {
            if(dsqdpc[i].getMaPCThamNien().equals(mapcthamnien)) {
                sua(dsqdpc[i]);
                return;
            }
        }
        System.out.println("Sửa thất bại");
    }
    // tim kiem theo ma
    public void tiemKiemTheoMa() {
        System.out.print("Nhập mã phụ cấp thâm niên muốn tìm kiếm: ");
        String mapcthamnien = sc.nextLine().toUpperCase();

        for(int i = 0; i < n;i++) {
            if(dsqdpc[i].getMaPCThamNien().equals(mapcthamnien)) {
                dsqdpc[i].in();
                return;
            }
        }
        System.out.println("Tìm kiếm thất bại");
    }
    public QuyDinhPhuCapThamNien timKiemTheoMa(String mapcthamnien) {
        for(int i = 0; i < n;i++) {
            if(dsqdpc[i].getMaPCThamNien().equals(mapcthamnien)) {
                return dsqdpc[i];
            }
        }
        return null;
    }
    // tim kiem theo số tiền thưởng phụ cấp
    public void timKiemTheoSoTien() {
        System.out.print("Nhập số tiền phụ cấp thâm niên muốn tìm kiếm: ");
        double sotien = sc.nextDouble();
        sc.nextLine();

        for(int i = 0; i < n;i++) {
            if(dsqdpc[i].getSoTienPhuCap() == sotien) {
                dsqdpc[i].in();
                return;
            }
        }
        System.out.println("Tìm kiếm thất bại");
    }
    public QuyDinhPhuCapThamNien timKiemTheoSoTien(double sotien) {
        for(int i = 0; i < n;i++) {
            if(dsqdpc[i].getSoTienPhuCap() == sotien) {
                return dsqdpc[i];
            }
        }
        return null;
    }
    // tim kiem theo so nam tham nien
    public void timKiemTheoNam() {
        System.out.print("Nhập số năm muốn tìm kiếm: ");
        int nam = sc.nextInt();
        sc.nextLine();

        for(int i = 0; i < n;i++) {
            if(dsqdpc[i].getSoNam() == nam) {
                dsqdpc[i].in();
                return;
            }
        }
        System.out.println("Tìm kiếm thất bại");
    }
    public QuyDinhPhuCapThamNien timKiemTheoNam(int nam) {
        for(int i = 0; i < n;i++) {
            if(dsqdpc[i].getSoNam() == nam) {
                return dsqdpc[i];
            }
        }
        return null;
    }

    public double tinhThuongThamNien(int nam) {
        if(timKiemTheoNam(nam) == null) {
            return 500_000;
        }
        return timKiemTheoNam(nam).getSoTienPhuCap();
    }
    // in
    public void inPhucCapThamNien() {
        System.out.println("===========================================================");
        System.out.printf("|%-15s|%-17s|%24s|\n","Mã PCTN","Số Năm Thâm Niên","Số Tiền Phụ Cấp");
        System.out.println("-----------------------------------------------------------");
        for(int i = 0; i < n;i++) {
            dsqdpc[i].in();
        }
    }
    // xuat file phu cap tham nien
    public void xuatFilePhuCapThamNien() {
        try(PrintWriter write = new PrintWriter(new FileWriter("C:\\training\\QuanLyNhanSu\\File\\DanhSachPhuCapThamNien.txt"))) {
            write.println("===========================================================");
            write.printf("|%-15s|%-17s|%23s|\n","Mã PCTN","Số Năm Thâm Niên","Số Tiền Phụ Cấp");
            write.println("-----------------------------------------------------------");
            for(QuyDinhPhuCapThamNien p : dsqdpc) {
                write.printf("|%-15s|%-17d|%,17.2f/tháng|\n",
                p.getMaPCThamNien(), p.getSoNam(), p.getSoTienPhuCap());
            }
        }catch(IOException e) {
            System.out.println("Lỗi không thể xuất file phụ cấp thâm niên" + e.getMessage());
        }
    }
    public void docFilePhuCapThamNien() {
        try(BufferedReader br = new BufferedReader(new FileReader("C:\\training\\QuanLyNhanSu\\File\\DanhSachPhuCapThamNien.txt"))) {
            br.readLine();
            br.readLine();
            br.readLine();

            String line;
            while((line = br.readLine()) != null) {
                
                    String[] info = line.split("\\|");
                    
                    String mathamnien = info[1].trim();
                    int namthamnien = Integer.parseInt(info[2].trim());
                    double tienthuong = Double.parseDouble(info[3].trim().replace("/tháng","").replace(",",""));
                    themQuyDinhPCTN(new QuyDinhPhuCapThamNien(mathamnien, namthamnien, tienthuong));
            
            }
        }catch(IOException e) {
            System.out.println("Lỗi đọc dữ liệu từ file" + e.getMessage());
        }
    }

    // thong kê số năm có số tiền thưởng thâm niên từ 1tr
    public void thongKeTienPCTN() {
        System.out.println("\n========= THỐNG KÊ THƯỞNG PHỤ CẤP TRÊN 1TR =========");
        for(int i = 0; i < n;i++) {
            if(dsqdpc[i].getSoTienPhuCap() >= 1000000) {
                System.out.println("Số năm phụ cấp là: " + dsqdpc[i].getSoNam());
            }
        }
    }
    // thong ke 
    public void thongKePhuCapThamNien(){
        double tongphucap = 0;
        double maxphucap = 0;
        double minphucap = 0;

        for( int i=0; i<n; i++){
            tongphucap += dsqdpc[i].getSoTienPhuCap();

            if(dsqdpc[i].getSoTienPhuCap() > maxphucap)
                maxphucap = dsqdpc[i].getSoTienPhuCap();
            else if(dsqdpc[i].getSoTienPhuCap() < minphucap)
                minphucap = dsqdpc[i].getSoTienPhuCap();
            
            
        }

        System.out.println("\n========== THỐNG KÊ PHỤ CẤP THÂM NIÊN ==========");
        System.out.printf("Tổng số tiền phụ cấp thâm niên là: %,.0f VNĐ%n", tongphucap);
        System.out.printf("Trung bình phụ cấp thâm niên là: %,.0f VNĐ%n", tongphucap/n);
        System.out.printf("Phụ cấp cao nhất là: %,.0f VNĐ%n", maxphucap);
        System.out.printf("Phụ cấp thấp nhất là: %,.0f VNĐ%n", minphucap);

        for(int i=0; i<n; i++){
            if(dsqdpc[i]!=null && dsqdpc[i].getSoTienPhuCap()==maxphucap){
                System.out.println("Số năm được phụ cấp nhiều nhất là: "+dsqdpc[i].getSoNam());
            }
        }
    }
    
    // sua phu
    public void sua(QuyDinhPhuCapThamNien a) {
        while(true) {
            System.out.println("\n========== CHỨC NĂNG SỬA ==========");
            System.out.println("1. Sửa số năm thưởng phụ cấp thâm niên");
            System.out.println("2. Sửa số tiền thưởng phụ cấp thâm niên");
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
                    System.out.print("Nhập số năm mới: ");
                    a.setSoNam(sc.nextInt());sc.nextLine();
                    System.out.println("Sửa thành công");break;
                case 2: 
                    System.out.print("Nhập số tiền thưởng phụ cấp: ");
                    a.setSoTienPhuCap(sc.nextDouble());sc.nextLine();
                    System.out.println("Sửa thành công");break;
            }
        }
    }
}
