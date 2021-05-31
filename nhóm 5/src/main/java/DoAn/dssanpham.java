package DoAn;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Scanner;

public class dssanpham extends sanpham {

    File f = new File("sanpham.txt");
    Scanner input = new Scanner(System.in);
    sanpham[] sanpham;
    int n ;


    public dssanpham(sanpham[] sanpham, int n, String MAHANG, String TENHANG, String NSX, String HSD, String NCC, String LOAI, int SOLUONG, String DONVI) {
        super(MAHANG, TENHANG, NSX, HSD, NCC, LOAI, SOLUONG, DONVI);
        this.sanpham = null;
        this.n = 0;
    }

    /**
     *
     */
    public dssanpham() {
        sanpham=null;
        n=0;//To change body of generated methods, choose Tools | Templates.
    }

    public void docFile() {
        BufferedReader file = null;
        try {
            file = new BufferedReader(new FileReader(f));
            String line;
            String[] linenew;
            System.out.println("Du lieu duoc doc tu " + f.toString());
            while ((line = file.readLine()) != null) {
                n++;
            }
        } catch (Exception e) {
        }
        int i = 0;
        sanpham=new sanpham[n];
        try {
            file = new BufferedReader(new FileReader(f));
            String line;
            String[] linenew;
            System.out.println("Du lieu duoc doc tu " + f.toString());
            while ((line = file.readLine()) != null) {
                linenew = line.split(" ");
                sanpham[i] = new sanpham();
                sanpham[i].MAHANG = linenew[0];
                sanpham[i].TENHANG = linenew[1];
                sanpham[i].NSX = linenew[2];
                sanpham[i].HSD = linenew[3];
                sanpham[i].NCC = linenew[4];
                sanpham[i].SOLUONG = Integer.valueOf(linenew[5]);
                sanpham[i].DONVI = linenew[6];
                i++;
            }
        } catch (IOException e) {
        }
    }

    public int kiemtratrung(String A) {
        for (int b = 0; b < n; b++) {
            if (sanpham[b].MAHANG.equals(A)) {
                return 1;
            }
        }
        return 0;
    }

    public void add() {
        int giatricu = n;
        System.out.println("Ban muon nhap them bao nhieu hang hoa?");
        String d1 = input.nextLine();
        while (kiemtra.isNumberic(d1) != true) {
            System.out.println("Sai!");
            System.out.print("Nhap lai ");
            d1 = input.nextLine();
        }
        int k = Integer.valueOf(d1);
        this.n = n + k;
        sanpham = Arrays.copyOf(sanpham, n);
        System.out.println("Nhap thong tin hang hoa!!");
        for (int i = giatricu; i < n; i++) {
            System.out.println("1-Food");
            System.out.println("2-Drink");
            String d2 = input.nextLine();
            while (kiemtra.isNumberic(d2) != true) {
                System.out.println("Sai!");
                d2 = input.nextLine();
            }
            int d3 = Integer.valueOf(d2);
            switch (d3) {
                case 1: {
                    sanpham[i] = new food();
                    System.out.println("Hay nhap ma hang");
                    String A = input.nextLine();
                     sanpham[i].MAHANG = A;
                    while (kiemtratrung(A) == 1) {
                        System.out.println("Hang hoa da ton tai");
                        A = input.nextLine();
                    }
                    sanpham[i].MAHANG = A;
                    System.out.println("Hay nhap ten hang");
                    sanpham[i].TENHANG = input.nextLine();
                    while (kiemtra.checkName(sanpham[i].TENHANG) != false) {
                        System.out.println("Sai!");
                        System.out.println("Hay nhap ten hang");
                        sanpham[i].TENHANG = input.nextLine();
                    }
                    System.out.println("Hay nhap ngay san xuat");
                    sanpham[i].NSX = input.nextLine();
                    while (kiemtra.date(sanpham[i].NSX) == false) {
                        System.out.println("Sai!");
                        System.out.println("Hay nhap ngay san xuat");
                        sanpham[i].NSX = input.nextLine();
                    }
                    System.out.println("Hay nhap han su dung");
                    sanpham[i].HSD = input.nextLine();
                    while (kiemtra.date(sanpham[i].HSD) == false) {
                        System.out.println("Sai");
                        System.out.println("Hay nhap han su dung");
                        sanpham[i].HSD = input.nextLine();
                    }
                    System.out.println("Hay nhap vao nha cung cap");
                    sanpham[i].NCC = input.nextLine();
                    System.out.println("Hay nhap so luong");
                    String d9 = input.nextLine();
                    while (kiemtra.isNumberic(d9) == false) {
                        System.out.println("Sai!");
                        System.out.println("Hay nhap so luong");
                        d9 = input.nextLine();
                    }
                    sanpham[i].SOLUONG = Integer.valueOf(d9);
                    System.out.println("Hay nhap don vi");
                    sanpham[i].DONVI = input.nextLine();
                    
                }
                break;
                case 2: {
                    sanpham[i] = new drink();
                    String A = input.nextLine();
                    while (kiemtratrung(A) == 1) {
                        System.out.println("Hang hoa da ton tai");
                        A=input.nextLine();
                    }
                    sanpham[i].MAHANG = A;
                    System.out.println("Hay nhap ten hang");
                    sanpham[i].TENHANG = input.nextLine();
                    while (kiemtra.checkName(sanpham[i].TENHANG) == false) {
                        System.out.println("Sai!");
                        System.out.println("Hay nhap ten hang");
                        sanpham[i].TENHANG = input.nextLine();
                    }
                    System.out.println("Hay nhap ngay san xuat");
                    sanpham[i].NSX = input.nextLine();
                    while (kiemtra.date(sanpham[i].NSX) == false) {
                        System.out.println("Sai!");
                        System.out.println("Hay nhap ngay san xuat");
                        sanpham[i].NSX = input.nextLine();
                    }
                    System.out.println("Hay nhap han su dung");
                    sanpham[i].HSD = input.nextLine();
                    while (kiemtra.date(sanpham[i].HSD) == false) {
                        System.out.println("Sai");
                        System.out.println("Hay nhap han su dung");
                        sanpham[i].HSD = input.nextLine();
                    }
                    System.out.println("Hay nhap so luong");
                    String d9 = input.nextLine();
                    while (kiemtra.isNumberic(d9) == false) {
                        System.out.println("Sai!");
                        System.out.println("Hay nhap so luong");
                        d9 = input.nextLine();
                    }
                    sanpham[i].SOLUONG = Integer.valueOf(d9);
                    System.out.println("Hay nhap don vi");
                    sanpham[i].DONVI = input.nextLine();
                }
                break;
            }
        }
        save();
    }

