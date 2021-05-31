
package DoAn;

import java.util.Scanner;
public class MAIN {
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        String d;
        System.out.println("Ban muon dang nhap voi vai tro gi ?");
        System.out.println("0-Thoat chuong trinh");
        System.out.println("1-Admin");
        System.out.println("2-User");
        System.out.println("====================================");
        System.out.print("HAY NHAP LUA CHON :");
        d = input.nextLine();
        while (kiemtra.isNumberic(d) != true) {
            System.out.println("Sai!");
            System.out.print("HAY NHAP LUA CHON (bang so): ");
            d = input.nextLine();
        }
        int ktt=0;
        while (1 == 1) {
            switch (d) {
                case "0": {
                    return;
                }
                case "1": {
                    while(ktt!=1){
                    Admin d2 = new Admin();
                    System.out.print("Tai khoan :");
                    String taikhoan = input.nextLine();
                    System.out.print("Mat khau :");
                    String matkhau = input.nextLine();
                    if (d2.dangnhap(taikhoan, matkhau) == true) {
                        System.out.println("Xin chao admin");
                        System.out.println("0-Thoat");
                        System.out.println("1-Quan ly nhan vien");
                        System.out.println("2-Quan ly khach hang");
                        System.out.println("3-Quan li san pham");
                        System.out.println("4-Quan li hoa don");
                        System.out.println("5-Quan li phieu nhap");
                        System.out.println("6-Quan li phieu xuat");
                        System.out.print("HAY NHAP LUA CHON :");
                        String d3 = input.nextLine();
                        while (d3!="0") {
                            switch (d3) {
                                case "0":{
                                    ktt=1;
                                    break;
                                }
                                case "1": {
                                    dsNhanvien d7 = new dsNhanvien();
                                    d7.docFile();
                                    System.out.println("1-Xuat danh sach nhan vien");
                                    System.out.println("2-Thao tac tren danh sach nhan vien ");
                                    System.out.print("HAY NHAP LUA CHON :");
                                    String d5 = input.nextLine();
                                    while (kiemtra.isNumberic(d5) != true) {
                                        System.out.println("Sai!");
                                        System.out.print("HAY NHAP LUA CHON (bang so): ");
                                        d5 = input.nextLine();
                                    }
                                    int d6 = Integer.valueOf(d5);
                                    switch (d6) {
                                        case 1: {
                                            System.out.println("Danh sach nhan vien ");
                                            d7.xuatds();
                                        }
                                        break;
                                        case 2: {
                                            d7.thaotac();
                                        }
                                        break;
                                    }
                                }
                                break;
                                case "2": {
                                    System.out.println("Quan li khach hang");
                                    dsKhachHang d8 = new dsKhachHang();
                                    d8.docFile();
                                    System.out.println("1-Xuat danh sach khach hang");
                                    System.out.println("2-Thao tac tren danh sach khach hang");
                                    System.out.println("HAY NHAP LUA CHON :");
                                    String d9 = input.nextLine();
                                    while (kiemtra.isNumberic(d9) != true) {
                                        System.out.println("Sai!");
                                        System.out.println("Sai!");
                                        System.out.print("HAY NHAP LUA CHON (bang so): ");
                                        d9 = input.nextLine();
                                    }
                                    int d10 = Integer.valueOf(d9);
                                    switch (d10) {
                                        case 1: {
                                            System.out.println("Danh sach khach hang ");
                                            d8.xuatds();
                                        }
                                        break;
                                        case 2: {
                                            d8.thaotac();
                                        }
                                        break;
                                    }
                                }
                                break;
                                case "3": {
                                    dssanpham d10 = new dssanpham();
                                    d10.docFile();
                                    System.out.println("QUAN LY SAN PHAM");
                                    System.out.println("1-Xuat danh sach san pham");
                                    System.out.println("2-Them san pham");
                                    System.out.println("3-Xoa san pham");
                                    String d11 = input.nextLine();
                                    while (kiemtra.isNumberic(d11) == false) {
                                        System.out.println("Sai!");
                                        d11 = input.nextLine();
                                    }
                                    int d12 = Integer.valueOf(d11);
                                    switch (d12) {
                                        case 1: {
                                            d10.xuat();
                                        }
                                        break;
                                        case 2: {
                                            d10.add();
                                        }
                                        break;
                                        case 3: {
                                            d10.delete();
                                        }
                                        break;
                                    }
                                }
                                break;
                                case "4": {
                                    dsHoadon d11 = new dsHoadon();
                                    chitiethoadon d15 = new chitiethoadon();
                                    d11.docFile();
                                    System.out.println("1-Xuat hoa don");
                                    System.out.println("2-Them hoa don");
                                    System.out.println("3-Chinh sua hoa don");
                                    String d12 = input.nextLine();
                                    while (kiemtra.isNumberic(d12) != true) {
                                        System.out.println("Sai!");
                                        System.out.println("Hay nhap lai");
                                        d12 = input.nextLine();
                                    }
                                    int d13 = Integer.valueOf(d12);
                                    switch (d13) {
                                        case 1: {
                                            d11.xuat();
                                        }
                                        break;
                                        case 2: {
                                            System.out.println("Nhap ma hoa don");
                                            String d14 = input.nextLine();
                                            d11.add(d14);
                                        }
                                        break;
                                        case 3: {
                                          
                                        }
                                        break;
                                    }
                                }
                                break;
                                case "5": {
                                    dsPhieunhap d19 = new dsPhieunhap();
                                    dschitietphieunhap d16 = new dschitietphieunhap(); //change
                                    d19.docFile();
                                    System.out.println("1-Xuat phieu nhap");
                                    System.out.println("2-Them phieu nhap");
                                    System.out.println("3-Xuat chi tiet phieu nhap");
                                    String d17 = input.nextLine();
                                    while (kiemtra.isNumberic(d17) != true) {
                                        System.out.println("Sai!!!!!!!!!!");
                                        System.out.println("1-Xuat phieu nhap");
                                        System.out.println("2-Them phieu nhap");
                                        System.out.println("3-Xuat chi tiet phieu nhap");
                                        d17 = input.nextLine();

                                    }
                                    while (kiemtra.isNumberic(d17) == true) {
                                        int d18 = Integer.valueOf(d17);
                                        switch (d18) {
                                            case 1: {
                                                System.out.println("Danh sach phieu nhap");
                                                d19.xuat();
                                            }
                                            break;
                                            case 2: {
                                                System.out.println("Hay nhap vao ma phieu nhap moi");
                                                String d20 = input.nextLine();
                                                d19.add(d20); //change
                                                d16.xuat(d20);
                                            }
                                            break;
                                            case 3: {
                                                System.out.println("Hay nhap vao ma phieu nhap can xem");
                                                String d21 = input.nextLine();
                                                d16.docfile();
                                                d16.xuat(d21); //change
                                            }
                                            break;
                                            default: {
                                                break;
                                            }
                                        }
                                    }
                                }
                                break;
                                default: {
                                    System.out.println("Sai!Vui long nhap lai");
                                    d3 = input.nextLine();
                                }
                            }
                            if(ktt==1)
                            {
                                break;
                            }
                        }
                    }
                    else 
                    {
                        System.out.println("Ban da nhap sai mk hoac ten tk!");
                        System.out.println("Ban muon thoat khong?Y/N");
                        String kt=input.nextLine();
                        if(kt.equals("Y")||kt.equals("y"))
                        {
                            ktt=1;
                        }
                        else 
                            continue;
                    }
                    }
                    System.out.println("Ban muon vao che do User khong?Y/N");
                    String kt=input.nextLine();
                    if(kt.equals("y")||kt.equals("Y"))
                    {
                        
                    }
                    else 
                        return;
                }          
                case "2": {
                    System.out.println("CHE DO USER");
                    User d99 = new User();
                    System.out.print("Tai khoan :");
                    String taikhoan = input.nextLine();
                    System.out.print("Mat khau : ");
                    String matkhau = input.nextLine();
                    if (d99.dangnhap(taikhoan, matkhau) == true) {
                        System.out.print("Tai khoan :");
                        taikhoan = input.nextLine();
                        System.out.print("Mat khau : ");
                        matkhau = input.nextLine();
                    }

                }
                break;
                default: {
                    System.out.println("SAI!Vui Long Nhap Lai");
                    d = input.nextLine();
                }
            }
        }
    }
}
