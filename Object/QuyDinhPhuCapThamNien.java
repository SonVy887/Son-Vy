package Object;
import java.util.Scanner;

public class QuyDinhPhuCapThamNien {
    private String mapcthamnien;
    private int sonam;
    private double sotienphucap; // tren tháng
    Scanner sc = new Scanner(System.in);

    public QuyDinhPhuCapThamNien(){}
    public QuyDinhPhuCapThamNien(String mapcthamnien, int sonam, double sotienphucap) {
        this.mapcthamnien = mapcthamnien;
        this.sonam = sonam;
        this.sotienphucap = sotienphucap;
    }
    public QuyDinhPhuCapThamNien(QuyDinhPhuCapThamNien copy) {
        this.mapcthamnien = copy.mapcthamnien;
        this.sonam = copy.sonam;
        this.sotienphucap = copy.sotienphucap;
    }

    // nhap
    public void nhap() {
        System.out.print("Nhập mã phụ cấp thâm niên (VD: PCTN1): ");
        this.mapcthamnien = sc.nextLine().toUpperCase();

        System.out.print("Nhập số năm thâm niên: ");
        this.sonam = sc.nextInt();

        System.out.print("Nhập số tiền phụ cấp thâm niên (trên tháng): ");
        this.sotienphucap = sc.nextDouble();
        sc.nextLine();
    }
    // in
    public void in() {
        System.out.printf("|%-15s|%-17d|%,18.0f/tháng|\n",mapcthamnien,sonam,sotienphucap);
    }
    public String getMaPCThamNien() {
        return mapcthamnien;
    }
    public void setMaPCThamNien(String mapcthamnien) {
        this.mapcthamnien = mapcthamnien;
    }
    public int getSoNam() {
        return sonam;
    }
    public void setSoNam(int sonam) {
        this.sonam = sonam;
    }
    public double getSoTienPhuCap() {
        return sotienphucap;
    }
    public void setSoTienPhuCap(double sotienphucap) {
        this.sotienphucap = sotienphucap;
    }

}
