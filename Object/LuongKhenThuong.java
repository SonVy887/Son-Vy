package Object;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class LuongKhenThuong {
    private String maluongkhenthuong;
    private double luongkhenthuong;
    private String lydo;
    private NhanSu nhansu;
    private final String[] ngayLe =  {"01/01","30/04","01/05","02/09","10/03"};
    Scanner sc = new Scanner(System.in);

    // Constructor
    public LuongKhenThuong(String maluongkhenthuong, double luongkhenthuong, String lydo, NhanSu nhansu) {
        this.maluongkhenthuong = maluongkhenthuong;
        this.luongkhenthuong = luongkhenthuong;
        this.lydo = lydo;
        this.nhansu = nhansu;
    }
    public LuongKhenThuong(LuongKhenThuong lkt) {
        this.maluongkhenthuong = lkt.maluongkhenthuong;
        this.luongkhenthuong = lkt.luongkhenthuong;
        this.lydo = lkt.lydo;
        this.nhansu = lkt.nhansu;
    }
    public LuongKhenThuong(){}
    
    // nhap luong khen thuong
    public void nhapLuongKhenThuong(){
        System.out.print("Nhập mã lương khen thưởng (VD:LKT001): ");
        this.maluongkhenthuong = sc.nextLine().toUpperCase();

        System.out.print("Nhập số tiền được khen thưởng: ");
        this.luongkhenthuong = sc.nextDouble();
        sc.nextLine();

        System.out.print("Nhập lý do: ");
        this.lydo = sc.nextLine();

    }
    // in thong tin khen thuong
    public void inThongTinKhenThuong(){
        System.out.println("===========================================Bảng Lương Khen Thưởng===============================================");
        System.out.printf("|%-15s|%-18s|%-15s|%-15s|%-18s|%24s|\n","Mã","Lương Thưởng","Lý do","Nhân Sự","Thưởng Lễ","Tổng Lương");
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        System.out.printf("|%-15s|%-,18.2f|%-15s|%-15s|%-,18.2f|%,20.2f VND|\n",maluongkhenthuong,luongkhenthuong,lydo,
        nhansu == null ? "Trong" : nhansu.getMaNhanSu(),thuongLe(),tongLuong());
    }
    //thuong le
    public double thuongLe(){
        LocalDate homnay = LocalDate.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM");

        String ngayThang = homnay.format(formatter);

        for(String s : ngayLe){
            if(s.contains(ngayThang)){
                return 200_000;
            }
        }
        return 0.0;
    }
    // tong luong khen thuong 
    public double tongLuong(){
        return luongkhenthuong + thuongLe();
    }
    

    // Getters and Setters
    public String getMaLuongKhenThuong() {
        return maluongkhenthuong;
    }
    public void setMaLuongKhenThuong(String maluongkhenthuong) {
        this.maluongkhenthuong = maluongkhenthuong;
    }
    public double getLuongKhenThuong() {
        return luongkhenthuong;
    }
    public void setLuongKhenThuong(double luongkhenthuong) {
        this.luongkhenthuong = luongkhenthuong;
    }
    public String getLyDo() {
        return lydo;
    }
    public void setLyDo(String lydo) {
        this.lydo = lydo;
    }
    public NhanSu getNhanSu(){
        return this.nhansu;
    }
    public void setNhanSu(NhanSu ns){
        this.nhansu = ns;
    }

    public static void main(String[] agrs){
        LuongKhenThuong lkt = new LuongKhenThuong();
        lkt.nhapLuongKhenThuong();
        lkt.inThongTinKhenThuong();
    }

}
