package QuanLy;
import Object.*;
import java.io.IOException;
import java.util.Scanner;


public class QuanLyBCCN extends QuanLy {
    Scanner sc = new Scanner(System.in);

    @Override
    public void menuChinh() {
        while(true){
            System.out.println("\n========== MENU QUẢN LÝ CHẤM CÔNG ==========");
            System.out.println("1. Thêm bảng chấm công");
            System.out.println("2. Thêm n bảng chấm công đầu tiên");
            System.out.println("3. Xóa bảng chấm công");
            System.out.println("4. Sửa bảng chấm công");
            System.out.println("5. Tìm kiếm bảng chấm công");
            System.out.println("6. Thống kê trạng thái trong 1 năm");
            System.out.println("7. In bảng chấm công");
            System.out.println("0. Để quay lại");
            System.out.print("Lựa chọn: ");

            int choice;

            try {
                choice = sc.nextInt();
                sc.nextLine(); 
            } catch (Exception e) {
                System.out.println("Vui lòng nhập số!");
                sc.nextLine();
                continue;      
            }

            if(choice == 0) break;
            switch(choice) {
                case 1: themBangChamCongNgay();break;
                case 2: them();break;
                case 3: danhsachbangchamcongngay.xoaBangChamCongNgay();break;
                case 4: danhsachbangchamcongngay.suaBangChamCongNgay();break;
                case 5: danhsachbangchamcongngay.timKiem();break;
                case 6: danhsachbangchamcongngay.thongKeChamCongNgay();break;
                case 7: danhsachbangchamcongngay.inBangChamCongNgay();break;
            }
        }
    }
    // them bang cham cong ngay
    public void themBangChamCongNgay() {
        System.out.print("Nhập mã chấm công ngày để kiểm tra(VD:CC001): ");
        String machamcong = sc.nextLine().toUpperCase();
        if(danhsachbangchamcongngay.kiemTra(machamcong)) {
            System.out.print("Mã đã tồn tại.Vui lòng nhập lại: ");
            return;
        } 

        System.out.println("Nhập mã nhân sự (VD:NS001): ");
        NhanSu ns = danhsachnhansu.timKiem(sc.nextLine().toUpperCase());

        if(ns == null) {
            System.out.println("Nhân sự chưa được tạo");
            return;
        }

        System.out.print("Nhập ngày: ");
        int ngay = sc. nextInt();sc.nextLine();

        System.out.print("Nhập tháng: ");
        int thang = sc.nextInt();sc.nextLine();

        System.out.print("Nhập năm: ");
        int nam = sc.nextInt();sc.nextLine();

        System.out.println("Nhập trạng thái: ");
        BangChamCongNgay bccn = new BangChamCongNgay(machamcong, ns.getMaNhanSu(), ngay, thang, nam, null);
        bangTrangThai(bccn);

        danhsachbangchamcongngay.themBangChamCongNgay(bccn);
    }
    // them n phần từ
    public void them() {
        System.out.print("Nhập n bảng chấm công ngày đầu tiên: ");
        int n = sc.nextInt();sc.nextLine();

        for(int i = 0; i < n;i++) {
            themBangChamCongNgay();
        }
    }
    // bang status
    public void bangTrangThai(BangChamCongNgay bccn) {
        while(true) {
            System.out.println("Chọn trạng thái làm việc:");
            System.out.println("1. Đi làm");
            System.out.println("2. Nghỉ phép");
            System.out.println("3. Nghỉ ốm");
            System.out.println("4. Nghỉ không phép");
            System.out.println("0. Để thoát");
            System.out.print("Lựa chọn của bạn (1-4): ");
            int choice;

            try{
                choice = sc.nextInt();
                sc.nextLine();
            }catch(Exception e) {
                System.out.println("Vui lòng nhập số!");
                sc.nextLine();
                continue;
            }
            if (choice == 0) break;

            switch (choice) {
                case 1:
                    bccn.setStatus("Đi làm");
                    break;
                case 2:
                    bccn.setStatus("Nghỉ phép");
                    break;
                case 3:
                    bccn.setStatus("Nghỉ ốm");
                    break;
                case 4:
                    bccn.setStatus("Nghỉ không phép");
                    break;
                default:
                    System.out.println("Vui lòng chọn đúng số trong menu!");
                    bangTrangThai(bccn);
                    break;
            }
        }
    }
}
