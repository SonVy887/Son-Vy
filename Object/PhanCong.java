package Object;
import java.util.Scanner;

public class PhanCong {
    private String maphancong;
    private NhanSu nhansu;
    private DoAn doan;
    private int thoigian;
    Scanner sc = new Scanner(System.in);

    public PhanCong(){}
    public PhanCong(String maphancong, NhanSu nhansu, DoAn doan, int thoigian){
        this.maphancong = maphancong;
        this.nhansu = nhansu;
        this.doan = doan;
        this.thoigian = thoigian;
    }
    public PhanCong(PhanCong pc){
        this.nhansu = pc.nhansu;
        this.doan = pc.doan;
        this.thoigian = pc.thoigian;
    }
    
    // in 
    public void inThongTinPhanCong(){
        // System.out.println("=================================================================");
        // System.out.printf("|%-15s|%-15s|%-15s|%15s|\n","Mã Phân Công","Mã Nhân Sự","Mã Đồ Án","Thời Gian");
        // System.out.println("-----------------------------------------------------------------");
        System.out.printf("|%-15s|%-15s|%-15s|%15s|\n",maphancong,nhansu == null ? "Trống" : nhansu.getMaNhanSu(),
        doan == null ? "Trống" : doan.getMaDoAn(),thoigian);
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
    public NhanSu getNhanSu() {
        return nhansu;
    }

    public void setNhanSu(NhanSu nhansu) {
        this.nhansu = nhansu;
    }

    public DoAn getDoAn() {
        return doan;
    }

    public void setDoAn(DoAn doan) {
        this.doan = doan;
    }

    public int getThoiGian() {
        return thoigian;
    }

    public void setThoiGian(int thoigian) {
        this.thoigian = thoigian;
    }
    public static void main(String[] args){
        PhanCong pc = new PhanCong();
        pc.inThongTinPhanCong();
    }
}
