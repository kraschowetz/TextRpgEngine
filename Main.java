import java.util.Scanner;

public class Main{

    public static FileManager fileReader;

    public static String currentText = "";
    public static int dialogueState = 0;

    public Scanner scan;
    public DialogueInterpreter interpreter;
    public static Main main;

    public static void main(String args[]){
        fileReader = new FileManager();
        fileReader.readFile("Dialogues/teste.txt");

        //System.out.println(currentText);

        main = new Main();
        main.initDialogueLoop();
    }

    public Main(){
        interpreter = new DialogueInterpreter();
        scan = new Scanner(System.in);
    }

    public void initDialogueLoop(){
        interpreter.updateDialogue("0");
        update();
    }

    public void update(){
        String opt = scan.nextLine();
        interpreter.updateDialogue(opt);
        if(dialogueState >= 0){
            update();
        }
    }

}