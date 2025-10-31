package Object;
import java.util.Scanner;

public class BangLuongThang {
    private String mabangluongthang;
    private int thang;
    private int nam;
    private String manhansu;
    private double luongcoban;
    private double thuongle;
    private double thuongduan;
    private double phucap;
    private double truluong;
    private double tongluong;
    Scanner sc = new Scanner(System.in);

    public BangLuongThang(){}
    public BangLuongThang(String mabangluongthang, int thang, int nam, String manhansu, double luongcoban, double thuongle, double thuongduan, double phucap, double truluong, double tongluong) {
        this.mabangluongthang = mabangluongthang;
        this.thang = thang;
        this.nam = nam;
        this.manhansu = manhansu;
        this.luongcoban = luongcoban;
        this.thuongle = thuongle;
        this.thuongduan = thuongduan;
        this.phucap = phucap;
        this.truluong = truluong;
        this.tongluong = tongluong;
    }
    public BangLuongThang(BangLuongThang copy) {
        this.mabangluongthang = copy.mabangluongthang;
        this.thang = copy.thang;
        this.nam = copy.nam;
        this.manhansu = copy.manhansu;
        this.luongcoban = copy.luongcoban;
        this.thuongle = copy.thuongle;
        this.thuongduan = copy.thuongduan;
        this.phucap = copy.phucap;
        this.truluong = copy.truluong;
        this.tongluong = copy.tongluong;
    }

    public void nhapBangLuong() {
        System.out.print("Nhập mã bảng lương tháng (VD: BLT001): ");
        this.mabangluongthang = sc.nextLine();

        System.out.print("Nhập tháng: ");
        this.thang = sc.nextInt();

        System.out.print("Nhập năm: ");
        this.nam = sc.nextInt();
        sc.nextLine();
    }
    public void in() {
        System.out.printf("|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|\n",mabangluongthang, thang +"/"+nam, manhansu, luongcoban, thuongle, thuongduan, phucap, truluong, tongluong);
    }

    public String getMaBangLuongThang() {
        return this.mabangluongthang;
    }
    public void setMaBangLuongThang(String mabangluongthang) {
        this.mabangluongthang = mabangluongthang;
    }
    public String getMaNhanSu() {
        return this.manhansu;
    }
    public void setMaNhanSu(String manhansu) {
        this.manhansu = manhansu;
    }
    public int getThang() {
        return this.thang;
    }
    public void setThang(int thang) {
        this.thang = thang;
    }
    public int getNam() {
        return this.nam;
    }
    public void setNam(int nam) {
        this.nam = nam;
    }
    public double getLuongCoBan() {
        return this.luongcoban;
    }
    public void setLuongCoBan(double luongcoban) {
        this.luongcoban = luongcoban;
    }
    public double getThuongLe() {
        return this.thuongle;
    }
    public void setThuongLe(double thuongle) {
        this.thuongle = thuongle;
    }
    public double getThuongDuAn() {
        return this.thuongduan;
    }
    public void setThuongDuAn(double thuongduan) {
        this.thuongduan = thuongduan;
    }
    public double getPhuCap() {
        return this.phucap;
    }
    public void setPhuCap(double phucap) {
        this.phucap = phucap;
    }
    public double getTruLuong() {
        return this.truluong;
    }
    public void setTruLuong(double truluong) {
        this.truluong = truluong;
    }
    public double getTongLuong() {
        return this.tongluong;
    }
    public void setTongLuong(double tongluong) {
        this.tongluong = tongluong;
    }
}
