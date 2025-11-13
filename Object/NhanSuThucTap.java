package Object;
import java.util.Scanner;
public class NhanSuThucTap extends NhanSu {
    private int thoigianthuctap; // in months
    private  double gpa;
    Scanner sc = new Scanner (System.in);


    // Constructor
    public NhanSuThucTap(String manhansu, String ho, String ten, String diachi, String sodienthoai, String gioitinh, String ngaysinh, String maphongban, String ngayvaolam, String machucvu, int thoigianthuctap,double gpa) {
        super(manhansu, ho, ten, diachi, sodienthoai, gioitinh, ngaysinh, maphongban, ngayvaolam, machucvu);
        this.thoigianthuctap = thoigianthuctap;
        this.gpa = gpa;
    }
    public NhanSuThucTap() {
        super();
    }
    public NhanSuThucTap(NhanSuThucTap copy) {
        super(copy);
        this.thoigianthuctap = copy.thoigianthuctap;
        this.gpa = copy.gpa;
    }
    // Getter and Setter
    public int getThoiGianThucTap() {
        return thoigianthuctap;
    }
    public void setThoiGianThucTap(int thoigianthuctap) {
        this.thoigianthuctap = thoigianthuctap;
    }
    public double getGpa() {
        return gpa;
    }
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    //
    @Override
    public void inThongTin() {
        super.inThongTin();
        System.err.printf("%8s tháng|%7s|\n",thoigianthuctap, gpa);
    }

    @Override
    public String loai() {
        return "TT";
    }
    @Override 
    public void nhapThongTin() {
        super.nhapThongTin();
        System.out.print("Nhập thời gian thực tập (tháng): ");
        this.thoigianthuctap = sc.nextInt();
        sc.nextLine();
        System.out.print("Nhap GPA: ");
        this.gpa = sc.nextDouble();
        sc.nextLine();
    }
}
