package DoAn;
import java.util.Scanner;
abstract public class ConNguoi {
    protected String Hoten;
    protected String Ngaysinh;
    protected String SDT;
    Scanner input=new Scanner(System.in);
    public ConNguoi()
    {
        Hoten=null;
        Ngaysinh=null;
        SDT=null;
    }
    public ConNguoi(String Hoten,String Ngaysinh,String SDT)
    {
        this.Hoten=Hoten;
        this.Ngaysinh=null;
        this.SDT=null;
    }
    public String getHoten() 
    {
        return Hoten;
    }
    public void setHoten(String Hoten) 
    {
        this.Hoten = Hoten;
    }
    public String getNgaysinh()
    {
        return Ngaysinh;
    }
    public void setNgaysinh(String Ngaysinh)
    {
        this.Ngaysinh = Ngaysinh;
    }
    public String getSDT()
    {
        return SDT;
    }
    public void setSDT(String SDT) 
    {
        this.SDT = SDT;
    }
    public void nhap()
    {
        System.out.println("Hay nhap vao ho va ten");
        Hoten=input.nextLine();
        while(kiemtra.checkName(Hoten)!=true)
        {
            System.out.println("Sai!");
            System.out.println("Vui long nhap lai ten");
             Hoten=input.nextLine();
        }
        System.out.println("Hay nhap vao ngay sinh");
        Ngaysinh=input.nextLine();
        while(kiemtra.date(Ngaysinh)!=true)
        {
            System.out.println("Sai!!!!!!!!!");
            System.out.println("Ngay sinh phai co dang so theo cau tru dd/mm/yy (d la ngay,m la thang,y la nam)");
            Ngaysinh=input.nextLine();
        }
        System.out.println("Hay nhap vao so dien thoai");
        SDT=input.nextLine();
        while(kiemtra.phone(SDT)!=true)
        {
            System.out.println("Sai!!!!!!!!!");
            System.out.println("So dien thoai phai bao gom 10 chu so ");
            SDT=input.nextLine();
        }
      
    }
    public void xuat()
    {
        System.out.printf("%-20s%-20s%-20s\n",Hoten,Ngaysinh,SDT);
    }
}
