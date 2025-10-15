package Object;
import java.util.Scanner;
public class NhanSuThucTap extends NhanSu {
    private int thoigianthuctap; // in months
    private  double gpa;
    private String truongdaihoc;
    Scanner sc = new Scanner (System.in);


    // Constructor
    public NhanSuThucTap(String manhansu, String ho, String ten, int tuoi, String diachi, String sodienthoai, String gioitinh, String ngaysinh, String email, PhongBan phongban,int thoigianthuctap,double gpa,String truongdaihoc) {
        super(manhansu, ho, ten, tuoi, diachi, sodienthoai, gioitinh, ngaysinh, email, phongban);
        this.thoigianthuctap = thoigianthuctap;
        this.gpa = gpa;
        this.truongdaihoc = truongdaihoc;
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
    public String getTruongDaiHoc() {
        return truongdaihoc;
    }
    public void setTruongDaiHoc(String truongdaihoc) {
        this.truongdaihoc = truongdaihoc;
    }

    @Override
    public void inThongTin() {
        System.out.println("====================================================================================================================================================================================");
        System.out.printf("|%-15s|%-8s|%-10s|%-8s|%-12s|%-15s|%-12s|%-12s|%-20s|%-15s|%-20s|%-15s|%-10s|\n",
        "Mã Nhân Sự","Họ", "Tên",
        "Tuổi", "Địa Chỉ", "Số Điện Thoại", "Giới Tính",
        "Ngày Sinh", "Email", "Lương Cơ Bản", "Thời Gian Thực Tập", "GPA","Trường Đại Học","Phong Ban");
        System.out.printf("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
        System.out.printf("|%-15s|%-8s|%-10s|%-8s|%-12s|%-15s|%-12s|%-12s|%-20s|%-15s|%-20s|%-15s|%-10s|\n",
        manhansu, ho, ten,
        tuoi, diachi, sodienthoai, gioitinh, 
        ngaysinh, email, luongcoban,
        thoigianthuctap, gpa, truongdaihoc,phongban == null ? "Rong" : phongban.getMaPhongBan());
        System.out.println("====================================================================================================================================================================================");
    }

    @Override
    public void String loai() {
        return "Nhân Sự Thực Tập";
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
        System.out.print("Nhap truong dai hoc: ");
        this.truongdaihoc = sc.nextLine();
    }
}
