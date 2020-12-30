import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileSystemAnalysis {

    private static List<File> files = new ArrayList<File>();
    private static List<String> filesPlus = new ArrayList<String>();

    public static void main(String[] args) {
        String nameFile = args[2];
        try(FileWriter writer = new FileWriter(nameFile, false))
        {
            String parent = args[0];
            String child = args[1];
            getSubFiles(files, filesPlus, new File(parent, child), "");
            
            StringBuilder sb = new StringBuilder();
            int k = 0;
            for (Object file : files.toArray()) {

                if (((File) file).isDirectory()) {
                    writer.append(filesPlus.get(k) + ((File) file).getName() + "/ \n");
                } else {

                    writer.append(filesPlus.get(k) + ((File) file).getName() + "\n");
                }
                k++;
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void getSubFiles(List<File> source, List<String> sourcePlus, File parent, String plus) {
        List<File> dir = new ArrayList<File>();
        if (!source.contains(parent)) {
            source.add(parent);
            sourcePlus.add(plus);
        }
        File[] listFiles = parent.listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file : listFiles) {
            if (file.isDirectory()) {
                dir.add(file);
            } else {
                if (!source.contains(file)) {
                    source.add(file);
                    sourcePlus.add(plus + " ");
                }
            }
        }
        String newPlus = plus + " ";
        for (File file : dir) {
            getSubFiles(source, sourcePlus, file, newPlus);
        }

    }
}
