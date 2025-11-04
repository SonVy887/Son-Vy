package Manage;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import Interface.*;
import Object.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;


public class DanhSachNhanSu implements INhanSu {
    private int n;// so luong nhan su 
    private NhanSu[] dsns;
    Scanner sc = new Scanner(System.in); 

    //constructor
    public DanhSachNhanSu() {
        dsns = new NhanSu[0];
        n = 0;
        docFileDanhSachNhanSu();
    }
    
    // them nhan su
    @Override
    public void addNhanSu(NhanSu ns){
        dsns = Arrays.copyOf(dsns, n + 1);
        dsns[n] = ns;
        this.n++;
    }
    // them n nhan su dau tien
    @Override
    public void addSoLuongNhanSu(){// da test
        while(true){
            System.out.println("==========================");
            System.out.println("1. Nhập nhân sự chính thức");
            System.out.println("2. Nhập nhân sự thực tập");
            System.out.println("0. Để thoát");
            System.out.print("Lựa chọn: ");

            int choice = sc.nextInt();
            sc.nextLine();
            if(choice == 0) break;

            System.out.print("Nhập n nhân sự đầu tiên: ");
            this.n = sc.nextInt();
            sc.nextLine();

            dsns = new NhanSu[n];

            for(int i = 0; i < n;i++){
                if(choice == 1)
                    dsns[i] = new NhanSuChinhThuc();
                else if ( choice == 2)
                    dsns[i] = new NhanSuThucTap();
                dsns[i].nhapThongTin();
            }
        }
    }
    @Override
    public void addNhanSu(){// da test
        System.out.println("==========================");
        System.out.println("1. Nhập nhân sự chính thức");
        System.out.println("2. Nhập nhân sự thực tập");
        System.out.println("==========================");
        System.out.print("Lựa chọn: ");
        int choice = sc.nextInt();
        sc.nextLine();

        System.out.print("Nhập mã nhân sự để kiểm tra: ");
        while(kiemTraDuyNhat(sc.nextLine().toUpperCase())) {
            System.out.println("Nhân sự này đã tồn tại");
            System.out.print("Mời bạn nhập lại: ");
        }

        NhanSu ns = null;

        if(choice == 1){
            ns = new NhanSuChinhThuc();
        }else if (choice == 2){
            ns = new NhanSuThucTap();
        }
        ns.nhapThongTin();
        dsns = Arrays.copyOf(dsns, n + 1);
        dsns[n] = ns;
        this.n++;
    }
    //sua nhan su
    @Override
    public void suaNhanSu(String manhansu){
        for(int i = 0; i < n; i++){
            if(dsns[i].getMaNhanSu().equals(manhansu)) {
                sua(dsns[i]);
                return;
            }
        }
        System.out.print("Không tìm thấy nhân sự");
    }
    @Override
    public void suaNhanSu(){
        System.out.println("Nhập mã nhân sự cần sửa: ");
        String manhansu = sc.nextLine().toUpperCase();
        
        for(int i = 0; i < n;i++){
            if(dsns[i].getMaNhanSu().equals(manhansu)) {
                sua(dsns[i]);
                return;
            }
        }
        System.out.println("Không tìm thấy nhân sự");
    }
    //xoa nhan su bang ma
    @Override
    public void xoaNhanSu(String manhansu){
        for(int i = 0; i < n;i++){
            if(dsns[i].getMaNhanSu().equals(manhansu)){
                for(int j = i; j < n - 1;j++)
                    dsns[j] = dsns[j+1];
                this.n--;
                dsns = Arrays.copyOf(dsns, n);
                return;
            }
        }
        System.out.println("Không tìm thấy nhân sự");
    }
    @Override
    public void xoaNhanSu(){// da test
        System.out.print("Nhập mã nhân sự cần xóa: ");
        String manhansu = sc.nextLine().toUpperCase();

        for(int i = 0; i < n;i++){
            if(dsns[i].getMaNhanSu().equals(manhansu)){
                for(int j = i; j < n - 1; j++)
                    dsns[j] = dsns[j+1];
                this.n--;
                dsns = Arrays.copyOf(dsns, n);
                return;
            }
        }
        System.out.println("Không tìm thấy nhân sự");
    }
    //tim kiem nhan su
    @Override
    public void timKiem(){// da test
        System.out.print("Nhập mã nhân sự cần tìm: ");
        String manhansu = sc.nextLine().toUpperCase();

        for(int i = 0; i < n;i++){
            if(dsns[i].getMaNhanSu().equals(manhansu)){
                dsns[i].inThongTin();
                return;
            }
        }
        System.out.println("Không tìm thấy nhân sự");
    }
    @Override
    public NhanSu timKiem(String manhansu){

        for(int i = 0; i < n;i++){
            if(dsns[i].getMaNhanSu().equals(manhansu)){
                return dsns[i];
            }
        }
        return null;
    }
    //tim kiem theo ho
    @Override
    public void timKiemTheoHo(){
        System.out.println("Nhập họ nhân sự cần tìm: ");
        String honhansu = sc.nextLine();

        boolean found = false;
        for(int i = 0; i < n;i++){
            if(dsns[i].getHoNhanSu().contains(honhansu)){
                dsns[i].inThongTin();
                found = true;
            }
        }
        if(!found)
            System.out.println("Không tìm thấy nhân sự");
    }
    @Override
    public NhanSu[] timKiemTheoHo(String honhansu){
        NhanSu[] kq = new NhanSu[0];
        int j = 0;

        for(int i = 0; i < n; i++){
            if(dsns[i].getHoNhanSu().contains(honhansu)){
                kq = Arrays.copyOf(kq, j + 1);
                kq[j++] = dsns[i];
            }
        }
        if(j > 0) return kq;
        else {
            System.out.println("Không tìm thấy nhân sự");
            return kq;
        }
    }
    //tim kiem theo ten
    @Override 
    public void timKiemTheoTen(){
        System.out.println("Nhập tên nhân sự cần tìm kiếm: ");
        String tennhansu = sc.nextLine();

        boolean found = false;
        for(int i = 0; i < n; i++){
            if(dsns[i].getTenNhanSu().contains(tennhansu)){
                dsns[i].inThongTin();
                found = true;
            }
        }
        if(!found)
            System.out.println("không tìm thấy nhân sự");
    }
    @Override 
    public NhanSu[] timKiemTheoTen(String tennhansu){
        NhanSu[] kq = new NhanSu[0];
        int j = 0;

        for(int i = 0; i < n;i++){
            if(dsns[i].getTenNhanSu().contains(tennhansu)){
                kq = Arrays.copyOf(kq, j + 1);
                kq[j++] = dsns[i];
            }
        }
        if(j > 0) return kq;
        else{
            System.out.println("Không tìm thấy nhân sự");
            return kq;
        }
    }
    // thong ke gioi tinh
    @Override
    public void thongKeGioiTinh(){
        int countgirl = 0;
        int countboy = 0;

        for(int i = 0; i < n; i++){
            if(dsns[i].getGioiTinh().equalsIgnoreCase("Nam"))
                countboy++;
            else countgirl++;
        }
        System.out.println("Số lượng nam giới là: " + countboy);
        System.out.println("Số lượng nữ giới là: "+ countgirl);
    }
    @Override
    public int[] summarizeGender(){
        int countgirl = 0;
        int countboy = 0;

        for(int i = 0; i < n; i++){
            if(dsns[i].getGioiTinh().equalsIgnoreCase("Nam"))
                countboy++;
            else countgirl++;
        }

        return new int[] { countboy, countgirl };
    }
    // xuất file giới tính
    @Override
    public void xuatFileThongKeGioiTinh() {
        try (FileWriter write = new FileWriter("C:\\training\\QuanLyNhanSu\\File\\thongKeGioiTinh.txt")) {
            int[] thongKe = summarizeGender();
            write.write("Số lượng nam giới: " + thongKe[0] + "\n");
            write.write("Số lượng nữ giới: " + thongKe[1] + "\n");
            write.close();
        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi khi xuất file: " + e.getMessage()); // getMessage() lấy ra tên lỗi
        }
    }
    // thong ke theo tuoi
    @Override
    public void thongKeTuoi(){
        int duoi18 = 0;
        int tu19den30 = 0;
        int tu31den65 = 0;
        int tren66 = 0;
        
        for(int i = 0; i < n;i++){
            LocalDate birthDate = dsns[i].convert();
            if(birthDate != null){
                int age = Period.between(birthDate, LocalDate.now()).getYears();

                if (age <= 18) duoi18++;
                else if (age <= 30) tu19den30++;
                else if (age <= 65) tu31den65++;
                else tren66++;
            }
        }
        System.out.println("Số lượng nhân sự dưới 18 tuổi: " + duoi18);
        System.out.println("Số lượng nhân sự từ 19 đến 30 tuổi: " + tu19den30);
        System.out.println("Số lượng nhân sự từ 31 đến 65 tuổi: " + tu31den65);
        System.out.println("Số lượng nhân sự trên 66 tuổi: " + tren66);
    }
    @Override
    public int[] summarizeAge(){
        int duoi18 = 0;
        int tu19den30 = 0;
        int tu31den65 = 0;
        int tren66 = 0;
        
        for(int i = 0; i < n;i++){
            LocalDate birthDate = dsns[i].convert();
            if(birthDate != null){
                int age = Period.between(birthDate, LocalDate.now()).getYears();

                if (age <= 18) duoi18++;
                else if (age <= 30) tu19den30++;
                else if (age <= 65) tu31den65++;
                else tren66++;
            }
        }
        return new int[] { duoi18, tu19den30, tu31den65, tren66 };
    }
    // xuat file thong ke tuoi
    @Override
    public void xuatFileThongKeTuoi() {
        try{
            FileWriter write = new FileWriter("C:\\training\\QuanLyNhanSu\\File\\thongKeTuoi.txt");
            int[] thongKe = summarizeAge();
            write.write("Số lượng nhân sự dưới 18 tuổi: " + thongKe[0] + "\n");
            write.write("Số lượng nhân sự từ 19 đến 30 tuổi: " + thongKe[1] + "\n");
            write.write("Số lượng nhân sự từ 31 đến 65 tuổi: " + thongKe[2] + "\n");
            write.write("Số lượng nhân sự trên 66 tuổi: " + thongKe[3] + "\n");
            write.close();
        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi khi xuất file: " + e.getMessage());
        }
    }
    @Override
    public void thongKeNamKinhNghiem() {
        int duoi1nam = 0;
        int tu2den3nam = 0;
        int tu4den7nam = 0;
        int tren7nam = 0;

        for(int i = 0; i < n;i++){
            if(dsns[i] instanceof NhanSuChinhThuc){
                NhanSuChinhThuc nsct = (NhanSuChinhThuc) dsns[i];
                int namkn = nsct.getSoNamKinhNghiem();
                if(namkn <= 1) duoi1nam++;
                else if(namkn <= 3) tu2den3nam++;
                else if(namkn <= 7) tu4den7nam++;
                else tren7nam++;
            }
        }
        System.out.println("Số lượng nhân sự có kinh nghiệm dưới 1 năm: " + duoi1nam);
        System.out.println("Số lượng nhân sự có kinh nghiệm từ 1 đến 3 năm: " + tu2den3nam);
        System.out.println("Số lượng nhân sự có kinh nghiệm từ 4 đến 7 năm: " + tu4den7nam);
        System.out.println("Số lượng nhân sự có kinh nghiệm trên 7 năm: " + tren7nam);
    }
    @Override
    public int[] summarizeAgeExperience() {
        int duoi1nam = 0;
        int tu2den3nam = 0;
        int tu4den7nam = 0;
        int tren7nam = 0;

        for(int i = 0; i < n;i++){
            if(dsns[i] instanceof NhanSuChinhThuc){
                NhanSuChinhThuc nsct = (NhanSuChinhThuc) dsns[i];
                int namkn = nsct.getSoNamKinhNghiem();
                if(namkn <= 1) duoi1nam++;
                else if(namkn <= 3) tu2den3nam++;
                else if(namkn <= 7) tu4den7nam++;
                else tren7nam++;
            }
        }
        return new int[] { duoi1nam, tu2den3nam, tu4den7nam, tren7nam };
    }
    // xuat file thong ke nam kinh nghiem
    @Override
    public void xuatFileThongKeNamKinhNghiem() {
        try{
            FileWriter write = new FileWriter("C:\\training\\QuanLyNhanSu\\File\\thongKeNamKinhNghiem.txt");
            int[] thongKe = summarizeAgeExperience();
            write.write("Số lượng nhân sự có kinh nghiệm dưới 1 năm: " + thongKe[0] + "\n");
            write.write("Số lượng nhân sự có kinh nghiệm từ 1 đến 3 năm: " + thongKe[1] + "\n");
            write.write("Số lượng nhân sự có kinh nghiệm từ 4 đến 7 năm: " + thongKe[2] + "\n");
            write.write("Số lượng nhân sự có kinh nghiệm trên 7 năm: " + thongKe[3] + "\n");
            write.close();
        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi khi xuất file: " + e.getMessage());
        }
    }
    // thong ke gpa
    @Override
    public void thongKeGPA() {
        int duoi2_0 = 0;
        int tu2_0den2_5 = 0;
        int tu2_5den3_2 = 0;
        int tu3_2den3_6 = 0;
        int tren3_6 = 0;

        for(int i = 0; i < n;i++){
            if(dsns[i] instanceof NhanSuThucTap){
                NhanSuThucTap nstt = (NhanSuThucTap) dsns[i];
                double gpa = nstt.getGpa();
                if(gpa < 2.0) duoi2_0++; // yếu
                else if(gpa < 2.5) tu2_0den2_5++; // trung bình
                else if(gpa < 3.2) tu2_5den3_2++; // khá
                else if(gpa < 3.6) tu3_2den3_6++; // giỏi
                else tren3_6++; // xuất sắc
            }
        }
        System.out.println("Số lượng nhân sự có GPA dưới 2.0: " + duoi2_0);
        System.out.println("Số lượng nhân sự có GPA từ 2.0 đến 2.5: " + tu2_0den2_5);
        System.out.println("Số lượng nhân sự có GPA từ 2.5 đến 3.2: " + tu2_5den3_2);
        System.out.println("Số lượng nhân sự có GPA từ 3.2 đến 3.6: " + tu3_2den3_6);
        System.out.println("Số lượng nhân sự có GPA trên 3.6: " + tren3_6);
    }
    @Override
    public int[] summarizeGPA() {
        int duoi2_0 = 0;
        int tu2_0den2_5 = 0;
        int tu2_5den3_2 = 0;
        int tu3_2den3_6 = 0;
        int tren3_6 = 0;

        for(int i = 0; i < n;i++){
            if(dsns[i] instanceof NhanSuThucTap){
                NhanSuThucTap nstt = (NhanSuThucTap) dsns[i];
                double gpa = nstt.getGpa();
                if(gpa < 2.0) duoi2_0++; // yếu
                else if(gpa < 2.5) tu2_0den2_5++; // trung bình
                else if(gpa < 3.2) tu2_5den3_2++; // khá
                else if(gpa < 3.6) tu3_2den3_6++; // giỏi
                else tren3_6++; // xuất sắc
            }
        }
        return new int[] { duoi2_0, tu2_0den2_5, tu2_5den3_2, tu3_2den3_6, tren3_6 };
    }
    // xuat file thong ke gpa
    @Override
    public void xuatFileThongKeGPA() {
        try{
            FileWriter write = new FileWriter("C:\\training\\QuanLyNhanSu\\File\\thongKeGPA.txt");
            int[] thongKe = summarizeGPA();
            write.write("Số lượng nhân sự có GPA dưới 2.0: " + thongKe[0] + "\n");
            write.write("Số lượng nhân sự có GPA từ 2.0 đến 2.5: " + thongKe[1] + "\n");
            write.write("Số lượng nhân sự có GPA từ 2.5 đến 3.2: " + thongKe[2] + "\n");
            write.write("Số lượng nhân sự có GPA từ 3.2 đến 3.6: " + thongKe[3] + "\n");
            write.write("Số lượng nhân sự có GPA trên 3.6: " + thongKe[4] + "\n");
            write.close();
        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi khi xuất file: " + e.getMessage());
        }
    }
    // hien thi danh sach
    @Override
    public void in(){
        System.out.println("\n======================================================================================================================================================================");
        System.out.printf("|%-8s|%-9s|%-10s|%-16s|%-15s|%-12s|%-13s|%-11s|%-11s|%-16s|%-10s|%22s|\n",
        "Mã NS","Họ", "Tên",
        "Địa Chỉ", "Số Điện Thoại", "Giới Tính",
        "Ngày Sinh", "Chức Vụ", "Phòng Ban", "Ngày Vào Làm", "Loại NS"," Lương Cơ Bản");
        System.out.printf("----------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
        for(int i = 0; i < n;i++){
            dsns[i].inThongTin();
        }
    }
    // in chi tiet nhan su chinh thuc
    @Override
    public void inChiTietNhanSuChinhThuc() {
        System.out.println("\n=====================================================================================================================================================================-");
        System.out.printf("|%-8s|%-9s|%-10s|%-16s|%-15s|%-12s|%-13s|%-11s|%-11s|%-16s|%-10s|%22s|\n",
        "Mã NS","Họ", "Tên",
        "Địa Chỉ", "Số Điện Thoại", "Giới Tính",
        "Ngày Sinh", "Chức Vụ", "Phòng Ban", "Ngày Vào Làm", "Năm K/N"," Lương Cơ Bản");
        System.out.printf("----------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");

        for(int i = 0; i < n;i++){
            if(dsns[i] instanceof NhanSuChinhThuc){
                NhanSuChinhThuc nsct = (NhanSuChinhThuc) dsns[i];
                nsct.inChiTietCT();
            }
        }
    }
    // in chi tiet nhan su thuc tap
    @Override
    public void inChiTietNhanSuThucTap() {
        System.out.println("\n==============================================================================================================================================================================");
        System.out.printf("|%-8s|%-9s|%-10s|%-14s|%-15s|%-12s|%-13s|%-11s|%-11s|%-16s|%-14s|%-5s|%22s|\n",
        "Mã NS","Họ", "Tên",
        "Địa Chỉ", "Số Điện Thoại", "Giới Tính",
        "Ngày Sinh", "Chức Vụ", "Phòng Ban", "Ngày Vào Làm", "Thời Gian T/T", "GPA", "Lương Cơ Bản");
        System.out.printf("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");

        for(int i = 0; i < n;i++){
            if(dsns[i] instanceof NhanSuThucTap){
                NhanSuThucTap nstt = (NhanSuThucTap) dsns[i];
                nstt.inChiTietTT();
            }
        }
    }
    // kiem tra ma nhan su duy nhat
    public boolean kiemTraDuyNhat(String manhansu){
        for(int i = 0; i < n;i++){
            if(dsns[i].getMaNhanSu().equals(manhansu))
                return true;
        }
        return false;
    }
    // xuat file danh sach nhan su
    @Override
    public void xuatFileDanhSachNhanSu() {
        try(PrintWriter write = new PrintWriter(new FileWriter("C:\\training\\QuanLyNhanSu\\File\\DanhSachNhanSu.txt"))) {
            for(NhanSu ns : dsns) {
                if(ns instanceof NhanSuChinhThuc) {
                    NhanSuChinhThuc nsct = (NhanSuChinhThuc) ns;
                    write.printf("|%-9s|%-8s|%-9s|%-10s|%-14s|%-15s|%-12s|%-13s|%-11s|%-11s|%-16s|%-10s|%-,18.2fVNĐ|\n",
                    nsct.loai(), nsct.getMaNhanSu(), nsct.getHoNhanSu(), nsct.getTenNhanSu(),
                    nsct.getDiaChi(), nsct.getSoDienThoai(), nsct.getGioiTinh(), 
                    nsct.getNgaySinh(), nsct.getMaChucVu() == "" ? "Trống" : nsct.getMaChucVu(),
                    nsct.getPhongBan() == "" ? "Trống" : nsct.getPhongBan(), nsct.getNgayVaoLam(), nsct.getSoNamKinhNghiem(), nsct.getLuongCoBan());
                }
                else {
                    NhanSuThucTap nstt = (NhanSuThucTap) ns;
                    write.printf("|%-9s|%-8s|%-9s|%-10s|%-14s|%-15s|%-12s|%-13s|%-11s|%-11s|%-16s|%-8s|%-5s|%-,18.2fVNĐ|\n",
                    nstt.loai(), nstt.getMaNhanSu(), nstt.getHoNhanSu(), nstt.getTenNhanSu(),
                    nstt.getDiaChi(), nstt.getSoDienThoai(), nstt.getGioiTinh(), 
                    nstt.getNgaySinh(), nstt.getMaChucVu() == "" ? "Trống" : nstt.getMaChucVu(), nstt.getPhongBan() == "" ? "Trống" : nstt.getPhongBan(), nstt.getNgayVaoLam(),
                    nstt.getThoiGianThucTap(), nstt.getGpa(), nstt.getLuongCoBan());
                }
            }
        }catch(IOException e) {
            System.out.println("Đã xảy ra lỗi khi xuất file: " + e.getMessage());
        }
    }
    // doc file
    public void docFileDanhSachNhanSu() {
        try(BufferedReader br = new BufferedReader(new FileReader("C:\\training\\QuanLyNhanSu\\File\\DanhSachNhanSu.txt"))) {
            String line;
            while((line = br.readLine()) != null) {
                String[] info = line.split("\\|");

                if(info[1].trim().equals("TT")) {
                    String manhansu = info[2].trim();
                    String ho = info[3].trim();
                    String ten = info[4].trim();
                    String diachi = info[5].trim();
                    String sodienthoai = info[6].trim();
                    String gioitinh = info[7].trim();
                    String ngaysinh = info[8].trim();
                    String machucvu = info[9].trim();
                    String maphongban = info[10].trim();
                    String ngayvaolam = info[11].trim();
                    int thoigiantt = Integer.parseInt(info[12].trim());
                    Double gpa = Double.parseDouble(info[13].trim());                    
                    NhanSu ns = new NhanSuThucTap(manhansu, ho, ten, diachi, sodienthoai, gioitinh, ngaysinh, maphongban, ngayvaolam, machucvu, thoigiantt, gpa);
                    addNhanSu(ns);
                }else {
                    String manhansu = info[2].trim();
                    String ho = info[3].trim();
                    String ten = info[4].trim();
                    String diachi = info[5].trim();
                    String sodienthoai = info[6].trim();
                    String gioitinh = info[7].trim();
                    String ngaysinh = info[8].trim();
                    String machucvu = info[9].trim();
                    String maphongban = info[10].trim();
                    String ngayvaolam = info[11].trim();
                    int namkn = Integer.parseInt(info[12].trim());
                    NhanSu ns = new NhanSuChinhThuc(manhansu, ho, ten, diachi, sodienthoai, gioitinh, ngaysinh, maphongban, ngayvaolam, machucvu, namkn);
                    addNhanSu(ns);
                }
            }
        }catch(IOException e) {
            System.out.println("Không có dữ liệu từ file" + e.getMessage());
        }
    }
    public void sua(NhanSu ns){
        while(true){
            System.out.println("\n========= CHỨC NĂNG SỬA ==========");
            System.out.println("1. Sửa tên nhân sự");
            System.out.println("2. Sửa họ nhân sự");
            System.out.println("3. Sửa ngày vào làm");
            System.out.println("4. Sửa địa chỉ");
            System.out.println("5. Sửa số điện thoại");
            System.out.println("6. Sửa giới tính");
            System.out.println("7. Sửa ngày sinh");
            System.out.println("0. Để thoát");
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

            switch(choice){
                case 1: 
                    System.out.print("Vui lòng nhập tên mới: ");
                    ns.setTenNhanSu(sc.nextLine());
                    System.out.println("Sửa thành công");break;
                case 2: 
                    System.out.print("Vui lòng nhập họ mới: ");
                    ns.setHoNhanSu(sc.nextLine());
                    System.out.println("Sửa thành công");break;
                case 3: 
                    System.out.print("Vui lòng nhập ngày vào làm mới: ");
                    ns.setNgayVaoLam(sc.nextLine());
                    System.out.println("Sửa thành công");break;
                case 4: 
                    System.out.print("Vui lòng nhập địa chỉ mới: ");
                    ns.setDiaChi(sc.nextLine());
                    System.out.println("Sửa thành công");break;
                case 5: 
                    System.out.print("Vui lòng nhập số điện thoại mới: ");
                    ns.setSoDienThoai(sc.nextLine());
                    System.out.println("Sửa thành công");break;
                case 6: 
                    System.out.print("Vui lòng nhập giới tính mới: ");
                    ns.setGioiTinh(sc.nextLine());
                    System.out.println("Sửa thành công");break;
                case 7:
                    System.out.println("Vui lòng nhập ngày sinh mới(dd-MM-yyyy): ");
                    ns.setNgaySinh(sc.nextLine());
                    System.out.println("Sửa thành công");break;
            }
        }

    }
    

    
}

