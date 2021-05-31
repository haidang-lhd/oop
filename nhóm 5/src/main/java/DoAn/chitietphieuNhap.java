/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoAn;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;
/**
 *
 * @author Admin
 */
public class chitietphieuNhap {
    public String MaPN;
    public String MAHANG;
    public String TENHANG;
    protected String NSX;
    protected String HSD;
    protected String NCC;
    protected int SOLUONG;
    protected String DONVI;
    sanpham[] sanpham;
    int n=0;
    Scanner input=new Scanner(System.in);
    String line,line1,line2;
    String[] linenew,linenew1,linenew2;
    File file=new File("chitietphieunhap.txt");
    File file1=new File("sanpham.txt");
    File file2=new File("phieunhap.txt");
    @Override
       public String toString()
    {
        return MaPN+" "+MAHANG+" "+TENHANG+" "+NSX+" "+HSD+" "+NCC+" "+SOLUONG+" "+DONVI;
                
    }
      public void xuat()
    {
         System.out.printf("%-10s%-10s%-15s%-10s%-11s%-11s%-15s%-15s\n", MaPN,MAHANG, TENHANG, NSX, HSD, NCC,SOLUONG,DONVI);
    }
    public void xuatCTPN(String x)
    {
        BufferedReader f=null;
        try{
            f=new BufferedReader(new FileReader(file));
            System.out.println("========================================");
           System.out.printf("%-10s%-10s%-15s%-10s%-11s%-11s%-15s%-15s\n", MaPN,MAHANG, TENHANG, NSX, HSD, NCC,SOLUONG,DONVI);
            while((line=f.readLine())!=null)
            {
                linenew=line.split(" ");
                if(linenew[0].equals(x))
                {
                   System.out.printf("%-10s%-10s%-15s%-10s%-11s%-11s%-15s%-15s\n", MaPN,MAHANG, TENHANG, NSX, HSD, NCC,SOLUONG,DONVI);
                }
            }
        }catch(Exception e){}
    }
   /* public void add(String x)//them vao chi tiet phieu nhap
    {
        try{
            FileWriter f1=new FileWriter(file,true);
            BufferedReader f2=new BufferedReader(new FileReader(file));
            Writer out=new BufferedWriter(f1);
            BufferedReader f3=null;
            try{
                 f3=new BufferedReader(new FileReader(file2));
                while((line2=f3.readLine())!=null)
                {
                    linenew2=line2.split(" ");
                    MaPN=linenew2[0];
                }
               }catch(IOException e){}
            System.out.println("Hay nhap ma san pham");
            MAHANG=input.nextLine();
            System.out.println("Hay nhap So luong");
            SOLUONG=input.nextLine();
            out.write("\r\n"+MaPN+" "+MAHANG+" "+SOLUONG);
            out.close();
            System.out.println(file.getAbsolutePath());
            f1.close();
        }catch(IOException e){
            System.out.println("Error " +e);
        }
    }*/
    public chitietphieuNhap() {
        this.MaPN = null;
        this.MAHANG=null;
        this.TENHANG=null;
        this.NSX=null;
        this.HSD=null;
        this.DONVI=null;
        this.NCC=null;
        this.SOLUONG = 0;
    }
}
