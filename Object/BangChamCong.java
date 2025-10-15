package Object;
public class BangChamCong {
    private String machamcong;
    private String day;
    private int songaylamviec;
    private int songaykhongphep;
    private int songayphep;


    // Constructor
    public BangChamCong(String machamcong, String day, int songaylamviec, int songaykhongphep, int songayphep) {
        this.machamcong = machamcong;
        this.day = day;
        this.songaylamviec = songaylamviec;
        this.songaykhongphep = songaykhongphep;
        this.songayphep = songayphep;
    }
    public BangChamCong() {
    }
    // Getters and Setters
    public String getMaChamCong() {
        return machamcong;
    }
    public void setMaChamCong(String machamcong) {
        this.maChamCong = maChamCong;
    }
    public String getDay() {
        return day;
    }
    public void setDay(String day) {
        this.day = day;
    }
    public int getSoNgayLamViec() {
        return songaylamviec;
    }
    public void setSoNgayLamViec(int songaylamviec) {
        this.songaylamviec = songaylamviec;
    }
    public int getSoNgayKhongPhep() {
        return songaykhongphep;
    }
    public void setSoNgayKhongPhep(int songaykhongphep) {
        this.songaykhongphep = songaykhongphep;
    }
    public int getSoNgayPhep() {
        return songayphep;
    }
    public void setSoNgayPhep(int songayphep) {
        this.songayphep = songayphep;
    }
}
