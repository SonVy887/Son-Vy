package QuanLy;
import java.util.Scanner;

import Object.*;

public class QuanLyQDTL extends QuanLy {
    Scanner sc = new Scanner(System.in);
    
    @Override
    public void menuChinh() {
        while(true) {
            System.out.println("\n========== QUẢN LÝ QUY ĐỊNH THƯỞNG LỄ =========");
            System.out.println("1. Thêm quy định thưởng lễ");
            System.out.println("2. Thêm n quy định thưởng lễ đầu tiên");
            System.out.println("3. Sửa quy định thưởng lễ");
            System.out.println("4. Xóa quy định thưởng lễ");
            System.out.println("5. Tìm kiếm quy định thưởng lễ");
            System.out.println("6. Tìm kiếm tên quy định thưởng lễ");
            System.out.println("7. In danh sách quy định thưởng lễ");
            System.out.println("8. Xuất file danh sách quy định thưởng lễ");
            System.out.println("0. Để quay lại");
            System.out.print("Lựa chọn: ");

            int choice;

            try {
                choice = sc.nextInt();
                sc.nextLine();
            } catch(Exception e) {
                System.out.println("Vui lòng nhập số!");
                sc.nextLine();
                continue; 
            }
            if(choice == 0) break;

            switch(choice) {
                case 1: danhsachquydinhthuongle.themQuyDinhThuongLe();break;
                case 2: danhsachquydinhthuongle.them();break;
                case 3: danhsachquydinhthuongle.suaQuyDinhThuongLe();break;
                case 4: danhsachquydinhthuongle.xoaQuyDinhThuongLe();break;
                case 5: danhsachquydinhthuongle.timKiemTheoMa();break;
                case 6: danhsachquydinhthuongle.timKiemTheoTen();break;
                case 7: danhsachquydinhthuongle.inDanhSachQuyDinhThuongLe();break;
                case 8: danhsachquydinhthuongle.xuatFileThuongLe();break;
                case 9: danhsachquydinhthuongle.xuat();break;
                default: System.out.println("Vui lòng nhập đúng số trong menu!");menuChinh();break;
            }
        }
    }
}
