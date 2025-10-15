package Object;
import java.util.*;
import java.time.*;
import java.time.format.*;

public abstract class NhanSu {
    protected String manhansu;
    protected String ten;
    protected String ho;
    protected int tuoi;
    protected String diachi;
    protected String sodienthoai;
    protected String gioitinh;
    protected String ngaysinh;
    protected String email;
    protected final double luongcoban = 5_000_000;
    protected PhongBan phongban;
    Scanner sc = new Scanner(System.in);


    //============================================================>
    // Constructor
    public NhanSu(){}
    public NhanSu(NhanSu copy) {
        this.manhansu = copy.manhansu;
        this.ho = copy.ho;
        this.ten = copy.ten;
        this.tuoi = copy.tuoi;
        this.diachi = copy.diachi;
        this.sodienthoai = copy.sodienthoai;
        this.gioitinh = copy.gioitinh;
        this.ngaysinh = copy.ngaysinh;
        this.email = copy.email;
        this.phongban = copy.phongban;
    }
    public NhanSu(String manhansu, String ho, String ten, int tuoi, String diachi, String sodienthoai, String gioitinh, String ngaysinh, String email, PhongBan phongban) {
        this.manhansu = manhansu;
        this.ho = ho;
        this.ten = ten;
        this.tuoi = tuoi;
        this.diachi = diachi;
        this.sodienthoai = sodienthoai;
        this.gioitinh = gioitinh;
        this.ngaysinh = ngaysinh;
        this.email = email;
        this.phongban = phongban;
    }
    //============================================================>
    public abstract double tinhLuong();
    //============================================================>
    public void nhapThongTin() {
        System.out.print("Nhap ma nhan su:");
        this.manhansu = sc.nextLine().toUpperCase();

        System.out.print("Nhap ho: ");
        this.ho = sc.nextLine();

        System.out.print("Nhap ten: ");
        this.ten = sc.nextLine();

        System.out.print("Nhap tuoi: ");
        this.tuoi = sc.nextInt();
        sc.nextLine();

        System.out.print("Nhap dia chi: ");
        this.diachi = sc.nextLine();

        System.out.print("Nhap so dien thoai: ");
        this.sodienthoai = sc.nextLine();

        System.out.print("Nhap gioi tinh: ");
        this.gioitinh = sc.nextLine();

        System.out.print("Nhap ngay sinh: ");
        this.ngaysinh = sc.nextLine();

        System.out.print("Nhap ten email (khong can phan duoi): ");
        this.email = sc.nextLine() + "@gmail.com";

    }
    //============================================================>
    public abstract void inThongTin();
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
    public int getTuoi(){ return tuoi;}
    public void setTuoi(int tuoi){ this.tuoi = tuoi;}
    public String getDiaChi(){ return diachi;}
    public void setDiaChi(String diachi){ this.diachi = diachi;}
    public String getSoDienThoai(){ return sodienthoai;}
    public void setSoDienThoai(String sodienthoai){ this.sodienthoai = sodienthoai;}
    public String getGioiTinh(){ return gioitinh;}
    public void setGioiTinh(String gioitinh){ this.gioitinh = gioitinh;}
    public String getNgaySinh(){ return ngaysinh;}
    public void setNgaySinh(String ngaysinh){ this.ngaysinh = ngaysinh;}
    public String getEmail(){ return email;}
    public void setEmail(String email){ this.email = email;}
    public double getLuongCoban(){ return luongcoban;}
    public PhongBan getPhongBan(){ return phongban;}
    public void setPhongBan(PhongBan phongban){ this.phongban = phongban;}//set pb


    public LocalDate convert(){
        String[] type = {"dd-MM-yyyy", "yyyy-MM-dd"};

        for(String f : type){
            DateTimeFormatter transType = DateTimeFormatter.ofPattern(f);
            return LocalDate.parse(this.ngaysinh,transType);
        }
        return null;
    }
}
