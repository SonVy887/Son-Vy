package QuanLy;
import java.util.Scanner;

import Object.*;

public class QuanLyPhongBan extends QuanLy{
    Scanner sc = new Scanner(System.in);
    
    @Override
    public void menuChinh() {
        while(true){
            System.out.println("\n========== MENU QUẢN LÝ PHÒNG BAN ==========");
            System.out.println("1. Thêm phòng ban");
            System.out.println("2. Thêm n phòng ban đầu tiên");
            System.out.println("3. Xóa phòng ban bằng mã");
            System.out.println("4. Tìm phòng ban bằng mã");
            System.out.println("5. Tìm phòng ban bằng tên");
            System.out.println("6. Sửa phòng ban");
            System.out.println("7. Thống kê phòng ban chưa có trưởng phòng");
            System.out.println("8. Thống kê phòng ban quản lý x dự án");
            System.out.println("9. In danh sách phòng ban");
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
                case 1:  danhsachphongban.addPhongBan(); break;
                case 2:  danhsachphongban.addSoLuongPhongBan(); break;
                case 3:  danhsachphongban.xoaPhongBan(); break;
                case 4:  danhsachphongban.timKiem(); break;
                case 5:  danhsachphongban.timKiemTheoTen(); break;
                case 6:  danhsachphongban.suaPhongBan(); break;
                case 7: danhsachphongban.thongKePhongBan(); break;
                case 8: danhsachduan.thongKeDuAnPb();break;
                case 9:  danhsachphongban.inThongTin(); break;
                default: System.out.println("Vui lòng nhập đúng số trong menu!");menuChinh();break;
            }
        }
    }
}
