package DoAn;

import java.util.Scanner;

public class Nhanvien extends ConNguoi {

    protected String MaNV;
    Scanner input = new Scanner(System.in);

    public String toString() {
        return MaNV + " " + Hoten + " " + Ngaysinh + " " + SDT;
    }
    public Nhanvien() {
        super();
        MaNV = null;
    }

    public Nhanvien(String Hoten, String Ngaysinh, String SDT, String MaNV) {
        super(Hoten, Ngaysinh, SDT);
        this.MaNV = MaNV;
    }

    @Override
    public void nhap() {
        System.out.println("Hay nhap vao ma nhan vien ");
        MaNV = input.nextLine();
        super.nhap();
    }

    @Override
    public void xuat() {
        System.out.printf("%-20s", MaNV);
        super.xuat();
    }

    public String getMaNV() {
        return MaNV;
    }
}
