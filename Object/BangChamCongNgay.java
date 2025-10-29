package Object;
import java.util.Scanner;

public class BangChamCongNgay {
    private String machamcong;
    private String manhansu;
    private String ngaylamviec;
    private String status;
    Scanner sc = new Scanner(System.in);


    // Constructor
    public BangChamCongNgay(String machamcong, String manhansu, String ngaylamviec, String status) {
        this.machamcong = machamcong;
        this.manhansu = manhansu;
        this.ngaylamviec = ngaylamviec;
        this.status = status;
    }
    public BangChamCongNgay() {}
    public BangChamCongNgay(BangChamCongNgay copy){
        this.machamcong = copy.machamcong;
        this.manhansu = copy.manhansu;
        this.ngaylamviec = copy.ngaylamviec;
        this.status = copy.status;
    }

    public void in() {
        // System.out.println("\n=============================================================================================================================");
        // System.out.printf("|%-15s|%-20s|%-15s|%-15s|%-15s|\n","Mã NV", "Tổng ngày công", "Nghỉ P", "Nghỉ Ốm", "Nghỉ KP");
        // System.out.println("------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("|%-15s|%-15s|%-18s|%-10s\n",
        machamcong == "" ? "Trống" : machamcong,
        manhansu == "" ? "Trống" : manhansu,
        ngaylamviec == "" ? "Trống" : ngaylamviec,
        status == "" ? "Trống" : status);
        // System.out.println("==============================================================================================================================");
    }

    public void nhap() {
        System.out.print("Nhập mã bảng chấm công ngày (VD: BCC001): ");
        this.machamcong = sc.nextLine().toUpperCase();
    }
    public void bangTrangThai() {
        while(true) {
            System.out.println("Chọn trạng thái làm việc:");
            System.out.println("1. Đi làm");
            System.out.println("2. Nghỉ phép");
            System.out.println("3. Nghỉ ốm");
            System.out.println("4. Nghỉ không phép");
            System.out.println("0. Để thoát");
            System.out.print("Lựa chọn của bạn (1-4): ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 0) break;

            switch (choice) {
                case 1:
                    this.status = "Đi làm";
                    break;
                case 2:
                    this.status = "Nghỉ phép";
                    break;
                case 3:
                    this.status = "Nghỉ ốm";
                    break;
                case 4:
                    this.status = "Nghỉ không phép";
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.Vui lòng thử lại.");
                    break;
            }
        }
    }


    // Getters and Setters
    public String getMaChamCong() {
        return machamcong;
    }
    public void setMaChamCong(String machamcong) {
        this.machamcong = machamcong;
    }
    public String getMaNhanSu() {
        return manhansu;
    }
    public void setMaNhanSu(String manhansu) {
        this.manhansu = manhansu;
    }
    public String getNgayLamViec() {
        return ngaylamviec;
    }
    public void setNgayLamViec(String ngaylamviec) {
        this.ngaylamviec = ngaylamviec;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

}
