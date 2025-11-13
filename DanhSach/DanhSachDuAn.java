package DanhSach;
import Object.*;
import java.util.*;
import Interface.*;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;


public class DanhSachDuAn {
    private DuAn[] dsda;
    private int n;
    Scanner sc = new Scanner(System.in);

    public DanhSachDuAn(){
        dsda = new DuAn[0];
        this.n = 0;
    }
    // kiem tra duy nhat
    public boolean kiemTra(String maduan) {
        for (int i = 0; i < n; i++) {
            if(dsda[i].getMaDuAn().equals(maduan)){
                return true;
            }
        }
        return false;
    }
    // them do an
    public void themDuAn(){
        System.out.print("Vui lòng nhập mã dự án để kiểm tra (VD: DA001): ");
        if(kiemTra(sc.nextLine().toUpperCase())){
            System.out.println("Mã dự án đã tồn tại");
            return;
        }
        
        dsda = Arrays.copyOf(dsda, n + 1);
        dsda[n] = new DuAn();
        dsda[n].nhapDuAn();
        this.n++;
    }
    public void themDuAn(DuAn da){
        dsda = Arrays.copyOf(dsda, n + 1);
        dsda[n] = da;
        this.n++;
    }
    // them n danh sach do an dau tien
    public void themSoLuongDuAn(){
        System.out.print("Nhập n dự án muốn đầu tiên: ");
        this.n = sc.nextInt();
        sc.nextLine();

        dsda = new DuAn[n];
        for(int  i = 0; i < n;i++){
            dsda[i] = new DuAn();
            dsda[i].nhapDuAn();
        }
    }
    // sua du an
    public void suaDuAn(){
        System.out.print("Nhập mã dự án cần sửa (VD: DA001): ");
        String maduan = sc.nextLine().toUpperCase();

        for(int i = 0; i < n;i++){
            if(dsda[i].getMaDuAn().equals(maduan)){
                sua(dsda[i]);
                return;
            }
        }
        System.out.print("Không tìm thấy dự án");
    }
    public void suaDuAn(String maduan){
        for(int i = 0; i < n;i++){
            if(dsda[i].getMaDuAn().equals(maduan)){
                sua(dsda[i]);
                return;
            }
        }
        System.out.print("Không tìm thấy dự án");
    }
    public DuAn timDuAn(String maduan){
         for(int i = 0; i < n;i++){
            if(dsda[i].getMaDuAn().equals(maduan)){
                return dsda[i];
            }
        }
        System.out.print("Không tìm thấy dự án");
        return null;
    }
    // tim du an
    public void timDuAn(){
        System.out.print("nhập mã dự án cần tìm (VD: DA001): ");
        String maduan = sc.nextLine().toUpperCase();

        System.out.println("\n==========================================================================================================================");
        System.out.printf("|%-15s|%-30s|%-15s|%-15s|%-20s|%-20s|\n","Mã Dự Án","Tên Dự Án","Phòng Ban","Địa Điểm","Ngày Bắt Đầu","Ngày Kết Thúc");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");

        for(int i = 0; i < n;i++){
            if(dsda[i].getMaDuAn().equals(maduan)){
                dsda[i].inDuAn();
                System.out.println("==========================================================================================================================");
                return;
            }
        }
        System.out.print("Không tìm thấy dự án");
    }
    // xoa du an
    public void xoaDuAn(){
        System.out.print("Nhập mã dự án muốn xóa (VD: DA001): ");
        String maduan = sc.nextLine().toUpperCase();

        for(int i = 0; i < n;i++){
            if(dsda[i].getMaDuAn().equals(maduan)){
                for(int j = i; j < n - 1;j++)
                    dsda[j] = dsda[j+1];
                n--;
                dsda = Arrays.copyOf(dsda, n);
                return;
            }
        }
        System.out.println("Xóa thất bại");
    }
    public void xoaDuAn(String maduan){
        for(int i = 0; i < n;i++){
            if(dsda[i].getMaDuAn().equals(maduan)){
                for(int j = i; j < n - 1;j++)
                    dsda[j] = dsda[j+1];
                n--;
                dsda = Arrays.copyOf(dsda, n);
                return;
            }
        }
        System.out.println("Xóa thất bại");
    }
    //tim kiem theo ten
    public void timKiemTheoTen(){
        System.out.print("Nhập tên dự án cần tìm: ");
        String tenduan = sc.nextLine();

        System.out.println("\n==========================================================================================================================");
        System.out.printf("|%-15s|%-30s|%-15s|%-15s|%-20s|%-20s|\n","Mã Dự Án","Tên Dự Án","Phòng Ban","Địa Điểm","Ngày Bắt Đầu","Ngày Kết Thúc");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");


        for(int i = 0; i < n;i++){
            if(dsda[i].getTenDuAn().contains(tenduan)){
                dsda[i].inDuAn();
                System.out.println("==========================================================================================================================");
                return;
            }
        }
        System.out.print("Không tìm thấy dự án");
    }
    public DuAn[] timKiemTheoTen(String tenduan){
        DuAn[] kq = new DuAn[0];
        int j = 0;

        for(int i = 0; i < n;i++){
            if(dsda[i].getTenDuAn().contains(tenduan)){
                kq = Arrays.copyOf(kq, j + 1);
                kq[j++] = dsda[i];
            }
        }
        return kq;
    }
    // tim du an chua co pb
    public void thongKeDuAnChuaPb(){
        System.out.println("========== THỐNG KÊ DỰ ÁN CHƯA PHÒNG BAN =========");
        for(int i = 0; i < n;i++){
            if(dsda[i].getPhongBan() == null){
                System.out.println("Dự án "+ dsda[i].getTenDuAn());
            }
        }
    }
    // thong kê dự án chưa pb
    public DuAn[] searchDuAnChuaPb(){
        DuAn[] kq = new DuAn[0];
        int j = 0;

        for(int i = 0; i < n;i++){
            if(dsda[i].getPhongBan() == null){
                kq = Arrays.copyOf(kq, j + 1);
                kq[j++] = dsda[i];
            }
        }
        return kq;
    }

