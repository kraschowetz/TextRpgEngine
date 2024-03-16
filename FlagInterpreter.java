public class FlagInterpreter {
    
    public void interpretFlag(String flag){
        switch (flag) {
            case "flag goes here":
                System.out.println("default flag reached");
                break;
            case "flush":
                System.out.println("\033[H\033[2J");
                System.out.flush();
            default:
                break;
        }
    }

}
