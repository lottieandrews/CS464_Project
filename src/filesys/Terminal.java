package filesys;
import assessment.GroceryList;

import java.util.Arrays;
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
            case "grep":
                if (args.length > 3) {
                    grep(String.join(" ", Arrays.copyOfRange(args, 1, args.length - 2)), args[args.length-1]);
                }
                else if (validateNumArgs(args, 3, "grep")) {
                    grep(args[1], args[2]);
                }
                break;
            case "ls":
                if (args.length == 1) { ls(); }
                else if (args.length == 2) { ls(args[1]); }
                else {
                    printError("ls: extra operand `" + args[2] + "`", "ls");
                }
                break;
            case "man":
                if (args.length == 1) { man(); }
                else if (args.length == 2) { man(args[1]); }
                break;
            case "mkdir":
                if (validateNumArgs(args, 2, "mkdir")) { mkdir(args[1]); }
                break;
            case "more":
                if (validateNumArgs(args, 2, "more")) { more(args[1]); }
                break;
            case "mv":
                if (validateNumArgs(args, 3, "mv")) { mv(args[1], args[2]); }
                break;
            case "pwd":
                if (validateNumArgs(args, 1, "pwd")) { pwd(); }
                break;
            case "rm":
                if (validateNumArgs(args, 2, "rm")) { rm(args[1]); }
                break;
            case "":
            case "exit":
                break;
            default:
                printError("Command not found: " + args[0], "man");
                break;
        }
    }

    //Use if a command may only be followed by one specific number of arguments.
    private boolean validateNumArgs(String[] args, int validNum, String command) {
        if (args.length == validNum) {
            return true;
        }
        else if (args.length < validNum) {
            printError(command + ": missing operand after `" + args[args.length - 1] + "`", command);
            return false;
        }
        else {
            printError(command + ": extra operand `" + args[validNum] + "`", command);
            return false;
        }
    }

    private void printError(String errorMessage, String command) {
        System.out.println(errorMessage);
        if (command.equals("man")) {
            System.out.println("Need help? Type `man` for more information.");
        }
        else {
            System.out.println("Need help? Type `man " + command + "` for more information.");
        }
    }

    public static void main(String[] args) {
        GroceryList gl = new GroceryList();
        Terminal tr = new Terminal(gl.gl);
        tr.launch();
    }
}