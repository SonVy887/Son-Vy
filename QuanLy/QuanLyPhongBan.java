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
            System.out.println("6. Cập nhật trưởng phòng");
            System.out.println("7. Sửa phòng ban");
            System.out.println("8. In danh sách phòng ban");
            System.out.println("9. Xuất file phòng ban");
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
                case 6:  setTruongPhong(); break;
                case 7:  danhsachphongban.suaPhongBan(); break;
                case 8:  danhsachphongban.inThongTin(); break;
                case 9:  danhsachphongban.xuatFilePhongBan(); break;
                default: System.out.println("Vui lòng nhập đúng số trong menu!");menuChinh();break;
            }
        }
    }
    public void setTruongPhong() {
        System.out.print("Nhập mã phòng ban (VD:PB001): ");
        PhongBan pb = danhsachphongban.timKiem(sc.nextLine().toUpperCase());

        if(pb == null) {
            System.out.println("Phòng ban chưa được tạo");
            return;
        }

        System.out.print("Nhập mã nhân sự làm trưởng phòng (VD:NS001): ");
        NhanSu ns = danhsachnhansu.timKiem(sc.nextLine().toUpperCase());

        if(ns == null) {
            System.out.println("Nhân sự chưa được khởi tạo");
            return;
        }

        pb.setTruongPhong(ns.getMaNhanSu());
        ns.setMaChucVu("CV001");
    }
}
