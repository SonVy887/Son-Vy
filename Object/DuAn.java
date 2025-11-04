package Object;
import java.util.Scanner;

public class DuAn {
    private String maduan;
    private String tenduan;
    private String diadiem;
    private String maphongban;
    private String ngaybatdau;
    private String ngayketthuc;
    Scanner sc = new Scanner(System.in);

    // Constructor
    public DuAn(String maduan, String tenduan, String diadiem, String maphongban, String ngaybatdau, String ngayketthuc) {
        this.maduan = maduan;
        this.tenduan = tenduan;
        this.diadiem = diadiem;
        this.maphongban = maphongban;
        this.ngaybatdau = ngaybatdau;
        this.ngayketthuc = ngayketthuc;
    }
    public DuAn(DuAn copy){
        this.maduan = copy.maduan;
        this.tenduan = copy.tenduan;
        this.diadiem = copy.diadiem;
        this.maphongban = copy.maphongban;
        this.ngaybatdau = copy.ngaybatdau;
        this.ngayketthuc = copy.ngayketthuc;
    }

    public DuAn() {
    }
    // nhap do an
    public void nhapDuAn(){
        System.out.print("Nhập mã dự án(VD: DA001): ");
        this.maduan = sc.nextLine().toUpperCase();
        
        System.out.print("Nhập tên dự án: ");
        this.tenduan = sc.nextLine();

        System.out.print("Nhập địa điểm: ");
        this.diadiem = sc.nextLine();

        System.out.print("Nhập ngày bắt đầu: ");
        this.ngaybatdau = sc.nextLine();

        System.out.print("Nhập ngày kết thúc: ");
        this.ngayketthuc = sc.nextLine();

    }
    // in thong tin do an
    public void inDuAn(){
        // System.out.println("==========================================================================================================================");
        // System.out.printf("|%-15s|%-30s|%-15s|%-15s|%-20s|%-20s|\n","Mã  Án","Tên Đồ Án","Phòng Ban","Địa Điểm","Ngày Bắt Đầu","Ngày Kết Thúc");
        // System.out.println("--------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("|%-15s|%-30s|%-15s|%-15s|%-20s|%-20s|\n",maduan,tenduan,maphongban == null ? "Trống" : maphongban,diadiem,ngaybatdau,ngayketthuc);
    }
    // Getter and Setter
    public String getMaDuAn() {
        return maduan;
     }
    public void setMaDuAn(String maduan) {
        this.maduan = maduan;
    }
    public String getTenDuAn() {
        return tenduan;
    }
    public void setTenDuAn(String tenduan) {
        this.tenduan = tenduan;
    }
    public String getDiaDiem(){
        return this.diadiem;
    }
    public void setDiaDiem(String diadiem){
        this.diadiem = diadiem;
    }
    public String getPhongBan(){
        return this.maphongban;
    }
    public void setPhongBan(String maphongban){
        this.maphongban = maphongban;
    }
    public String getNgayBatDau(){
        return this.ngaybatdau;
    }
    public void setNgayBatDau(String ngaybatdau){
        this.ngaybatdau = ngaybatdau;
    }
    public String getNgayKetThuc(){
        return this.ngayketthuc;
    }
    public void setNgayKetThuc(String ngayketthuc){
        this.ngayketthuc = ngayketthuc;
    }
}
