package QuanLy;
import Object.*;
import java.util.Scanner;

public class QuanLyBCCT extends QuanLy {
    Scanner sc = new Scanner(System.in);
    @Override
    public void menuChinh() {
        while(true){
            System.out.println("\n========== MENU QUẢN LÝ CHẤM CÔNG THÁNG ==========");
            System.out.println("1. Thêm bảng chấm công tháng");
            System.out.println("2. Thêm n bảng chấm công tháng đầu tiên");
            System.out.println("3. Xóa bảng chấm công tháng");
            System.out.println("4. Sửa bảng chấm công tháng");
            System.out.println("5. Tìm kiếm bảng chấm công tháng");
            System.out.println("6. Chấm công tháng cho nhân sự");
            System.out.println("7. Thống kê bảng chấm công tháng");
            System.out.println("8. In bảng chấm công tháng");
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
                case 1: danhsachbangchamcongthang.themBangChamCongThang();break;
                case 2: danhsachbangchamcongthang.them();break;
                case 3: danhsachbangchamcongthang.xoaBangChamCongThang();break;
                case 4: danhsachbangchamcongthang.suaBangChamCongThang();break;
                case 5: danhsachbangchamcongthang.timKiem();break;
                case 6: chamCongThang();break;
                case 7: danhsachbangchamcongthang.thongKeBanChamCongThang();break;
                case 8: danhsachbangchamcongthang.inBangChamCongThang();break;
                default:System.out.println("Vui lòng nhập đúng số trong menu!"); menuChinh(); break;
            }
        }
    }
    // cham cong thang cho nhan su
    public void chamCongThang() {
        System.out.print("Nhập mã bảng chấm công tháng tháng (VD:BCCT001): ");
        BangChamCongThang bcct = danhsachbangchamcongthang.timKiem(sc.nextLine().toUpperCase());

        if(bcct == null) {
            System.out.println("Bảng chấm công tháng chưa được tạo");
            return;
        }

        System.out.print("Nhập mã nhân sự (VD:NS001): ");
        String manhansu = sc.nextLine().toUpperCase();
        System.out.print("Nhập tháng: ");
        int thang = sc.nextInt();sc.nextLine();
        System.out.print("Nhập năm: ");
        int nam = sc.nextInt();sc.nextLine();
        BangChamCongNgay bccn = danhsachbangchamcongngay.timKiemNSCCN(manhansu, thang, nam);
        
        if(bccn == null) {
            System.out.println("Nhân sự chưa được chấm công ngày");
            return;
        }

        int[] chamcongngay = danhsachbangchamcongngay.tinhNgay(bccn.getMaNhanSu(), bccn.getThang(), bccn.getNam());

        bcct.setSoNgayLamViec(chamcongngay[0]);
        bcct.setSoNgayNghi(chamcongngay[1]);
        bcct.setMaNhanSu(bccn.getMaNhanSu());
        bcct.setNam(bccn.getNam());
        bcct.setThang(bccn.getThang());
    }
}
