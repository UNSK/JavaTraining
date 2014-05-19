package ex20_08;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class FileEntryManager {
    
    /**
     * create a table file with the position of entry.
     * entries separated by lines starting with "%%".
     * the table file name is "<FILENAME>.entry".
     * @param file the read file
     * @throws IOException file is not found or could not read 
     */
    public void createEntriesFile(File in) throws IOException {
        RandomAccessFile rFile = new RandomAccessFile(in, "r");
        File outFile = new File(in.getCanonicalPath() + ".entry");
        RandomAccessFile out = new RandomAccessFile(outFile, "rw");
        String line;
        long pos = 0;
        while ((line = rFile.readLine()) != null) {
            if (line.startsWith("%%")) {
//                System.out.println(pos);
                out.writeLong(pos);
            }
            pos = rFile.getFilePointer();
        }
        out.close();
        rFile.close();
    }
    
    public long getRandomEntryPointer(File entryFile) throws IOException {
        RandomAccessFile rFile = null;
        List<Long> list = new ArrayList<>();
        try {  
            rFile = new RandomAccessFile(entryFile, "r");
            long l;
            while (true) {
                l = rFile.readLong();
                list.add(l);
            }
        } catch (EOFException e) {
//            System.out.println("stop");
            //nop
        } finally {
            rFile.close();
        }
        Random random = new Random();
        int pos = random.nextInt(list.size());
        return list.get(pos);
    }
    
    public static void main(String[] args) throws IOException {
        FileEntryManager fem = new FileEntryManager();
        File file = new File("../ch20/src/ex20_08/alice.txt");
        File entryFile = new File("../ch20/src/ex20_08/alice.txt.entry");
        fem.createEntriesFile(file);
        
        long pos = fem.getRandomEntryPointer(entryFile);
//        System.out.println(pos);
        RandomAccessFile ranFile = new RandomAccessFile(file, "r");
        ranFile.seek(pos);
        System.out.println(ranFile.readLine());
        ranFile.close();
    }
}
