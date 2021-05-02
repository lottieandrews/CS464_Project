


public class Manual {

    public void man() {
        System.out.println("""

                MAN: ACCESS THE MANUAL

                Command Input:
                man [COMMAND]

                Use the `man` command followed by a command name to access information about that command.
                Supported commands: cd, exit, grep, ls, mkdir, more, mv, pwd, rm, rmdir
                """);
    }

    public void man(String command) {
        switch (command) {
            case "cd":
                System.out.println("""
                        
                        CD: CHANGE DIRECTORY
                        
                        Command Input:
                        cd
                        cd [DIRECTORY]

                        Move from one directory location to another.
                        Type `cd` to return to the home directory.
                        Type `cd ..` to return to the parent of the current directory.
                        Type `cd` followed by the name of any directory inside of the current directory to move there.
                        """);
                break;
            case "exit":
                System.out.println("""
                        
                        EXIT: EXIT THE PROGRAM
                        
                        Command Input:
                        exit
                        
                        Exit the terminal.
                        """);
                break;
            case "grep":
                System.out.println("""
                        
                        GREP: SEARCH INSIDE A FILE
                        
                        Command Input:
                        grep [WORD] [FILE]

                        Type `grep` followed by any word and the name of a file in your current directory to search for that word inside of the file.
                        This command will return all lines in the specified file which contain the specified word.
                        """);
                break;
            case "ls":
                System.out.println("""
                            
                            LS: LIST DIRECTORY CONTENTS
                            
                            Command Input:
                            ls
                            ls [DIRECTORY]
                            
                            Type `ls` to list the contents of the current directory.
                            Type `ls` followed by the name of a directory to list the contents of that directory.
                            Type `ls ..` to list the contents of the parent directory.
                            """);
                break;
            case "man":
                man();
                break;
            case "mkdir":
                System.out.println("""
                        
                        MKDIR: MAKE DIRECTORY
                        
                        Command Input:
                        mkdir [DIRECTORY]
                        
                        Type `mkdir` followed by your desired directory name to create a new directory.
                        """);
                break;
            case "more":
                System.out.println("""
                        
                        MORE: VIEW FILE CONTENTS
                        
                        Command Input:
                        more [FILE]
                        
                        Type `more` followed by the name of a file view the contents of that file.
                        """);
                break;
            case "mv":
                System.out.println("""
                        
                        MV: MOVE OR RENAME
                        
                        Command Input:
                        mv [FILE] [FILE]
                        mv [FILE OR DIRECTORY] [DIRECTORY]
                        
                        Renaming a file or directory:
                        Type `mv` followed by the file or directory you wish to rename, followed by the new name.
                        
                        Moving a file or directory into another directory:
                        Type `mv` followed by the name of the file or directory you wish to move, followed by the name of the destination directory.
                        """);
                break;
            case "pwd":
                System.out.println("""
                        
                        PWD: PRINT CURRENT DIRECTORY
                        
                        Command Input:
                        pwd
                        
                        Type `pwd` to view the name of your current directory.
                        """);
                break;
            case "rm":
                System.out.println("""
                        
                        RM: REMOVE A FILE
                        
                        Command Input:
                        rm [FILE]
                        
                        Type `rm` followed by the name of a file to delete that file.
                        """);
                break;
            case "rmdir":
                System.out.println("""
                        
                        RMDIR: REMOVE EMPTY DIRECTORY
                        
                        Command Input:
                        rmdir [DIRECTORY]
                        
                        Type `rmdir` followed by the name of a directory to delete that directory.
                        """);
                break;
            default:
                System.out.println("Command not supported: " + command);
                System.out.println("Type `man` for a list of supported commands.");
                break;
        }
    }
}
