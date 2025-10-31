package Object;
import java.util.Scanner;
public class NhanSuThucTap extends NhanSu {
    private int thoigianthuctap; // in months
    private  double gpa;
    private String nguoihuongdan;
    Scanner sc = new Scanner (System.in);


    // Constructor
    public NhanSuThucTap(String manhansu, String ho, String ten, String diachi, String sodienthoai, String gioitinh, String ngaysinh, String maphongban, String ngayvaolam, String machucvu, int thoigianthuctap,double gpa, String nguoihuongdan) {
        super(manhansu, ho, ten, diachi, sodienthoai, gioitinh, ngaysinh, maphongban, ngayvaolam, machucvu);
        this.thoigianthuctap = thoigianthuctap;
        this.gpa = gpa;
        this.nguoihuongdan = nguoihuongdan;
    }
    public NhanSuThucTap() {
        super();
    }
    public NhanSuThucTap(NhanSuThucTap copy) {
        super(copy);
        this.thoigianthuctap = copy.thoigianthuctap;
        this.gpa = copy.gpa;
        this.nguoihuongdan = copy.nguoihuongdan;
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
    public String getNguoiHuongDan() {
        return nguoihuongdan;
    }
    public void setNguoiHuongDan(String nguoihuongdan) {
        this.nguoihuongdan = nguoihuongdan;
    }
    //
    public void inChiTietTT() {
        // System.out.println("====================================================================================================================================================================================");
        // System.out.printf("|%-15s|%-8s|%-10s|%-8s|%-12s|%-15s|%-12s|%-12s|%-20s|%-15s|%-20s|%-15s|%-10s|\n",
        // "Mã Nhân Sự","Họ", "Tên",
        // "Tuổi", "Địa Chỉ", "Số Điện Thoại", "Giới Tính",
        // "Ngày Sinh", "Email", "Lương Cơ Bản", "Thời Gian Thực Tập", "GPA","Trường Đại Học","Phong Ban");
        // System.out.printf("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
        System.out.printf("|%-8s|%-9s|%-10s|%-16s|%-15s|%-12s|%-12s|%-12s|%-12s|%-16s|%-8s tháng|%-5s|%-16s|%,18.2f VNĐ\n",
        manhansu, ho, ten,
        diachi, sodienthoai, gioitinh, 
        ngaysinh, machucvu, maphongban =="" ? "Rỗng" : maphongban, ngayvaolam,
        thoigianthuctap, gpa, nguoihuongdan, luongcoban);
        // System.out.println("====================================================================================================================================================================================");
    }
    @Override
    public void inThongTin() {
        System.out.printf("|%-8s|%-9s|%-10s|%-16s|%-15s|%-12s|%-12s|-12s|%-11s|%-16s|%-10s|%,18.2f VNĐ\n",
        manhansu, ho, ten,
        diachi, sodienthoai, gioitinh, 
        ngaysinh,machucvu ==""?"Trống" : machucvu, maphongban=="" ? "Rỗng" : maphongban, ngayvaolam, loai(), luongcoban);
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
        System.out.print("Nhập mã người hướng dẫn: ");
        this.nguoihuongdan = sc.nextLine();
    }
}
