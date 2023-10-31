
package common;

import java.io.File;
import java.util.Scanner;


public class Library {
    static Scanner sc = new Scanner(System.in);
    public int inputIntLimit(int min, int max) {
        while (true) {
            try {
                System.out.print("Enter your choice: ");
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in rage [" + min + ", " + max + "]");
                
            }
        }
    }
    
    public String getString(String mes) {
        System.out.print(mes);
        return sc.nextLine();
    }
    
    public String checkInputPathFile(String promt) {
        System.out.print(promt);
        while (true) {
            String result = sc.nextLine().trim();
            File file = new File(result);
            if (!file.exists() || !file.isFile()) {
                System.err.println("Path doesn't exist!!!");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }
}
