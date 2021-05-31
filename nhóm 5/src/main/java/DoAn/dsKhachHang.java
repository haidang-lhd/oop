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

public class dsKhachHang extends KhachHang implements thaotac {

    File f = new File("Khachhang.txt");
    int n;
    int i = 0;
    Scanner input = new Scanner(System.in);
    KhachHang[] khachhang;

    public dsKhachHang() {
        khachhang = null;
        n = 0;
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
        } catch (IOException e) {
            System.out.println("ERROR " + e);
        }
        khachhang=new KhachHang[n];
        try {
            file = new BufferedReader(new FileReader(f));
            String line;
            String[] linenew;
            System.out.println("Du lieu duoc doc tu " + f.toString());
            while ((line = file.readLine()) != null) {
                linenew = line.split(" ");
                khachhang[i] = new KhachHang();
                khachhang[i].MaKH = linenew[0];
                khachhang[i].Hoten = linenew[1];
                khachhang[i].Ngaysinh = linenew[2];
                khachhang[i].SDT = linenew[3];
                i++;
            }            
        } catch (IOException e) {
            System.out.println("ERROR " + e);
        }
    }

    public void xuatds() {
        System.out.println("so khach hang hien tai la" + n);
        System.out.printf("%-20s%-20s%-20s%-20s\n", "Ma khach hang", "Ho ten", "Ngay sinh", "So dien thoai");
        for (int m = 0; m < n; m++) {
            khachhang[m].xuat();
        }
    }

    public int kiemtraTrung(int n, KhachHang x) {
        for (int i = 0; i < n; i++) {
            if ((khachhang[i].MaKH).equals(x.MaKH)) {
                return 1;
            }
        }
        return 0;
    }

    public void find() {
        System.out.print("Hay nhap vao ma khach hang ban muon tim kiem");
        String manv = input.nextLine();
        for (int i = 0; i < n; i++) {
            if (khachhang[i].MaKH.equals(manv)) {
                khachhang[i].xuat();
            }
        }
    }

    @Override
    public void add() {
        System.out.println("Nhap so luong nhan vien can them vao:");
        String d = input.nextLine();
        while (kiemtra.isNumberic(d) != true) {
            System.out.println("Sai!");
            d = input.nextLine();
        }
        int k = Integer.valueOf(d);
        int giatricu = n;
        this.n = n + k;
        khachhang = Arrays.copyOf(khachhang, n);
        for (int j = giatricu; j < n; j++) {
            khachhang[j] = new KhachHang();
            System.out.println("Hay nhap vao ma khach hang ");
            khachhang[j].MaKH = input.nextLine();
            while (kiemtraTrung(giatricu, khachhang[j]) == 1) {
                System.out.println("Khach hang nay da ton tai ");
                System.out.println("Hay nhap vao ma khach hang");
                khachhang[j].MaKH = input.nextLine();
            }
            System.out.println("Hay nhap vao ho va ten");
            khachhang[j].Hoten = input.nextLine();
            while (kiemtra.checkName(khachhang[j].Hoten) != false) {
                System.out.println("Sai!!!!!!!!!");
                System.out.println("Ho va Ten khong duoc co so!!Nhap lai");
                khachhang[j].Hoten = input.nextLine();
            }
            System.out.println("Hay nhap vao ngay sinh");
            khachhang[j].Ngaysinh = input.nextLine();
            while (kiemtra.date(khachhang[j].Ngaysinh) != true) {
                System.out.println("Sai!!!!!!!!!");
                System.out.println("Ngay sinh phai co dang so theo cau tru dd/mm/yy (d la ngay,m la thang,y la nam)");
                khachhang[j].Ngaysinh = input.nextLine();
            }
            System.out.println("Hay nhap vao SDT");
            khachhang[j].SDT = input.nextLine();
            while (kiemtra.phone(khachhang[j].SDT) != true) {
                System.out.println("Sai!!!!!!!!!");
                System.out.println("So dien thoai phai bao gom 10 chu so ");
                khachhang[j].SDT = input.nextLine();
            }
        }
        save();
        xuatds();
    }

    @Override
    public void delete() {
        System.out.println("Hay nhap vao ma khach hang muon xoa :");
        String k = input.nextLine();
        for (int i = 0; i < n; i++) {
            if (k.equals(khachhang[i].MaKH)) {
                for (int j = i; j < n - 1; j++) {
                    khachhang[j] = khachhang[j + 1];
                }
            }
             n--;
        }
       
        save();
        xuatds();
    }

    public void change() {
        System.out.print("Hay nhap vao ma cua khach hang muon sua :");
        String k = input.nextLine();
        String d;
        for (int i = 0; i < n; i++) {
            if (k.equals(khachhang[i].MaKH)) {
                do {
                    System.out.println("Ban muon chinh sua thong tin gi ?");
                    System.out.println("0 - Thoat khoi thao tac chinh sua");
                    System.out.println("1 - Ma khach hang");
                    System.out.println("2 - Ho va ten");
                    System.out.println("3 - Ngay sinh");
                    System.out.println("4 - So dien thoai");
                    System.out.println("==============================================");
                    System.out.println("HAY NHAP LUA CHON");
                    d = input.nextLine();
                    while (kiemtra.isNumberic(d) != true) {
                        System.out.print("Hay nhap lua chon bang so ");
                        d = input.nextLine();
                    }
                    if (kiemtra.isNumberic(d) == true) {
                        int d1 = Integer.valueOf(d);
                        switch (d1) {
                            case 1: {
                                System.out.print("Hay nhap vao ma khach hang :");
                                khachhang[i].MaKH = input.nextLine();
                        while (kiemtra.checkMNV(khachhang[i].MaKH, f)) {
                               System.out.println("Nhan vien nay da ton tai ");
                               System.out.println("Hay nhap vao ma nhan vien ");
                               khachhang[i].MaKH = input.nextLine();
            }}
                            break;
                            case 2: {
                                System.out.print("Hay nhap vao ho va ten :");
                                khachhang[i].Hoten = input.nextLine();
                                while (kiemtra.checkName(khachhang[i].Hoten) != false) {
                                         System.out.println("Sai!!!!!!!!!");
                                       System.out.println("Ho va Ten khong duoc co so!!Nhap lai");
                                            khachhang[i].Hoten = input.nextLine();
            }
                            }
                            break;
                            case 3: {
                                System.out.println("Hay nhap vao ngay sinh");
                                khachhang[i].Ngaysinh = input.nextLine();
                                while (kiemtra.date(khachhang[i].Ngaysinh) != true) {
                                    System.out.println("Sai!!!!!!!!!");
                                    System.out.println("Ngay sinh phai co dang so theo cau tru dd/mm/yy (d la ngay,m la thang,y la nam)");
                                    khachhang[i].Ngaysinh = input.nextLine();
                                }
                            }
                            break;
                            case 4: {
                                System.out.println("Hay nhap vao SDT");
                                khachhang[i].SDT = input.nextLine();
                                while (kiemtra.phone(khachhang[i].SDT) != true) {
                                    System.out.println("Sai!!!!!!!!!");
                                    System.out.println("So dien thoai phai bao gom 10 chu so ");
                                    khachhang[i].SDT = input.nextLine();
                                }
                            }
                            break;
                        }
                        
                    }                    
                } while (!"0".equals(d));
                if ("0".equals(d)) {
                    System.out.println("Da thoat khoi thao tac chinh sua");
                }
            }
        }
        System.out.println("Thong tin da duoc chinh sua");
        save();
        xuatds();
    }

    public void thaotac() {
        
        int x;
        do {
            System.out.println("==============================================");
            System.out.println("Ban muon thuc hien thao tac gi ?");
            System.out.println("0-Ket thuc thuc hien thao tac");
            System.out.println("1-Them khach hang");
            System.out.println("2-Xoa khach hang");
            System.out.println("3-Tim kiem khach hang");
            System.out.println("4-Chinh sua thong tin");
            System.out.println("==============================================");
            System.out.println("HAY CHON THAO TAC MUON THUC HIEN");
            x = input.nextInt();
            input.nextLine();
            switch (x) {
                case 1: {
                    System.out.println("==============================================");
                    System.out.println("DANG THUC HIEN THAO TAC THEM KHACH HANG VAO DANH SACH");
                    add();
                }
                break;
                case 2: {                    
                    System.out.println("==============================================");
                    System.out.println("DANG THUC HIEN THAO TAC XOA KHACH HANG KHOI DANH SACH");
                    delete();
                }
                break;
                case 3: {                    
                    System.out.println("==============================================");
                    System.out.println("DANHG THUC HIEN THAO TAC TIM KIEM KHACH HANG TRONG DANH SACH");
                    find();
                }
                break;
                case 4: {
                    System.out.println("==============================================");
                    System.out.println("DANG THUC HIEN THAO TAC CHINH SUA THONG TIN KHACH HANG");
                    change();
                }
                break;
            }
        } while (x > 0);
    }

    @Override
    public void save() {
        File file = new File("khachhang.txt");
        try {
            FileWriter file1 = new FileWriter(file);
            BufferedReader file2 = new BufferedReader(new FileReader(file));
            Writer out = new BufferedWriter(file1);
            String line;
            for (int i = 0; i < n; i++) {
                if (i == 0) {
                    out.write(khachhang[i].toString());
                } else {
                    out.write("\n" + khachhang[i].toString());
                }
                
            }
            out.close();
            System.out.println(f.getAbsolutePath());
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
    }
    
    @Override
    public void add(String x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void delete(String x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
