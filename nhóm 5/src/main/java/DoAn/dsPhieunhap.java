package DoAn;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;
public class dsPhieunhap extends phieuNhap {

    File file = new File("phieunhap.txt");
    BufferedReader f1 = null;
    BufferedReader f2 = null;
    String line, line1, line2;
    String[] linenew, linenew1, linenew2;
    phieuNhap[] Phieunhap;
    int n ;
    Scanner input = new Scanner(System.in);
    public  dsPhieunhap(){
        Phieunhap=null;
        n=0;
    }
    public void docFile() {
        Phieunhap = new phieuNhap[100];
        BufferedReader f = null;
        try {
            f = new BufferedReader(new FileReader(file));
            while ((line = f.readLine()) != null) {
                linenew = line.split(" ");
                Phieunhap[n] = new phieuNhap();
                Phieunhap[n].Ma= linenew[0];//Ma phieu nhap
                Phieunhap[n].MaNV= linenew[1];
                n++;
            }
        } catch (IOException e) {
        }
    }

    public void xuat() {
        System.out.printf("%-10s%-10s\n", "MaPN", "MaNV");
        for (int i = 0; i < n; i++) {
            Phieunhap[i].xuat();
        }
    }

    public int kiemtraTrung(String x) {
        for (int i = 0; i < n; i++) {
            if (x.equals(Phieunhap[i].Ma)) {
                return 1;
            }
        }
        return 0;
    }

    public void add(String x) {
        input.nextLine();
        Phieunhap[n] = new phieuNhap();
        Phieunhap[n].Ma = x;
        while (kiemtraTrung(x) == 1) {

            System.out.println("==========================");
            System.out.println("Ma phieu nhap nay da ton tai");
            System.out.println("Hay nhap ma phieu nhap ");
            Phieunhap[n].Ma = input.nextLine();
            x = Phieunhap[n].Ma;
        }
        System.out.println("Nhap ma nhan vien phu trach");
        Phieunhap[n].MaNV = input.nextLine();
        dsNhanvien a = new dsNhanvien();
        a.docFile();
        if (a.kiemtraTrung(Phieunhap[n].MaNV) == 0) {
            System.out.println("Ma nv nay khong ton tai trong danh sach nhan vien!!");
            System.out.println("Ban muon them nhan vien nay vao danh sach khong?Y/N");
            char yesno = input.next().charAt(0);
            int kt=0;
            while (kt!=1) {
                switch (yesno) {
                    case 'Y': {
                        dsNhanvien d = new dsNhanvien();
                        d.docFile();
                        d.add(Phieunhap[n].MaNV);
                        save();
                        kt=1;
                        break;
                    }
                    case 'N': {
                        System.out.println("Ban khong them vao nv moi!Thoat");
                        kt=1;
                    }
                    default: {
                        System.out.println("Ban da nhap sai!Vui long nhap lai");
                        yesno = input.next().charAt(0);
                    }
                }//switch
            }//while
        }
        dschitietphieunhap k = new dschitietphieunhap();
        k.docfile();
        k.add(Phieunhap[n].Ma);
        n = n + 1;
        save();
        xuat();
    }

    public void save() {
        try {
            FileWriter file1 = new FileWriter(file);
            BufferedReader file2 = new BufferedReader(new FileReader(file));
            Writer out = new BufferedWriter(file1);
            for (int i = 0; i < n; i++) {
                out.write(Phieunhap[i].Ma + " " + Phieunhap[i].MaNV + "\r\n");

            }
            out.close();
            System.out.println(file.getAbsolutePath());
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
    }
    /* public void change(String passADMIN,String passMANV)
    {
        
    }*/

}
