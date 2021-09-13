import java.io.*;
class Maker {
    public static void main(String [] args){
        File dir = new File("dir");
        File f = new File(dir, "f");
        f = null;
        System.out.println(f);
    }
}