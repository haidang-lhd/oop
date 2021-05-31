/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoAn;

/**
 *
 * @author Admin
 */
public class drink extends sanpham {
    public static String LOAISP;

    public drink(String MAHANG, String TENHANG, String NSX, String HSD, String NCC, String LOAI, int SOLUONG, String DONVI) {
        super(MAHANG, TENHANG, NSX, HSD, NCC, LOAI, SOLUONG, DONVI);
        LOAI=LOAISP;
    }
   public drink()
   {
       super();
       LOAI=LOAISP;
   }
    
}
