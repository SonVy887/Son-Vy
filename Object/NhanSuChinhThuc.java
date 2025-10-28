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
    public void inChiTietCT() {
        System.out.printf("|%-8s|%-9s|%-10s|%-8s|%-16s|%-15s|%-12s|%-12s|%-24s|%-11s|%-10s|%,18.2f VNĐ\n",
        manhansu, ho, ten,
        tuoi, diachi, sodienthoai, gioitinh, 
        ngaysinh, email,
        phongban==null ? "Rong" : phongban.getMaPhongBan(), sonamkinhnghiem, luongcoban);
    }
    //===============================================================
    @Override
    public void inThongTin() {
        // System.out.println("===========================================================================================================================================================");
        // System.out.printf("|%-17s|%-8s|%-10s|%-8s|%-12s|%-15s|%-12s|%-12s|%-24s|%-11s|%-13s|%22s\n",
        // "Mã NS","Họ", "Tên",
        // "Tuổi", "Địa Chỉ", "Số Điện Thoại", "Giới Tính",
        // "Ngày Sinh", "Email", "Phòng Ban", "Năm K/N"," Lương Cơ Bản");
        // System.out.printf("-----------------------------------------------------------------------------------------------------------------------------------------------------------\n");
        System.out.printf("|%-8s|%-9s|%-10s|%-8s|%-16s|%-15s|%-12s|%-12s|%-24s|%-11s|%-13s|%,18.2f VNĐ\n",
        manhansu, ho, ten,
        tuoi, diachi, sodienthoai, gioitinh, 
        ngaysinh, email,
        phongban==null ? "Rong" : phongban.getMaPhongBan(), loai(), luongcoban);
        // System.out.println("===========================================================================================================================================================");
    }
    @Override 
    public String loai(){
        return "Chính Thức";
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
