package QuanLy;
import Object.*;
import java.util.Scanner;

public class QuanLyBLT extends QuanLy{
    Scanner sc = new Scanner(System.in);

    @Override
    public void menuChinh() {
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
                case 8: tinhLuongThang();;break;
                case 10: danhsachbangluongthang.inBangLuongThang();break;
            }
        }
    }
    // tinh bang luong thang
    public void tinhLuongThang() {
        System.out.print("Nhập mã bảng lương tháng (VD: BLT001): ");
        BangLuongThang blt = danhsachbangluongthang.timKiem(sc.nextLine().toUpperCase());

        if(blt == null) {
            System.out.println("Bảng lương tháng chưa được tạo");
            return;
        }
        
        System.out.print("Nhập mã nhân sự (VD:NS001): ");
        BangChamCongThang bcct = danhsachbangchamcongthang.timKiemNhanSuBCCT(sc.nextLine().toUpperCase());

        if(bcct == null) {
            System.out.println("Nhân sự chưa được chấm công tháng");
            return;
        }

        // set quy dinh thuong le
        danhsachquydinhthuongle.inDanhSachQuyDinhThuongLe();
        System.out.print("Nhập mã thưởng lễ: ");
        double tienthuongle = danhsachquydinhthuongle.timKiemTheoMa(sc.nextLine().toUpperCase()).getSoTienThuongLe();
        blt.setThuongLe(tienthuongle);

        // set luong cơ bản
        double luongcoban = danhsachnhansu.timKiem(bcct.getMaNhanSu()).getLuongCoBan();
        blt.setLuongCoBan(luongcoban);

        // set tháng và năm
        blt.setThang(bcct.getThang());
        blt.setNam(bcct.getNam());

        // set mã nhân sư
        blt.setMaNhanSu(bcct.getMaNhanSu());

        // set thưởng dự án
        double thuongduan = danhsachphancong.tienThuong(bcct.getMaNhanSu());
        blt.setThuongDuAn(thuongduan);

        //set thưởng chức Vụ
        String machucvu = danhsachnhansu.timKiem(bcct.getMaNhanSu()).getMaChucVu();
        double tienchucvu = danhsachchucvu.tienPhuCapChucVu(machucvu);

        // set tiền thưởng phụ cấp thâm niên
        int nam = danhsachnhansu.timKiem(bcct.getMaNhanSu()).tinhThamNien();
        double tienpctn = danhsachphucapthamnien.timKiemTheoNam(nam).getSoTienPhuCap();
        blt.setPhuCapThamNien(tienpctn);
        
        // set trừ lương
        double luongtru = bcct.getSoNgayNghi() * 250_000;
        blt.setTruLuong(luongtru);

        // set tong luong
        double tongluong = (luongcoban + tienthuongle + thuongduan + tienchucvu + tienpctn) - luongtru; 
        blt.setTongLuong(tongluong);
    }
}
