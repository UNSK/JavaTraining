package ex20_09;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileManager {
    
    public void printFileInfo(File... files) {
        for (File f : files) {
            boolean isDirectory = f.isDirectory();
            System.out.println("Name: " + f.getName());
            System.out.print("Type: ");
            if (f.isHidden()) {
                System.out.print("hidden");
            }
            System.out.println(isDirectory ? "directory" : "file");
                
            try {
                System.out.println("Path: " + f.getCanonicalPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
            Date lastModDate = new Date(f.lastModified());
            System.out.println("Last modified: " + lastModDate);
            if (isDirectory) {
                System.out.println("File list:");
                for (String s : f.list())
                    System.out.println("  " + s);
            } else {
                System.out.println("Size: " + f.length() + " bytes");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        FileManager manager = new FileManager();
        File file = new File("../ch20/src/ex20_09/alice.txt");
        File dic = new File("../ch20/src/ex20_09/");
        manager.printFileInfo(file, dic);
    }
}
