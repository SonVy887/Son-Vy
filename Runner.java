import Manage.*;
import Object.*;
import Interface.*;
import java.util.Scanner;

public class Runner {
    private INhanSu danhsachnhansu;
    private IPhongBan danhsachphongban;
    private IDuAn danhsachduan;
    private ILuongKhenThuong danhsachkhenthuong;
    private IPhanCong danhsachphancong;
    private IBangChamCongNgay danhsachbangchamcongngay;
    private IBangLuong danhsachbangluong;
    Scanner sc = new Scanner(System.in);

    // mau chot lien ket
    public Runner() {
        danhsachnhansu = new DanhSachNhanSu();
        danhsachphongban = new DanhSachPhongBan(danhsachnhansu);
        danhsachduan = new DanhSachDuAn(danhsachphongban);
        danhsachkhenthuong = new DanhSachLuongKhenThuong(danhsachnhansu);
        danhsachphancong = new DanhSachPhanCong(danhsachnhansu,danhsachduan);
        danhsachbangchamcongngay = new DanhSachBangChamCongNgay(danhsachnhansu);
        danhsachbangluong = new DanhSachBangLuong(danhsachbangchamcongngay, danhsachphancong, danhsachkhenthuong,danhsachnhansu);
    }



    public void run() {
        while(true){
            System.out.println("\n======= Chọn Quản Lý =======");
            System.out.println("1.Quản Lý Nhân Sự");
            System.out.println("2.Quản Lý Phòng Ban");
            System.out.println("3.Quản Lý Dự Án");
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
                case 3: quanLyDuAn();break;
                case 4: quanLyLuongKhenThuong();break;
                case 5: quanLyPhanCong();break;
                case 6: quanLyBangChamCongNgay();break;
                case 7: quanLyBangLuong();break;
            }//switch
        }// while
    }// run()

        
    private void quanLyNhanSu(){
            //Chuc nang
        while(true){
            System.out.println("\n======== Menu Quản Lý Nhân Sự =========");
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




            int choice = sc.nextInt();
            sc.nextLine();
            if(choice == 0) break;

            String maNhanSu = null;
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
                default: System.out.println("Lua chon khong hop le. Vui long thu lai!"); break;
}
        }
    }
    private void quanLyPhongBan(){
        while(true){
            System.out.println("\n========= Menu Quản Lý Phòng Ban ========");
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
            System.out.println("11. In danh sách phòng ban");
            System.out.println("12. Xuat file phong ban");
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
                case 12: danhsachphongban.xuatFilePhongBan(); break;
                default: System.out.println("Nhap sai roi ni oi !!!");break;
            }
        }
    }
    private void quanLyDuAn(){
        while(true){
            System.out.println("\n========== MENU QUẢN LÝ Dự ÁN ==========");
            System.out.println("1. Thêm 1 dự án");
            System.out.println("2. Thêm n dự án đầu tiên");
            System.out.println("3. Sửa dự án");
            System.out.println("4. Xóa dự án");
            System.out.println("5. Tìm dự án theo mã");
            System.out.println("6. Tìm kiếm dự án theo tên");
            System.out.println("7. In danh sách dự án");
            System.out.println("8. Gán phòng ban cho dự án");
            System.out.println("9. Tìm dự án chưa có phòng ban");
            System.out.println("10. Xuất file dự án");
            System.out.println("0. Quay lại");
            System.out.print("Lựa chọn: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if(choice == 0) break;

            switch (choice) {
                case 1:  danhsachduan.themDuAn(); break;
                case 2:  danhsachduan.themSoLuongDuAn(); break;
                case 3:  danhsachduan.suaDuAn(); break;
                case 4:  danhsachduan.xoaDuAn(); break;
                case 5:  danhsachduan.timDuAn(); break;
                case 6:  danhsachduan.timKiemTheoTen(); break;
                case 7:  danhsachduan.inThongTinDuAn(); break;
                case 8:  danhsachduan.ganPhongBanDa();break;
                case 9:  danhsachduan.timDuAnChuaPb(); break;
                case 10: danhsachduan.xuatFileDuAn(); break;

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
            System.out.println("7. Xuất file lương khen thưởng");
            System.out.println("10. In thông tin lương khen thưởng");
            System.out.println("0. Để quay lại");

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
                case 7: danhsachkhenthuong.xuatFileLuongKhen();break;
                case 10: danhsachkhenthuong.in();break;
            }
        }
    }
    private void quanLyPhanCong() {
        while(true){
            System.out.println("\n========== MENU QUẢN LÝ PHÂN CÔNG ==========");
            System.out.println("1. Thêm phân công");
            System.out.println("2. Thêm nhiều phân công");
            System.out.println("3. Xóa phân công");
            System.out.println("4. Sửa phân công");
            System.out.println("5. Tìm kiếm phân công");
            System.out.println("6. Phân công nhân sự");
            System.out.println("7. In thông tin");
            System.out.println("8. Xuất file phân công");
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
                case 8: danhsachphancong.xuatFilePhanCong(); break;

                
            }
        }
    }
    private void quanLyBangChamCongNgay(){
        while(true){
            System.out.println("\n========== MENU QUẢN LÝ CHẤM CÔNG ==========");
            System.out.println("1. Thêm bảng chấm công");
            System.out.println("2. Thêm n bảng chấm công đầu tiên");
            System.out.println("3. Xóa bảng chấm công");
            System.out.println("4. Sửa bảng chấm công");
            System.out.println("5. Tìm kiếm bảng chấm công");
            System.out.println("6. Chấm công nhân sự");
            System.out.println("7. In bảng chấm công");
            System.out.println("8. Xuất file bảng chấm công");
            System.out.println("0. Để thoát");
            System.out.print("Lựa chọn: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if(choice == 0) break;
            switch(choice) {
                case 1: danhsachbangchamcongngay.themBangChamCong();break;
                case 2: danhsachbangchamcongngay.them();break;
                case 3: danhsachbangchamcongngay.xoaBangChamCong();break;
                case 4: danhsachbangchamcongngay.suaBangChamCong();break;
                case 5: danhsachbangchamcongngay.timKiem();break;
                case 6: danhsachbangchamcongngay.setNhanSuCc();break;
                case 7: danhsachbangchamcongngay.inBangChamCong();break;
                case 8: danhsachbangchamcongngay.xuatFileBangChamCong();break;
            }
        }
    }
    private void quanLyBangLuong() {
        while(true){
            System.out.println("\n========== MENU QUẢN LÝ BẢNG LƯƠNG ==========");
            System.out.println("1. Thêm bảng lương");
            System.out.println("2. Thêm n bảng lương đầu tiên");
            System.out.println("3. Xóa bảng lương");
            System.out.println("4. Sửa bảng lương");
            System.out.println("5. Tìm kiếm bảng lương");
            System.out.println("8. Tính bảng lương nhân sự");
            System.out.println("0. Quay Lại");
            System.out.println("10. In thông tin bảng lương");
            System.out.print("Lựa chọn: ");


            int choice = sc.nextInt();
            sc.nextLine();
            if(choice == 0) break;

            switch(choice){
                case 1: danhsachbangluong.themBangLuong();break;
                case 2: danhsachbangluong.them();break;
                case 3: danhsachbangluong.xoaBangLuong();break;
                case 4: danhsachbangluong.suaBangLuong();break;
                case 5: danhsachbangluong.timKiem();break;
                case 8: danhsachbangluong.tinhBangLuongNhanSu();break;
                case 10: danhsachbangluong.inThongTin();break;
            }
        }
    }
}

