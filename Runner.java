import Manage.*;
import Object.*;
import Interface.*;
import java.util.Scanner;

public class Runner {
    private INhanSu danhsachnhansu;
    private IPhongBan danhsachphongban;
    private IDoAn danhsachdoan;
    private ILuongKhenThuong danhsachkhenthuong;
    private IPhanCong danhsachphancong;
    private IBangChamCong danhsachchamcong;
    private IBangLuong danhsachbangluong;
    Scanner sc = new Scanner(System.in);

    // mau chot lien ket
    public Runner() {
        danhsachnhansu = new DanhSachNhanSu();
        danhsachphongban = new DanhSachPhongBan(danhsachnhansu);
        danhsachdoan = new DanhSachDoAn(danhsachphongban);
        danhsachkhenthuong = new DanhSachLuongKhenThuong(danhsachnhansu);
        danhsachphancong = new DanhSachPhanCong(danhsachnhansu,danhsachdoan);
        danhsachchamcong = new DanhSachBangChamCong(danhsachnhansu);
        danhsachbangluong = new DanhSachBangLuong(danhsachchamcong, danhsachphancong, danhsachkhenthuong,danhsachnhansu);
    }



    public void run() {
        while(true){
            System.out.println("=======Chọn Quản Lý=======");
            System.out.println("1.Quản Lý Nhân Sự");
            System.out.println("2.Quản Lý Phòng Ban");
            System.out.println("3.Quản Lý Đồ Án");
            System.out.println("4.Quản lý Lương Khen Thưởng");
            System.out.println("5.Quản Lý Phân Công");
            System.out.println("6.Quản Lý Chấm Công");
            System.out.println("7.Quản lý bảng lương");
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
                case 6: quanLyChamCong();break;
                case 7: quanLyBangLuong();break;
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
                case 1: danhsachnhansu.addNhanSu(); break;
                case 2: danhsachnhansu.addSoLuongNhanSu(); break;
                case 3:danhsachnhansu.xoaNhanSu();break;
                case 4: danhsachnhansu.timKiem(); break;
                case 6: danhsachnhansu.in(); break;
                case 36: 
                    danhsachnhansu.addNhanSu(new NhanSuChinhThuc("NS001", "Nguyen", "An", 28, "Hà Nội","0901234567", "Nam", "1997-05-10", "an.nguyen@example.com",null, 3));
                    danhsachnhansu.addNhanSu(new NhanSuChinhThuc("NS002", "Tran", "Binh", 32, "TP.HCM", "0912345678", "Nam", "1993-09-21", "binh.tran@example.com", null, 7));
                    danhsachnhansu.addNhanSu(new NhanSuChinhThuc("NS003", "Le", "Chi", 26, "Đà Nẵng", "0923456789", "Nữ", "1999-03-15", "chi.le@example.com", null, 2));
                    danhsachnhansu.addNhanSu(new NhanSuChinhThuc("NS004", "Pham", "Dung", 30, "Hải Phòng", "0934567890", "Nữ", "1995-11-02", "dung.pham@example.com", null, 5));
                    danhsachnhansu.addNhanSu(new NhanSuChinhThuc("NS005", "Do", "Khang", 35, "Cần Thơ", "0945678901", "Nam", "1990-07-19", "khang.do@example.com", null, 10));
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
                case 1:  danhsachphongban.addPhongBan(); break;
                case 2:  danhsachphongban.addSoLuongPhongBan(); break;
                case 3:  danhsachphongban.xoaPhongBan(); break;
                case 4:  danhsachphongban.timKiem(); break;
                case 5:  danhsachphongban.timKiemTheoTen(); break;
                case 6:  danhsachphongban.setTruongPhong(); break;
                case 7:  danhsachphongban.themNhanSuPb(); break;
                case 8:  danhsachphongban.xoaNhanSuPb(); break;
                case 9:  danhsachphongban.suaPhongBan(); break;
                case 10: danhsachphongban.inNhanSuPb(); break;
                case 11: danhsachphongban.inThongTin(); break;
                case 12: 
                    danhsachphongban.addPhongBan(new PhongBan("PB001", "NC", null, "Trong"));
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
                case 1:  danhsachdoan.themDoAn(); break;
                case 2:  danhsachdoan.themSoLuongDoAn(); break;
                case 3:  danhsachdoan.suaDoAn(); break;
                case 4:  danhsachdoan.xoaDoAn(); break;
                case 5:  danhsachdoan.timDoAn(); break;
                case 6:  danhsachdoan.timKiemTheoTen(); break;
                case 7:  danhsachdoan.inThongTinDoAn(); break;
                case 8:  danhsachdoan.ganPhongBanDa();break;
                case 9:  danhsachdoan.timDoAnChuaPb(); break;

                case 36:
                    danhsachdoan.themDoAn(new DoAn("DA001", "AI", "Hà Nội", null, "01/03/2025", "30/06/2025"));
                    danhsachdoan.themDoAn(new DoAn("DA002", "Web", "TP.HCM", null, "15/02/2025", "15/07/2025"));
                    danhsachdoan.themDoAn(new DoAn("DA003", "App", "Đà Nẵng", null, "01/04/2025", "30/09/2025"));
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
                case 1: danhsachkhenthuong.themLuongKhen();break;
                case 2: danhsachkhenthuong.themNhieuLuongKhen();break;
                case 3: danhsachkhenthuong.xoaLuongKhen();break;
                case 4: danhsachkhenthuong.suaLuongKhen();break;
                case 5: danhsachkhenthuong.timKiemLuongKhen();break;
                case 6: danhsachkhenthuong.ganNhanSu();break;
                case 10: danhsachkhenthuong.in();break;
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
                case 1: danhsachphancong.addPhanCong();break;
                case 2: danhsachphancong.addSoLuongPhanCong();break;
                case 3: danhsachphancong.xoaPhanCong();break;
                case 4: danhsachphancong.suaPhanCong();break;
                case 5: danhsachphancong.timKiem();break;
                case 6: danhsachphancong.phanCongDoAn();break;
                case 7: danhsachphancong.in();break;

                case 36: 
                    danhsachphancong.addPhancong(new PhanCong("PC001",null,null,"30"));
                    danhsachphancong.addPhancong(new PhanCong("PC002",null,null,"25"));
                    danhsachphancong.addPhancong(new PhanCong("PC003",null,null,"21"));
            }
        }
    }
    private void quanLyChamCong(){
        while(true){
            System.out.println("1. Thêm bảng chấm công");
            System.out.println("2. Thêm n bảng chấm công đầu tiên");
            System.out.println("3. Xóa bảng chấm công");
            System.out.println("4. Sửa bảng chấm công");
            System.out.println("5. Tìm kiếm bảng chấm công");
            System.out.println("6. Chấm công nhân sự");
            System.out.println("7. In bảng chấm công");
            System.out.println("0. Để thoát");
            System.out.print("Lựa chọn: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if(choice == 0) break;
            switch(choice) {
                case 1: danhsachchamcong.themBangChamCong();break;
                case 2: danhsachchamcong.them();break;
                case 3: danhsachchamcong.xoaBangChamCong();break;
                case 4: danhsachchamcong.suaBangChamCong();break;
                case 5: danhsachchamcong.timKiem();break;
                case 6: danhsachchamcong.setNhanSuCc();break;
                case 7: danhsachchamcong.inBangChamCong();break;
            }
        }
    }
    private void quanLyBangLuong() {
        while(true){
            System.out.println("\n");
            System.out.println("1. Thêm bảng lương");
            System.out.println("2. Thêm n bảng lương đầu tiên");
            System.out.println("8. Chấm công nhân sự");
            System.out.println("0. Quay Lại");
            System.out.println("10. In thông tin bảng lương");
            System.out.print("Lựa chọn: ");


            int choice = sc.nextInt();
            sc.nextLine();
            if(choice == 0) break;

            switch(choice){
                case 1: danhsachbangluong.themBangLuong();break;
                case 2: danhsachbangluong.them();break;
                case 8: danhsachbangluong.themNhanSu();break;
                case 10: danhsachbangluong.inThongTin();break;
            }
        }
    }
}

