package ReaderWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Writer {

    private File file;

    public Writer(String Path) throws IOException {
        file = new File(Path);
    }

    public void Write(ArrayList<String> entidade) throws IOException {
        try{
            FileWriter writer = new FileWriter(this.file,true);
            PrintWriter printWriter = new PrintWriter(writer);

            for(int i = 0 ; i < entidade.size() ; i++){
                printWriter.println(entidade.get(i));
            }
            printWriter.println("%");
            printWriter.print("-");
            printWriter.println("");
            printWriter.flush();
            writer.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void WriteAll(ArrayList<String> entidade) throws IOException {
        try{
            FileWriter writer = new FileWriter(this.file,false);
            PrintWriter printWriter = new PrintWriter(writer);

            for(int i = 0 ; i < entidade.size() ; i++){
                printWriter.println(entidade.get(i));
            }
            printWriter.println("");
            printWriter.flush();
            writer.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }

}
