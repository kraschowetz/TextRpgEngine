public class DialogueInterpreter {
    
    String currentLine;         //variavel que guarda o texto da linha de diálogo atual

    //função que pega a linha de diálogo atual || 6° função a ser executada
    void getDialogueLine(){
        String[] lines = Main.currentText.split("\n");

        for(int i = 0; i < lines.length; i++){
            if(Integer.parseInt(lines[i].split(":")[0]) == Main.dialogueState){
                currentLine = lines[i];
                return;
            }
        }
        currentLine = "0:erro: nao foi possivel achar a linha de dialogo (" + Main.dialogueState +"):1:/okay>0"; 
    }


    //função que atualiza a linha de diálogo e exibe o texto || 5° função a ser executada
    public void updateDialogue(String opt){

        getDialogueLine();      //executa a função que pega linha de diálogo atual

        //começa o processo de evitar erros
        
        try {                                       /***********************************************/
            Integer.parseInt(opt);                  /*verifica se a resposta do usuário é um número*/
        }                                           /***********************************************/
        //caso a resposta não for um numero inteiro:
        catch (NumberFormatException e) {        
            System.out.print("\033[H\033[2J");          // limpa o console
            System.out.flush();                           // limpa o console
           
            System.out.println("erro: NaN");            //exibe a mensagem de erro
            updateDialogue("0");                      //volta a linha de dialogo para a linha 0
            Main.main.update();                           //retorna ao loop de diálogo
            System.out.println("\n\n\n");
            return;
        }

        //lê dentro do txt qual é o limite de opções da linha de diálogo atual
        int optAmmount = Integer.parseInt(currentLine.split(":")[2]);

        //verifica se o número digitado é inválido
        if(Integer.parseInt(opt) < 0 || Integer.parseInt(opt) > optAmmount){
            System.out.print("\033[H\033[2J");                  //limpa o console
            System.out.flush();                                   //limpa o console

            System.out.println("erro: opção invalida");         //exibe a mensagem de erro
            updateDialogue("0");                              //volta a linha de dialogo para a linha 0
            Main.main.update();                                   //retorna ao loop de diálogo
            System.out.println("\n\n\n");
            return;
        }
        //termina o processo de evitar erros

        //caso o numero digitado não seja 0, avança o diálogo baseado na opção selecionada
        if(!opt.equals("0")){
            String options = currentLine.split("/")[1];     //separa as opções de resposta da linha atual
            int selectedOption = Integer.parseInt(opt) - 1;       //guarda a resposta selecionada como uma int
            String subOpt = options.split(":")[selectedOption];             //sepera a opção selecionada
            Main.dialogueState = Integer.parseInt(subOpt.split(">")[1]);    //muda a variavel da linha de dialogo
            getDialogueLine();      //atualiza a linha de dialogo a ser lida
            optAmmount = Integer.parseInt(currentLine.split(":")[2]);//verifica qnts resposta existem para o dialogo

            //verifica se a linha atual não possui nenhuma flag
            if(currentLine.split("/").length > 2){
                Main.flagInterpreter.interpretFlag(currentLine.split("/")[2]);
            }

        }

        //exibe o texto da linha de diálogo atual
        System.out.println("\n" + currentLine.split(":")[1]);

        //exibe as opções possiveis para a linha de dialogo atual
        for(int i = 0; i < optAmmount; i++){        //para cada numero entre 0 e quantidade de respostas:
            String[] options = currentLine.split("/")[1].split(":");    //separa o texto da opção X
            System.out.println((i + 1) + ") " + options[i].split(">")[0]);    //exibe o texto da opção X
        }
        
    }

}
