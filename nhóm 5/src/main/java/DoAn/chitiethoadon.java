package DoAn;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class chitiethoadon implements thaotac {

    public String MaHD;
    public String MaSP;
    public int Sl;
    public long Gia;
    String line, line1;
    String[] linenew, linenew1;
    File file = new File("chitiethoadon.txt");
    File file3 = new File("hoadon.txt");
    Scanner input = new Scanner(System.in);

    public chitiethoadon() {
        MaHD = null;
        MaSP = null;
        Sl = 0;
        Gia = 0;
    }

    public void xuatCTHD(String x) {
        BufferedReader f = null;
        System.out.println("Ma hoa don :" + x);
        System.out.printf("%-20s%-20s%-20s\n", "MaSP", "SL", "Gia");
        try {
            f = new BufferedReader(new FileReader(file));
            while ((line = f.readLine()) != null) {
                linenew = line.split(" ");
                if (linenew[0].equals(x)) {

                    System.out.printf("%-20s%-20s%-20s\n", linenew[1], linenew[2], linenew[3]);
                }
            }
        } catch (IOException e) {
        }
    }

    public String toString() {
        return MaHD + " " + MaSP + " " + Sl + " " + Gia;
    }

    @Override
    public void add(String x) {
        try {
            FileWriter file1 = new FileWriter(file, true);
            BufferedReader file2 = new BufferedReader(new FileReader(file));
            Writer out = new BufferedWriter(file1);
//            try {
//                f3 = new BufferedReader(new FileReader(file3));
//                while ((line1 = f3.readLine()) != null) {
//                    linenew1 = line1.split(" ");
//                    if (x.equals(linenew1[0])) {
//                        MaHD = linenew1[0];
//                    }
//                }
//            } catch (IOException e) {
//            }
//             
            dsHoadon d = new dsHoadon();
            d.docFile();
            MaHD=x;
            System.out.println("Hay nhap ma san pham");
            MaSP = input.nextLine();
            System.out.println("Hay nhap So luong");
            String d5=input.nextLine();
            while(kiemtra.isNumberic(d5)!=true)
            {
                System.out.println("Sai!");
                d5=input.nextLine();
            }
            Sl=Integer.valueOf(d5);
            System.out.println("Hay nhap gia tien");
            String d6=input.nextLine();
            while(kiemtra.isNumberic(d5)!=true)
            {
                System.out.println("Sai!");
                d6=input.nextLine();
            }
            Gia = Integer.valueOf(d6);
            System.out.println();
            out.write("\n"+toString());
            out.close();
            System.out.println(file.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error " + e);
        }
    }

    @Override
    public void add() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String x) {

    }

    @Override
    public void delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
