package DoAn;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import static java.lang.Integer.parseInt;
import java.util.Arrays;
import java.util.Scanner;

public class dsHoadon extends hoadon implements thaotac {

    File f = new File("hoadon.txt");
    File f1 = new File("chitiethoadon.txt");
    Scanner input = new Scanner(System.in);
    int n = 0;
    hoadon[] hoadon;
    public String Ma;
    public String MaSP;
    public int Soluong;
    public int Gia;
    public int Tongtien;
    String line, line1;
    String[] linenew, linenew1;

    public long tinhtien(String x) {
        BufferedReader file1 = null;
        Tongtien = 0;
        try {
            file1 = new BufferedReader(new FileReader(f1));
            String line1;
            String[] linenew1;
            while ((line1 = file1.readLine()) != null) {
                linenew1 = line1.split(" ");
                if (linenew1[0].equals(x)) {
                    Soluong = Integer.parseInt(linenew1[2]);
                    Gia = Integer.parseInt(linenew1[3]);
                    Tongtien = ((Soluong * Gia) + Tongtien);
                }
            }
            return Tongtien;

        } catch (IOException e) {
        }
        return 1;
    }

    public void docFile() {
        BufferedReader file = null;
        try {
            file = new BufferedReader(new FileReader(f));
            {
                while ((line = file.readLine()) != null) {
                    n++;
                }
            }
        } catch (Exception e) {
        };
        int i = 0;
        hoadon = new hoadon[n];
        try {
            file = new BufferedReader(new FileReader(f));

            System.out.println("Du lieu duoc doc tu " + f.toString());
            while ((line = file.readLine()) != null) {
                linenew = line.split(" ");
                hoadon[i] = new hoadon();
                hoadon[i].MaHD = linenew[0];
                hoadon[i].MaNV = linenew[1];
                hoadon[i].MaKH = linenew[2];
                hoadon[i].Ngay = linenew[3];
                i++;
            }
            file.close();
        } catch (IOException e) {
        }
    }

    public void gan() {
        for (int i = 0; i < n; i++) {
            hoadon[i].Tongtien = tinhtien(hoadon[i].MaHD);
        }
    }

    @Override
    public void xuat() {
        System.out.println("1-Xuat toan bo tat ca hoa don");
        System.out.println("2-Xuat hoa don them ma hoa don");
        System.out.printf("HAY NHAP VAO LUA CHON :");

        int k = input.nextInt();

        System.out.println("===============================================================");
        switch (k) {
            case 1: {
                System.out.printf("%-10s%-10s%-10s%-10s%-10s\n", "MaHD", "MaNV", "MaKH", "Ngay", "Tong tien");
                for (int i = 0; i < n; i++) {
                    hoadon[i].xuat();
                }
            }
            break;
            case 2: {
                chitiethoadon z = new chitiethoadon();
                System.out.println("Hay nhap vao hoa don muon xuat");
                input.nextLine();
                String d = input.nextLine();
                System.out.printf("%-10s%-10s%-10s%-10s%-10s\n", "MaHD", "MaNV", "MaKH", "Ngay", "Tong tien");
                for (int i = 0; i < n; i++) {
                    if (d.equals(hoadon[i].MaHD)) {
                        hoadon[i].xuat();
                        System.out.println("=============================");
                        System.out.println("CHI TIET HOA DON");
                        z.xuatCTHD(d);
                    }
                }
            }
            break;
        }
    }

    public int kiemtraTrung(String x) {
        for (int i = 0; i < n; i++) {
            if (x.equals(hoadon[i].MaHD)) {
                return 1;
            }
        }
        return 0;
    }
    
