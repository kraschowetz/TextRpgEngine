import java.util.Scanner;

public class Main{

    public static FileManager fileReader;           //guarda a classe que vai ler os arquivos com os dialogos
    public static FlagInterpreter flagInterpreter;  //guarda a classe que interpreta as flags dos dialogos
    public static Main main;                        //guarda uma versão desse script
    public static Menu menu;                        //guarda a classe do menu

    public static String currentText = "";      //guarda o texto bruto do dialogo atual como uma String
    public static int dialogueState = 0;        //quarga qual é a linha de dialogo atual

    public Scanner scan;                        //guarda o scanner
    public DialogueInterpreter interpreter;     // guarda a classe que interpreta o dialogo
    


    //1° função a ser executada
    public static void main(String args[]){

        fileReader = new FileManager();                      //instancia a classe que lê os arquivos com os dialogos
        fileReader.readFile("Dialogues/teste.txt");     //executa a função de ler o dialogo de um .txt
        flagInterpreter = new FlagInterpreter();             //instancia a classe que interpreta as flags

        main = new Main();                                   //instancia o objeto com esse script
        menu = new Menu(main.scan);
        //main.initDialogueLoop();                             //executa a função que inicia o loop do dialogo   
    }

    //método construtor || 3° função a ser executada
    public Main(){
        interpreter = new DialogueInterpreter();        //instancia o interpretador de dialogo
        scan = new Scanner(System.in);                  //instancia o scanner
        /*
        essa função só existe para que a variavel do scanner e interpretador não sejam estáticas.
         */
    }

    //função que inicia o loop de dialogo || 4° função a ser executada
    public void initDialogueLoop(){
        interpreter.updateDialogue("0"); //faz o interpretador de diálogo exibir a 1° linha de diálogo
        update(); //executa a função que atualiza o diálogo
    }

    //função que atualiza o diálogo || 7° função a ser executada 
    public void update(){
        String opt = scan.nextLine();           //lê a próxima linha com o scanner
        interpreter.updateDialogue(opt);        //faz o interpretador de diálogo atualizar o dialogo com base na variavel "opt"
        
        //enquanto a linha atual do diálogo tiver um id maior que 0 ele atualiza o diálogo em loop
        if(dialogueState >= 0){
            update();
        }
    }

}