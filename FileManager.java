import java.io.BufferedReader; //importa a classe que pega o arquivo
import java.io.FileReader; //importa a classe que le o arquivo como texto
import java.io.IOException; //importa a classe que gerencia os erros

public class FileManager {
    
    public String text =  ""; //text guarda todo o texto do arquivo lido como uma string

    public void readFile(String path){
        // tenta executar o seguinte:
        try{ 

            FileReader file = new FileReader(path);                 //FileReader pega o arquivo bruto
            BufferedReader reader = new BufferedReader(file);       // BufferedReader lê o arquivo como texto

            String line = reader.readLine(); // line é a próxima linha a ser lida pelo FileReader

            while( line != null){
                text += line + "\n";
                line = reader.readLine();
            }

            reader.close();
            Main.currentText = text;

        } 
        //caso aconteça um erro (por exemplo não conseguir ler o arquivo) exibe a mensagem de erro
        catch(IOException e){
            e.printStackTrace();
            System.out.println("ocorreu um erro :(");
        }
    }

}

/* 
    LÓGICA:

    texto = ""

    função readFIle(requer caminho do arquivo){
        se arquivo existir{
            ler arquivo como texto;
            String linha = texto.próxima linha
            enquanto houver uma próxima linha{
                linha += texto da próxima linha
                ler a próxima linha
            }
            fechar arquivo
        }
        se não{
            exibir mensagem de erro
        }
    }

*/ 