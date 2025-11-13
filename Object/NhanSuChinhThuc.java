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
    @Override
    public void inThongTin() {
        super.inThongTin();
        System.out.printf("%10s|\n", sonamkinhnghiem);
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
