package Object;
import java.util.Scanner;

public class BangLuong {
    private String mabangluong;
    private NhanSu nhansu;
    private double tongluong;
    private final double phucap = 500_00;
    Scanner sc = new Scanner(System.in);



    // Constructor
    public BangLuong(){}
    public BangLuong(String mabangluong, NhanSu nhansu, double tongluong){
        this.mabangluong = mabangluong;
        this.nhansu = nhansu;
        this.tongluong = tongluong;
    }
    public BangLuong(BangLuong bl){
        this.mabangluong = bl.mabangluong;
        this.nhansu = bl.nhansu;
        this.tongluong = bl.tongluong;
    }
    
    // in 
    public void inBangLuong(){
        System.out.print("\n=============================================================================================\n");
        System.out.printf("|%-15s|%-15s|%-15s|%-22s|%20s|\n","Mã BL","Mã NV","Phòng Ban","Họ và tên","Tổng lương");
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.printf("|%-15s|%-15s|%-15s|%-22s|%,16.2f VNĐ|\n",mabangluong,
        nhansu == null ? "Trống" : nhansu.getMaNhanSu(),
        nhansu == null ? "Trống" : nhansu.getPhongBan() == null ? "Trống" : nhansu.getPhongBan().getMaPhongBan(),
        nhansu == null ? "Trống" : nhansu.getHoVaTenNhanSu(),
        tongluong);
    }
    // nhap
    public void nhapBangLuong(){
        System.out.print("Nhập mã bảng lương (VD: BL001): ");
        this.mabangluong = sc.nextLine().toUpperCase();
    }

    public String getMaBangLuong() {
        return this.mabangluong;
    }
    public void setMaBangLuong(String mabangluong){
        this.mabangluong = mabangluong;
    }
    public NhanSu getNhanSu() {
        return this.nhansu;
    }
    public void setNhanSu(NhanSu ns){
        this.nhansu = ns;
    }
    public double getTongLuong() {
        return this.tongluong;
    }
    public void setTongLuong(double tongluong) {
        this.tongluong = tongluong;
    }
    

}
