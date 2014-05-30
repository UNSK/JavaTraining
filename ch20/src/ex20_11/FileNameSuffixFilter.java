package ex20_11;

import java.io.File;
import java.io.FilenameFilter;

public class FileNameSuffixFilter implements FilenameFilter {

    private final String suffix;
    
    public FileNameSuffixFilter(String suffix) {
        this.suffix = suffix;
    }
    
    @Override
    public boolean accept(File dir, String name) {
        return name.endsWith(suffix);
    }

    public static void main(String[] args) {
        if (args.length != 2) 
            throw new IllegalArgumentException("input 2 arguments");
        File dir = new File(args[0]);
        if (!dir.isDirectory()) 
            throw new IllegalArgumentException("file is not directory.");
        String[] files = dir.list(new FileNameSuffixFilter(args[1]));
        System.out.println(files.length + " file(s)");
        for (String s : files) {
            System.out.println("  " + s);
        }
    }

}
