package QuanLy;
import Object.*;
import java.util.Scanner;

public class QuanLyDuAn extends QuanLy {
    Scanner sc = new Scanner(System.in);
    @Override
    public void menuChinh() {
        while(true){
            System.out.println("\n========== MENU QUẢN LÝ DỰ ÁN ==========");
            System.out.println("1. Thêm 1 dự án");
            System.out.println("2. Thêm n dự án đầu tiên");
            System.out.println("3. Sửa dự án");
            System.out.println("4. Xóa dự án");
            System.out.println("5. Tìm dự án theo mã");
            System.out.println("6. Tìm kiếm dự án theo tên");
            System.out.println("7. Chọn phòng ban quản lý dự án");
            System.out.println("8. Thống kê dự án chưa có phòng ban");
            System.out.println("9. In danh sách dự án");
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

            switch (choice) {
                case 1:  danhsachduan.themDuAn(); break;
                case 2:  danhsachduan.themSoLuongDuAn(); break;
                case 3:  danhsachduan.suaDuAn(); break;
                case 4:  danhsachduan.xoaDuAn(); break;
                case 5:  danhsachduan.timDuAn(); break;
                case 6:  danhsachduan.timKiemTheoTen(); break;
                case 7:  chonPhongBan();break;
                case 8:  danhsachduan.thongKeDuAnChuaPb(); break;
                case 9:  danhsachduan.inThongTinDuAn(); break;


                default:System.out.println("Vui lòng chọn đúng số trong menu!"); menuChinh(); break;
            }
        }
    }
    // chon phong ban quan lý dự án
    public void chonPhongBan() {
        System.out.print("Nhập mã dự án (VD:DA001): ");
        DuAn da = danhsachduan.timDuAn(sc.nextLine().toUpperCase());

        if(da == null) {
            System.out.println("Dự án chưa được tạo");
            return;
        }

        System.out.println("Nhập mã phòng ban (VD:PB001): ");
        PhongBan pb = danhsachphongban.timKiem(sc.nextLine().toUpperCase());

        if(pb == null) {
            System.out.println("Phòng ban chưa được khởi tạo");
            return;
        }

        da.setPhongBan(pb.getMaPhongBan());
    }
}
