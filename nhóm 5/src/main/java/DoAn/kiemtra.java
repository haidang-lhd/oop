package DoAn;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class kiemtra {

    public static boolean isNumberic(String x) {
        try {
            Double.parseDouble(x);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean date(String x) {
        SimpleDateFormat df = new SimpleDateFormat("dd/mm/yyyy");
        df.setLenient(false);
        try {
            df.parse(x);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public static boolean phone(String x) {
        try {
            String phonePattern = "\\d{10}";
            if (x.matches(phonePattern)) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public static boolean checkName(String x) {
        int i = 0;
        String a;
        for (; i < x.length(); i++) {
            a = String.valueOf(x.charAt(i));
            if (isNumberic(a) == true) {
                return true;
            }
        }
        return false;
    }
    public static boolean checkMNV(String x, File file) {
        BufferedReader f = null;
        String line;
        String[] linenew;
        try {
            f = new BufferedReader(new FileReader(file));
            while ((line = f.readLine()) != null) {
                linenew = line.split(" ");
                if (linenew[0].equals(x)) {
                    return true;
                }
            }
        } catch (IOException e) {

        }
        return false;
    }
}
