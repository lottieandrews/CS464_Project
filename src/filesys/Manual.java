package filesys;

public class Manual {

    private int timesAccessed = 0;

    public int getTimesAccessed() {
        return timesAccessed;
    }

    public void man() {
        timesAccessed++;
        System.out.println("""

                MAN: ACCESS THE MANUAL

                Command Input:
                man [COMMAND]

                Use the `man` command followed by a command name to access information about that command.
                Supported commands: cd, grep, ls, mkdir, more, mv, pwd, rm, rmdir
                """);
    }

    public void man(String command) {
        timesAccessed++;
        switch (command) {
            case "cd":
                System.out.println("""
                        
                        CD: CHANGE DIRECTORY

                        This manual entry hasn't been written yet!
                        """);
                break;
            case "grep":
                System.out.println("""
                        
                        GREP: SEARCH INSIDE A FILE

                        This manual entry hasn't been written yet!
                        """);
                break;
            case "ls":
                System.out.println("""
                            
                            LS: LIST DIRECTORY CONTENTS
                            
                            This manual entry hasn't been written yet!
                            """);
                break;
            case "mkdir":
                System.out.println("""
                        
                        MKDIR: MAKE DIRECTORY
                        
                        This manual entry hasn't been written yet!
                        """);
                break;
            case "more":
                System.out.println("""
                        
                        MORE: VIEW FILE CONTENTS
                        
                        This manual entry hasn't been written yet!
                        """);
                break;
            case "mv":
                System.out.println("""
                        
                        MV: MOVE OR RENAME
                        
                        This manual entry hasn't been written yet!
                        """);
                break;
            case "pwd":
                System.out.println("""
                        
                        PWD: PRINT CURRENT DIRECTORY
                        
                        This manual entry hasn't been written yet!
                        """);
                break;
            case "rm":
                System.out.println("""
                        
                        "RM: REMOVE A FILE
                        
                        This manual entry hasn't been written yet!
                        """);
                break;
            case "rmdir":
                System.out.println("""
                        
                        RMDIR: REMOVE EMPTY DIRECTORY
                        
                        This manual entry hasn't been written yet!
                        """);
                break;
            default:
                System.out.println("Command not supported: " + command);
                System.out.println("Type `man` for a list of supported commands.");
                break;
        }
    }
}
