package Object;
import java.util.*;

public class PhongBan {
    private String maphongban;
    private String tenphongban;
    private String matruongphong;
    private String ngaynhanchuc;
    Scanner sc = new Scanner(System.in);

    
    // Constructor
    public PhongBan(String maphongban, String tenphongban, String matruongphong, String ngaynhanchuc) {
        this.maphongban = maphongban;
        this.tenphongban = tenphongban;
        this.matruongphong = matruongphong;
        this.ngaynhanchuc = ngaynhanchuc;
    }
    // constructor k tham so
    public PhongBan() {
        this.maphongban = "";
        this.tenphongban = "";
        this.matruongphong = "";
        this.ngaynhanchuc = "";
    }
    // constructor sao chep
    public PhongBan (PhongBan copy ){
        this.maphongban = copy.maphongban;
        this.tenphongban = copy.tenphongban;
        this.matruongphong = copy.matruongphong;
        this.ngaynhanchuc = copy.ngaynhanchuc;
    }

    //in thong tin phong ban
    public void inThongTinPhongBan() {
        // System.out.println("========================================================================================");
        // System.out.printf("|%-17s|%-18s|%-14s|%-16s|%-17s|\n","Ma Phong Ban", "Ten Phong Ban", "Truong Phong", "Ngay Nhan Chuc","So luong Nhan Su");
        // System.out.printf("----------------------------------------------------------------------------------------\n");
        System.out.printf("|%-17s|%-18s|%-14s|%-16s|\n",
        maphongban, tenphongban, matruongphong == "" ? "Trong" : matruongphong, ngaynhanchuc);
        // System.out.println("========================================================================================");
        
    }
    
    //nhap thong tin phong ban
    public void nhapThongTinPhongBan() {
        System.out.print("Nhập mã phòng ban (VD: PB001): ");
        this.maphongban = sc.nextLine().toUpperCase();
        System.out.print("Nhập tên phòng ban: ");
        this.tenphongban = sc.nextLine();
    }
    
    // Getter and Setter
    public String getMaPhongBan() {
        return maphongban;
    }
    public void setMaPhongBan(String maphongban) {
        this.maphongban = maphongban;
    }
    public String getTenPhongBan() {
        return tenphongban;
    }
    public void setTenPhongBan(String tenphongban) {
        this.tenphongban = tenphongban;
    }
    public String getNgayNhanChuc() {
        return this.ngaynhanchuc;
    }
    public void setNgayNhanChuc(String ngaynhanchuc){
        this.ngaynhanchuc = ngaynhanchuc;
    }
    public void setTruongPhong(String matruongphong){
        this.matruongphong = matruongphong;
    }
    public String getTruongPhong() {
        return this.matruongphong;
    }    
}
