package filesys;

import java.util.Arrays;
import java.util.Scanner;

public class Terminal extends FileNavigator {
    public final String USER;
    public final Manual MANUAL = new Manual(clueGame);

    public Terminal() {
        super();
        this.USER = "user@Bash-Terminal";
    }

    public Terminal(Directory ROOT_DIR) {
        super(ROOT_DIR);
        this.USER = "user@Bash-Terminal";
    }

    public Terminal(Directory ROOT_DIR, String USER) {
        super(ROOT_DIR);
        this.USER = USER;
        if (USER.equals("detective@Bash-Detective")) {
            clueGame = true;
        }
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
        if (clueGame && ROOT_DIR.getSubDir("Notebook") == null) {
            if (!args[0].equals("mkdir")) {
                System.out.println("You must create your Notebook before you can begin the game.");
                System.out.println("Do this by typing 'mkdir Notebook'.");
            } else if (!args[1].equals("Notebook")) {
                System.out.println("Oops! Check your spelling. You're trying to make a directory called `Notebook`.");
                System.out.println("Do this by typing 'mkdir Notebook'.");
            }
        } else {
            switch (args[0]) {
                case "cd":
                    if (args.length == 1) {
                        cd();
                    } else if (args.length == 2) {
                        cd(args[1]);
                    } else {
                        printError("cd: extra operand `" + args[2] + "`", "cd");
                    }
                    break;
                case "help":
                    System.out.println("Type `man` to access the manual.");
                    break;
                case "grep":
                    if (args.length > 3) {
                        grep(String.join(" ", Arrays.copyOfRange(args, 1, args.length - 2)), args[args.length - 1]);
                    } else if (validateNumArgs(args, 3, "grep")) {
                        grep(args[1], args[2]);
                    }
                    break;
                case "ls":
                    if (args.length == 1) {
                        ls();
                    } else if (args.length == 2) {
                        ls(args[1]);
                    } else {
                        printError("ls: extra operand `" + args[2] + "`", "ls");
                    }
                    break;
                case "man":
                    if (args.length == 1) {
                        MANUAL.man();
                    } else if (args.length == 2) {
                        MANUAL.man(args[1]);
                    }
                    break;
                case "mkdir":
                    if (validateNumArgs(args, 2, "mkdir")) {
                        mkdir(args[1]);
                    }
                    break;
                case "more":
                    if (validateNumArgs(args, 2, "more")) {
                        more(args[1]);
                    }
                    break;
                case "mv":
                    if (validateNumArgs(args, 3, "mv")) {
                        mv(args[1], args[2]);
                    }
                    break;
                case "pwd":
                    if (validateNumArgs(args, 1, "pwd")) {
                        pwd();
                    }
                    break;
                case "rm":
                    if (validateNumArgs(args, 2, "rm")) {
                        rm(args[1]);
                    }
                    break;
                case "rmdir":
                    if (validateNumArgs(args, 2, "rmdir")) {
                        rmdir(args[1]);
                    }
                    break;
                case "":
                case "exit":
                    break;
                default:
                    printError("Command not found: `" + args[0] + "`", "man");
                    break;
            }
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
}