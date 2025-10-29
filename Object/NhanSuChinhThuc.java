package Object;
import java.util.Scanner;
public class NhanSuChinhThuc extends NhanSu {
    private int sonamkinhnghiem;
    

    // Constructor
    public NhanSuChinhThuc(String manhansu, String ho, String ten, String diachi, String sodienthoai, String gioitinh, String ngaysinh, String maphongban, String ngayvaolam, String machucvu, int sonamkinhnghiem) {
        super(manhansu, ho, ten, diachi, sodienthoai, gioitinh, ngaysinh, maphongban, ngayvaolam, machucvu);
        this.sonamkinhnghiem = sonamkinhnghiem;
        
    }
    public NhanSuChinhThuc() {
        super();
    }
    public NhanSuChinhThuc(NhanSuChinhThuc copy) {
        super(copy);
        this.sonamkinhnghiem = copy.sonamkinhnghiem;
    }
    public void inChiTietCT() {
        System.out.printf("|%-8s|%-9s|%-10s|%-16s|%-15s|%-12s|%-12s|%-11s|%-11s|%-16s|%-10s|%,18.2f VNĐ\n",
        manhansu, ho, ten,
        diachi, sodienthoai, gioitinh, 
        ngaysinh, machucvu,
        maphongban=="" ? "Rong" : maphongban, ngayvaolam, sonamkinhnghiem, luongcoban);
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
        System.out.printf("|%-8s|%-9s|%-10s|%-16s|%-15s|%-12s|%-12s|%-11s|%-11s|%-16s|%-13s|%,18.2f VNĐ\n",
        manhansu, ho, ten,
        diachi, sodienthoai, gioitinh, 
        ngaysinh, machucvu,
        maphongban=="" ? "Rong" : maphongban, ngayvaolam, loai(), luongcoban);
        // System.out.println("===========================================================================================================================================================");
    }
    @Override 
    public String loai(){
        return "CT";
    }

    // Getter and Setter
    public int getSoNamKinhNghiem() {
        return sonamkinhnghiem;
    }
    public void setSoNamKinhNghiem(int sonamkinhnghiem) {
        this.sonamkinhnghiem = sonamkinhnghiem;
    }


    
    @Override 
    public void nhapThongTin() {
        super.nhapThongTin();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số năm kinh nghiệm: ");
        this.sonamkinhnghiem = sc.nextInt();
        sc.nextLine();
    }
}
