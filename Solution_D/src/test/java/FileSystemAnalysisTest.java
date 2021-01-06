import java.io.IOException;

import static org.junit.Assert.*;

public class FileSystemAnalysisTest {

    @org.junit.Test
    public void mainTest() throws IOException {
        String path = "src/../";
        String directory = "Test_Dir";
        String newDirectory = "Test_Dirs";
        String nameFile = "output.txt";

        FileSystemAnalysis fileAnalysis = new FileSystemAnalysis();

        String[] input = {path, directory, nameFile};
        String[] input2 = {path, newDirectory, nameFile};


        String output = fileAnalysis.main(input);
        String output2 = fileAnalysis.main(input2);

        String wantedOutput = "Test_Dir/ \n" +
                " file_1.jpg\n" +
                " dir_1/ \n" +
                "  dir_1_file_1.jpg\n" +
                "  dir_1_file_2.jpg\n" +
                "  dir_1_1/ \n" +
                " dir_2/ \n" +
                "  dir_2_file_1.jpg\n" +
                "  dir_2_file_2.jpg\n" +
                "  dir_2_1/ \n" +
                "   dir_2_1_file_1.jpg\n";

        assertEquals(output, wantedOutput);
        assertEquals(output2, "Directory not exists\n");

        //Check results in file - "output.txt" in project directory

    }
}