package ReaderWriter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Reader {

    private File file;

    public Reader(String Path) {
        file = new File(Path);
    }

    public ArrayList<String> getFile() throws IOException {
        String data[] = new String[0];
        String currentLine;
        ArrayList<String> returnData = new ArrayList<>();
        int i = 0;

        try{
            FileReader reader = new FileReader(this.file);
            BufferedReader filereader = new BufferedReader(reader);

            while((currentLine = filereader.readLine()) != null){
                returnData.add(currentLine);
                i++;
            }
            filereader.close();
            reader.close();
            return returnData;

        }catch(Exception e){
            System.out.println(e);
        }
        return returnData;

    }
}
