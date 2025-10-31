package Object;
import java.util.Scanner;

public class BangChamCongThang {
    private String machamcongthang;
    private String manhansu;
    private int thang;
    private int nam;
    private int songaylamviec;
    private int songaynghi;
    Scanner sc = new Scanner(System.in);

    //constructors
    public BangChamCongThang(){}
    public BangChamCongThang(String machamcongthang, String manhansu, int thang, int nam, int songaylamviec, int songaynghi) {
        this.machamcongthang = machamcongthang;
        this.manhansu = manhansu;
        this.thang = thang;
        this.nam = nam;
        this.songaylamviec = songaylamviec;
        this.songaynghi = songaynghi;
    }
    public BangChamCongThang(BangChamCongThang copy) {
        this.machamcongthang = copy.machamcongthang;
        this.manhansu = copy.manhansu;
        this.thang = copy.thang;
        this.nam = copy.nam;
        this.songaylamviec = copy.songaylamviec;
        this.songaynghi = copy.songaynghi;
    }

    // nhập 
    public void nhap() {
        System.out.print("Nhập mã chấm công tháng (VD:BCCT001): ");
        this.machamcongthang = sc.nextLine();
    }
    public void in() {
        // System.out.printf("|%-10s|%-8s|%-7s|%-7s|%-16s|%-16s|\n","Mã BCCT", "Mã NS", "Tháng", "Năm", "Số Ngày Làm", "Số Ngày Nghỉ");
        // System.out.println("---------------------------------------------------------------------------------------------------------------");
        System.out.printf("|%-10s|%-8s|%-7s|%-7s|%-16s|%-16s|\n", machamcongthang, manhansu == "" ? "Trống" : manhansu,
        thang, nam, songaylamviec, songaynghi);
    }

    //getters and setters
    public String getMaChamCongThang() {
        return this.machamcongthang;
    }
    public void setMaChamCongThang(String machamcongthang) {
        this.machamcongthang = machamcongthang;
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
        return nam;
    }
    public void setNam(int nam) {
        this.nam = nam;
    }
    public int getSoNgayLamViec() {
        return this.songaylamviec;
    }
    public void setSoNgayLamViec(int songaylamviec) {
        this.songaylamviec = songaylamviec;
    }
    public int getSoNgayNghi() {
        return this.songaynghi;
    }
    public void setSoNgayNghi(int songaynghi) {
        this.songaynghi = songaynghi;
    }
}
