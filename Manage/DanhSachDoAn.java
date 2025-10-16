package Manage;
import Object.*;
import java.util.*;
import Interface.*;


public class DanhSachDoAn implements IDoAn {
    private DoAn[] dsda;
    private int n;
    IPhongBan cnpb;// chuc nang phong ban
    Scanner sc = new Scanner(System.in);

    public DanhSachDoAn(IPhongBan cnpb){
        dsda = new DoAn[0];
        this.n = 0;
        this.cnpb = cnpb;
    }
    // kiem tra duy nhat
    public boolean kiemTra(String madoan) {
        for (int i = 0; i < n; i++) {
            if(dsda[i].getMaDoAn().equals(madoan)){
                return true;
            }
        }
        return false;
    }
    // them do an
    @Override
    public void themDoAn(){
        System.out.print("Vui lòng nhập mã đồ án để kiểm tra: ");
        while(kiemTra(sc.nextLine())){
            System.out.println("Mã đồ án đã tồn tại");
            System.out.print("Vui lòng nhập lại: ");
        }
        
        dsda = Arrays.copyOf(dsda, n + 1);
        dsda[n] = new DoAn();
        dsda[n].nhapDoAn();
        this.n++;
    }
    @Override
    public void themDoAn(DoAn da){
        dsda = Arrays.copyOf(dsda, n + 1);
        dsda[n] = da;
        this.n++;
    }
    // them n danh sach do an dau tien
    @Override
    public void themSoLuongDoAn(){
        System.out.print("Nhập n đồ án muốn đầu tiên: ");
        this.n = sc.nextInt();
        sc.nextLine();

        dsda = new DoAn[n];
        for(int  i = 0; i < n;i++){
            dsda[i] = new DoAn();
            dsda[i].nhapDoAn();
        }
    }
    // sua do an
    @Override
    public void suaDoAn(){
        System.out.print("Nhap ma do an can sua: ");
        String maDoAn = sc.nextLine().toUpperCase();

        for(int i = 0; i < n;i++){
            if(dsda[i].getMaDoAn().equals(maDoAn)){
                sua(dsda[i]);
                return;
            }
        }
        System.out.print("Khong tim thay do an");
    }
    @Override
    public void suaDoAn(String maDoAn){
        for(int i = 0; i < n;i++){
            if(dsda[i].getMaDoAn().equals(maDoAn)){
                sua(dsda[i]);
                return;
            }
        }
        System.out.print("Khong tim thay do an");
    }
    @Override
    public DoAn timDoAn(String maDoAn){
         for(int i = 0; i < n;i++){
            if(dsda[i].getMaDoAn().equals(maDoAn)){
                return dsda[i];
            }
        }
        System.out.print("Khong tim thay do an");
        return null;
    }
    // tim do an
    @Override
    public void timDoAn(){
        System.out.print("Nhap ma do an can tim: ");
        String maDoAn = sc.nextLine().toUpperCase();

        for(int i = 0; i < n;i++){
            if(dsda[i].getMaDoAn().equals(maDoAn)){
                dsda[i].inDoAn();
                return;
            }
        }
        System.out.print("Khong tim thay do an");
    }
    // xoa do an
    @Override
    public void xoaDoAn(){
        System.out.print("Nhap ma do an: ");
        String maDoAn = sc.nextLine().toUpperCase();

        for(int i = 0; i < n;i++){
            if(dsda[i].getMaDoAn().equals(maDoAn)){
                for(int j = i; j < n - 1;j++)
                    dsda[j] = dsda[j+1];
                dsda[n - 1] = null;
                n--;
                return;
            }
        }
        System.out.println("Xoa that bai");
    }
    @Override
    public void xoaDoAn(String maDoAn){
        for(int i = 0; i < n;i++){
            if(dsda[i].getMaDoAn().equals(maDoAn)){
                for(int j = i; j < n - 1;j++)
                    dsda[j] = dsda[j+1];
                dsda[n - 1] = null;
                n--;
                return;
            }
        }
        System.out.println("Xoa that bai");
    }
    //tim kiem theo ten
    @Override
    public void timKiemTheoTen(){
        System.out.print("Nhap ten do an: ");
        String tenDoAn = sc.nextLine();

        for(int i = 0; i < n;i++){
            if(dsda[i].getTenDoAn().contains(tenDoAn)){
                dsda[i].inDoAn();
                return;
            }
        }
        System.out.print("Tim that bai");
    }
    @Override
    public DoAn[] timKiemTheoTen(String tenDoAn){
        DoAn[] kq = new DoAn[0];
        int j = 0;

        for(int i = 0; i < n;i++){
            if(dsda[i].getTenDoAn().contains(tenDoAn)){
                kq = Arrays.copyOf(kq, j + 1);
                kq[j++] = dsda[i];
            }
        }
        return kq;
    }
    @Override
    public void ganPhongBanDa(){
        System.out.print("Nhập mã đồ án: ");
        String maDoAn = sc.nextLine().toUpperCase();
        DoAn da = timDoAn(maDoAn);
        if(da == null){
            System.out.println("Do an chua duoc khoi tao!");
            return;
        }
        System.out.print("Nhập mã phòng ban: ");
        String maPhongBan = sc.nextLine().toUpperCase();
        PhongBan pb = cnpb.timKiem(maPhongBan);
        if(pb == null){
            System.out.println("Phong ban chua duoc khoi tao");
            return;
        }
        da.setPhongBan(pb);
    }
    // tim do an chua co pb
    @Override
    public void timDoAnChuaPb(){
        for(int i = 0; i < n;i++){
            if(dsda[i].getPhongBan() == null){
                dsda[i].inDoAn();
                return;
            }
        }
        System.out.println("Không tìm thấy");
    }
    @Override
    public DoAn[] searchDoAnChuaPb(){
        DoAn[] kq = new DoAn[0];
        int j = 0;

        for(int i = 0; i < n;i++){
            if(dsda[i].getPhongBan() == null){
                kq = Arrays.copyOf(kq, j + 1);
                kq[j++] = dsda[i];
            }
        }
        return kq;
    }
    @Override 
    public void inThongTinDoAn(){
        for(int i = 0; i < n;i++){
            dsda[i].inDoAn();
        }
    }
    // hàm phụ
    public void sua(DoAn da ){
            while(true) {
            System.out.println("1. Sửa tên");
            System.out.println("2. Sửa địa điểm");
            System.out.println("3. Sửa ngày bắt đầu");
            System.out.println("4. Sửa ngày kết thúc");
            System.out.println("0. Để thoát");
            System.out.print("Lựa chọn: ");

            int choice = sc.nextInt(); 
            sc.nextLine();
            if(choice == 0) break;

            switch(choice) {
                case 1: 
                    System.out.print("Vui lòng nhập tên mới: ");
                    da.setTenDoAn(sc.nextLine());   
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
