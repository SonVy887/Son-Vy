package DanhSach;
import Object.*;
import java.util.Scanner;

import DanhSach.*;

import java.util.Arrays;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class DanhSachBangLuongThang {
    private BangLuongThang[] dsblt;
    private int n;
    Scanner sc = new Scanner(System.in);

    public DanhSachBangLuongThang() {
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

        dsblt = new BangLuongThang[n];
        for(int i = 0; i < n;i++){
            dsblt[i] = new BangLuongThang();
            dsblt[i].nhapBangLuong();
        }
    }
    public void themBangLuongThang() {
        System.out.print("Vui lòng nhập mã bảng lương để kiểm tra (VD: BLT001): ");
        if(kiemTra(sc.nextLine().toUpperCase())) {
            System.out.println("Bảng lương đã tồn tại ");
            return;
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
        System.out.print("Nhập mã bảng lương cần xóa (VD: BLT001): ");
        String mabangluong = sc.nextLine().toUpperCase();
        
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
        System.out.print("Nhập mã bảng lương tháng cần sửa (VD: BLT001): ");
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
        System.out.print("Nhập mã bảng lương tháng cần tìm (VD: BLT001): ");
        String mabangluongthang = sc.nextLine();

        for(int i = 0; i < n;i++) {
            if(dsblt[i].getMaBangLuongThang().equals(mabangluongthang)) {
                dsblt[i].in();
                return;
            }
        }
        System.out.println("Không tìm thấy");
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
    // thong ke
    public void thongKeBangLuongThang(int thang, int nam) {
        double max = 0;
        double min = dsblt[0].getTongLuong();
        double tong = 0;
        int count = 0;
        
        for(int i = 0; i < n;i++) {
            if(dsblt[i].getThang() == thang && dsblt[i].getNam() == nam){
                count++;
                tong = dsblt[i].getTongLuong();
                if(dsblt[i].getTongLuong() > max) max = dsblt[i].getTongLuong();
                else if(dsblt[i].getTongLuong() < min) min = dsblt[i].getTongLuong();
            }
        }

        System.out.println("\n========== THỐNG KÊ BẢNG LƯƠNG THÁNG ==========");
        System.out.printf("Tổng lương tháng " + thang + " là: %,.0f VNĐ%n", tong);
        System.out.printf("Tổng lương trung bình tháng " + thang + " của nhân sự là: %,.0f VNĐ%n", tong/count);
        System.out.printf("Lương tháng cao nhất trong tháng "+ thang + " là: %,.0f VNĐ%n", max);
        System.out.printf("Lương tháng thấp nhất trong tháng " + thang + " là: %,.0f VNĐ%n", min);

        for(int i = 0; i < n;i++) {
            if(dsblt[i].getTongLuong() == max) 
                System.out.println("Nhân sự có lương cao nhất trong tháng " + thang + " là: " + dsblt[i].getMaNhanSu());
            else if(dsblt[i].getTongLuong() == min )
                System.out.println("Nhân sự có tổng lương thấp nhất trong tháng " + thang +" là: " + dsblt[i].getMaNhanSu());
        }
    }
    
    // thống kê theo quý
    // public void thongKeTheoQuy(int quy, int nam) {
        
    //     for(int i = 0; i < n;i++) {

    //     }
    //     }
    // }
    // in 
    public void inBangLuongThang() {
        System.out.println("\n==============================================================================================================================================================================");
        System.out.printf("|%-10s|%-10s|%10s|%19s|%19s|%19s|%19s|%19s|%19s|%19s|\n","Mã BLT", "Tháng/năm", "Mã NS", "Lương Cơ Bản", "Thưởng lễ", "Thưởng dự án", "Thưởng PCCV", "Thưởng PCTN", "Trừ Lương", "Tổng lương");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        for(int i = 0; i < n;i++) {
            dsblt[i].in();
        }
    }
    // xuat file
    public void xuatFileBangLuongThang() {
        try(PrintWriter write = new PrintWriter(new FileWriter("C:\\training\\QuanLyNhanSu\\File\\DanhSachBangLuongThang.txt"))) {
            write.println("=======================================================================================================================================================================");
            write.printf("|%-10s|%-10s|%-10s|%18s|%18s|%18s|%18s|%18s|%18s|%18s|\n","Mã BLT", "Tháng/năm", "Mã NS", "Lương Cơ Bản", "Thưởng lễ", "Thưởng dự án", "Thưởng PCCV", "Thưởng PCTN", "Trừ Lương", "Tổng lương");
            write.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            for(int i = 0; i < n;i++) {
                write.printf("|%-10s|%-10s|%-10s|%,15.0fVNĐ|%,15.0fVNĐ|%,15.0fVNĐ|%,15.0fVNĐ|%,15.0fVNĐ|%,15.0fVNĐ|%,15.0fVNĐ|\n",
                dsblt[i].getMaBangLuongThang(), dsblt[i].getThang()+"/"+dsblt[i].getNam(), dsblt[i].getMaNhanSu(), dsblt[i].getLuongCoBan(), dsblt[i].getThuongLe(), dsblt[i].getThuongDuAn(), dsblt[i].getPhuCapChucVu(), dsblt[i].getPhuCapThamNien(), dsblt[i].getTruLuong(), dsblt[i].getTongLuong());
            }
        }catch(IOException e) {
            System.out.println("Xuất file thất bại" + e.getMessage());
        }
    }
    // doc file
    public void docFileBangLuongThang() {
        try(BufferedReader br = new BufferedReader(new FileReader("C:\\training\\QuanLyNhanSu\\File\\DanhSachBangLuongThang.txt"))) {
            br.readLine();
            br.readLine();
            br.readLine();

            String line;
            while((line = br.readLine()) != null) {
                String[] info = line.split("\\|");

                String mabangluong = info[1].trim();
                String[] info1 = info[2].split("/");
                int thang = Integer.parseInt(info1[0].trim());
                int nam = Integer.parseInt(info1[1].trim());
                String manhansu = info[3].trim();
                Double luongcoban = Double.parseDouble(info[4].trim().replace(",","").replace("VNĐ",""));
                Double thuongle = Double.parseDouble(info[5].trim().replace(",","").replace("VNĐ",""));
                Double thuongduan = Double.parseDouble(info[6].trim().replace(",","").replace("VNĐ",""));
                Double thuongpccv = Double.parseDouble(info[7].trim().replace(",","").replace("VNĐ",""));
                Double thuongpctn = Double.parseDouble(info[8].trim().replace(",","").replace("VNĐ",""));
                Double truluong = Double.parseDouble(info[9].trim().replace(",","").replace("VNĐ",""));
                Double tongluong = Double.parseDouble(info[10].trim().replace(",","").replace("VNĐ",""));

                themBangLuongThang(new BangLuongThang(mabangluong, thang, nam, manhansu, luongcoban, thuongle, thuongduan, thuongpccv, thuongpctn, truluong, tongluong));
            }
        }catch(IOException e) {
            System.out.println("Không có dữ liệu từ file" + e.getMessage());
        }
    }
    // sua phu
    public void sua(BangLuongThang blt) {
        while(true) {
            System.out.println("1. Sửa tháng");
            System.out.println("2. Sửa năm");
            System.out.println("3. Sửa lương cơ bản");
            System.out.println("4. Sửa thưởng lễ");
            System.out.println("5. Sửa thưởng dự án");
            System.out.println("6. Sửa phụ cấp thâm niên");
            System.out.println("7. Sửa phụ cấp chức vụ");
            System.out.println("9. Sửa trừ lương");
            System.out.println("10. Sửa tổng lương");
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
                    blt.setThang(sc.nextInt());sc.nextLine();
                    System.out.println("Sửa thành công");break;
                case 2: 
                    System.out.print("Nhập năm mới: ");
                    blt.setNam(sc.nextInt());sc.nextLine();
                    System.out.println("Sửa thành công");break;
                case 3: 
                    System.out.print("Nhập mã lương cơ bản mới: ");
                    blt.setLuongCoBan(sc.nextDouble());sc.nextLine();
                    System.out.println("Sửa thành công");break;
                case 4: 
                    System.out.print("Nhập thưởng lễ mới: ");
                    blt.setThuongLe(sc.nextDouble());sc.nextLine();
                    System.out.println("Sửa thành công");break;
                case 5:
                    System.out.print("Nhập thưởng dự án mới: ");
                    blt.setThuongDuAn(sc.nextDouble());sc.nextLine();
                    System.out.println("Sửa thành công");break;
                case 6:
                    System.out.print("Nhập phụ cấp thâm niên mới: ");
                    blt.setPhuCapThamNien(sc.nextDouble());sc.nextLine();
                    System.out.println("Sửa thành công");break;
                case 7:
                    System.out.print("Nhập phụ cấp chức vụ mới: ");
                    blt.setPhuCapChucVu(sc.nextDouble());sc.nextLine();
                    System.out.println("Sửa thành công");break;
                case 8:
                    System.out.print("Nhập lương trừ mới: ");
                    blt.setTruLuong(sc.nextDouble());sc.nextLine();
                    System.out.println("Sửa thành công");break;
                case 9:
                    System.out.print("Nhập tổng lương mới: ");
                    blt.setTongLuong(sc.nextDouble());sc.nextLine();
                    System.out.println("Sửa thành công");break;
            }
        }
    }
}
