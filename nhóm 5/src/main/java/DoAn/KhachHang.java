package DoAn;

import java.util.Scanner;

public class KhachHang extends ConNguoi {

    protected String MaKH;
    Scanner input = new Scanner(System.in);

    @Override
    public String toString() {
        return MaKH + " " + Hoten + " " + Ngaysinh + " " + SDT;
    }

    public KhachHang() {
        super();
        MaKH = null;
    }

    public KhachHang(String Hoten, String Ngaysinh, String SDT, String MaKH) {
        super(Hoten, Ngaysinh, SDT);
        this.MaKH = MaKH;
    }

    @Override
    public void nhap() {
        System.out.println("Hay nhap vao ma khach hang");
        MaKH = input.nextLine();
        super.nhap();
    }

    @Override
    public void xuat() {
        System.out.printf("%-20s", MaKH);
        super.xuat();
    }

    public String getMaKH() {
        return MaKH;
    }
}
