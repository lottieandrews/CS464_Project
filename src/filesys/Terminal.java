package filesys;
import assessment.GroceryList;

import java.util.Scanner;

public class Terminal extends FileNavigator {

    public final String USER;
    private Scanner scnr = new Scanner(System.in);

    public Terminal() {
        super();
        this.USER = "user@Bash-Terminal";
    }

    public Terminal(Directory ROOT_DIR) {
        super(ROOT_DIR);
        this.USER = "user@Bash-Terminal";
    }

    public Terminal(String USER, Directory ROOT_DIR) {
        super(ROOT_DIR);
        this.USER = USER;
    }

    public void launch() {
        Scanner s = new Scanner(System.in);
        System.out.print(USER + ":" + currentDir.getName() + " % ");
        while(s.hasNextLine()) {
            String in = s.nextLine();
            if (in.equals("exit")) {
                break;
            }
            else {
                processUserInput(in);
                System.out.print(USER + ":" + currentDir.getName() + " % ");
            }
        }
        s.close();
        System.out.println("\n[Process completed]");
        System.out.println("Rerun the program to access a new terminal window.");
    }

    public void processUserInput(String in) {
        String[] args = in.split(' ');
        switch(args[0]) {
            case "cat":
                break;
            case "cd":
                break;
            case "grep":
                break;
            case "ls":
                break;
            case "mkdir":
                break;
            case "mv":
                break;
            case "pwd":
                break;
            case "rm":
                break;
            default:
                break;
        }
    }

    public static void main(String[] args) {
        GroceryList gl = new GroceryList();
        Terminal tr = new Terminal(gl.gl);
        tr.launch();
    }
}