package QuanLy;

import java.util.Scanner;

public class QuanLyQDPCTN extends QuanLy{
    Scanner sc = new Scanner(System.in);
    
    @Override
    public void menuChinh() {
        while(true) {
            System.out.println("\n========== QUẢN LÝ QUY ĐỊNH THÂM NIÊN =========");
            System.out.println("1. Thêm quy định phụ cấp thâm niên");
            System.out.println("2. Thêm n quy định phụ cấp thâm niên đầu tiên");
            System.out.println("3. Sửa quy định phụ cấp thâm niên");
            System.out.println("4. Xóa quy định phụ cấp thâm niên");
            System.out.println("5. Tìm kiếm quy định phụ cấp thâm niên");
            System.out.println("6. Tìm kiếm số năm hưởng quy định phụ cấp thâm niên");
            System.out.println("7. Tìm kiếm theo số tiền quy định phụ cấp thâm niên");
            System.out.println("8. Thống kê năm phụ cấp có tiền thưởng trên 1tr");
            System.out.println("9. Thống kê tổng phụ cấp thâm niên");
            System.out.println("10. In danh sách phụ cấp thâm niên");
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
                case 1: danhsachphucapthamnien.themQuyDinhPCTN();break;
                case 2: danhsachphucapthamnien.them();break;
                case 3: danhsachphucapthamnien.suaQuyDinhPCTN();break;
                case 4: danhsachphucapthamnien.xoaQuyDinhPCTN();break;
                case 5: danhsachphucapthamnien.tiemKiemTheoMa();break;
                case 6: danhsachphucapthamnien.timKiemTheoNam();break;
                case 7: danhsachphucapthamnien.timKiemTheoSoTien();break;
                case 8: danhsachphucapthamnien.thongKeTienPCTN();break;
                case 9: danhsachphucapthamnien.thongKePhuCapThamNien();break;
                default: System.out.println("Vui lòng nhập đúng số trong menu"); menuChinh(); break;
            }
        }
    }
}
