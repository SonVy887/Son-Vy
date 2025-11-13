package Object;
import java.util.*;
import java.time.*;
import java.time.format.*;

public abstract class NhanSu {
    protected String manhansu;
    protected String ten;
    protected String ho;
    protected String diachi;
    protected String sodienthoai;
    protected String gioitinh;
    protected String ngaysinh;
    protected String maphongban;
    protected String ngayvaolam;
    protected String machucvu;
    protected double luongcoban = 5_000_000;
    Scanner sc = new Scanner(System.in);


    //============================================================>
    // Constructor
    public NhanSu(){}
    public NhanSu(NhanSu copy) {
        this.manhansu = copy.manhansu;
        this.ho = copy.ho;
        this.ten = copy.ten;
        this.diachi = copy.diachi;
        this.sodienthoai = copy.sodienthoai;
        this.gioitinh = copy.gioitinh;
        this.ngaysinh = copy.ngaysinh;
        this.maphongban = copy.maphongban;
        this.ngayvaolam = copy.ngayvaolam;
        this.machucvu = copy.machucvu;
    }
    public NhanSu(String manhansu, String ho, String ten, String diachi, String sodienthoai, String gioitinh, String ngaysinh, String maphongban, String ngayvaolam, String machucvu) {
        this.manhansu = manhansu;
        this.ho = ho;
        this.ten = ten;
        this.diachi = diachi;
        this.sodienthoai = sodienthoai;
        this.gioitinh = gioitinh;
        this.ngaysinh = ngaysinh;
        this.maphongban = maphongban;
        this.ngayvaolam = ngayvaolam;
        this.machucvu = machucvu;
    }
    //============================================================>
    public void nhapThongTin() {
        System.out.print("Nhập mã nhân sự (VD: NS001): ");
        this.manhansu = sc.nextLine().toUpperCase();

        System.out.print("Nhập họ: ");
        this.ho = sc.nextLine();

        System.out.print("Nhập tên: ");
        this.ten = sc.nextLine();


        System.out.print("Nhập địa chỉ: ");
        this.diachi = sc.nextLine();

        System.out.print("Nhập số điện thoại: ");
        this.sodienthoai = sc.nextLine();

        System.out.print("Nhập giới tính: ");
        this.gioitinh = sc.nextLine();

        System.out.print("Nhập ngày sinh (dd/MM/yyyy): ");
        this.ngaysinh = sc.nextLine();

        System.out.print("Nhập ngày vào làm (dd/MM/yyyy): ");
        this.ngayvaolam = sc.nextLine();

    }
    //============================================================>
    public void inThongTin() {
        System.out.printf("|%-8s|%-9s|%-10s|%-16s|%-15s|%-12s|%-13s|%-11s|%-11s|%-16s|%10s|%,18.0f VNĐ|",
        manhansu, ho, ten,
        diachi, sodienthoai, gioitinh, 
        ngaysinh, machucvu == null ? "Trống" : machucvu,
        maphongban== null ? "Trống" : maphongban, ngayvaolam, loai(), luongcoban);
    }
    //============================================================>
    public abstract String loai();
    //============================================================>
    
    // Getter
    public String getMaNhanSu(){ return manhansu;}
    // Getter and Setter
    public String getHoNhanSu(){ return ho;}
    public void setHoNhanSu(String ho){ this.ho = ho;}
    public String getTenNhanSu(){ return ten;}
    public void setTenNhanSu(String ten){ this.ten = ten;}
    public String getHoVaTenNhanSu(){ return ho + " " + ten;}
    public String getDiaChi(){ return diachi;}
    public void setDiaChi(String diachi){ this.diachi = diachi;}
    public String getSoDienThoai(){ return sodienthoai;}
    public void setSoDienThoai(String sodienthoai){ this.sodienthoai = sodienthoai;}
    public String getGioiTinh(){ return gioitinh;}
    public void setGioiTinh(String gioitinh){ this.gioitinh = gioitinh;}
    public String getNgaySinh(){ return ngaysinh;}
    public void setNgaySinh(String ngaysinh){ this.ngaysinh = ngaysinh;}
    public double getLuongCoBan(){ return luongcoban;}
    public String getPhongBan(){ return maphongban;}
    public void setPhongBan(String maphongban){ this.maphongban = maphongban;}//set pb
    public String getNgayVaoLam(){ return ngayvaolam;}
    public void setNgayVaoLam(String ngayvaolam){ this.ngayvaolam = ngayvaolam;}
    public String getMaChucVu(){ return machucvu;}
    public void setMaChucVu(String machucvu){ this.machucvu = machucvu;}



    public LocalDate convert(){
        String[] type = {"dd/MM/yyyy", "yyyy/MM/dd"};
        for(String f : type){
            try{
                DateTimeFormatter transType = DateTimeFormatter.ofPattern(f);
                return LocalDate.parse(this.ngaysinh,transType);
            }catch(Exception e){}
        }
        return null;
    }

    public int tinhThamNien() {
        String[] type = {"dd/MM/yyyy", "yyyy/MM/dd"};
        LocalDate ngaythangnam = null;

        for(String f : type){
            try {
                DateTimeFormatter transType = DateTimeFormatter.ofPattern(f);
                ngaythangnam = LocalDate.parse(ngayvaolam, transType);
            } catch (Exception e) {}
        }
        return Period.between(ngaythangnam, LocalDate.now()).getYears();
    }
}
