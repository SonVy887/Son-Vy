package Manage;
import java.util.*;
import Object.*;
import Interface.*;

public class DanhSachPhongBan implements IPhongBan {
    private PhongBan[] dspb;
    private int n;
    INhanSu cnns; // chuc nang nhan su
    Scanner sc = new Scanner(System.in);

    public DanhSachPhongBan(INhanSu cnns) {
        this.cnns = cnns;
        dspb = new PhongBan[0];
        n = 0;
    }

    //them n phong ban dau tien
    @Override
    public void addSoLuongPhongBan(){
        System.out.println("Nhập n phòng ban đầu tiên: ");
        this.n = sc.nextInt();
        sc.nextLine();

        dspb = new PhongBan[n];
        for(int i = 0; i < n; i++){
            dspb[i] = new PhongBan();
            dspb[i].nhapThongTinPhongBan();
        }
    }
    @Override 
    public void addPhongBan(){// da test

        System.out.print("Vui lòng nhập mã phòng ban để kiểm tra: ");
        while(kiemTraPb(sc.nextLine())){
            System.out.println("Mã phòng ban đã tồn tại");
            System.out.print("Vui lòng nhập lại mã phòng ban: ");
        }

        dspb = Arrays.copyOf(dspb, n + 1);
        dspb[n]= new PhongBan();
        dspb[n].nhapThongTinPhongBan();
        this.n++;
    }
    //sua phong ban
    @Override
    public void suaPhongBan(String maphongban){// chua
        for(int i = 0; i < n;i++){
            if(dspb[i].getMaPhongBan().equals(maphongban)){
                System.out.print("Vui lòng nhập tên mới: ");
                dspb[i].setTenPhongBan(sc.nextLine());;
                System.out.println("Sửa thành công");
                return;
            }
        }
        System.out.println("Không tìm thấy phòng ban");
    }
    @Override
    public void suaPhongBan(){
        System.out.print("Nhập mã phòng ban cần sửa: ");
        String maphongban = sc.nextLine().toUpperCase();

        for(int i = 0; i < n;i++){
            if(dspb[i].getMaPhongBan().equals(maphongban)){
                System.out.print("Vui lòng nhập tên mới: ");
                dspb[i].setTenPhongBan(sc.nextLine());;
                System.out.println("Sửa thành công");
                return;
            }
        }
        System.out.println("Không tìm thấy phòng ban");
    }
    //xoa phong ban
    @Override
    public void xoaPhongBan(String maphongban){//chua
        for(int i = 0; i < n;i++){
            if(dspb[i].getMaPhongBan().equals(maphongban)){
                NhanSu[] nhansupb = dspb[i].getDsns();
                for(int j = 0; j < dspb[i].getSoLuongNhanSu();j++){
                    NhanSu ns = cnns.timKiem(nhansupb[j].getMaNhanSu());
                    ns.setPhongBan(null);
                }
                for(int k = i; k < n - 1;k++)
                    dspb[k] = dspb[k + 1];
                dspb = Arrays.copyOf(dspb, n); 
                return;
            }
       }
       System.out.println("Không tìm thấy phòng ban");
    }
    @Override
    public void xoaPhongBan(){// chua test
        System.out.println("Nhập mã phòng ban muốn xóa: ");
        String maphongban = sc.nextLine().toUpperCase();

        for(int i = 0; i < n;i++){
            if(dspb[i].getMaPhongBan().equals(maphongban)){
                NhanSu[] nhansupb = dspb[i].getDsns();
                for(int j = 0; j < dspb[i].getSoLuongNhanSu();j++){
                    NhanSu ns = cnns.timKiem(nhansupb[j].getMaNhanSu());
                    ns.setPhongBan(null);
                }
                for(int k = i; k < n - 1;k++)
                    dspb[k] = dspb[k + 1];
                dspb = Arrays.copyOf(dspb, n);
                return;
            }
       }
       System.out.println("Không tìm thấy phòng ban");

    }
    // tim phong ban
    @Override
    public void timKiem(){
        System.out.print("Nhập mã phòng ban muốn tìm: ");
        String maphongban = sc.nextLine().toUpperCase();

        for(int i = 0; i < n;i++){
            if(dspb[i].getMaPhongBan().equals(maphongban)){
                dspb[i].inThongTinPhongBan();
                return;
            }
        }
        System.out.println("không tìm thấy phòng ban");
    }
    @Override
    public PhongBan timKiem(String maphongban){

        for(int i = 0; i < n;i++){
            if(dspb[i].getMaPhongBan().equals(maphongban)){
                return dspb[i];
            }
        }
        return null;
    }
    // tim theo ten
    @Override
    public void timKiemTheoTen(){
        System.out.println("Nhập tên phòng ban: ");
        String tenphongban = sc.nextLine();
        boolean found = false;

        for(int i = 0; i < n;i++){
            if(dspb[i].getTenPhongBan().contains(tenphongban)){
                dspb[i].inThongTinPhongBan();
                found = true;
            }
        }
        if(!found)
            System.out.println("Không tìm thấy phòng ban");
    }
    @Override
    public PhongBan[] timKiemTheoTen(String tenphongban){
        PhongBan[] kq = new PhongBan[0];
        int j = 0;

        for(int i = 0; i < n;i++){
            if(dspb[i].getTenPhongBan().contains(tenphongban)){
                kq = Arrays.copyOf(kq, j + 1);
                kq[j++] = dspb[i];
            }
        }
        if(j == 0)
            System.out.println("Không tìm thấy phòng ban");
        return kq;
        
    }
    @Override
    public void setTruongPhong() {
        System.out.print("Nhập mã phòng ban cần set trưởng phòng: ");
        String maphongban = sc.nextLine().toUpperCase();
        PhongBan pb = timKiem(maphongban);// day
        if(pb == null){
            System.out.println("Không tìm thấy phòng ban");
            return;
        }
        System.out.print("Nhập mã nhân sự làm trưởng phòng: ");
        String manhansu = sc.nextLine().toUpperCase();
        NhanSu ns = cnns.timKiem(manhansu);//day
        if(ns == null){
            System.out.println("Không tìm thấy nhân sự");
            return;
        }
        pb.setTruongPhong(ns);
        System.out.print("Nhập ngày nhận chức: ");
        String ngaynhanchuc = sc.nextLine();
        pb.setNgayNhanChuc(ngaynhanchuc);
    }
    // in
    @Override
    public void inThongTin(){
        for (int i = 0; i < n; i++) {
            dspb[i].inThongTinPhongBan();
        }
    }
    // them nhan su vao phong ban
    public void themNhanSuPb(){
        System.out.print("Nhập mã phòng ban muốn thêm nhân sự: ");
        String maphongban = sc.nextLine().toUpperCase();
        System.out.print("Nhập mã nhân sự: ");
        String manhansu = sc.nextLine().toUpperCase(); 

        PhongBan pb = timKiem(maphongban);
        if(pb == null){
            System.out.println("Phòng ban chưa được khởi tạo");
            return;
        }
        NhanSu newNs = cnns.timKiem(manhansu);
        if(newNs == null){
            System.out.println("Nhân sự chưa được khởi tạo");
            return;
        }
        for(int i = 0; i < n;i++){
            if(dspb[i].getMaPhongBan().equals(maphongban)){
                dspb[i].themNhanSu(newNs);
            }
        }
        newNs.setPhongBan(pb);
    }
    @Override
    public void themSoLuongNhanSuPb(){
        System.out.print("Nhập mã phòng ban muốn thêm nhân sự: ");
        String maphongban = sc.nextLine().toUpperCase();

        boolean check = kiemTraPb(maphongban);
        if(!check){
            System.out.println("Phòng ban chưa được khởi tạo");
            return;
        }
        System.out.print("Thêm n nhân sự đầu tiên vào phòn ban: ");
        int m = sc.nextInt();sc.nextLine();
                
        NhanSu[] temp = new NhanSu[m];

        for(int i = 0; i < n;i++){
            if(dspb[i].getMaPhongBan().equals(maphongban)){
                for(int j = 0; j < m;j++){
                    System.out.println("1. Nhập nhân sự chính thức");
                    System.out.println("2. Nhập nhân sự thực tập");
                    System.out.print("Lua chon: ");
                    int choice = sc.nextInt();
                    sc.nextLine();

                    NhanSu ns = null;
                    if(choice == 1){
                        ns = new NhanSuChinhThuc();
                    }else if (choice == 2){
                        ns = new NhanSuThucTap();
                    }
                    dspb[i].themNhanSu(ns);
                }
                return;
            }
        }
    }
    @Override
    public void inNhanSuPb(){
        System.out.print("Nhập mã phòng ban muốn xem chi tiết nhân sự: ");
        String maphongban = sc.nextLine().toUpperCase();
        for(int i = 0; i < n;i++){
            if(dspb[i].getMaPhongBan().equals(maphongban)){
                dspb[i].inThongTinChiTiet();
                return;
            }
        }
        System.out.println("Phòng ban chưa tồn tại");
    }
    public boolean kiemTraPb(String maphongban){
        for(int i = 0; i < n;i++){
            if(dspb[i].getMaPhongBan().equals(maphongban)){
                return true;
            }
        }
        return false;
    }
    @Override
    public void xoaNhanSuPb(){
        System.out.print("Nhập mã phòng ban: ");
        String maphongban = sc.nextLine().toUpperCase();

        PhongBan pb = timKiem(maphongban);
        if(pb == null){
            System.out.println("Phòng ban chưa được tạo");
        }
        System.out.print("Nhập mã nhân sự: ");
        String manhansu = sc.nextLine().toUpperCase();

        NhanSu ns = pb.timNhanSuPb(manhansu);
        if(ns == null){
            System.out.println("Nhân sự chưa được khởi tạo");
            return;
        }
        pb.xoaNhanSu(ns.getMaNhanSu());

    }
    @Override
    public void addPhongBan(PhongBan pb){
        dspb = Arrays.copyOf(dspb, n + 1);
        dspb[n] = pb;
        n++;
    }
}
