public class Main{

    public static FileManager fileReader;

    public static String currentText = "";

    public static void main(String args[]){
        fileReader = new FileManager();
        fileReader.readFile("Dialogues/teste.txt");

        System.out.println(currentText);
    }

}