public class DialogueInterpreter {
    
    String currentLine;

    void getDialogueLine(){
        String[] lines = Main.currentText.split("\n");

        for(int i = 0; i < lines.length; i++){
            if(Integer.parseInt(lines[i].split(":")[0]) == Main.dialogueState){
                currentLine = lines[i];
                return;
            }
        }
        currentLine = "0:can not find line error (" + Main.dialogueState +"):1:/okay>0"; 
    }

    public void updateDialogue(String opt){
        getDialogueLine();

        //failsafe-start
        try {
            Integer.parseInt(opt);
        } catch (NumberFormatException e) {
            System.out.println("NaN error");
            updateDialogue("0");
            Main.main.update();
            System.out.println("\n\n\n");
            return;
        }
        int optAmmount = Integer.parseInt(currentLine.split(":")[2]);
        if(Integer.parseInt(opt) < 0 || Integer.parseInt(opt) > optAmmount){
            System.out.println("invalid option error");
            updateDialogue("0");
            Main.main.update();
            System.out.println("\n\n\n");
            return;
        }
        //failsafe-end

        if(!opt.equals("0")){
            String options = currentLine.split("/")[1];
            int selectedOption = Integer.parseInt(opt) - 1;
            String subOpt = options.split(":")[selectedOption];
            Main.dialogueState = Integer.parseInt(subOpt.split(">")[1]);
            getDialogueLine();
            optAmmount = Integer.parseInt(currentLine.split(":")[2]);
        }
        System.out.println("\n" + currentLine.split(":")[1]);

        for(int i = 0; i < optAmmount; i++){
            String[] options = currentLine.split("/")[1].split(":");
            System.out.println((i + 1) + ") " + options[i].split(">")[0]);
        }
        
    }

}
