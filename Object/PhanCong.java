package Object;
import java.util.Scanner;

public class PhanCong {
    private String maphancong;
    private String manhansu;
    private String maduan;
    private int thoigian;
    private double thuong;
    Scanner sc = new Scanner(System.in);

    public PhanCong(){}
    public PhanCong(String maphancong, String manhansu, String maduan, int thoigian, double thuong){
        this.maphancong = maphancong;
        this.manhansu = manhansu;
        this.maduan = maduan;
        this.thoigian = thoigian;
        this.thuong = thuong;
    }
    public PhanCong(PhanCong pc){
        this.maphancong = pc.maphancong;
        this.manhansu = pc.manhansu;
        this.maduan = pc.maduan;
        this.thoigian = pc.thoigian;
        this.thuong = pc.thuong;
    }
    
    // in 
    public void inThongTinPhanCong(){
        // System.out.println("=================================================================");
        // System.out.printf("|%-15s|%-15s|%-15s|%15s|\n","Mã Phân Công","Mã Nhân Sự","Mã Đồ Án","Thời Gian");
        // System.out.println("-----------------------------------------------------------------");
        System.out.printf("|%-15s|%-15s|%-15s|%15s|\n",maphancong,manhansu =="" ? "Trống" : manhansu,
        maduan == "" ? "Trống" : maduan,thoigian);
        // System.out.println("=================================================================");
    }
    //nhap
    public void nhapPhanCong(){
        System.out.print("Nhập mã phân công (VD: PC001): ");
        this.maphancong = sc.nextLine().toUpperCase();
    }
    public String getMaPhanCong(){
        return this.maphancong;
    }
    public void setMaPhanCong(String maphancong){
        this.maphancong = maphancong;
    }
    public String getNhanSu() {
        return manhansu;
    }

    public void setNhanSu(String manhansu) {
        this.manhansu = manhansu;
    }

    public String getDuAn() {
        return maduan;
    }

    public void setDuAn(String maduan) {
        this.maduan = maduan;
    }

    public int getThoiGian() {
        return thoigian;
    }

    public void setThoiGian(int thoigian) {
        this.thoigian = thoigian;
    }

    public double getThuong() {
        return this.thuong;
    }
    public void setThuong(double thuong) {
        this.thuong = thuong;
    }
}
