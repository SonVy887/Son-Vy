package Object;
import java.util.Scanner;

public class DoAn {
    private String madoan;
    private String tendoan;
    private String diadiem;
    private PhongBan phongban;
    private String ngaybatdau;
    private String ngayketthuc;
    Scanner sc = new Scanner(System.in);

    // Constructor
    public DoAn(String madoan, String tendoan, String diadiem, PhongBan phongban, String ngaybatdau, String ngayketthuc) {
        this.madoan = madoan;
        this.tendoan = tendoan;
        this.diadiem = diadiem;
        this.phongban = phongban;
        this.ngaybatdau = ngaybatdau;
        this.ngayketthuc = ngayketthuc;
    }
    public DoAn(DoAn copy){
        this.madoan = copy.madoan;
        this.tendoan = copy.tendoan;
        this.diadiem = copy.diadiem;
        this.phongban = copy.phongban;
        this.ngaybatdau = copy.ngaybatdau;
        this.ngayketthuc = copy.ngayketthuc;
    }

    public DoAn() {
    }
    // nhap do an
    public void nhapDoAn(){
        System.out.print("Nhap ma do an: ");
        this.madoan = sc.nextLine().toUpperCase();
        
        System.out.print("Nhap ten do an: ");
        this.tendoan = sc.nextLine();

        System.out.print("Nhap dia diem do an: ");
        this.diadiem = sc.nextLine();

        System.out.print("Nhap ngay bat dau: ");
        this.ngaybatdau = sc.nextLine();

        System.out.print("Nhap ngay ket thuc: ");
        this.ngayketthuc = sc.nextLine();
    }
    // in thong tin do an
    public void inDoAn(){
        System.out.printf("|%-15s|%-17s|%-15s|%-15s|%-20s|%-20s|\n","Ma Do An","Ten Do An","Phong Ban","Dia Diem","Ngay Bat Dau","Ngay Ket Thuc");
        System.out.println("-------------------------------------------------------------------------------------------------------");
        System.out.printf("|%-15s|%-17s|%-15s|%-15s|%-20s|%-20s|\n",madoan,tendoan,phongban == null ? "Trong" : phongban.getMaPhongBan(),diadiem,ngaybatdau,ngayketthuc);
    }
    // Getter and Setter
    public String getMaDoAn() {
        return madoan;
     }
    public void setMaDoAn(String madoan) {
        this.madoan = madoan;
    }
    public String getTenDoAn() {
        return tendoan;
    }
    public void setTenDoAn(String tendoan) {
        this.tendoan = tendoan;
    }
    public String getDiaDiem(){
        return this.diadiem;
    }
    public void setDiaDiem(String diadiem){
        this.diadiem = diadiem;
    }
    public PhongBan getPhongBan(){
        return this.phongban;
    }
    public void setPhongBan(PhongBan pb){
        this.phongban = pb;
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
