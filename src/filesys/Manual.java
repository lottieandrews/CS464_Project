package filesys;

public class Manual {

    private boolean clueGame;

    public Manual(boolean clueGame) {
        this.clueGame = clueGame;
    }

    public void man() {
        System.out.println("\n" +
                           "MAN: ACCESS THE MANUAL\n" +
                           "\n" +
                           "Command Input:\n" +
                           "man [COMMAND]\n" +
                           "\n" +
                           "Use the `man` command followed by a command name to access information about that command.\n" +
                           "Supported commands: cd, exit, grep, ls, mkdir, more, mv, pwd, rm, rmdir\n");
    }

    public void man(String command) {
        switch (command) {
            case "cd":
                System.out.println("\n" +
                                   "CD: CHANGE DIRECTORY\n" +
                                   "\n" +
                                   "Command Input:\n" +
                                   "cd\n" +
                                   "cd [DIRECTORY]\n" +
                                   "\n" +
                                   "Move from one directory location to another.\n" +
                                   "Type `cd` to return to the home directory.\n" +
                                   "Type `cd ..` to return to the parent of the current directory.\n" +
                                   "Type `cd` followed by the name of any directory inside of the current directory to move there.\n");
                break;
            case "exit":
                System.out.println("\n" +
                                   "EXIT: EXIT THE PROGRAM\n" +
                                   "\n" +
                                   "Command Input:\n" +
                                   "exit\n" +
                                   "\n" +
                                   "Exit the terminal.\n");
                break;
            case "grep":
                System.out.println("\n" +
                                   "GREP: SEARCH INSIDE A FILE\n" +
                                   "\n" +
                                   "Command Input:\n" +
                                   "grep [WORD] [FILE]\n" +
                                   "\n" +
                                   "Type `grep` followed by any word and the name of a file in your current directory to search for that word inside of the file.\n" +
                                   "This command will return all lines in the specified file which contain the specified word.\n");
                if (clueGame) {
                    System.out.println("In this game, you can only use the `grep` command to search for a single word (no spaces are allowed). If one of your answers contains two words, search for it as follows:\n" +
                            "- If the name of the room contains two words (e.g., 'Game Room'), search only for the first word (e.g., 'Game').\n" +
                            "- All of the suspect names contain a title followed by a surname (e.g., 'Mr. Smith'). Search only for the surname (e.g., 'Smith').");
                }
                break;
            case "ls":
                System.out.println("\n" +
                                   "LS: LIST DIRECTORY CONTENTS\n" +
                                   "\n" +
                                   "Command Input:\n" +
                                   "ls\n" +
                                   "ls [DIRECTORY]\n" +
                                   "\n" +
                                   "Type `ls` to list the contents of the current directory.\n" +
                                   "Type `ls` followed by the name of a directory to list the contents of that directory.\n" +
                                   "Type `ls ..` to list the contents of the parent directory.\n");
                break;
            case "man":
                man();
                break;
            case "mkdir":
                System.out.println("\n" +
                                   "MKDIR: MAKE DIRECTORY\n" +
                                   "\n" +
                                   "Command Input:\n" +
                                   "mkdir [DIRECTORY]\n" +
                                   "\n" +
                                   "Type `mkdir` followed by your desired directory name to create a new directory.\n");
                break;
            case "more":
                System.out.println("\n" +
                                   "MORE: VIEW FILE CONTENTS\n" +
                                   "\n" +
                                   "Command Input:\n" +
                                   "more [FILE]\n" +
                                   "\n" +
                                   "Type `more` followed by the name of a file view the contents of that file.\n");
                break;
            case "mv":
                System.out.println("\n" +
                                   "MV: MOVE OR RENAME\n" +
                                   "\n" +
                                   "Command Input:\n" +
                                   "mv [FILE] [FILE]\n" +
                                   "mv [FILE OR DIRECTORY] [DIRECTORY]\n" +
                                   "\n" +
                                   "Renaming a file or directory:\n" +
                                   "Type `mv` followed by the file or directory you wish to rename, followed by the new name.\n" +
                                   "\n" +
                                   "Moving a file or directory into another directory:\n" +
                                   "Type `mv` followed by the name of the file or directory you wish to move, followed by the name of the destination directory.\n");
                break;
            case "pwd":
                System.out.println("\n" +
                                   "PWD: PRINT CURRENT DIRECTORY\n" +
                                   "\n" +
                                   "Command Input:\n" +
                                   "pwd\n" +
                                   "\n" +
                                   "Type `pwd` to view the name of your current directory.\n");
                break;
            case "rm":
                System.out.println("\n" +
                                   "RM: REMOVE A FILE\n" +
                                   "\n" +
                                   "Command Input:\n" +
                                   "rm [FILE]\n" +
                                   "\n" +
                                   "Type `rm` followed by the name of a file to delete that file.\n");
                break;
            case "rmdir":
                System.out.println("\n" +
                                   "RMDIR: REMOVE EMPTY DIRECTORY\n" +
                                   "\n" +
                                   "Command Input:\n" +
                                   "rmdir [DIRECTORY]\n" +
                                   "\n" +
                                   "Type `rmdir` followed by the name of a directory to delete that directory.\n");
                break;
            default:
                System.out.println("Command not supported: " + command);
                System.out.println("Type `man` for a list of supported commands.");
                break;
        }
    }
}
