package Object;
import java.util.Scanner;
public class NhanSuChinhThuc extends NhanSu {
    private int sonamkinhnghiem;
    

    // Constructor
    public NhanSuChinhThuc(String manhansu, String ho, String ten, int tuoi, String diachi, String sodienthoai, String gioitinh, String ngaysinh, String email, PhongBan phongban,int sonamkinhnghiem) {
        super(manhansu, ho, ten, tuoi, diachi, sodienthoai, gioitinh, ngaysinh, email, phongban);
        this.sonamkinhnghiem = sonamkinhnghiem;
        
    }
    public NhanSuChinhThuc() {
        super();
    }
    //===============================================================
    @Override
    public void inThongTin() {
        System.out.println("===========================================================================================================================================================");
        System.out.printf("|%-16s|%-8s|%-10s|%-8s|%-12s|%-15s|%-12s|%-12s|%-24s|%-15s|%-11s|\n",
        "Mã Nhân Sự","Họ", "Tên",
        "Tuổi", "Địa Chỉ", "Số Điện Thoại", "Giới Tính",
        "Ngày Sinh", "Email", "Lương Cơ Bản", "Phòng Ban");
        System.out.printf("-----------------------------------------------------------------------------------------------------------------------------------------------------------\n");
        System.out.printf("|%-16s|%-8s|%-10s|%-8s|%-12s|%-15s|%-12s|%-12s|%-24s|%-15s|%-11s|\n",
        manhansu, ho, ten,
        tuoi, diachi, sodienthoai, gioitinh, 
        ngaysinh, email, luongcoban,
        phongban==null ? "Rong" : phongban.getMaPhongBan());
        System.out.println("===========================================================================================================================================================");
    }
    @Override 
    public void String loai(){
        return "Nhân Sự Chính Thức";
    }

    // Getter and Setter
    public int getSoNamKinhNghiem() {
        return sonamkinhnghiem;
    }
    public void setSoNamKinhNghiem(int sonamkinhnghiem) {
        this.sonamkinhnghiem = sonamkinhnghiem;
    }


    @Override 
    public double tinhLuong() {
        return luongcoban * 2.0;
    }
    @Override 
    public void nhapThongTin() {
        super.nhapThongTin();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so nam kinh nghiem: ");
        this.sonamkinhnghiem = sc.nextInt();
        sc.nextLine();
    }
}
