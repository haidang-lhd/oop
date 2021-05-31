package DoAn;

public class hoadon {

    public String MaHD;
    public String MaNV;
    public String MaKH;
    public String Ngay;
    public long Tongtien;

    public hoadon() {
        MaHD = null;
        MaNV = null;
    }

    public hoadon(String MaHD, String MaNV) {
        this.MaHD = MaHD;
        this.MaNV = MaNV;
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public void nhap() {

    }

    public void xuat() {
        System.out.printf("%-10s%-10s%-10s%-10s%-10s\n", MaHD, MaNV,MaKH,Ngay,Tongtien);
    }
}
