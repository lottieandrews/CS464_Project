package filesys;

import java.util.Arrays;

public abstract class FileNavigator {

    protected final Directory ROOT_DIR;
    protected Directory currentDir;

    int moveCounter = 0;
    boolean isFirstTime = true;
    int rmdirCounter = 0;
    int grepCounter = 0;

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
            if (currentDir.getName().equals("Rooms") && !isFirstTime){
                System.out.println("You're back in the 'Rooms' directory. Use the rmdir command to remove the empty room, then choose another room to investigate. Remember to use the ls command to see which rooms can be searched.");
            }
        }
        if (dirName.equals("Rooms") && isFirstTime){
            System.out.println("Good work! Now use the ls command to look at your options " +
            "and the cd command again to choose which room you'd like to investigate first. ");
            isFirstTime = false;
        }
        if (dirName.equals("Ballroom") || dirName.equals("BilliardRoom") || dirName.equals("Conservatory") || dirName.equals("DiningRoom") || dirName.equals("Hall") || dirName.equals("Kitchen") || dirName.equals("Library") || dirName.equals("Lounge") || dirName.equals("Study")){
            System.out.println("You're in the " + dirName + "! Use the ls command to list the clues hidden here. Use the more command to read what the clues contain.");
        }
        if (dirName.equals("Notebook")){
            System.out.println("Now that you have all the evidence it's time to piece together the murder scene. Using the process of elimination, determine the murder weapon, scene of the crime, and prime suspect to solve this case!");
            System.out.println("Possible murder weapons: Wrench, Lead Pipe, Revolver, Knife, Rope, Candlestick");
            System.out.println("Possible perpetrators: Miss Scarlett, Reverend Green, Professor Plum, Colonel Mustard, Mrs. Peacock, Mrs. White");
            System.out.println("Possible crime scenes: Study, Kitchen, Hall, Conservatory, Lounge, Ballroom, Dining Room, Library, Billiard Room");
        }
        
    }

    public void grep(String word, String fileName) {
        if (validateName(fileName, new String[]{"File"})) {
            String[] fileText = getLines(currentDir.getFile(fileName).getFileText());
            for (String line : fileText) {
                if (line.contains(word)) {
                    switch(word){
                        case "Mustard":
                            System.out.println("Great work! You found the murderer!");
                            grepCounter++;
                            break;
                        case "study":
                            System.out.println("Nice job! You found the scene of the crime!");
                            grepCounter++;
                            break;
                        case "revolver":
                            System.out.println("Excellent! You found the murder weapon!");
                            grepCounter++;
                            break;
                        default:
                            System.out.println(line);
                            break;
                    }
                }
            }
        }
        if (grepCounter >= 3){
            System.out.println("Congratulations! You won the game! Use the exit command to quit the terminal.");
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
            System.out.println("Great! Now you are ready to start looking for clues! Use the command 'cd Rooms' to enter the rooms.");
        }
    }

    public void more(String fileName) {
        if (validateName(fileName, new String[]{"File"}) && !fileName.equals("CONFIDENTIAL")) {
            System.out.println(currentDir.getFile(fileName).getFileText());
            System.out.println("\nYou found a clue! Use the mv command to rename the clue to something that's easier to remember (e.g., 'mv ballroomClue notDiningRoom') then type the command 'mv ~/Notebook' to move it to your Notebook for safe keeping.");
        } else {
            System.out.println("Hey! No peeking!");
        }
    }

    public void mv(String name1, String name2) {
        if (validateName(name1, new String[]{"File", "Directory"})) {
            if (getType(name1) == "Directory") {
                if (name1.equals("..") || name1.equals(".") || name1.equals("~")) { // Move current or parent directory somewhere else (bad)
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
                            System.out.println("You've found all the clues in this room! Use the command 'cd ..' to move back to your previous directory.");
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
        if (dirName.equals(".") || dirName.equals("..") || dirName.equals("~")) {
            printError("rmdir: " + dirName + ": Operation not permitted");
        }
        else if(validateName(dirName, new String[]{"Directory"})) {
            if (!currentDir.getSubDir(dirName).isEmpty()) {
                printError(dirName + ": Directory not empty");
            }
            else {
                currentDir.remove(dirName);
                rmdirCounter++;
                if(rmdirCounter >= 9){
                    System.out.println("You've found all the clues! Use the 'cd ~' command to go back to your home directory, then navigate to your Notebook to sift through your notes and solve this murder!");
                }
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