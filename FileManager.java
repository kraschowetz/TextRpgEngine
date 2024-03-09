import java.io.BufferedReader; //importa a classe que pega o arquivo
import java.io.FileReader; //importa a classe que le o arquivo como texto
import java.io.IOException; //importa a classe que gerencia os erros

public class FileManager {
    
    public String key; //

    public void readFile(String path){
        try{
            FileReader file = new FileReader(path);
            BufferedReader reader = new BufferedReader(file);

            String line = reader.readLine(); // line é a próxima linha a ser lida pelo FileReader

            while( line != null){
                key += line + "\n";
                line = reader.readLine();
            }

            reader.close();
            Main.currentText = key;
        } 
        catch(IOException e){
            e.printStackTrace();
        }
    }

}
