package Manage;
import Object.*;
import java.util.*;
import Interface.*;


public class DanhSachDuAn implements IDuAn {
    private DuAn[] dsda;
    private int n;
    IPhongBan cnpb;// chuc nang phong ban
    Scanner sc = new Scanner(System.in);

    public DanhSachDuAn(IPhongBan cnpb){
        dsda = new DuAn[0];
        this.n = 0;
        this.cnpb = cnpb;
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
    @Override
    public void themDuAn(){
        System.out.print("Vui lòng nhập mã dự án để kiểm tra: ");
        while(kiemTra(sc.nextLine())){
            System.out.println("Mã dự án đã tồn tại");
            System.out.print("Vui lòng nhập lại: ");
        }
        
        dsda = Arrays.copyOf(dsda, n + 1);
        dsda[n] = new DuAn();
        dsda[n].nhapDuAn();
        this.n++;
    }
    @Override
    public void themDuAn(DuAn da){
        dsda = Arrays.copyOf(dsda, n + 1);
        dsda[n] = da;
        this.n++;
    }
    // them n danh sach do an dau tien
    @Override
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
    @Override
    public void suaDuAn(){
        System.out.print("Nhập mã dự án cần sửa: ");
        String maduan = sc.nextLine().toUpperCase();

        for(int i = 0; i < n;i++){
            if(dsda[i].getMaDuAn().equals(maduan)){
                sua(dsda[i]);
                return;
            }
        }
        System.out.print("Không tìm thấy dự án");
    }
    @Override
    public void suaDuAn(String maduan){
        for(int i = 0; i < n;i++){
            if(dsda[i].getMaDuAn().equals(maduan)){
                sua(dsda[i]);
                return;
            }
        }
        System.out.print("Không tìm thấy dự án");
    }
    @Override
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
    @Override
    public void timDuAn(){
        System.out.print("nhập mã dự án cần tìm: ");
        String maduan = sc.nextLine().toUpperCase();

        for(int i = 0; i < n;i++){
            if(dsda[i].getMaDuAn().equals(maduan)){
                dsda[i].inDuAn();
                return;
            }
        }
        System.out.print("Không tìm thấy dự án");
    }
    // xoa du an
    @Override
    public void xoaDuAn(){
        System.out.print("Nhập mã dự án muốn xóa: ");
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
    @Override
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
    @Override
    public void timKiemTheoTen(){
        System.out.print("Nhập tên dự án cần tìm: ");
        String tenduan = sc.nextLine();

        for(int i = 0; i < n;i++){
            if(dsda[i].getTenDuAn().contains(tenduan)){
                dsda[i].inDuAn();
                return;
            }
        }
        System.out.print("Không tìm thấy dự án");
    }
    @Override
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
    @Override
    public void ganPhongBanDa(){
        System.out.print("Nhập mã dự án: ");
        String maduan = sc.nextLine().toUpperCase();
        DuAn da = timDuAn(maduan);
        if(da == null){
            System.out.println("Dự án không tồn tại");
            return;
        }

        System.out.print("Nhập mã phòng ban: ");
        String maphongban = sc.nextLine().toUpperCase();
        PhongBan pb = cnpb.timKiem(maphongban);

        if(pb == null){
            System.out.println("Phòng ban không tồn tại");
            return;
        }
        da.setPhongBan(pb.getMaPhongBan());
    }
    // tim du an chua co pb
    @Override
    public void timDuAnChuaPb(){
        for(int i = 0; i < n;i++){
            if(dsda[i].getPhongBan() == null){
                dsda[i].inDuAn();
                return;
            }
        }
        System.out.println("Không tìm thấy");
    }
    @Override
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
    @Override 
    public void inThongTinDuAn(){
        System.out.println("\n==========================================================================================================================");
        System.out.printf("|%-15s|%-30s|%-15s|%-15s|%-20s|%-20s|\n","Mã Dự Án","Tên Dự Án","Phòng Ban","Địa Điểm","Ngày Bắt Đầu","Ngày Kết Thúc");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");

        for(int i = 0; i < n;i++){
            dsda[i].inDuAn();
        }
    }
    // tra về danh sach du an
    @Override
    public DuAn[] getDanhSachDuAn(){
        return this.dsda;
    }
    // xuat file danh sach du an
    @Override
    public void xuatFileDanhSachDuAn() {
        try(PrintWriter write= new PrintWriter(new FileWriter("C:\\training\\QuanLyNhanSu\\File\\DanhSachDuAn.txt"))) {
            write.println("\n==========================================================================================================================");
            write.printf("|%-15s|%-30s|%-15s|%-15s|%-20s|%-20s|\n","Mã Dự Án","Tên Dự Án","Phòng Ban","Địa Điểm","Ngày Bắt Đầu","Ngày Kết Thúc");
            write.println("--------------------------------------------------------------------------------------------------------------------------");
            for(int i = 0; i < n;i++){
                write.printf("|%-15s|%-30s|%-15s|%-15s|%-20s|%-20s|\n",
                dsda[i].getMaDuAn(), dsda[i].getTenDuAn(), (dsda[i].getPhongBan() == "" ? "Trống" : dsda[i].getPhongBan()),
                dsda[i].getDiaDiem(), dsda[i].getNgayBatDau(), dsda[i].getNgayKetThuc());
            }
        }catch(IOException e) {
            System.out.println("Lỗi không thể xuất file");
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

            int choice = sc.nextInt(); 
            sc.nextLine();
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
