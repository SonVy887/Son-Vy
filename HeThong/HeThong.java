package HeThong;
import QuanLy.*;
import java.util.Scanner;

import DanhSach.DanhSachNhanSu;

public class HeThong {
    QuanLy[] qlns;
    Scanner sc = new Scanner(System.in);

    public HeThong() {
        qlns = new QuanLy[10];

        QuanLy.docFile();
        qlns[0] = new QuanLyNhanSu();
        qlns[1] = new QuanLyPhongBan();
        qlns[2] = new QuanLyDuAn();
        qlns[3] = new QuanLyChucVu();
        qlns[4] = new QuanLyPhanCong();
        qlns[5] = new QuanLyBCCN();
        qlns[6] = new QuanLyBCCT();
        qlns[7] = new QuanLyQDPCTN();
        qlns[8] = new QuanLyQDTL();
        qlns[9] = new QuanLyBLT(); 
    }

    public void menuChinh() {
        while(true){
            System.out.println("\n========= CHỨC NĂNG QUẢN LÝ =========");
            System.out.println("1.Quản Lý Nhân Sự");
            System.out.println("2.Quản Lý Phòng Ban");
            System.out.println("3.Quản Lý Dự Án");
            System.out.println("4.Quản Lý Chức Vụ");
            System.out.println("5.Quản Lý Phân Công");
            System.out.println("6.Quản Lý Chấm Công Ngày");
            System.out.println("7.Quản Lý Chấm Công Tháng");
            System.out.println("8.Quản lý Quy Định Phụ Cấp Tham Niên");
            System.out.println("9.Quản Lý Quy Định Thưởng Lễ");
            System.out.println("10.Quản Lý Bảng Lương Tháng");
            System.out.println("11. Thống kê theo quý");
            System.out.println("0. Để thoát");
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

            if(choice == 0) {
                QuanLy.xuatFile();
                break;
            }

            // lua chon
            switch(choice){
                case 1: qlns[0].menuChinh();break;
                case 2: qlns[1].menuChinh();break;
                case 3: qlns[2].menuChinh();break;
                case 4: qlns[3].menuChinh();break;
                case 5: qlns[4].menuChinh();break;
                case 6: qlns[5].menuChinh();break;
                case 7: qlns[6].menuChinh();break;
                case 8: qlns[7].menuChinh();break;
                case 9: qlns[8].menuChinh();break;
                case 10: qlns[9].menuChinh();break;
                case 11: QuanLy.thongKeTheoQuy();break;
                default: System.out.println("Vui lòng chọn đúng (1-10)!");menuChinh();break;
            }
        }
    }
}
