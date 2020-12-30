import static org.junit.Assert.*;

public class FileSystemAnalysisTest {

    @org.junit.Test
    public void mainTest() {
        String path = "src/../";
        String directory = "Test_Dir";
        String nameFile = "output.txt";

        FileSystemAnalysis fileAnalysis = new FileSystemAnalysis();

        String[] input = {path, directory, nameFile};


        fileAnalysis.main(input);

        //Check results in file - "output.txt" in project directory

    }
}