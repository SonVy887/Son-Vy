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
            System.out.println("6. Tính bảng lương nhân sự");
            System.out.println("7. Thống kê lương tháng");
            System.out.println("8. In thông tin bảng lương");
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
                case 6: tinhLuongThang();break;
                case 7: 
                    System.out.print("Nhập số tháng mà bạn muốn thống kê: ");
                    int thang = sc.nextInt();
                    System.out.print("Nhập năm mà bạn muốn thống kê: ");
                    int nam = sc.nextInt();sc.nextLine();
                    danhsachbangluongthang.thongKeBangLuongThang(thang, nam);break;
                case 8: danhsachbangluongthang.inBangLuongThang();break;
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
        String manhansu = sc.nextLine().toUpperCase();
        System.out.print("Nhập tháng: ");
        int thang = sc.nextInt();sc.nextLine();
        System.out.print("Nhập năm: ");
        int nam = sc.nextInt();sc.nextLine();

        BangLuongThang check = danhsachbangluongthang.timKiemNhanSuThangNam(manhansu, thang, nam);

           if (check != null) {
              System.out.println(" Nhân sự " + manhansu + " đã có bảng lương trong tháng " + thang + "/" + nam + " (Mã: " + check.getMaBangLuongThang() + ")");
             return;
         }

        BangChamCongThang bcct = danhsachbangchamcongthang.timKiemNhanSuBCCT(manhansu, thang, nam);

        if(bcct == null) {
            System.out.println("Nhân sự chưa được chấm công tháng");
            return;
        }

        // set quy dinh thuong le
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
        blt.setPhuCapChucVu(tienchucvu);

        // set tiền thưởng phụ cấp thâm niên
        int namtn = danhsachnhansu.timKiem(bcct.getMaNhanSu()).tinhThamNien();
        double tienpctn = danhsachphucapthamnien.tinhThuongThamNien(namtn);
        blt.setPhuCapThamNien(tienpctn);
        
        // set trừ lương
        double luongtru = bcct.getSoNgayNghi() * 250_000;
        blt.setTruLuong(luongtru);

        // set tong luong
        double tongluong = (luongcoban + tienthuongle + thuongduan + tienchucvu + tienpctn) - luongtru; 
        blt.setTongLuong(tongluong);
    }
}
