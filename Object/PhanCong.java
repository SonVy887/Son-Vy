package Object;
import java.util.Scanner;

public class PhanCong {
    private String maphancong;
    private String manhansu;
    private String maduan;
    private int thoigian;
    private double thuong;
    private String dokho;
    Scanner sc = new Scanner(System.in);

    public PhanCong(){}
    public PhanCong(String maphancong, String manhansu, String maduan, int thoigian, double thuong, String dokho){
        this.maphancong = maphancong;
        this.manhansu = manhansu;
        this.maduan = maduan;
        this.thoigian = thoigian;
        this.thuong = thuong;
        this.dokho = dokho;
    }
    public PhanCong(PhanCong pc){
        this.maphancong = pc.maphancong;
        this.manhansu = pc.manhansu;
        this.maduan = pc.maduan;
        this.thoigian = pc.thoigian;
        this.thuong = pc.thuong;
        this.dokho = pc.dokho;
    }
    
    // in 
    public void inThongTinPhanCong(){
        // System.out.println("=================================================================");
        // System.out.printf("|%-15s|%-15s|%-15s|%15s|\n","Mã Phân Công","Mã Nhân Sự","Mã Đồ Án","Thời Gian");
        // System.out.println("-----------------------------------------------------------------");
        System.out.printf("|%-15s|%-15s|%-15s|%15s|%-13s|%-20s\n",maphancong,manhansu =="" ? "Trống" : manhansu,
        maduan == "" ? "Trống" : maduan,thoigian,dokho == "" ? "Trống" : dokho, thuong);
        // System.out.println("=================================================================");
    }
    //nhap
    public void nhapPhanCong(){
        System.out.print("Nhập mã phân công (VD: PC001): ");
        this.maphancong = sc.nextLine().toUpperCase();
    }
    public void bangDoKho() {
        System.out.println("\n");
        System.out.println("1. Khó");
        System.out.println("2. Trung bình");
        System.out.println("3. Dễ");
        System.out.println("0. Để thoát");
        System.out.println("Lựa chọn: ");

        int choice = sc.nextInt();sc.nextLine();

        switch(choice) {
            case 1:this.dokho = "Khó";break;
            case 2:this.dokho = "Trung bình";break;
            case 3:this.dokho = "Dễ";break;
        }
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
    public String getDoKho() {
        return this.dokho;
    }
    public void setDoKho(String dokho) {
        this.dokho = dokho;
    }
}
