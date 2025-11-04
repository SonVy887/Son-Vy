import Manage.*;
import Object.*;
import java.util.Scanner;

// sua lai
public class Menu {
    private DanhSachNhanSu danhsachnhansu;
    private DanhSachPhongBan danhsachphongban;
    private DanhSachDuAn danhsachduan;
    private DanhSachPhanCong danhsachphancong;
    private DanhSachBangChamCongNgay danhsachbangchamcongngay;
    private DanhSachBangChamCongThang danhsachbangchamcongthang;
    private DanhSachQuyDinhThuongLe danhsachquydinhthuongle;
    private DanhSachPhuCapThamNien danhsachphucapthamnien;
    private DanhSachBangLuongThang danhsachbangluongthang;
    private DanhSachChucVu danhsachchucvu;
    Scanner sc = new Scanner(System.in);

    // mau chot lien ket
    public Menu() {
        danhsachnhansu = new DanhSachNhanSu();
        danhsachphongban = new DanhSachPhongBan(danhsachnhansu);
        danhsachduan = new DanhSachDuAn(danhsachphongban);
        danhsachchucvu = new DanhSachChucVu(danhsachnhansu);
        danhsachphancong = new DanhSachPhanCong(danhsachnhansu,danhsachduan);
        danhsachbangchamcongngay = new DanhSachBangChamCongNgay(danhsachnhansu);
        danhsachbangchamcongthang = new DanhSachBangChamCongThang(danhsachbangchamcongngay, danhsachnhansu);
        danhsachquydinhthuongle = new DanhSachQuyDinhThuongLe();
        danhsachphucapthamnien = new DanhSachPhuCapThamNien();
        danhsachbangluongthang = new DanhSachBangLuongThang(danhsachbangchamcongthang, danhsachphancong, danhsachnhansu, danhsachphucapthamnien, danhsachquydinhthuongle, danhsachchucvu);
    }

