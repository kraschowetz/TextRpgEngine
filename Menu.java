import java.util.Scanner;

public class Menu {
    
    Scanner scan;               //variavel do scanner
    String state = "0";         //variavel que guarda o estado do menu
    Boolean closed = false;     //variavel que guarda se o menu esta fechado

    public Menu(Scanner _scan){
        scan = _scan;

        do{

            switch (state) {
                case "0":   //estado inicial do menu
                    System.out.println("\nBEM VINDO AO JOGO!");
                    System.out.println("\n1-instruções\n2-jogar\n3-creditos\n4-sair");
                    state = scan.nextLine();
                    break;
                    //exibe a mensagem de titulo
                
                case "1":   //estado "instruções"
                    System.out.println("\nLeia os textos, digite os numeros de 1-9 para selecionar a opção de diálogo escolhida");
                    scan.nextLine();
                    state = "0";
                    break;
                    //exibe as intruções, espera um input e volta para o estado inicial

                case "2":   //estado "jogar"
                    System.out.print("\033[H\033[2J");
                    System.out.flush(); 

                    closed = true;

                    Main.main.initDialogueLoop();
                    //limpa o console, inicia o loop de dialogo, fecha o scanner

                case "3":   //estado "créditos"
                    System.out.println("\nfeito por: João Pedro Kraschowetz Souza e Maria Fernanda Silva Leite");
                    scan.nextLine();
                    state = "0";
                    break;
                    //mostra os creditos, espera um input e volta para o estado inicial

                default:    //estado padrão (usado em erros ou na opção "sair")
                    scan.close();
                    closed = true;
                    break;
                    //fecha o scanner, fecha o menu
            }

        }while(!closed);
    }

}