    // thống kê dự án theo phòng bang
    public void thongKeDuAnPb() {

        System.out.println("=========== THỐNG KÊ PHÒNG BAN QUẢN LÝ DỰ ÁN ==========");
        boolean[] dathongke =new boolean[n];

        for(int i=0; i<n; i++){
            if(dathongke[i]) continue;

            String maphongban=dsda[i].getPhongBan();
            int dem=1;
            for( int j=i+1; j<n; j++){
                if(dsda[j].getPhongBan().equals(maphongban)){
                    dem++;
                    dathongke[j]=true;
                }
            }
            if(maphongban==null || maphongban.isEmpty()){ maphongban=" Chua Phan Cong ";}
            System.out.println("Phòng ban "+maphongban+ " có "+dem+" dự án");
        }
        
    } 
    public void inThongTinDuAn(){
        System.out.println("\n==========================================================================================================================");
        System.out.printf("|%-15s|%-30s|%-15s|%-15s|%-20s|%-20s|\n","Mã Dự Án","Tên Dự Án","Phòng Ban","Địa Điểm","Ngày Bắt Đầu","Ngày Kết Thúc");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");

        for(int i = 0; i < n;i++){
            dsda[i].inDuAn();
        }
    }
    // xuat file danh sach du an
    public void xuatFileDanhSachDuAn() {
        try(PrintWriter write= new PrintWriter(new FileWriter("C:\\training\\QuanLyNhanSu\\File\\DanhSachDuAn.txt"))) {
            write.println("==========================================================================================================================");
            write.printf("|%-15s|%-30s|%-15s|%-15s|%-20s|%-20s|\n","Mã Dự Án","Tên Dự Án","Phòng Ban","Địa Điểm","Ngày Bắt Đầu","Ngày Kết Thúc");
            write.println("--------------------------------------------------------------------------------------------------------------------------");
            for(int i = 0; i < n;i++){
                write.printf("|%-15s|%-30s|%-15s|%-15s|%-20s|%-20s|\n",
                dsda[i].getMaDuAn(), dsda[i].getTenDuAn(), dsda[i].getPhongBan() != null ? dsda[i].getPhongBan() : "Trống",
                dsda[i].getDiaDiem(), dsda[i].getNgayBatDau(), dsda[i].getNgayKetThuc());
            }
        }catch(IOException e) {
            System.out.println("Lỗi không thể xuất file" + e.getMessage());
        }
    }
    // doc File
    public void docFileDanhSachDuAn() {
        try(BufferedReader br = new BufferedReader(new FileReader("C:\\training\\QuanLyNhanSu\\File\\DanhSachDuAn.txt"))) {
            br.readLine();
            br.readLine();
            br.readLine();

            String line;
            while((line = br.readLine()) != null) {
                String[] info = line.split("\\|");

                String maduan = info[1].trim();
                String tenduan = info[2].trim();
                String maphongban = info[3].trim();
                String diadiem = info[4].trim();
                String ngaybatdau = info[5].trim();
                String ngayketthuc = info[6].trim();

                themDuAn(new DuAn(maduan, tenduan, diadiem, maphongban, ngaybatdau, ngayketthuc));
            }
        }catch(IOException e) {
            System.out.println("Không có dữ liệu từ file" + e.getMessage());
        }
    }
    // hàm phụ
    public void sua(DuAn da ){
        while(true) {
            System.out.println("1. Sửa tên");
            System.out.println("2. Sửa địa điểm");
            System.out.println("3. Sửa ngày bắt đầu");
            System.out.println("4. Sửa ngày kết thúc");
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
                    System.out.print("Vui lòng nhập tên mới: ");
                    da.setTenDuAn(sc.nextLine());   
                    System.out.println("Sửa thành công");break;
                case 2: 
                    System.out.print("Vui lòng nhập địa điểm mới: ");
                    da.setDiaDiem(sc.nextLine());
                    System.out.println("Sửa thành công");break;
                case 3: 
                    System.out.print("Vui lòng nhập ngày bắt đầu mới: ");
                    da.setNgayBatDau(sc.nextLine());
                    System.out.println("Sửa thành công");break;
                case 4: 
                    System.out.print("Vui lòng nhập ngày kết thúc mới: ");
                    da.setNgayKetThuc(sc.nextLine());
                    System.out.println("Sửa thành công");break;
            }
        }
    }
    
}
