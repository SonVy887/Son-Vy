package QuanLy;
import Object.*;
import java.util.Scanner;

public class QuanLyChucVu extends QuanLy {
    Scanner sc = new Scanner(System.in);

    @Override
    public void menuChinh() {
        while(true) {
            System.out.println("\n========== MENU QUẢN LÝ CHỨC VỤ =========");
            System.out.println("1. Thêm chức vụ");
            System.out.println("2. Thêm n chức vụ đầu tiên");
            System.out.println("3. Xóa chức vụ");
            System.out.println("4. Sửa chức vụ");
            System.out.println("5. Tìm kiếm chức vụ");
            System.out.println("6. Tìm kiếm theo tên chức vụ");
            System.out.println("7. Trao chức vụ cho nhân sự");
            System.out.println("8. In danh sách chức vụ");
            System.out.println("0. Để quay lại");
            System.out.print("Lựa chọn: ");

            int choice;

            try {
                choice = sc.nextInt();
                sc.nextLine();
            }catch(Exception e) {
                System.out.println("Vui lòng nhập số!");
                sc.nextLine();
                continue;
            }
            if(choice == 0) break;
            
            switch(choice) {
                case 1: danhsachchucvu.themBangChucVu();break;
                case 2: danhsachchucvu.them();break;
                case 3: danhsachchucvu.xoaBangChucVu();break;
                case 4: danhsachchucvu.suaBangChucVu();break;
                case 5: danhsachchucvu.timKiem();break;
                case 6: danhsachchucvu.timKiemTheoTen();break;
                case 7: traoChucVu();break;
                case 8: danhsachchucvu.inThongTinChucVu();break;
            }
        }
    }
    // trao chuc vu
    public void traoChucVu() {
        danhsachchucvu.inThongTinChucVu();
        System.out.println();

        System.out.print("Nhập mã chức vụ (VD:CV001): ");
        ChucVu cv = danhsachchucvu.timKiem(sc.nextLine().toUpperCase());

        if(cv == null) {
            System.out.println("Chức vụ chưa được tạo");
            return;
        }

        System.out.print("Nhập mã nhân sự (VD:NS001): ");
        NhanSu ns = danhsachnhansu.timKiem(sc.nextLine().toUpperCase());

        if(ns == null) {
            System.out.println("Nhân sự chưa được tạo");
            return;
        }

        if(cv.getMaChucVu().equals("CV001")) {
            danhsachphongban.inThongTin();
            System.out.println();

            System.out.print("Nhập mã phòng ban: ");
            PhongBan pb = danhsachphongban.timKiem(sc.nextLine().toUpperCase());

            if(pb == null) {
                System.out.println("Phòng ban chưa được tạo!");
                return;
            }
            pb.setTruongPhong(ns.getMaNhanSu());

            System.out.println("Nhập ngày nhận chức (VD:dd/MM/yyyy): ");
            pb.setNgayNhanChuc(sc.nextLine());
        }
        ns.setMaChucVu(cv.getMaChucVu());

    }
}
