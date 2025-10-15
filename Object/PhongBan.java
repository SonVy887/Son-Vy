package Object;
import java.util.*;

public class PhongBan {
    private String maphongban;
    private String tenphongban;
    private NhanSu truongphong;
    private String ngaynhanchuc;
    private NhanSu[] dsns;
    private int soluongtrongpb; // nhan su trong pb
    Scanner sc = new Scanner(System.in);

    
    // Constructor
    public PhongBan(String maphongban, String tenphongban, NhanSu truongphong, String ngaynhanchuc) {
        this.maphongban = maphongban;
        this.tenphongban = tenphongban;
        this.truongphong = truongphong;
        this.ngaynhanchuc = ngaynhanchuc;
        this.dsns = new NhanSu[0];
        this.soluongtrongpb = 0;
    }
    // constructor k tham so
    public PhongBan() {
        this.maphongban = "";
        this.tenphongban = "";
        this.truongphong = null;
        this.ngaynhanchuc = "";
        this.dsns = new NhanSu[0];
        this.soluongtrongpb = 0;
    }
    // constructor sao chep
    public PhongBan (PhongBan pb ){
        this.maphongban = pb.maphongban;
        this.tenphongban =pb.tenphongban;
        this.truongphong = truongphong;
        this.ngaynhanchuc = pb.ngaynhanchuc;
        this.dsns = pb.dsns;
        this.soluongtrongpb = pb.soluongtrongpb;
    }

    //in thong tin phong ban
    public void inThongTinPhongBan() {
        System.out.println("========================================================================================");
        System.out.printf("|%-17s|%-18s|%-14s|%-16s|%-17s|\n","Ma Phong Ban", "Ten Phong Ban", "Truong Phong", "Ngay Nhan Chuc","So luong Nhan Su");
        System.out.printf("----------------------------------------------------------------------------------------\n");
        System.out.printf("|%-17s|%-18s|%-14s|%-16s|%-17s|\n",
        this.maphongban, this.tenphongban, (this.truongphong != null ? truongphong.getMaNhanSu() : "Trong"), this.ngaynhanchuc,this.soluongtrongpb);
        System.out.println("========================================================================================");
        
    }
    //thong tin nhan su trong phong ban
    public void inThongTinChiTiet(){
        for(int i = 0; i < soluongtrongpb;i++){
            dsns[i].inThongTin();
        }
    }

    //nhap thong tin phong ban
    public void nhapThongTinPhongBan() {
        System.out.print("Nhap ma phong ban: ");
        this.maphongban = sc.nextLine().toUpperCase();
        System.out.print("Nhap ten phong ban: ");
        this.tenphongban = sc.nextLine();
    }
    // them nhan su vao phong ban
    public void themNhanSu(NhanSu ns){
        try{
            dsns = Arrays.copyOf(dsns, soluongtrongpb + 1);
            dsns[soluongtrongpb] = ns;
            soluongtrongpb++;
            ns.setPhongBan(this);
        }catch(Exception e){
            System.out.println("Them that bai");
        }
    }
    // xoa nhan su trong phong ban
    public void xoaNhanSu(String maNhanSu){
        for(int i = 0; i < soluongtrongpb;i++){
            if(dsns[i].getMaNhanSu().equals(maNhanSu)){
                for(int j = i; j < soluongtrongpb - 1;j++){
                    dsns[j] = dsns[j + 1];
                }
                dsns[soluongtrongpb - 1] = null;
                soluongtrongpb--;
            }
        }
    }
    // tim nhan su trong phong ban
    public NhanSu timNhanSuPb(String maNhanSu){
        for(int i = 0; i < soluongtrongpb;i++){
            if(dsns[i].getMaNhanSu().equals(maNhanSu))
                return dsns[i];
        }
        return null;
    }

    // Getter and Setter
    public String getMaPhongBan() {
        return maphongban;
    }
    public void setMaPhongBan(String maphongban) {
        this.maphongban = maphongban;
    }
    public String getTenPhongBan() {
        return tenphongban;
    }
    public void setTenPhongBan(String tenphongban) {
        this.tenphongban = tenphongban;
    }
    public String getNgayNhanChuc() {
        return this.ngaynhanchuc;
    }
    public void setNgayNhanChuc(String ngaynhanchuc){
        this.ngaynhanchuc = ngaynhanchuc;
    }
    public void setTruongPhong(NhanSu ns){
        this.truongphong = ns;
    }
    public NhanSu[] getDsns(){
        return dsns;
    }
    public void setDsns(NhanSu[] ns){
        this.dsns = ns;
    }
    public int getSoLuongNhanSu(){
        return soluongtrongpb;
    }
    public void setSoLuongNhanSu(int n){
        this.soluongtrongpb = n;
    }

    
}
