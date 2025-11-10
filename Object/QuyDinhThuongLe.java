package Object;
import java.util.Scanner;


public class QuyDinhThuongLe {
    private String mathuongle;
    private String tenthuongle;
    private String ngaythangle;
    private double sotienthuongle;
    Scanner sc = new Scanner(System.in);

    public QuyDinhThuongLe(){}
    public QuyDinhThuongLe(String mathuongle, String tenthuongle, String ngaythangle, double sotienthuongle) {
        this.mathuongle = mathuongle;
        this.tenthuongle = tenthuongle;
        this.ngaythangle = ngaythangle;
        this.sotienthuongle = sotienthuongle;
    }
    public QuyDinhThuongLe(QuyDinhThuongLe copy) {
        this.mathuongle = copy.mathuongle;
        this.tenthuongle = copy.tenthuongle;
        this.ngaythangle = copy.ngaythangle;
        this.sotienthuongle = copy.sotienthuongle;
    }

    public void nhapQuyDinhThuongLe() {
        System.out.print("Nhập mã thưởng lễ (VD:TL001): ");
        this.mathuongle = sc.nextLine().toUpperCase();

        System.out.print("Nhập tên thưởng lễ: ");
        this.tenthuongle = sc.nextLine();

        System.out.print("Nhập ngày tháng (DD/MM): ");
        this.ngaythangle = sc.nextLine();

        System.out.print("Nhập số tiền thưởng lễ: ");
        this.sotienthuongle = sc.nextDouble();
        sc.nextLine();
    }
    public void in() {
        System.out.printf("|%-15s|%-20s|%-15s|%,20.2fVNĐ|\n",mathuongle,tenthuongle,ngaythangle,sotienthuongle);
    }

    public String getMaThuongLe() {
        return mathuongle;
    }
    public void setMaThuongLe(String mathuongle) {
        this.mathuongle = mathuongle;
    }
    public String getTenThuongLe() {
        return tenthuongle;
    }
    public void setTenThuongLe(String tenthuongle) {
        this.tenthuongle = tenthuongle;
    }
    public String getNgayThangLe() {
        return ngaythangle;
    }
    public void setNgayThangLe(String ngaythangle) {
        this.ngaythangle = ngaythangle;
    }
    public double getSoTienThuongLe() {
        return sotienthuongle;
    }
    public void setSoTienThuongLe(double sotienthuongle) {
        this.sotienthuongle = sotienthuongle;
    }

    
}
