/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoAn;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 *
 * @author Admin
 */
public class Admin extends Account {

    File file = new File("admin.txt");
    String line;
    String[] linenew;

    public boolean dangnhap(String x, String y) {
        String line;
        String[] linenew;
        BufferedReader f = null;
        try {
            f = new BufferedReader(new FileReader(file));
            while ((line = f.readLine()) != null) {
                linenew = line.split(" ");
                if (x.equals(linenew[0]) && y.equals(linenew[1])) {
                    System.out.println("Ban da dang nhap thanh cong");
                    return true;
                }
            }
        } catch (Exception e) {
        }
        System.out.println("Sai!!Vui long nhap lai");
        return false;
    }


}
