package DanhSach;
import java.util.Scanner;
import Object.*;
import java.util.Arrays;

import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class DanhSachQuyDinhThuongLe {
    private QuyDinhThuongLe[] dsqdtl;
    private int n;
    Scanner sc = new Scanner(System.in);

    public DanhSachQuyDinhThuongLe() {
        dsqdtl = new QuyDinhThuongLe[0];
        this.n = 0;
    }

    // kiem tra
    public boolean kiemTra(String mathuongle) {
        for(int i = 0; i < n;i++) {
            if(dsqdtl[i].getMaThuongLe().equals(mathuongle)) {
                return true;
            }
        }
        return false;
    }
    // them 
    public void themQuyDinhThuongLe() {
        System.out.print("Vui lòng nhập mã thưởng lễ để kiểm tra (VD: TL001): ");
        if(kiemTra(sc.nextLine().toUpperCase())) {
            System.out.println("Mã thưởng lễ đã tồn tại!");
            return;
        }

        dsqdtl = Arrays.copyOf(dsqdtl, n + 1);
        dsqdtl[n] = new QuyDinhThuongLe();
        dsqdtl[n].nhapQuyDinhThuongLe();
        this.n++;
    }
    public void themQuyDinhThuongLe(QuyDinhThuongLe qdtl) {
        dsqdtl = Arrays.copyOf(dsqdtl, n + 1);
        dsqdtl[n] = qdtl;
        this.n++;
    }
    // thêm n quy dinh thưởng đầu tiên
    public void them() {
        System.out.println("Nhập n quy định thưởng lễ đầu tiên:");
        this.n = sc.nextInt();
        sc.nextLine();

        dsqdtl = new QuyDinhThuongLe[n];

        for(int i = 0; i < n;i++) {
            dsqdtl[i] = new QuyDinhThuongLe();
            dsqdtl[i].nhapQuyDinhThuongLe();
        }
    }
    // xoa 
    public void xoaQuyDinhThuongLe() {
        System.out.print("Nhập mã quy định thưởng lễ bạn muốn xóa (VD: TL001): ");
        String mathuongle = sc.nextLine().toUpperCase();

        for(int i = 0; i < n;i++) {
            if(dsqdtl[i].getMaThuongLe().equals(mathuongle)) {
                for(int j = i; j < n - 1;j++) {
                    dsqdtl[j] = dsqdtl[j + 1];
                }
                this.n--;
                dsqdtl = Arrays.copyOf(dsqdtl, n);
                return;
            }
        }
        System.out.println("Xóa thất bại");
    }

    public void xoaQuyDinhThuongLe(String mathuongle) {
        for(int i = 0; i < n;i++) {
            if(dsqdtl[i].getMaThuongLe().equals(mathuongle)) {
                for(int j = i;j < n - 1;j++) {
                    dsqdtl[j] = dsqdtl[j + 1];
                }
                this.n--;
                dsqdtl = Arrays.copyOf(dsqdtl, n);
                return;
            }
        }
        System.out.println("Xóa thất bại");
    }

    // sua
    public void suaQuyDinhThuongLe() {
        System.out.print("Nhập mã quy định thưởng lễ muốn sửa (VD: TL001): ");
        String mathuongle = sc.nextLine().toUpperCase();

        for(int i = 0; i < n;i++) {
            if(dsqdtl[i].getMaThuongLe().equals(mathuongle)) {
                sua(dsqdtl[i]);
                return;
            }
        }
        System.out.println("Sửa thành công");
    }
    public void suaQuyDinhThuongLe(String mathuongle) {

        for(int i = 0; i < n;i++) {
            if(dsqdtl[i].getMaThuongLe().equals(mathuongle)) {
                sua(dsqdtl[i]);
                return;
            }
        }
        System.out.println("Sửa thành công");
    }

    // tim kiem theo ma
    public void timKiemTheoMa() {
        System.out.print("Nhập mã thưởng lễ muốn tìm kiếm (VD: TL001): ");
        String mathuongle = sc.nextLine().toUpperCase();

        System.out.println("\n=============================================================================");
        System.out.printf("|%-15s|%-20s|%-15s|%23s|\n","Mã Thưởng Lễ","Tên Thưởng Lễ","Ngày","Số Tiền Thưởng");
        System.out.println("-----------------------------------------------------------------------------");


        for(int i = 0; i < n ;i++) {
            if(dsqdtl[i].getMaThuongLe().equals(mathuongle)) {
                dsqdtl[i].in();
                System.out.println("=============================================================================");
                return;
            }
        }
        System.out.println("Không tìm thấy mã thưởng lễ");
    }
    public QuyDinhThuongLe timKiemTheoMa(String mathuongle) {
        for(int i = 0; i < n;i++) {
            if(dsqdtl[i].getMaThuongLe().equals(mathuongle)) {
                return dsqdtl[i];
            }
        }
        return null;
    }
    // tim kiem theo ten lễ
    public void timKiemTheoTen() {
        System.out.print("Nhập tên lễ muốn tìm kiếm: ");
        String tenthuongle = sc.nextLine();

        System.out.println("\n=============================================================================");
        System.out.printf("|%-15s|%-20s|%-15s|%23s|\n","Mã Thưởng Lễ","Tên Thưởng Lễ","Ngày","Số Tiền Thưởng");
        System.out.println("-----------------------------------------------------------------------------");
        
        for(int i = 0; i < n;i++) {
            if(dsqdtl[i].getTenThuongLe().equals(tenthuongle)) {
                dsqdtl[i].in();
                System.out.println("=============================================================================");
                return;
            }
        }
        System.out.println("Không tìm thấy tên");
    }
    public QuyDinhThuongLe timKiemTheoTen(String tenthuongle) {
        for(int i = 0; i < n;i++) {
            if(dsqdtl[i].getTenThuongLe().equals(tenthuongle)) {
                return dsqdtl[i];
            }
        }
        return null;
    }

    // tim kiem so tiền thưởng lễ
    public void timKiemTheoTienThuongLe() {
        System.out.print("Nhập số tiền bạn muốn tìm kiếm: ");
        double sotienthuongle = sc.nextDouble();
        sc.nextLine();

        System.out.println("\n=============================================================================");
        System.out.printf("|%-15s|%-20s|%-15s|%23s|\n","Mã Thưởng Lễ","Tên Thưởng Lễ","Ngày","Số Tiền Thưởng");
        System.out.println("-----------------------------------------------------------------------------");

        for(int i = 0; i < n;i++) {
            if(dsqdtl[i].getSoTienThuongLe() == sotienthuongle) {
                dsqdtl[i].in();
                System.out.println("=============================================================================");
                return;
            }
        }
        System.out.println("Không tìm thấy số tiền thưởng lễ");
    }
    public QuyDinhThuongLe timKiemTheoTienThuong(double sotienthuongle) {
        for(int i = 0; i < n;i++) {
            if(dsqdtl[i].getSoTienThuongLe() == sotienthuongle) {
                return dsqdtl[i];
            }
        }
        return null;
    }
    // in 
    public void inDanhSachQuyDinhThuongLe() {
        System.out.println("\n=============================================================================");
        System.out.printf("|%-15s|%-20s|%-15s|%23s|\n","Mã Thưởng Lễ","Tên Thưởng Lễ","Ngày","Số Tiền Thưởng");
        System.out.println("-----------------------------------------------------------------------------");

        for(int i = 0; i < n;i++) {
            dsqdtl[i].in();
        }
        System.out.println("\n");
    }
    // xuat file quy dinh thuong le
    public void xuatFileThuongLe() {
        try(PrintWriter write = new PrintWriter(new FileWriter("C:\\training\\QuanLyNhanSu\\File\\DanhSachQuyDinhThuongLe.txt"))) {
        write.println("===========================================================================");
        write.printf("|%-15s|%-20s|%-15s|%20s|\n","Mã Thưởng Lễ","Tên Thưởng Lễ","Ngày","Số Tiền Thưởng");
        write.println("---------------------------------------------------------------------------");

        for(QuyDinhThuongLe d : dsqdtl) {
            write.printf("|%-15s|%-20s|%-15s|%,17.0fVNĐ|\n",d.getMaThuongLe(),d.getTenThuongLe(),d.getNgayThangLe(),d.getSoTienThuongLe());
        }
        }catch(Exception e) {
            System.out.println("Lỗi không thể ghi xuống file" + e.getMessage());
        }
    }
    // doc file
    public void docFileDanhSachThuongLe() {
        try(BufferedReader br = new BufferedReader(new FileReader("C:\\training\\QuanLyNhanSu\\File\\DanhSachQuyDinhThuongLe.txt"))) {
            br.readLine();
            br.readLine();
            br.readLine();

            String line;
            while((line = br.readLine()) != null) {
                String[] info = line.split("\\|");

                String mathuongle = info[1].trim();
                String tenthuongle = info[2].trim();
                String ngaythangle = info[3].trim();
                Double tienthuong = Double.parseDouble(info[4].trim().replace("VNĐ","").replace(",",""));

                themQuyDinhThuongLe(new QuyDinhThuongLe(mathuongle, tenthuongle, ngaythangle, tienthuong));
            }
        }catch(IOException e) {
            System.out.println("Không có dữ liệu từ file" + e.getMessage());
        }
    }

    // thong ke tên lễ co so tien lon hon 1tr
    public String[] thongKeTienTL() {
        String[] kq = new String[0];
        int j = 0;

        for(int i = 0; i < n;i++) {
            if(dsqdtl[i].getSoTienThuongLe() >= 1000000) {
                kq = Arrays.copyOf(kq, j + 1);
                kq[j++] = dsqdtl[i].getTenThuongLe();
            }
        }
        return kq;
    }
    // thống kê tiền tl từ 1tr
    public void thongKeTienThuongLe() {
        System.out.println("\n========== DANH SÁCH TIỀN THƯỞNG LỄ TRÊN 1TR ==========");

        for(int i = 0; i < n;i++) {
            if(dsqdtl[i].getSoTienThuongLe() >= 1000000) {
                System.out.println("Tên thưởng lễ là: " + dsqdtl[i].getTenThuongLe());
            }
        }
    }
    // thống kê tổng
    public void thongKeQuyDinhThuong(){
        double tongthuong=0;
        double maxthuong=0;
        double minthuong=dsqdtl[0].getSoTienThuongLe();

        for( int i=0; i<n; i++){
            tongthuong+=dsqdtl[i].getSoTienThuongLe();

            if(dsqdtl[i].getSoTienThuongLe()>maxthuong){
                maxthuong=dsqdtl[i].getSoTienThuongLe();
            }else if(dsqdtl[i].getSoTienThuongLe()<minthuong){
                minthuong=dsqdtl[i].getSoTienThuongLe();
            }
            
        }

        System.out.println("\n========== THỐNG KÊ QUY ĐỊNH THƯỞNG LỄ ==========");
        System.out.printf("Tổng tiền thưởng lễ là: %,.0f VNĐ%n", tongthuong);
        System.out.printf("Thưởng lễ trung bình là: %,.0f VNĐ%n", tongthuong/n);
        System.out.printf("Thưởng lễ cao nhất là: %,.0f VNĐ%n", maxthuong);
        System.out.printf("Thưởng lễ thấp nhất là: %,.0f VNĐ%n", minthuong);

        for( int i=0; i<n; i++){
            if(dsqdtl[i]!=null && dsqdtl[i].getSoTienThuongLe()==maxthuong){
                System.out.println("Tên lễ có thưởng cao nhất là: "+dsqdtl[i].getTenThuongLe());
            }else if(dsqdtl[i]!=null && dsqdtl[i].getSoTienThuongLe()==minthuong){
                System.out.println("Tên lễ có thưởng thấp nhất là: "+dsqdtl[i].getTenThuongLe());

            }
        }
    }
    // sua phu
    public void sua(QuyDinhThuongLe qdtl) {
        while(true){
            System.out.println("\n========== CHỨC NĂNG SỬA ==========");
            System.out.println("1. Sửa ngày tháng lễ");
            System.out.println("2. Sửa tên lễ");
            System.out.println("3. Sửa số tiền thưởng lễ");
            System.out.println("0. Để thoát");
            System.out.println("Lựa chọn: ");

            int choice = sc.nextInt();sc.nextLine();

            if(choice == 0) break;

            switch(choice) {
                case 1: 
                    System.out.print("Nhập ngày tháng lễ mới (DD/MM): ");
                    qdtl.setNgayThangLe(sc.nextLine());
                    System.out.println("Sửa thành công");break;
                case 2:
                    System.out.print("Nhập tên lễ mới: ");
                    qdtl.setTenThuongLe(sc.nextLine()); 
                    System.out.println("Sửa thành công");break;
                case 3:    
                    System.out.print("Nhập số tiền thưởng lễ mới: ");
                    qdtl.setSoTienThuongLe(sc.nextDouble());sc.nextLine(); 
                    System.out.println("Sửa thành công");break;
            }
        }
    }
}
