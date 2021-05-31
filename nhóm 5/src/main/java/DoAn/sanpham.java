package DoAn;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Admin
 */
import java.util.Scanner;

public class sanpham {

    protected String MAHANG;
    protected String TENHANG;
    protected String NSX;
    protected String HSD;
    protected String NCC;
    protected String LOAI;
    protected int SOLUONG;
    protected String DONVI;

    public sanpham() {
        this.MAHANG = null;
        this.TENHANG = null;
        this.NSX = null;
        this.HSD = null;
        this.NCC = null;
        this.LOAI = null;
        this.SOLUONG = 0;
        this.DONVI = null;
    }

    public sanpham(String MAHANG, String TENHANG, String NSX, String HSD, String NCC, String LOAI, int SOLUONG, String DONVI) {
        this.MAHANG = MAHANG;
        this.TENHANG = TENHANG;
        this.NSX = NSX;
        this.HSD = HSD;
        this.NCC = NCC;
        this.LOAI = LOAI;
        this.SOLUONG = SOLUONG;
        this.DONVI = DONVI;
    }
    
    public String toString() {
        return MAHANG + " " + TENHANG + " " + NSX + " " + HSD + " " + NCC + " " + SOLUONG + " " + DONVI;
    }

    public String getMAHANG() {
        return MAHANG;
    }

    public void setMAHANG(String MAHANG) {
        this.MAHANG = MAHANG;
    }

    public String getTENHANG() {
        return TENHANG;
    }

    public void setTENHANG(String TENHANG) {
        this.TENHANG = TENHANG;
    }

    public String getNSX() {
        return NSX;
    }

    public void setNSX(String NSX) {
        this.NSX = NSX;
    }

    public String getHSD() {
        return HSD;
    }

    public void setHSD(String HSD) {
        this.HSD = HSD;
    }

    public String getNCC() {
        return NCC;
    }

    public void setNCC(String NCC) {
        this.NCC = NCC;
    }

    public int getSOLUONG() {
        return SOLUONG;
    }

    public void setSOLUONG(int SOLUONG) {
        this.SOLUONG = SOLUONG;
    }

    public String getDONVI() {
        return DONVI;
    }

    public void setDONVI(String DONVI) {
        this.DONVI = DONVI;
    }

    public void xuat() {
        System.out.printf("%-10s%-15s%-10s%-11s%-11s%-15s%-15s%-15s\n", MAHANG, TENHANG, NSX, HSD, NCC, SOLUONG, DONVI,LOAI);
    }
}
