
package DoAn;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;
public class dschitietphieunhap extends chitietphieuNhap implements thaotac{
    chitietphieuNhap[] chitiet;
    File f=new File("chitietphieunhap.txt");
    int n=0;
    Scanner input=new Scanner(System.in);
    public dschitietphieunhap(){}
    public void docfile()
    {
        chitiet= new chitietphieuNhap[100];
        BufferedReader file=null;
        try{
            file=new BufferedReader(new FileReader(f));
            String line;
            String[] linenew;
            while((line=file.readLine())!=null)
            {
                linenew=line.split(" ");
                chitiet[n]=new chitietphieuNhap();
                chitiet[n].MaPN=linenew[0];
                chitiet[n].MAHANG=linenew[1];
                chitiet[n].TENHANG=linenew[2];
                chitiet[n].NSX=linenew[3];
                chitiet[n].HSD=linenew[4];
                chitiet[n].NCC=linenew[5];
                chitiet[n].SOLUONG=Integer.valueOf(linenew[6]);
                chitiet[n].DONVI=linenew[7];
                n++;
            }
        }catch(IOException e){           
       }
    }
    public int kiemtratrung(String A)
    {
        for(int b=0;b<n;b++)
        {
            if(chitiet[b].MaPN.equals(A))
            {
                return 1;
            }
        }
        return 0;
    }
    public void add(String s) {//Viet them
        System.out.println("Ban muon them bao nhieu hang hoa vao phieu nhap?");
        String k=input.nextLine();while(kiemtra.isNumberic(k)!=true){System.out.println("Ban khong nhap so!Sai, vui long nhap so");k=input.nextLine();};
        int q=Integer.valueOf(k);
        dssanpham sanpham=new dssanpham();
           sanpham.docFile();
        System.out.println("Nhap thong tin hang hoa!!");
        System.out.println("MAHANG-TENHANG-NSX-HSD-NCC-SOLUONG-DONVI");
        for(int i=0;i<q;i++)
        {
           chitiet[n]=new chitietphieuNhap();
            String A=input.nextLine();
            chitiet[n].MaPN=s;
            chitiet[n].MAHANG=A; 
            if(sanpham.kiemtratrung(chitiet[n].MAHANG)==1)
            {
                System.out.println("San pham nay da ton tai trong kho!Chi can nhap soluong");
                System.out.println("Soluong:");
                String KT=input.nextLine();while(kiemtra.isNumberic(KT)==false){System.out.println("SOLUONG khong hop le!Vui long nhap lai!"); KT=input.nextLine();}
                chitiet[n].SOLUONG=Integer.valueOf(KT);
                sanpham.capnhatcong(chitiet[n].MAHANG,chitiet[n].SOLUONG);
             }
            else{
            chitiet[n].TENHANG=input.nextLine();
            chitiet[n].NSX=input.nextLine(); while(kiemtra.date(chitiet[n].NSX)==false){System.out.println("NSX khong hop le!Vui long nhap lai!"); chitiet[n].NSX=input.nextLine();}
            chitiet[n].HSD=input.nextLine(); while(kiemtra.date(chitiet[n].HSD)==false){System.out.println("HSD khong hop le!Vui long nhap lai!"); chitiet[n].HSD=input.nextLine();}
            chitiet[n].NCC=input.nextLine(); //thieu NCC
            String KT=input.nextLine();while(kiemtra.isNumberic(KT)==false){System.out.println("SOLUONG khong hop le!Vui long nhap lai!"); KT=input.nextLine();}
            chitiet[n].SOLUONG=Integer.valueOf(KT);
            chitiet[n].DONVI=input.nextLine();
            sanpham.addtuchitietphieu(chitiet[n].MAHANG, chitiet[n].TENHANG, chitiet[n].NSX, chitiet[n].HSD, chitiet[n].NCC, chitiet[n].SOLUONG, chitiet[n].DONVI);
            n++;
            }
            System.out.println("-----------------------------");
            save();
        }//for
    }
    


    public void delete(String x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void save() {
            File file=new File("chitietphieunhap.txt");
        try{
            FileWriter file1=new FileWriter(file);
            BufferedReader file2=new BufferedReader(new FileReader(file));
            Writer out=new BufferedWriter(file1);
            String line;
            for(int i=0;i<n;i++)
            {
                if(i==0)
                {
                    out.write(chitiet[i].toString());
                }
                else
                    out.write("\n"+chitiet[i].toString());
            }
            out.close();
            System.out.println(f.getAbsolutePath());
        }catch(Exception e){
            System.out.println("Error " +e);
        }
    }
    public void xuat(String a)
    {
         System.out.printf("%-10s%-10s%-15s%-10s%-11s%-11s%-15s%-15s\n", "MaPN","MAHANG", "TENHANG"," NSX", "HSD", "NCC","SOLUONG","DONVI");
        for(int i=0;i<n;i++)
        {
            if(chitiet[i].MaPN.equals(a))
            chitiet[i].xuat();
        }
    }
    public void add() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
