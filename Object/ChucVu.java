package Object;
import java.util.Scanner;

public class ChucVu {
    private String machucvu;
    private String tenchucvu;
    private double phucapchucvu;
    Scanner sc = new Scanner(System.in);

    public ChucVu(){}
    public ChucVu(String machucvu, String tenchucvu, double phucapchucvu) {
        this.machucvu = machucvu;
        this.tenchucvu = tenchucvu;
        this.phucapchucvu = phucapchucvu;
    }
    public ChucVu(ChucVu copy) {
        this.machucvu = copy.machucvu;
        this.tenchucvu = copy.tenchucvu;
        this.phucapchucvu= copy.phucapchucvu;
    }

    public void nhapChucVu() {
        System.out.print("Nhập mã chức vụ (VD: CV001): ");
        this.machucvu = sc.nextLine().toUpperCase();

        bangTenChucVu();
    }
    public void inChucVu() {
        System.out.printf("|%-15s|%-15s|%,18.0fVNĐ|\n", machucvu, tenchucvu, phucapchucvu);
    }
    public void bangTenChucVu() {
        System.out.println("\n=========== BẢNG CHỨC VỤ ==========");
        System.out.println("1. Trưởng phòng");
        System.out.println("2. Phó phòng");
        System.out.println("3. Giám đốc");
        System.out.println("0. Để thoát");
        System.out.print("Lựa chọn của bạn(1-3): ");

        int choice = sc.nextInt();sc.nextLine();

        switch(choice) {
            case 1:this.tenchucvu = "Trưởng phòng"; this.phucapchucvu = 2_000_000;break;
            case 2:this.tenchucvu = "Phó phòng"; this.phucapchucvu = 1_000_000;break;
            case 3: this.tenchucvu = "Giám đốc"; this.phucapchucvu = 5_000_000;break;
            case 4: this.tenchucvu = "Phó Giám Đốc"; this.phucapchucvu = 3_000_000; break;
            default:System.out.println("Lựa chọn không hợp lệ.Vui lòng thử lại.");
        }
    }

    public String getMaChucVu() {
        return machucvu;
    }
    public void setMaChucVu(String machucvu) {
        this.machucvu = machucvu;
    }
    public String getTenChucVu() {
        return tenchucvu;
    }
    public void setTenChucVu(String tenchucvu) {
        this.tenchucvu = tenchucvu;
    }
    public double getPhuCapChucVu() {
        return this.phucapchucvu;
    }
    public void setPhuCapChucVu(Double phucapchucvu) {
        this.phucapchucvu = phucapchucvu;
    }

    
    

}
