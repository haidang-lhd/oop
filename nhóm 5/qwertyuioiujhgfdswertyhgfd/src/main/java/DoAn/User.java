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
public class User {

    File file = new File("user.txt");
    BufferedReader f = null;
    String line;
    String[] linenew;

    public boolean dangnhap(String x, String y) {
        BufferedReader f = null;
        try {
            f = new BufferedReader(new FileReader(file));
            while ((line = f.readLine()) != null) {
                linenew = line.split(" ");
                if (x == linenew[0] && y == linenew[1]) {
                    System.out.println("Ban da dang nhap thanh cong ");
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println("ERROR " + e);
        }
        return false;
    }
}
