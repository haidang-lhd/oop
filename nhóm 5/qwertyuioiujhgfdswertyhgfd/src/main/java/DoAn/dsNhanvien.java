package DoAn;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Scanner;

public class dsNhanvien extends Nhanvien implements thaotac {

    File f = new File("Nhanvien.txt");
    int n;
    Scanner input = new Scanner(System.in);
    Nhanvien[] nhanvien;

    public dsNhanvien() {
        nhanvien = null;
        n = 0;
    }

    public void docFile() {
        nhanvien = new Nhanvien[n];
        int giatricu;
        BufferedReader file = null;
        try {
            file = new BufferedReader(new FileReader(f));
            String line;
            String[] linenew;
            n = 0;
            while ((line = file.readLine()) != null) {
                n++;
            }
        } catch (IOException e) {
            System.out.println("ERROR " + e);
        }
        nhanvien = new Nhanvien[n];
        try {
            file = new BufferedReader(new FileReader(f));
            String line;
            String[] linenew;
            int i = 0;
            while ((line = file.readLine()) != null) {
                linenew = line.split(" ");
                nhanvien[i] = new Nhanvien();
                nhanvien[i].MaNV = linenew[0];
                nhanvien[i].Hoten = linenew[1];
                nhanvien[i].Ngaysinh = linenew[2];
                nhanvien[i].SDT = linenew[3];
                i++;
            }
        } catch (IOException e) {
            System.out.println("ERROR " + e);
        }
    }

    public void xuatds() {
        System.out.println("So luong nhan vien hien tai " + n);
        System.out.printf("%-20s%-20s%-20s%-20s\n", "Ma Nhan vien", "Ho ten", "Ngay sinh", "So dien thoai");
        for (int m = 0; m < n; m++) {
            nhanvien[m].xuat();
        }
    }
    public int kiemtraTrung(String x)
    {
        for(int i=0;i<n;i++)
        {
            if(nhanvien[i].MaNV.equals(x))
            {
                return 1;
            }
        }
        return 0;
    }
    public int kiemtraTrung(int n, Nhanvien x) {
        for (int i = 0; i < n; i++) {
            if ((nhanvien[i].MaNV).equals(x.MaNV)) {
                return 1;
            }
        }
        return 0;
    }

    public void find() {
        System.out.print("Hay nhap vao ma nhan vien ban muon tim kiem");
        String manv = input.nextLine();
        for (int i = 0; i < n; i++) {
            if (nhanvien[i].MaNV.equals(manv)) {
                nhanvien[i].xuat();
            }
        }
    }

    @Override
    public void add() {

        System.out.println("Hay nhap luong nhan vien");
        String d = input.nextLine();
        while(kiemtra.isNumberic(d)!=true)
        {
            System.out.println("Sai!");
             System.out.println("Hay nhap lai ");
             d = input.nextLine();
        }
        int giatricu = n;
        int k = Integer.valueOf(d);
        this.n = n + k;
        nhanvien = Arrays.copyOf(nhanvien, n);
        for (int j = giatricu; j < n; j++) {
            nhanvien[j] = new Nhanvien();
            System.out.println("Hay nhap vao ma nhan vien ");
            nhanvien[j].MaNV = input.nextLine();
            while (kiemtra.checkMNV(nhanvien[j].MaNV, f)) {
                System.out.println("Nhan vien nay da ton tai ");
                System.out.println("Hay nhap vao ma nhan vien ");
                nhanvien[j].MaNV = input.nextLine();
            }
            System.out.println("Hay nhap vao ho va ten");
            nhanvien[j].Hoten = input.nextLine();
            while (kiemtra.checkName(nhanvien[j].Hoten) != false) {
                System.out.println("Sai!!!!!!!!!");
                System.out.println("Ho va Ten khong duoc co so!!Nhap lai");
                nhanvien[j].Hoten = input.nextLine();
            }
            System.out.println("Hay nhap vao ngay sinh");
            nhanvien[j].Ngaysinh = input.nextLine();
            while (kiemtra.date(nhanvien[j].Ngaysinh) != true) {
                System.out.println("Sai!!!!!!!!!");
                System.out.println("Ngay sinh phai co dang so theo cau tru dd/mm/yy (d la ngay,m la thang,y la nam)");
                nhanvien[j].Ngaysinh = input.nextLine();
            }
            System.out.println("Hay nhap vao so dien thoai");
            nhanvien[j].SDT = input.nextLine();
            while (kiemtra.phone(nhanvien[j].SDT) != true) {
                System.out.println("Sai!!!!!!!!!");
                System.out.println("So dien thoai phai bao gom 10 chu so ");
                nhanvien[j].SDT = input.nextLine();
            }
        }
        save();
        xuatds();
    }

