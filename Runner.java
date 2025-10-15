import Manage.*;
import Object.*;
import Interface.*;
import java.util.Scanner;

public class Runner {
    private INhanSu nhanSuService;
    private IPhongBan phongBanService;
    private IDoAn doAnService;
    private ILuongKhenThuong lktService;
    private IPhanCong phanCongService;
    Scanner sc = new Scanner(System.in);

    // mau chot lien ket
    public Runner() {
        nhanSuService = new DanhSachNhanSu();
        phongBanService = new DanhSachPhongBan(nhanSuService);
        doAnService = new DanhSachDoAn(phongBanService);
        lktService = new DanhSachLuongKhenThuong(nhanSuService);
        phanCongService = new DanhSachPhanCong(nhanSuService,doAnService);
    }



    public void run() {
        while(true){
            System.out.println("=======Chọn Quản Lý=======");
            System.out.println("1.Quản Lý Nhân Sự");
            System.out.println("2.Quản Lý Phòng Ban");
            System.out.println("3.Quản Lý Dồ Án");
            System.out.println("4.Quản lý Lương Khen Thưởng");
            System.out.println("5.Quản Lý Phân Công");
            System.out.print("Lựa chọn: ");
            int choice = sc.nextInt();

            if(choice == 8) break;




            // lua chon
            switch(choice){
                case 1: quanLyNhanSu(); break;
                case 2: quanLyPhongBan();break;
                case 3: quanLyDoAn();break;
                case 4: quanLyLuongKhenThuong();break;
                case 5: quanLyPhanCong();break;
            }//switch
        }// while
    }// run()

        
    private void quanLyNhanSu(){
            //Chuc nang
        while(true){
            System.out.println("========Menu Quản Lý Nhân Sự=========");
            System.out.println("1. Them nhan su");
            System.out.println("2. Them \"n\" nhan su");
            System.out.println("3. Xoa nhan su bằng mã nhân sự");
            System.out.println("4. Tim kiem nhan su bang ma");
            System.out.println("6. In thong tin nhan su");
            System.out.println("0. Quay lai");
            System.out.print("Lua chon: ");


            int choice = sc.nextInt();
            sc.nextLine();
            if(choice == 0) break;

            String maNhanSu = null;
            switch (choice) {
                case 1: nhanSuService.addNhanSu(); break;
                case 2: nhanSuService.addSoLuongNhanSu(); break;
                case 3:nhanSuService.xoaNhanSu();break;
                case 4: nhanSuService.timKiem(); break;
                case 6: nhanSuService.in(); break;
                case 36: 
                    nhanSuService.addNhanSu(new NhanSuChinhThuc("NS001", "Nguyen", "An", 28, "Hà Nội","0901234567", "Nam", "1997-05-10", "an.nguyen@example.com",null, 3));
                    nhanSuService.addNhanSu(new NhanSuChinhThuc("NS002", "Tran", "Binh", 32, "TP.HCM", "0912345678", "Nam", "1993-09-21", "binh.tran@example.com", null, 7));
                    nhanSuService.addNhanSu(new NhanSuChinhThuc("NS003", "Le", "Chi", 26, "Đà Nẵng", "0923456789", "Nữ", "1999-03-15", "chi.le@example.com", null, 2));
                    nhanSuService.addNhanSu(new NhanSuChinhThuc("NS004", "Pham", "Dung", 30, "Hải Phòng", "0934567890", "Nữ", "1995-11-02", "dung.pham@example.com", null, 5));
                    nhanSuService.addNhanSu(new NhanSuChinhThuc("NS005", "Do", "Khang", 35, "Cần Thơ", "0945678901", "Nam", "1990-07-19", "khang.do@example.com", null, 10));
                    break;
                default: System.out.println("Lua chon khong hop le. Vui long thu lai!"); break;
}
        }
    }
    private void quanLyPhongBan(){
        while(true){
            System.out.println("=========Menu Quản Lý Phòng Ban========");
            System.out.println("1. Them phong ban");
            System.out.println("2. Them so luong phong ban");
            System.out.println("3. Xoa phong ban bang ma");
            System.out.println("4. Tim phong ban bang ma");
            System.out.println("5. Tim phong ban bang ten");
            System.out.println("6. Cap nhat truong phong");
            System.out.println("7. Them nhan su vao phong ban");
            System.out.println("8. Xoa nhan su trong phong ban");
            System.out.println("9. Sua phong ban");
            System.out.println("10. Thông tin nhân sự trong phòng ban");
            System.out.println("0. De quay lai");
            System.out.print("Lua chon: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if(choice == 0) break;


            switch (choice) {
                case 1:  phongBanService.addPhongBan(); break;
                case 2:  phongBanService.addSoLuongPhongBan(); break;
                case 3:  phongBanService.xoaPhongBan(); break;
                case 4:  phongBanService.timKiem(); break;
                case 5:  phongBanService.timKiemTheoTen(); break;
                case 6:  phongBanService.setTruongPhong(); break;
                case 7:  phongBanService.themNhanSuPb(); break;
                case 8:  phongBanService.xoaNhanSuPb(); break;
                case 9:  phongBanService.suaPhongBan(); break;
                case 10: phongBanService.inNhanSuPb(); break;
                case 11: phongBanService.inThongTin(); break;
                case 12: 
                    PhongBan pb = new PhongBan("PB001", "NC", null, "Trong");
                    phongBanService.addPhongBan(pb);
                    break;
                default: System.out.println("Nhap sai roi ni oi !!!");break;
            }
        }
    }
    private void quanLyDoAn(){
        while(true){
            System.out.println("\n========== MENU QUẢN LÝ ĐỒ ÁN ==========");
            System.out.println("1. Thêm 1 đồ án");
            System.out.println("2. Thêm nhiều đồ án");
            System.out.println("3. Sửa đồ án");
            System.out.println("4. Xóa đồ án");
            System.out.println("5. Tìm đồ án theo mã");
            System.out.println("6. Tìm kiếm đồ án theo tên");
            System.out.println("7. In danh sách đồ án");
            System.out.println("8. Gán phòng ban cho đồ án");
            System.out.println("9. Tìm đồ án chưa có phòng ban");
            System.out.println("0. Quay lại");
            System.out.print("Lựa chọn: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if(choice == 0) break;

            switch (choice) {
                case 1:  doAnService.themDoAn(); break;
                case 2:  doAnService.themSoLuongDoAn(); break;
                case 3:  doAnService.suaDoAn(); break;
                case 4:  doAnService.xoaDoAn(); break;
                case 5:  doAnService.timDoAn(); break;
                case 6:  doAnService.timKiemTheoTen(); break;
                case 7:  doAnService.inThongTinDoAn(); break;
                case 8:  doAnService.ganPhongBanDa();break;
                case 9:  doAnService.timDoAnChuaPb(); break;

                case 36:
                    doAnService.themDoAn(new DoAn("DA001", "AI", "Hà Nội", null, "01/03/2025", "30/06/2025"));
                    doAnService.themDoAn(new DoAn("DA002", "Web", "TP.HCM", null, "15/02/2025", "15/07/2025"));
                    doAnService.themDoAn(new DoAn("DA003", "App", "Đà Nẵng", null, "01/04/2025", "30/09/2025"));
                    break;
                default:System.out.println("Lựa chọn không hợp lệ!");break;
            }
        }
    }
    private void quanLyLuongKhenThuong(){
        while(true){
            System.out.println("==========Menu Quản Lý Khen Thưởng==========");
            System.out.println("1. Thêm lương khen thưởng");
            System.out.println("2. Thêm n lương khen thưởng");
            System.out.println("3. Xóa lương khen thưởng");
            System.out.println("4. Sửa lương khen thưởng");
            System.out.println("5. Tìm kiếm lương khen thưởng");
            System.out.println("6. Cập nhật nhân sự được khen thưởng");
            System.out.println("0. Để quay lại");
            System.out.println("10. In thông tin lương khen thưởng");
            System.out.print("Lựa chọn: ");
            int choice = sc.nextInt();

            sc.nextLine();

            if(choice == 0) break;

            switch(choice){
                case 1: lktService.themLuongKhen();break;
                case 2: lktService.themNhieuLuongKhen();break;
                case 3: lktService.xoaLuongKhen();break;
                case 4: lktService.suaLuongKhen();break;
                case 5: lktService.timKiemLuongKhen();break;
                case 6: lktService.ganNhanSu();break;
                case 10: lktService.in();break;
            }
        }
    }
    private void quanLyPhanCong() {
        while(true){
            System.out.println("1. Thêm phân công");
            System.out.println("2. Thêm nhiều phân công");
            System.out.println("3. Xóa phân công");
            System.out.println("4. Sửa phân công");
            System.out.println("5. Tìm kiếm phân công");
            System.out.println("6. Phân công nhân sự");
            System.out.println("7. In thông tin");
            System.out.println("0. Để quay lại");
            System.out.print("Lựa chọn: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if(choice == 0) break;

            switch(choice){
                case 1: phanCongService.addPhanCong();break;
                case 2: phanCongService.addSoLuongPhanCong();break;
                case 3: phanCongService.xoaPhanCong();break;
                case 4: phanCongService.suaPhanCong();break;
                case 5: phanCongService.timKiem();break;
                case 6: 
                    System.out.print("Nhập mã phân công: ");
                    String maPhanCong = sc.nextLine().toUpperCase();

                    phanCongService.phanCongDoAn(maPhanCong);break;
                case 7: phanCongService.in();break;

                case 36: 
                    phanCongService.addPhancong(new PhanCong("PC001",null,null,"30"));
                    phanCongService.addPhancong(new PhanCong("PC002",null,null,"25"));
                    phanCongService.addPhancong(new PhanCong("PC003",null,null,"21"));
            }
        }
    }
}

