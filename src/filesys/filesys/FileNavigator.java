package filesys;
import java.util.Arrays;

public abstract class FileNavigator {

    protected final Directory ROOT_DIR;
    protected Directory currentDir;

    int moveCounter = 0;
    boolean isFirstTime = true;

    public FileNavigator() {
        this.ROOT_DIR = new Directory();
        this.currentDir = this.ROOT_DIR;
    }

    public FileNavigator(Directory ROOT_DIR) {
        this.ROOT_DIR = ROOT_DIR;
        this.currentDir = ROOT_DIR;
    }

    public void cd() {
        currentDir = ROOT_DIR;
    }

    public void cd(String dirName) {
        if (validateName(dirName, new String[]{"Directory"})) {
            currentDir = currentDir.getSubDir(dirName);
            if (currentDir.getName().equals("Rooms")){
                System.out.println("You're back in the 'Rooms' directory. Choose another room to investigate. Remember to use the ls command to see which rooms can be searched.");
            }
        }
        if (dirName.equals("Rooms") && isFirstTime){
            System.out.println("Good work! Now use the ls command to look at your options " + 
            "and the cd command again to choose which room you'd like to investigate first. ");
            isFirstTime = false;
        }
        if (dirName.equals("Ballroom") || dirName.equals("Billiard_Room") || dirName.equals("Conservatory") || dirName.equals("Dining_Room") || dirName.equals("Hall") || dirName.equals("Kitchen") || dirName.equals("Library") || dirName.equals("Lounge") || dirName.equals("Study")){
            System.out.println("You're in the " + dirName + "! Use the ls command to list the clues hidden here. Use the more command to read what the clues contain.");
        }
        
    }

    public void grep(String word, String fileName) {
        if (validateName(fileName, new String[]{"File"})) {
            String[] fileText = getLines(currentDir.getFile(fileName).getFileText());
            for (String line : fileText) {
                if (line.contains(word)) {
                    System.out.println(line);
                }
            }
        }
    }

    public void ls() {
        ls(currentDir);
    }

    public void ls(String name) {
        if (validateName(name, new String[]{"File", "Directory"})) {
            if (getType(name).equals("File")) {
                System.out.println(name);
            }
            else {
                ls(currentDir.getSubDir(name));
            }
        }
    }

    private void ls(Directory dir) {
        for (Directory d : dir.getSubDirList().values()) {
            System.out.println(d.getName());
        }
        for (File file : dir.getFileList().values()) {
            System.out.println(file.getName());
        }
    }

    public void man() {
        System.out.println("\nMAN: ACCESS THE MANUAL\n\n" +
                "Command Input: \n" +
                "man [COMMAND]\n\n" +
                "Use the `man` command followed by a command name to access information about that command.\n" +
                "Supported commands: cd, exit, grep, ls, mkdir, more, mv, pwd, rm\n");
    }

    public void man(String command) {
        System.out.println("This manual entry hasn't been written yet!");
    }

    public void mkdir(String dirName) {
        if (getType(dirName) != null) {
            printError(dirName + ": File or directory already exists");
        }
        else {
            currentDir.addChild(new Directory(dirName));
        }
        if (dirName.equals("Notebook")){
            System.out.println("Great! Now you are ready to start looking for clues! Use the cd command to enter the 'Rooms'.");
        }
    }

    public void more(String fileName) {
        if (validateName(fileName, new String[]{"File"})) {
            System.out.println(currentDir.getFile(fileName).getFileText());
        }
        System.out.println("You found a clue! Use the mv to rename the clue to something that's easier to remember (i.e., 'NotWrench') then use the mv command again to move it to your Notebook for safe keeping.");
    }

    public void mv(String name1, String name2) {
        if (validateName(name1, new String[]{"File", "Directory"})) {
            if (getType(name1) == "Directory") {
                if (name1.equals("..") || name1.equals(".")) { // Move current or parent directory somewhere else (bad)
                    printError("Rename " + name1 + " to " + name2 + ": Invalid argument");
                }
                if (getType(name2) == "File") { // Move directory to file (bad)
                    printError("Rename " + name1 + " to " + name2 + ": " + name2 + " is not a directory");
                }
                else if (getType(name2) == "Directory") { // Move directory into another directory
                    currentDir.getSubDir(name2).addChild(currentDir.getSubDir(name1));
                    currentDir.remove(name1);
                }
                else { // Rename directory
                    currentDir.getSubDir(name1).setName(name2);
                }
            }
            else if (getType(name1) == "File") {
                if (getType(name2) == "File") { // Move file to existing file
                    // We may want to ask the user here if they want to override the contents of the destination file.
                    currentDir.remove(name2);
                    currentDir.getFile(name1).setName(name2);
                }
                else if (getType(name2) == "Directory") { // Move file to directory
                        currentDir.getSubDir(name2).addChild(currentDir.getFile(name1));
                        currentDir.remove(name1);
                        moveCounter++;
                        if(moveCounter >= 2){
                            System.out.println("You've found all the clues in this room! Use the cd command to move back to the 'Rooms' directory");
                        }
                }
                else { // Rename file
                    currentDir.getFile(name1).setName(name2);
                }
            }
        }
    }

    public void pwd() {
        System.out.println(currentDir.getName());
    }

    public void rm(String fileName) {
        if(validateName(fileName, new String[]{"File"})) {
            currentDir.remove(fileName);
        }
    }

    public void rmdir(String dirName) {
        if (dirName.equals(".") || dirName.equals("..")) {
            printError("rmdir: " + dirName + ": Operation not permitted");
        }
        else if(validateName(dirName, new String[]{"Directory"})) {
            if (!currentDir.getSubDir(dirName).isEmpty()) {
                printError(dirName + ": Directory not empty");
            }
            else {
                currentDir.remove(dirName);
            }
        }
    }

    private String[] getLines(String fileText) {
        return fileText.split("\n");
    }

    private String getType(String name) {
        if (currentDir.getSubDir(name) != null) {
            return "Directory";
        }
        else if (currentDir.getFile(name) != null) {
            return "File";
        }
        else {
            return null;
        }
    }

    private boolean validateName(String name, String[] validTypes) {
        if (getType(name) == "Directory") {
            if (Arrays.asList(validTypes).contains("Directory")) {
                return true;
            }
            printError(name + " is a directory");
        }
        else if (getType(name) == "File") {
            if (Arrays.asList(validTypes).contains("File")) {
                return true;
            }
            printError(name + ": Not a directory");
        }
        else {
            printError(name + ": No such file or directory");
        }
        return false;
    }

    // We want to print to stdout and not stderr here because we're essentially treating this method as our exception catcher.
    private void printError(String errorMessage) {
        System.out.println(errorMessage);
    }
}