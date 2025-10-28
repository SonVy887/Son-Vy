package Object;
import java.util.Scanner;
public class NhanSuThucTap extends NhanSu {
    private int thoigianthuctap; // in months
    private  double gpa;
    Scanner sc = new Scanner (System.in);


    // Constructor
    public NhanSuThucTap(String manhansu, String ho, String ten, int tuoi, String diachi, String sodienthoai, String gioitinh, String ngaysinh, String email, PhongBan phongban,int thoigianthuctap,double gpa) {
        super(manhansu, ho, ten, tuoi, diachi, sodienthoai, gioitinh, ngaysinh, email, phongban);
        this.thoigianthuctap = thoigianthuctap;
        this.gpa = gpa;
    }
    public NhanSuThucTap() {
        super();
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
    public void inChiTietTT() {
        // System.out.println("====================================================================================================================================================================================");
        // System.out.printf("|%-15s|%-8s|%-10s|%-8s|%-12s|%-15s|%-12s|%-12s|%-20s|%-15s|%-20s|%-15s|%-10s|\n",
        // "Mã Nhân Sự","Họ", "Tên",
        // "Tuổi", "Địa Chỉ", "Số Điện Thoại", "Giới Tính",
        // "Ngày Sinh", "Email", "Lương Cơ Bản", "Thời Gian Thực Tập", "GPA","Trường Đại Học","Phong Ban");
        // System.out.printf("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
        System.out.printf("|%-8s|%-9s|%-10s|%-8s|%-16s|%-15s|%-12s|%-12s|%-20s|%-12s|%-8s tháng|%-5s|%,18.2f VNĐ\n",
        manhansu, ho, ten,
        tuoi, diachi, sodienthoai, gioitinh, 
        ngaysinh, email, phongban == null ? "Rong" : phongban.getMaPhongBan(),
        thoigianthuctap, gpa,luongcoban);
        // System.out.println("====================================================================================================================================================================================");
    }
    @Override
    public void inThongTin() {
        System.out.printf("|%-8s|%-9s|%-10s|%-8s|%-16s|%-15s|%-12s|%-12s|%-24s|%-11s|%-13s|%,18.2f VNĐ\n",
        manhansu, ho, ten,
        tuoi, diachi, sodienthoai, gioitinh, 
        ngaysinh, email,
        phongban==null ? "Rong" : phongban.getMaPhongBan(), loai(), luongcoban);
    }
    @Override
    public String loai() {
        return "Thực Tập";
    }


    @Override
    public double tinhLuong() {
        return luongcoban ;
    }
    @Override 
    public void nhapThongTin() {
        super.nhapThongTin();
        System.out.print("Nhap thoi gian thuc tap (thang): ");
        this.thoigianthuctap = sc.nextInt();
        sc.nextLine();
        System.out.print("Nhap GPA: ");
        this.gpa = sc.nextDouble();
        sc.nextLine();
    }
}