    public void run() {
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
                danhsachphucapthamnien.xuatFilePhuCapThamNien();
                danhsachduan.xuatFileDanhSachDuAn();
                danhsachquydinhthuongle.xuatFileThuongLe();
                danhsachphongban.xuatFilePhongBan();
                danhsachphancong.xuatFilePhanCong();
                danhsachchucvu.xuatFileBangChucVu();
                danhsachbangchamcongngay.xuatFileBangChamCongNgay();
                danhsachbangchamcongthang.xuatFileBangChamCongThang();
                danhsachnhansu.xuatFileDanhSachNhanSu();
                danhsachbangluongthang.xuatFileBangLuongThang();
                break;
            }
            // lua chon
            switch(choice){
                case 1: quanLyNhanSu(); break;
                case 2: quanLyPhongBan();break;
                case 3: quanLyDuAn();break;
                case 4: quanLyChucVu();break;
                case 5: quanLyPhanCong();break;
                case 6: quanLyBangChamCongNgay();break;
                case 7: quanLyChamCongThang();break;
                case 8: quanLyQuyDinhPhuCapThamNien();break;
                case 9: quanLyQuyDinhThuongLe();break;
                case 10: quanLyBangLuongThang();break;
                default: System.out.println("Vui lòng chọn đúng (1-10)!");run();
            }//switch
        }// while
    }// run()

        
    private void quanLyNhanSu(){
            //Chuc nang
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
}
        
    
    private void quanLyPhongBan(){
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
                case 6:  danhsachphongban.setTruongPhong(); break;
                case 7:  danhsachphongban.suaPhongBan(); break;
                case 8: danhsachphongban.inThongTin(); break;
                case 9: danhsachphongban.xuatFilePhongBan(); break;
                default: System.out.println("Nhap sai roi ni oi !!!");break;
            }
        }
    }
    private void quanLyDuAn(){
        while(true){
            System.out.println("\n========== MENU QUẢN LÝ DỰ ÁN ==========");
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
                case 1:  danhsachduan.themDuAn(); break;
                case 2:  danhsachduan.themSoLuongDuAn(); break;
                case 3:  danhsachduan.suaDuAn(); break;
                case 4:  danhsachduan.xoaDuAn(); break;
                case 5:  danhsachduan.timDuAn(); break;
                case 6:  danhsachduan.timKiemTheoTen(); break;
                case 7:  danhsachduan.inThongTinDuAn(); break;
                case 8:  danhsachduan.ganPhongBanDa();break;
                case 9:  danhsachduan.timDuAnChuaPb(); break;
                case 10: danhsachduan.xuatFileDanhSachDuAn(); break;

                default:System.out.println("Lựa chọn không hợp lệ!");break;
            }
        }
    }
    private void quanLyChucVu() {
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
            System.out.println("9. Xuất file chức vụ");
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
                case 7: danhsachchucvu.traoChucVuNhanSu();break;
                case 8: danhsachchucvu.inThongTinChucVu();break;
                case 9: danhsachchucvu.xuatFileBangChucVu();break;
            }

        }
    }
    private void quanLyPhanCong() {
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
            switch(choice) {
                case 1: danhsachbangchamcongngay.themBangChamCongNgay();break;
                case 2: danhsachbangchamcongngay.them();break;
                case 3: danhsachbangchamcongngay.xoaBangChamCongNgay();break;
                case 4: danhsachbangchamcongngay.suaBangChamCongNgay();break;
                case 5: danhsachbangchamcongngay.timKiem();break;
                case 6: danhsachbangchamcongngay.chamCongNhanSu();break;
                case 7: danhsachbangchamcongngay.inBangChamCongNgay();break;
                case 8: danhsachbangchamcongngay.xuatFileBangChamCongNgay();break;
            }
        }
    }
    private void quanLyChamCongThang(){
        while(true){
            System.out.println("\n========== MENU QUẢN LÝ CHẤM CÔNG THÁNG ==========");
            System.out.println("1. Thêm bảng chấm công tháng");
            System.out.println("2. Thêm n bảng chấm công tháng đầu tiên");
            System.out.println("3. Xóa bảng chấm công tháng");
            System.out.println("4. Sửa bảng chấm công tháng");
            System.out.println("5. Tìm kiếm bảng chấm công tháng");
            System.out.println("6. Chấm công tháng cho nhân sự");
            System.out.println("7. In bảng chấm công tháng");
            System.out.println("8. Xuất file bảng chấm công tháng");
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

            switch(choice) {
                case 1: danhsachbangchamcongthang.themBangChamCongThang();break;
                case 2: danhsachbangchamcongthang.them();break;
                case 3: danhsachbangchamcongthang.xoaBangChamCongThang();break;
                case 4: danhsachbangchamcongthang.suaBangChamCongThang();break;
                case 5: danhsachbangchamcongthang.timKiem();break;
                case 6: danhsachbangchamcongthang.chamCongThangChoNhanSu();break;
                case 7: danhsachbangchamcongthang.inBangChamCongThang();break;
                case 8: danhsachbangchamcongthang.xuatFileBangChamCongThang();break;
            }
        }
    }
    private void quanLyBangLuongThang() {
        while(true){
            System.out.println("\n========== MENU QUẢN LÝ BẢNG LƯƠNG THÁNG ==========");
            System.out.println("1. Thêm bảng lương");
            System.out.println("2. Thêm n bảng lương đầu tiên");
            System.out.println("3. Xóa bảng lương");
            System.out.println("4. Sửa bảng lương");
            System.out.println("5. Tìm kiếm bảng lương");
            System.out.println("8. Tính bảng lương nhân sự");
            System.out.println("10. In thông tin bảng lương");
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
                case 1: danhsachbangluongthang.themBangLuongThang();break;
                case 2: danhsachbangluongthang.them();break;
                case 3: danhsachbangluongthang.xoaBangLuongThang();break;
                case 4: danhsachbangluongthang.suaBangLuongThang();break;
                case 5: danhsachbangluongthang.timKiem();break;
                case 8: danhsachbangluongthang.tinhLuongThang();;break;
                case 10: danhsachbangluongthang.inBangLuongThang();break;
            }
        }
    }
    private void quanLyQuyDinhPhuCapThamNien() {
        while(true) {
            System.out.println("\n========== QUẢN LÝ QUY ĐỊNH PHỤ CẤP THÂM NIÊN ==========");
            System.out.println("1. Thêm quy định phụ cấp thâm niên");
            System.out.println("2. Thêm n quy định phụ cấp thâm niên đầu tiên");
            System.out.println("3. Sửa quy định phụ cấp thâm niên ");
            System.out.println("4. Xóa quy định phụ cấp thâm niên ");
            System.out.println("5. Tìm kiếm quy định phụ cấp thâm niên");
            System.out.println("6. Tìm kiếm số tiền phụ cấp thâm niên");
            System.out.println("7. Tìm kiếm năm phụ cấp thâm niên");
            System.out.println("8. In phụ cấp thâm niên");
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

            switch(choice) {
                case 1: danhsachphucapthamnien.themQuyDinhPCTN();break;
                case 2: danhsachphucapthamnien.them();break;
                case 3: danhsachphucapthamnien.suaQuyDinhPCTN();break;
                case 4: danhsachphucapthamnien.xoaQuyDinhPCTN();break;
                case 5: danhsachphucapthamnien.tiemKiemTheoMa();break;
                case 6: danhsachphucapthamnien.timKiemTheoSoTien();break;
                case 7: danhsachphucapthamnien.timKiemTheoNam();break;
                case 8: danhsachphucapthamnien.inPhucCapThamNien();break;
            }
        }
    }
    private void quanLyQuyDinhThuongLe() {
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
            }
        }
    }
}