     public int kiemtraTrung(String x,int n) {
        for (int i = 0; i < n; i++) {
            if (x.equals(hoadon[i].MaHD)) {
                return 1;
            }
        }
        return 0;
    }
    @Override
    public void add(String x) {
//       docFile();
//       input.nextLine();
        int giatricu = n;
//        System.out.println("Hay nhap so luong hoa don can them");
//        String d = input.nextLine();
//        while (kiemtra.isNumberic(d) != true) {
//            System.out.println("Sai!");
//            System.out.println("Hay nhap lai");
//            d = input.nextLine();
//        }
//        int k = Integer.valueOf(d);
        this.n = n + 1;
        hoadon = Arrays.copyOf(hoadon, n);
//        for (int j = giatricu; j < n; j++) {
        hoadon[giatricu] = new hoadon();
        hoadon[giatricu].MaHD = x;
        while ((kiemtraTrung(x)) == 1) {
            System.out.println("==========================");
            System.out.println("Ma hoa don nay da ton tai");
            System.out.println("Hay nhap ma hoa don ");
            x = input.nextLine();
//                x = hoadon[giatricu].MaHD;
        }
        hoadon[giatricu].MaHD = x;
        System.out.println("Nhap ma nhan vien");
        hoadon[giatricu].MaNV = input.nextLine();
        dsNhanvien a = new dsNhanvien();
        a.docFile();
        if (a.kiemtraTrung(hoadon[giatricu].MaNV) == 0) {
            System.out.println("Ma nv nay khong ton tai trong danh sach nhan vien!!");
            System.out.println("Ban muon them nhan vien nay vao danh sach khong?Y/N");
            char yesno = input.next().charAt(0);
            while (1 == 1) {
                switch (yesno) {
                    case 'Y': {
                        dsNhanvien as = new dsNhanvien();
                        as.docFile();
                        as.add(hoadon[giatricu].MaNV);
                        save();
                        yesno='N';
                        break;
                    }
                    case 'N': {
                        System.out.println("Ban khong them vao nv moi!Thoat");
                        return;
                    }
                    default: {
                        System.out.println("Ban da nhap sai!Vui long nhap lai");
                        yesno = input.next().charAt(0);
                    }
                }//switch
            }
        }
        //shdhagds
        System.out.println("Nhap ma khach hang");
        hoadon[giatricu].MaKH = input.nextLine();
        System.out.println("Nhap ngay cua hoa don");
        hoadon[giatricu].Ngay = input.nextLine();
        chitiethoadon d=new chitiethoadon();
        System.out.println("Nhap so luong sp cho hoa don");
        String c1=input.nextLine();
        while(kiemtra.isNumberic(c1)!=true)
        {
            System.out.println("Ban da nhap sai!");
            System.out.println("Chi duoc nhap so ");
            c1=input.nextLine();
        }
        int c=Integer.valueOf(c1);
        for(int i=0;i<c;i++)
        {
            d.add(x);
        }    
//        }
        save();
    }

    public void change() {
        System.out.print("Hay nhap vao ma cua hoa don muon sua :");
        String k = input.nextLine();
        int d;
        for (int i = 0; i < n; i++) {
            if (k.equals(hoadon[i].MaHD)) {
                System.out.println("Hay nhap ma hoa don");
                hoadon[i].MaHD = input.nextLine();
                while (kiemtraTrung(hoadon[i].MaHD) == 1) {
                    System.out.println("Sai!");
                    System.out.println("Ma hoa don da trung");
                    hoadon[i].MaHD = input.nextLine();
                }
                System.out.println("Hay nhap ma nhan vien");
                hoadon[i].MaNV = input.nextLine();
                dsNhanvien a = new dsNhanvien();
                a.docFile();
                if (a.kiemtraTrung(hoadon[i].MaNV) == 0) {
                    System.out.println("Ma nv nay khong ton tai trong danh sach nhan vien!!");
                    System.out.println("Ban muon them nhan vien nay vao danh sach khong?Y/N");
                    char yesno = input.next().charAt(0);
                    while (1 == 1) {
                        switch (yesno) {
                            case 'Y': {
                                dsNhanvien as = new dsNhanvien();
                                as.docFile();
                                as.add(hoadon[i].MaNV);
                                save();
                                break;
                            }
                            case 'N': {
                                System.out.println("Ban khong them vao nv moi!Thoat");
                                return;
                            }
                            default: {
                                System.out.println("Ban da nhap sai!Vui long nhap lai");
                                yesno = input.next().charAt(0);
                            }
                        }//switch
                    }
                }
            }
        }
        System.out.println("Thong tin da duoc chinh sua");
        save();
        xuat();
    }

    public void save() {
        try {
            FileWriter file1 = new FileWriter(f);
            BufferedReader file2 = new BufferedReader(new FileReader(f));
            Writer out = new BufferedWriter(file1);
            for (int i = 0; i < n; i++) {
                out.write(hoadon[i].MaHD + " " + hoadon[i].MaNV + " " + hoadon[i].MaKH + " " + hoadon[i].Ngay + "\r\n");
            }
            out.close();
            System.out.println(f.getAbsolutePath());
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
    }

    @Override
    public void add() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
