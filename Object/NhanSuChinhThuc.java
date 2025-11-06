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
        System.out.printf("|%-8s|%-9s|%-10s|%-16s|%-15s|%-12s|%-13s|%-11s|%-11s|%-16s|%-10s|%,18.2f VNĐ|\n",
        manhansu, ho, ten,
        diachi, sodienthoai, gioitinh, 
        ngaysinh, machucvu == null ? "Trống" : machucvu,
        maphongban== null ? "Trống" : maphongban, ngayvaolam, sonamkinhnghiem, luongcoban);
    }
    @Override
    public void inThongTin() {
        super.inThongTin();
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
