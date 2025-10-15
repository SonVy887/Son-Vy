package Object;

public class BangLuong {
    private String mabangluong;
    private NhanSu nhansu;
    private String thang;
    private LuongKhenThuong luongkhenthuong;
    private double phucap;
    private int songaylamviec;
    private int sogiotangca;
    private double tientangca;
    private double phat;
    private double tongluong;


    // Constructor
    
    public BangLuong(){}
    public BangLuong(String mabangluong, NhanSu nhansu, String thang, LuongKhenThuong luongkhenthuong, double phucap, int songaylamviec, int sogiotangca, double tientangca, double phat, double tongluong){
        this.mabangluong = mabangluong;
        this.nhansu = nhansu;
        this.thang = thang;
        this.luongkhenthuong = luongkhenthuong;
        this.phucap = phucap;
        this.songaylamviec = songaylamviec;
        this.sogiotangca = sogiotangca;
        this.tientangca = tientangca;
        this.phat = phat;
        this.tongluong = tongluong;
    }
    public BangLuong(BangLuong bl){
        this.mabangluong = bl.mabangluong;
        this.nhansu = bl.nhansu;
        this.thang = bl.thang;
        this.luongkhenthuong = bl.luongkhenthuong;
        this.phucap = bl.phucap;
        this.songaylamviec = bl.songaylamviec;
        this.sogiotangca = bl.sogiotangca;
        this.tientangca = bl.tientangca;
        this.phat = bl.phat;
        this.tongluong = bl.tongluong;
    }
    
    // in 
    public void inBangLuong(){
        
    }
    // nhap
    public void nhapBangLuong(){
        //
    }

    public String getMaBangLuong() {
        return this.mabangluong;
    }
    public void setMaBangLuong(String mabangluong){
        this.mabangluong = mabangluong;
    }
    public NhanSu getNhanSu() {
        return this.nhansu;
    }
    public void setNhanSu(NhanSu ns){
        this.nhansu = ns;
    }
    public String getThang() {
        return this.thang;
    }
    public void setThang(String thang){
        this.thang = thang;
    }
    public LuongKhenThuong getLuongKhen() {
        return luongkhenthuong;
    }
    public void setLuongKhen(LuongKhenThuong lkt){
        this.luongkhenthuong = lkt;
    }
    public double getPhuCap(){
        return this.phucap;
    }
    public void setPhuCap(double phucap){
        this.phucap = phucap;
    }
    public int getSoNgayLamViec() {
        return this.songaylamviec;
    }
    public void setSoNgayLamViec(int songaylamviec){
        this.songaylamviec = songaylamviec;
    }
    public int getSoGioTangCa() {
        return this.sogiotangca;
    }
    public void setSoGioTangCa(int sogiotangca){
        this.sogiotangca = sogiotangca;
    }

    public double getTienTangCa() {
        return this.tientangca;
    }
    public void setTienTangCa(double tientangca) {
        this.tientangca = tientangca;
    }
    public double getPhat() {
        return this.phat;
    }
    public void setPhat(double phat){
        this.phat = phat;
    }

    public double getTongLuong() {
        return this.tongluong;
    }
    public void setTongLuong(double tongluong) {
        this.tongluong = tongluong;
    }

}