    @Override
    public void delete() {
        System.out.print("Hay nhap vao ma sinh vien muon xoa :");
        String k = input.nextLine();
        for (int i = 0; i < n; i++) {
            if (k.equals(nhanvien[i].MaNV)) {
                for (int j = i; j < n - 1; j++) {
                    nhanvien[j] = nhanvien[j + 1];
                }
                n--;
            }
        }
        
        save();
        xuatds();
    }

    public void change() {
        System.out.print("Hay nhap vao ma cua nhan vien muon sua :");
        String k = input.nextLine();
        if(kiemtraTrung(k)==0)
        {
            System.out.println("Nhan vien nay khong ton tai!");
            return;
        }
        String d1;
        int d;
        for (int i = 0; i < n; i++) {
            if (k.equals(nhanvien[i].MaNV)) {
                do {
                    System.out.println("Ban muon chinh sua thong tin gi ?");
                    System.out.println("0 - Thoat khoi thao tac chinh su");
                    System.out.println("1 - Ma nhan vien");
                    System.out.println("2 - Ho va ten");
                    System.out.println("3 - Ngay sinh");
                    System.out.println("4 - So dien thoai");
                    System.out.println("==============================================");
                    System.out.println("HAY NHAP LUA CHON");
                    d1 = input.nextLine();
                    while(kiemtra.isNumberic(d1)==false){
                        System.out.println("Ban da nhap sai!Vui long chi nhap so");
                        d1=input.nextLine();
                    }
                    input.nextLine();
                    d=Integer.valueOf(d1);
                    switch (d) {
                       
                        case 1: {
                            System.out.print("Hay nhap vao ma nhan vien :");
                            nhanvien[i].MaNV = input.nextLine();
                            while (kiemtra.checkMNV(nhanvien[i].MaNV, f)) {
                               System.out.println("Nhan vien nay da ton tai ");
                                System.out.println("Hay nhap vao ma nhan vien ");
                                nhanvien[i].MaNV = input.nextLine();
                              }
                        }
                        break;
                        case 2: {
                            System.out.print("Hay nhap vao ho va ten :");
                            nhanvien[i].Hoten = input.nextLine();
                            while(kiemtra.checkName(nhanvien[i].Hoten)!=true)
                            {
                                System.out.println("Sai!");
                                System.out.println("Hay nhap lai ");   
                                nhanvien[i].Hoten = input.nextLine();
                            }
                        }
                        break;
                        case 3: {
                            System.out.println("Hay nhap vao ngay sinh");
                            nhanvien[i].Ngaysinh = input.nextLine();
                            while (kiemtra.date(nhanvien[i].Ngaysinh) != true) {
                                System.out.println("Sai!!!!!!!!!");
                                System.out.println("Ngay sinh phai co dang so theo cau tru dd/mm/yy (d la ngay,m la thang,y la nam)");
                                nhanvien[i].Ngaysinh = input.nextLine();
                            }
                        }
                        break;
                        case 4: {
                            System.out.println("Hay nhap vao so dien thoai");
                            nhanvien[i].SDT = input.nextLine();
                            while (kiemtra.phone(nhanvien[i].SDT) != true) {
                                System.out.println("Sai!!!!!!!!!");
                                System.out.println("So dien thoai phai bao gom 10 chu so ");
                                nhanvien[i].SDT = input.nextLine();
                            }
                        }
                        break;
                    }
                } while (d > 0);
                if (d == 0) {
                    System.out.println("Da thoat khoi thao tac chinh sua");
                }
            }
        }
        System.out.println("Thong tin da duoc chinh sua");
        save();
        xuatds();
    }

