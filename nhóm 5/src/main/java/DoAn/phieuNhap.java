
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
 * @author Admins t
 */
public class phieuNhap implements thaotac{
    public String Ma;
    public String MaNV;
    File file=new File("phieunhap.txt");
    String line;
    String[] linenew;
    Scanner input=new Scanner(System.in);
    public phieuNhap()
    {
        Ma = null;
        MaNV = null;
    }
//    public void docPN(String x)
//    {
//        BufferedReader f=null;
//        try{
//            f=new BufferedReader(new FileReader(file));
//            while((line=f.readLine())!=null)
//            {
//                linenew=line.split(" ");
//                if(linenew[0].equals(x))
//                {
//                    System.out.println("Ma phieu nhap " + linenew[0]);
//                    System.out.println("Nhan vien phu trach " +linenew[1]);
//                }
//            }
//        }catch(IOException e){}
//    }
    public void xuat()
    {
        System.out.printf("%-10s%-10s\n",Ma,MaNV);
    }
    public void add(String x) {
    }

    public void add(){};

    public void delete(String x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    

    public void save() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
