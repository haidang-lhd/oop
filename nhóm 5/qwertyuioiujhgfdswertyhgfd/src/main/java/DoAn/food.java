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
public class food extends sanpham {
    public static String LOAISP="Food";

    public food(String MAHANG, String TENHANG, String NSX, String HSD, String NCC, String LOAI, int SOLUONG, String DONVI) {
        super(MAHANG, TENHANG, NSX, HSD, NCC, LOAI, SOLUONG, DONVI);
        LOAI=LOAISP;
    }
    public food(){
        super();
        LOAI=food.LOAISP;
    }
  
    
}
