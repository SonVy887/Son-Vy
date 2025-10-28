package Object;
import java.util.Scanner;

public class BangChamCong {
    private String machamcong;
    private NhanSu nhansu;
    private int tongngaycong;
    private int nghiphep;
    private int nghiom;
    private int nghikhongphep;
    Scanner sc = new Scanner(System.in);


    // Constructor
    public BangChamCong(String machamcong, NhanSu nhansu, int tongngaycong, int nghiphep, int nghiom, int nghikhongphep) {
        this.machamcong = machamcong;
        this.nhansu = nhansu;
        this.tongngaycong = tongngaycong;
        this.nghiphep = nghiphep;
        this.nghiom = nghiom;
        this.nghikhongphep = nghikhongphep;
    }
    public BangChamCong() {}
    public BangChamCong(BangChamCong bcc){
        this.machamcong = bcc.machamcong;
        this.nhansu = bcc.nhansu;
        this.tongngaycong = bcc.tongngaycong;
        this.nghiphep = bcc.nghiphep;
        this.nghiom = bcc.nghiom;
        this.nghikhongphep = bcc.nghikhongphep;
    }

    public void in() {
        // System.out.println("\n=============================================================================================================================");
        // System.out.printf("|%-15s|%-20s|%-18s|%-20s|%-15s|%-15s|%-15s|\n","Mã NV", "Họ và tên", "Phòng ban", "Tổng ngày công", "Nghỉ P", "Nghỉ Ốm", "Nghỉ KP");
        // System.out.println("------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("|%-15s|%-20s|%-18s|%-15d Ngày|%-10d Ngày|%-10d Ngày|%-10d Ngày|\n",
        nhansu == null ? "Trống" : nhansu.getMaNhanSu(),
        nhansu == null ? "Trống" : nhansu.getHoNhanSu() + " " + nhansu.getTenNhanSu(),
        nhansu == null ? "Trống" : nhansu.getPhongBan(),
        tongngaycong, nghiphep, nghiom, nghikhongphep);
        // System.out.println("==============================================================================================================================");
    }

    public void nhap() {
        System.out.print("Nhập mã bảng chấm công (VD: BCC001): ");
        this.machamcong = sc.nextLine().toUpperCase();
    }


    // Getters and Setters
    public String getMaChamCong() {
        return machamcong;
    }
    public void setMaChamCong(String machamcong) {
        this.machamcong = machamcong;
    }
    public int getTongNgayCong() {
        return tongngaycong;
    }
    public void setTongNgayCong(int tongngaycong) {
        this.tongngaycong = tongngaycong;
    }
    public int getNghiPhep() {
        return nghiphep;
    }
    public void setNghiPhep(int nghiphep) {
        this.nghiphep = nghiphep;
    }
    public int getNghiOm() {
        return nghiom;
    }
    public void setNghiOm(int nghiom) {
        this.nghiom = nghiom;
    }
    public int getNghiKhongPhep() {
        return this.nghikhongphep;
    }
    public void setNghiKhongPhep(int nghikhongphep){
        this.nghikhongphep = nghikhongphep;
    }
    public void setNhanSu(NhanSu nhansu) {
        this.nhansu = nhansu;
    }
    public NhanSu getNhanSu() {
        return this.nhansu;
    }
}