    public void delete() {
        char k = '1';
        int kt = 0;
        System.out.println("Nhap MSP ban muon xoa");
        input.nextLine();
        String A = input.nextLine();
        while (k != '0') {
            for (int i = 0; i < n; i++) {
                if (sanpham[i].MAHANG.equals(A)) {
                    for (int j = i; i < n - 1; j++) {
                        sanpham[j] = sanpham[j + 1];
                    }
                    kt++;
                }
            }
            n--;
            if (kt == 0) {
                System.out.println("Khong ton tai ma hang hoac da xoa!");
            }
            System.out.println("Ban muon xoa them chu(Thoat chon 0)");
            k = input.next().charAt(0);
        }
        save();
    }

    public void save() {
        File file = new File("sanpham.txt");
        try {
            FileWriter file1 = new FileWriter(file);
            BufferedReader file2 = new BufferedReader(new FileReader(file));
            Writer out = new BufferedWriter(file1);
            String line;
            for (int i = 0; i < n; i++) {
                if (i == 0) {
                    out.write(sanpham[i].toString());
                } else {
                    out.write("\n" + sanpham[i].toString());
                }
            }
            out.close();
            System.out.println(f.getAbsolutePath());
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
    }

    public void xuat() {
        System.out.println("so luong san pham hien tai " + n);
        System.out.printf("%-10s%-15s%-10s%-11s%-11s%-15s%-15s%-15s\n", "MaHang", "TenHang", "NSX", "HSD", "NCC", "SOLUONG", "DONVI", "LOAI");
        for (int i = 0; i < n; i++) {
            sanpham[i].xuat();
        }
    }
     public void capnhatcong(String x,int a)
     {
        for(int i=0;i<n;i++)
        {
            if(sanpham[i].MAHANG.equals(x))
            {
                int t=sanpham[i].SOLUONG+a;
                sanpham[i].SOLUONG=t;
            }
        }
        save();
    }
    public void capnhattru(String x,int a)
    {
        for(int i=0;i<n;i++)
        {
            if(sanpham[i].MAHANG.equals(x))
            {
                int t=sanpham[i].SOLUONG-a;
                sanpham[i].SOLUONG=t;
            }
        }
        save();
    }
//     public void addtuchitietphieu(String MAHANG,String TENSP,String NSX,String HSD,String NCC,int SOLUONG,String DONVI)
//    {
//        int k;
//        sanpham[n]=new sanpham();
//        sanpham[n].MAHANG=MAHANG;
//        sanpham[n].TENHANG=TENSP;
//        sanpham[n].NSX=NSX;
//        sanpham[n].HSD=HSD;
//        sanpham[n].NCC=NCC;
//        sanpham[n].SOLUONG=SOLUONG;
//        sanpham[n].DONVI=DONVI;
//        n++;
//        save();
//    }
}
