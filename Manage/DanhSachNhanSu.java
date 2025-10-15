package Manage;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import Interface.*;
import Object.*;


public class DanhSachNhanSu implements INhanSu {
    private int n;// so luong nhan su 
    private NhanSu[] dsns;
    Scanner sc = new Scanner(System.in); 

    //constructor
    public DanhSachNhanSu() {
        dsns = new NhanSu[0];
        n = 0;
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
            for(int i = n; i < n + m;i++){
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
        System.out.print("Lua chon: ");
        int choice = sc.nextInt();
        sc.nextLine();

        System.out.print("Nhập mã nhân sự để kiểm tra: ");
        while(kiemTraDuyNhat(sc.nextLine())) {
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
            if(dsns[i].getMaNhanSu().equals(manhansu))
                sua(dsns[i]);
                return;
        }
        System.out.print("Không tìm thấy nhân sự");
    }
    @Override
    public void suaNhanSu(){
        System.out.println("Nhập mã nhân sự cần sửa: ");
        String manhansu = sc.nextLine().toUpperCase();
        
        for(int i = 0; i < n;i++){
            if(dsns[i].getMaNhanSu().equals(manhansu))
                sua(dsns[i]);
                return;
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
                dsns = Arrays.copyOf(dsns, n)
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
            if(dsns[i].getGioiTinh().equals("Nam"))
                countboy++;
            else countgirl++;
        }
        System.out.println("Số lượng nam giới là: " + countboy);
        System.out.println("Số lượng nữ giới là: "+ countgirl);
    }
    @Override
    public int[] thongKeGioiTinh(String gioiTinh){
        int countgirl = 0;
        int countboy = 0;

        for(int i = 0; i < n; i++){
            if(dsns[i].getGioiTinh().equals("Nam"))
                countboy++;
            else countgirl++;
        }

        return new int[] {countboy,countgirl};
    }
    // thong ke theo tuoi
    @Override
    public int[] thongKeTuoi(){
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
    // hien thi danh sach
    @Override
    public void in(){
        for(int i = 0; i < n;i++){
            dsns[i].inThongTin();
        }
    }
    public boolean kiemTraDuyNhat(String manhansu){
        for(int i = 0; i < n;i++){
            if(dsns[i].getMaNhanSu().equals(manhansu))
                return true;
        }
        return false;
    }
    // sửa phụ
    public void sua(NhanSu ns){
        while(true){
            System.out.println("1. Sửa tên nhân sự");
            System.out.println("2. Sửa họ nhân sự");
            System.out.println("3. Sửa tuổi nhân sự");
            System.out.println("4. Sửa địa chỉ");
            System.out.println("5. Sửa số điện thoại");
            System.out.println("6. Sửa giới tính");
            System.out.println("7. Sửa ngày sinh");
            System.out.println("8. Sửa email");
            System.out.println("0. Để thoát");
            System.out.print("Lựa chọn: ");

            int choice = sc.nextInt();
            sc.nextLine();

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
                    System.out.print("Vui lòng nhập tuổi mới: ");
                    ns.setTuoi(sc.nextInt());sc.nextLine();
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
                case 8:
                    System.out.print("Vui lòng nhập email mới: ");
                    ns.setEmail(sc.nextLine());
                    System.out.println("Sửa thành công");break;
            }
        }

    }
    

    
}

