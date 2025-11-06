package QuanLy;
import java.util.Scanner;

import Object.*;

public class QuanLyNhanSu extends QuanLy{
    Scanner sc = new Scanner(System.in);
    
    @Override
    public void menuChinh() {
        while(true){
            System.out.println("\n========= MENU QUẢN LÝ NHÂN SỰ =========");
            System.out.println("1. Thêm nhân sự");
            System.out.println("2. Thêm n nhân sự đầu tiên");
            System.out.println("3. Xóa nhân sự bằng mã");
            System.out.println("4. Tìm kiếm nhân sự bằng mã");
            System.out.println("5. Sửa nhân sự bằng mã");
            System.out.println("6. Tìm kiếm nhân sự bằng họ");
            System.out.println("7. Tìm kiếm nhân sự bằng tên");
            System.out.println("8. Thống kê nhân sự theo giới tính");
            System.out.println("9. Thống kê nhân sự theo tuổi");
            System.out.println("10. Thống kê nhân sự theo năm kinh nghiệm");
            System.out.println("11. Thống kê nhân sự thực tập theo GPA");
            System.out.println("12. Xuất file thống kê giới tính");
            System.out.println("13. Xuất file thống kê tuổi");
            System.out.println("14. Xuất file thống kê năm kinh nghiệm");
            System.out.println("15. Xuất file thống kê GPA");
            System.out.println("16. Xuất file danh sách nhân sự");
            System.out.println("17. In chi tiết nhân sự chính thức");
            System.out.println("18. In chi tiết nhân sự thực tập");
            System.out.println("19. In danh sách nhân sự");
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
                case 1: danhsachnhansu.addNhanSu(); break;
                case 2: danhsachnhansu.addSoLuongNhanSu(); break;
                case 3: danhsachnhansu.xoaNhanSu(); break;
                case 4: danhsachnhansu.timKiem(); break;
                case 5: danhsachnhansu.suaNhanSu(); break;
                case 6: danhsachnhansu.timKiemTheoHo(); break;
                case 7: danhsachnhansu.timKiemTheoTen(); break;
                case 8: danhsachnhansu.thongKeGioiTinh(); break;
                case 9: danhsachnhansu.thongKeTuoi(); break;
                case 10: danhsachnhansu.thongKeNamKinhNghiem(); break;
                case 11: danhsachnhansu.thongKeGPA(); break;
                case 12: danhsachnhansu.xuatFileThongKeGioiTinh(); break;
                case 13: danhsachnhansu.xuatFileThongKeTuoi(); break;
                case 14: danhsachnhansu.xuatFileThongKeNamKinhNghiem(); break;
                case 15: danhsachnhansu.xuatFileThongKeGPA(); break;
                case 16: danhsachnhansu.xuatFileDanhSachNhanSu(); break;
                case 17: danhsachnhansu.inChiTietNhanSuChinhThuc(); break;
                case 18: danhsachnhansu.inChiTietNhanSuThucTap(); break;
                case 19: danhsachnhansu.in(); break;
                default: System.out.println("Vui lòng nhập đúng số trong menu"); menuChinh(); break;
            }
        }
    }
}
