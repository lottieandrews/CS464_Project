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
        String[] args = in.trim().split(" ");
        switch(args[0]) {
            case "cd":
                if (args.length == 1) { cd(); }
                else if (args.length == 2) { cd(args[1]); }
                else {
                    printError("cd: extra operand `" + args[2] + "`", "cd");
                }
                break;
            case "exit":
                break;
            case "grep":
                break;
            case "ls":
                break;
            case "man":
                man();
                break;
            case "mkdir":
                break;
            case "more":
                break;
            case "mv":
                break;
            case "pwd":
                break;
            case "rm":
                break;
            case "":
                break;
            default:
                printError("Command not found: " + args[0], "man");
                break;
        }
    }

    private void printError(String errorMessage, String command) {
        System.out.println(errorMessage);
        if (command.equals("man")) {
            System.out.println("Stuck? Type `man` for more information.");
        }
        else {
            System.out.println("Stuck? Type `man " + command + "` for more information.");
        }
    }

    public static void main(String[] args) {
        GroceryList gl = new GroceryList();
        Terminal tr = new Terminal(gl.gl);
        tr.launch();
    }
}