    public void thaotac() {
        String d;
        do {
            System.out.println("==============================================");
            System.out.println("Ban muon thuc hien thao tac gi ?");
            System.out.println("0-Ket thuc thuc hien thao tac");
            System.out.println("1-Them nhan vien");
            System.out.println("2-Xoa nhan vien");
            System.out.println("3-Tim kiem nhan vien");
            System.out.println("4-Chinh sua thong tin");
            System.out.println("==============================================");
            System.out.println("HAY CHON THAO TAC MUON THUC HIEN");
            d = input.nextLine();
            while (kiemtra.isNumberic(d) != true) {
                System.out.println("Hay nhap lua chon bang so ");
                d = input.nextLine();
            }
            if (kiemtra.isNumberic(d) == true) {
                int d1 = Integer.valueOf(d);
                switch (d1) {
                    case 1: {
                        System.out.println("==============================================");
                        System.out.println("DANG THUC HIEN THAO TAC THEM NHAN VIEN VAO DANH SACH");
                        add();
                    }
                    break;
                    case 2: {
                        System.out.println("==============================================");
                        System.out.println("DANG THUC HIEN THAO TAC XOA NHAN VIEN KHOI DANH SACH");
                        delete();
                    }
                    break;
                    case 3: {
                        System.out.println("==============================================");
                        System.out.println("DANHG THUC HIEN THAO TAC TIM KIEM NHAN VIEN TRONG DANH SACH");
                        find();
                    }
                    break;
                    case 4: {
                        System.out.println("==============================================");
                        System.out.println("DANG THUC HIEN THAO TAC CHINH SUA THONG TIN NHAN VIEN");
                        change();
                    }
                    break;
                    default: {
                        
                        break;
                    }
                }
            }
        } while (!"0".equals(d));
        if ("0".equals(d)) {
            System.out.println("Da thoat!");
        }
    }

    @Override
    public void save() {
        File file = new File("Nhanvien.txt");
        try {
            FileWriter file1 = new FileWriter(file);
            BufferedReader file2 = new BufferedReader(new FileReader(file));
            Writer out = new BufferedWriter(file1);
            String line;
            for (int i = 0; i < n; i++) {
                if (i == 0) {
                    out.write(nhanvien[i].toString());
                } else {
                    out.write("\n" + nhanvien[i].toString());
                }
            }
            out.close();
            System.out.println(f.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error " + e);
        }
    }

    @Override
    public void add(String x) {
        int giatricu = n;
        int k = 1;
        this.n = n + k;
        nhanvien = Arrays.copyOf(nhanvien, n);
        for (int j = giatricu; j < n; j++) {
            nhanvien[j] = new Nhanvien();
            nhanvien[j].MaNV=x;
            System.out.println("Hay nhap vao ho va ten");
            nhanvien[j].Hoten = input.nextLine();
            while (kiemtra.checkName(nhanvien[j].Hoten) != false) {
                System.out.println("Sai!!!!!!!!!");
                System.out.println("Ho va Ten khong duoc co so!!Nhap lai");
                nhanvien[j].Hoten = input.nextLine();
            }
            System.out.println("Hay nhap vao ngay sinh");
            nhanvien[j].Ngaysinh = input.nextLine();
            while (kiemtra.date(nhanvien[j].Ngaysinh) != true) {
                System.out.println("Sai!!!!!!!!!");
                System.out.println("Ngay sinh phai co dang so theo cau tru dd/mm/yy (d la ngay,m la thang,y la nam)");
                nhanvien[j].Ngaysinh = input.nextLine();
            }
            System.out.println("Hay nhap vao so dien thoai");
            nhanvien[j].SDT = input.nextLine();
            while (kiemtra.phone(nhanvien[j].SDT) != true) {
                System.out.println("Sai!!!!!!!!!");
                System.out.println("So dien thoai phai bao gom 10 chu so ");
                nhanvien[j].SDT = input.nextLine();
            }
        }
        save();
        xuatds();
    }
    @Override
    public void delete(String x) {
    }
;
}
