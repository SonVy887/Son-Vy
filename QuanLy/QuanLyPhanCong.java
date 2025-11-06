package QuanLy;
import java.io.IOException;
import java.util.Scanner;
import Object.*;

public class QuanLyPhanCong extends QuanLy {
    Scanner sc = new Scanner(System.in);
    
    @Override
    public void menuChinh() {
        while(true){
            System.out.println("\n========== MENU QUẢN LÝ PHÂN CÔNG ==========");
            System.out.println("1. Thêm phân công");
            System.out.println("2. Thêm n phân công đầu tiên");
            System.out.println("3. Xóa phân công");
            System.out.println("4. Sửa phân công");
            System.out.println("5. Tìm kiếm phân công");
            System.out.println("6. Phân công nhân sự");
            System.out.println("7. In thông tin");
            System.out.println("8. Xuất file phân công");
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

            switch(choice){
                case 1: themPhanCong();;break;
                case 2: them();break;
                case 3: danhsachphancong.xoaPhanCong();break;
                case 4: danhsachphancong.suaPhanCong();break;
                case 5: danhsachphancong.timKiem();break;
                case 6: phanCongDuAn();break;
                case 7: danhsachphancong.in();break;
                case 8: danhsachphancong.xuatFilePhanCong(); break;
                default: System.out.println("Vui lòng chọn đúng số trong menu");menuChinh();break;
            }
        }
    }
    // nhap 
    public void themPhanCong() {
        System.out.print("Nhập mã phân công (VD: PC001): ");
        String maphancong = sc.nextLine().toUpperCase();

        System.out.print("Nhập mã dự án (VD:DA001): ");
        DuAn da = danhsachduan.timDuAn(sc.nextLine().toUpperCase());

        if(da == null) {
            System.out.println("Dự án chưa được tạo");
            return;
        }

        System.out.print("Nhập thời gian: ");
        int thoigian = sc.nextInt();sc.nextLine();

        System.out.print("Nhập độ khó: ");
        PhanCong pc = new PhanCong(maphancong, "", da.getMaDuAn(), thoigian, 0, "");
        bangDoKho(pc);
        
        danhsachphancong.addPhancong(pc);
    }
    // them n phan cong dau tien
    public void them() {
        System.out.println("Nhập n phân công đầu tiên: ");
        int n = sc.nextInt();sc.nextLine();

        for(int i = 0; i < n;i++) {
            themPhanCong();
        }
    }
    // // phan cong dự án cho nhân Sự
    public void phanCongDuAn() {
        System.out.print("Nhập mã phân công (VD:PC001): ");
        PhanCong pc = danhsachphancong.timKiem(sc.nextLine().toUpperCase());

        if(pc == null) {
            System.out.println("Phân công chưa tạo");
            return;
        }

        System.out.print("Nhập mã nhân sự (VD:NS001): ");
        NhanSu ns = danhsachnhansu.timKiem(sc.nextLine().toUpperCase());

        if(ns == null) {
            System.out.println("Nhân sự chưa được tạo");
            return;
        }

        pc.setNhanSu(ns.getMaNhanSu());

    }
    // bang do kho
    public void bangDoKho(PhanCong pc) {
        while(true) {
            System.out.println("\n=========== BẢNG ĐỘ KHÓ ==========");
            System.out.println("1. Khó");
            System.out.println("2. Trung bình");
            System.out.println("3. Dễ");
            System.out.println("0. Để thoát");
            System.out.print("Lựa chọn: ");

            int choice;

            try{
                choice = sc.nextInt();
                sc.nextLine();
            }catch(Exception e) {
                System.out.println("Vui lòng nhập số!");
                sc.nextLine();
                continue;
            }

            switch(choice) {
                case 1:pc.setDoKho("Khó");pc.setThuong(2_000_000);break;
                case 2:pc.setDoKho("Trung bình");pc.setThuong(1_000_000);break;
                case 3:pc.setDoKho("Dễ");pc.setThuong(600_000);break;
                default:System.out.println("Vui lòng chọn đún số trong menu");bangDoKho(pc);break;
            }
        }
    }

}
