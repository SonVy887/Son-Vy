package Manage;
import Interface.*;
import Object.*;
import java.util.Arrays;
import java.util.Scanner;

public class DanhSachLuongKhenThuong implements ILuongKhenThuong{
    private LuongKhenThuong[] dslk;
    private int n;
    INhanSu cnns; // chuc nang nhan su
    Scanner sc = new Scanner(System.in);

    public DanhSachLuongKhenThuong(INhanSu cnns) {
        dslk = new LuongKhenThuong[0];
        this.n = 0;
        this.cnns = cnns;
    }

    public boolean kiemTra(String maluongkhen){
        for(int i = 0; i < n;i++){
            if(dslk[i].getMaLuongkhenThuong().equals(maluongkhen)){
                return true;
            }
        }
        return false;
    }

    //them luong khen
    @Override
    public void themLuongKhen(){
        System.out.print("Vui lòng nhập mã lương khen thưởng để kiểm tra: ");
        while(kiemTra(sc.nextLine())){
            System.out.println("Mã lương khen thưởng đã tồn tại");
            System.out.print("Vui lòng nhập lại: ");
        }
        
        dslk = Arrays.copyOf(dslk, n + 1);
        dslk[n] = new LuongKhenThuong();
        dslk[n].nhapLuongKhenThuong();
        this.n++;
    }
    // them n luong khen thuong dau tien
    @Override
    public void themNhieuLuongKhen(){
        System.out.print("Nhập n lương khen thưởng đầu tiên: ");
        this.n = sc.nextInt();
        sc.nextLine();

        dslk = new LuongKhenThuong[n];
        for(int i = n; i < n + m;i++){
            dslk[i] = new LuongKhenThuong();
            dslk[i].nhapLuongKhenThuong();
        }
    }

    // xoa luong khen 
    @Override
    public void xoaLuongKhen(){
        System.out.print("Nhập mã lương khen muốn xóa: ");
        String maluongkhen = sc.nextLine().toUpperCase();

        for(int i = 0; i < n;i++){
            if(dslk[i].getMaLuongKhenThuong().equals(maluongkhen)){
                for(int j = i; j < n - 1;j++)
                    dslk[j] = dslk[j + 1];
                dslk[n - 1] = null;
                this.n--;
                return;
            }
        }
        System.out.println("Xóa thất bại");
    }
    @Override
    public void xoaLuongKhen(String maluongkhen){
        for(int i = 0; i < n;i++){
            if(dslk[i].getMaLuongKhenThuong().equals(maluongkhen)){
                for(int j = i; j < n - 1;j++)
                    dslk[j] = dslk[j + 1];
                dslk[n - 1] = null;
                this.n--;
                return;
            }
        }
        System.out.println("Xóa thất bại");
    }
    // sua luong khen
    @Override
    public void suaLuongKhen(){
        System.out.print("Nhập mã lương khen cần sửa: ");
        String maluongkhen = sc.nextLine().toUpperCase();

        for (int i = 0; i < n; i++) {
            if (dslk[i].getMaLuongKhenThuong().equals(maluongkhen)) {
                sua(dslk[i]);
                return;
            }
        }
        System.out.println("Xóa thất bại");
    }
    @Override
    public void suaLuongKhen(String maluongkhen) {
        for (int i = 0; i < n; i++) {
            if (dslk[i].getMaLuongKhenThuong().equals(maluongkhen)) {
                sua(dslk[i]);
                return;
            }
        }
        System.out.println("Xóa thất bại");
    }
    // tim kiem 
    @Override
    public void timKiemLuongKhen(){
        System.out.print("Nhập mã lương khen cần tìm: ");
        String maluongkhen = sc.nextLine().toUpperCase();

        for (int i = 0; i < n; i++) {
            if (dslk[i].getMaLuongKhenThuong().equals(maluongkhen)) {
                dslk[i].inThongTinKhenThuong();
                return;
            }
        }
        System.out.println("Tìm thất bại");
    }
    @Override
    public LuongKhenThuong timKiemLuongKhen(String maluongkhen){
        for (int i = 0; i < n; i++) {
            if (dslk[i].getMaLuongKhenThuong().equals(maluongkhen)) {
                return dslk[i];
            }
        }
        System.out.println("Tìm thất bại");
        return null;
    }
    @Override
    public void ganNhanSu() {
        System.out.print("Nhập mã lương khen: ");
        String maluongkhen = sc.nextLine().toUpperCase();
        LuongKhenThuong lkt = timKiemLuongKhen(maluongkhen);
        if(lkt == null){
            System.out.println("Lương khen chưa tồn tại");
            return;
        }

        System.out.print("Nhập mã nhân sự: ");
        String manhansu = sc.nextLine().toUpperCase();
        NhanSu ns = cnns.timKiem(manhansu);
        if(ns == null){
            System.out.println("Nhân sự chưa tồn tại");
            return;
        }
        lkt.setNhanSu(ns);
    }

    //in thong tin
    @Override
    public void in(){
        for(int i = 0; i < n;i++){
            dslk[i].inThongTinKhenThuong();
        }
    }
    // hàm sửa phụ
    public void sua(LuongKhenThuong lkt ){
            while(true) {
            System.out.println("1. Sửa lương khen thưởng");
            System.out.println("2. Sửa lý do");
            System.out.println("0. Để thoát");
            System.out.print("Lựa chọn: ");

            int choice = sc.nextInt(); 
            sc.nextLine();
            if(choice == 0) break;

            switch(choice) {
                case 1: 
                    System.out.print("Vui lòng nhập lương khen thưởng mới: ");
                    lkt.setLuongKhenThuong(sc.nextDouble());sc.nextLine();
                    System.out.println("Sửa thành công");break;
                case 2: 
                    System.out.print("Vui lòng nhập lý do mới: ");
                    lkt.setLyDo(sc.nextLine());
                    System.out.println("Sửa thành công");break;
            }
        }
    } 

}
