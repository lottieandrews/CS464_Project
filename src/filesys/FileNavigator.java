package filesys;

import java.util.Arrays;

public abstract class FileNavigator {

    protected final Directory ROOT_DIR;
    protected Directory currentDir;
    protected boolean clueGame = false;
    protected boolean cluesReviewed = false;

    protected int roomsVisitCounter = 0;
    protected int rmdirCounter = 0;
    protected int grepCounter = 0;
    protected int errorCounter = 0;

    public FileNavigator() {
        this.ROOT_DIR = new Directory();
        this.currentDir = this.ROOT_DIR;
    }

    public FileNavigator(Directory ROOT_DIR) {
        this.ROOT_DIR = ROOT_DIR;
        this.currentDir = ROOT_DIR;
    }

    public void cd() {
        cd("~");
    }

    public void cd(String dirName) {
        if (validateName(dirName, new String[]{"Directory"})) {
                currentDir = currentDir.getSubDir(dirName);
                errorCounter = 0;
            if (clueGame) {
                String currentRoom = currentDir.getName();
                if (currentRoom.equals("Rooms")) {
                    if (roomsVisitCounter == 0) {
                        roomsVisitCounter++;
                        System.out.println("Good work! Now that you're ready to start looking for clues, here are a few basic commands to get you started:");
                        System.out.println("- Use the `pwd` command to figure out where you are located.");
                        System.out.println("- Use the `cd` command followed by the name of a directory to move from room to room.");
                        System.out.println("- Use the command `cd ..` to move back to your previous room.");
                        System.out.println("- Use the command `cd ~` to return to your home directory.");
                        System.out.println("- Use the `ls` command to see what's in a room.");
                        System.out.println("- Feel free to use the `man` or `help` commands at any time if you get stuck on how to properly use a command and need some help.");
                        System.out.println("\nTry investigating the Ballroom first.");
                    }
                    else {
                        System.out.println("You're back in the 'Rooms' directory. Use the `rmdir` command to remove the empty room, then choose another room to investigate. Remember to use the `ls` command to see which rooms can be searched.");
                    }
                }
                if (currentDir.getParentName().equals("Rooms")) {
                    if (currentDir.isEmpty()) {
                        System.out.println("You've found all the clues in this room! Use the command `cd ..` to move back to your previous directory.");
                    }
                    else {
                        pwd();
                    }
                }
                if (currentRoom.equals("Clue") && cluesReviewed) {
                    System.out.println("Now that you have collected all of the clues and reviewed your evidence, it is time to make your final accusation. You must guess the name of the murderer, the weapon used, and the room in which the murder took place." + "" +
                            "Use the `grep` command to search for your answers in the CONFIDENTIAL file. Guess all three correctly and you win the game!");
                    System.out.println("Type `man grep` to learn how to use the `grep` command.");
                }
                if (currentRoom.equals("Notebook")) {
                    System.out.println("Now that you have all the evidence it's time to piece together the murder scene. Using the process of elimination, determine the murder weapon, scene of the crime, and prime suspect to solve this case!");
                    System.out.println("Possible murder weapons: Wrench, Lead Pipe, Revolver, Knife, Rope, Candlestick");
                    System.out.println("Possible perpetrators: Miss Scarlett, Reverend Green, Professor Plum, Colonel Mustard, Mrs. Peacock, Mrs. White");
                    System.out.println("Possible crime scenes: Study, Kitchen, Hall, Conservatory, Lounge, Ballroom, Dining Room, Library, Billiard Room");
                    System.out.println("\nUse `ls` to view the clues you have collected. Once you have your hunch, navigate back to the main directory to make your accusation.");
                }
            }
        }
    }

    public void grep(String word, String fileName) {
        if (validateName(fileName, new String[]{"File"})) {
            String[] fileText = getLines(currentDir.getFile(fileName).getFileText());
            for (String line : fileText) {
                if (!clueGame) {
                    if(line.contains(word)) {
                        System.out.println(line);
                    }
                }
                else {
                    if (line.toLowerCase().contains(word.toLowerCase())) {
                        if (!fileName.equals("CONFIDENTIAL")) {
                            System.out.println(line);
                        }
                        else {
                            switch (word.toLowerCase()) {
                                case "colonel":
                                    System.out.println("So close! '" + word + "' is not the right answer.");
                                    System.out.println("Keep exploring rooms for more clues or go back to your Notebook and review your evidence, then try again.");
                                    System.out.println("Still convinced you're right? Reread `man grep`. You may have entered the correct answer, but in the wrong format.");
                                    break;
                                case "mustard":
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
                                    System.out.println("Hey! No peeking!");
                                    break;
                            }
                        }
                    } else if (fileName.equals("CONFIDENTIAL")) {
                        System.out.println("So close! '" + word + "' is not the right answer.");
                        System.out.println("Keep exploring rooms for more clues or go back to your Notebook and review your evidence, then try again.");
                        System.out.println("Still convinced you're right? Reread `man grep`; you may have entered the correct answer, but in the wrong format.");
                    }
                    if (grepCounter >= 3){
                        System.out.println("Congratulations! You won the game! Use the `exit` command to quit the terminal.");
                    }
                }
            }
        }
        errorCounter = 0;
    }

    public void ls() {
        errorCounter = 0;
        if (clueGame) {
            if (currentDir.getParentName().equals("Rooms") && currentDir.isEmpty()) {
                System.out.println("You've found all the clues in this room! Use the command `cd ..` to move back to your previous directory.");
            }
            if(currentDir.getName().equals("Notebook")) {
                cluesReviewed = true;
            }
        }
        ls(currentDir);
    }

    public void ls(String name) {
        if (validateName(name, new String[]{"File", "Directory"})) {
            errorCounter = 0;
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

    public void mkdir(String dirName) {
        if (getType(dirName) != null) {
            printError(dirName + ": File or directory already exists", "mkdir");
        }
        else {
            errorCounter = 0;
            currentDir.addChild(new Directory(dirName));
        }
        if (clueGame && dirName.equals("Notebook")){
            System.out.println("Great! Now you are ready to start looking for clues! Use the command `cd Rooms` to enter the rooms.");
        }
    }

    public void more(String fileName) {
        if (validateName(fileName, new String[]{"File"})) {
            errorCounter = 0;
            if (clueGame && fileName.equals("CONFIDENTIAL")) {
                System.out.println("Hey! No peeking!");
                return;
            }
            System.out.println(currentDir.getFile(fileName).getFileText());
            if (clueGame) {
                System.out.println("\nYou found a clue! Use the `mv` command to rename the clue to something that's easier to remember (e.g., `mv roomClue1 notWeapon`), " +
                        "then use the command `mv` with the destination `~/Notebook` to move it to your Notebook for safekeeping.");
            }
        }
    }

    public void mv(String name1, String name2) {
        if (validateName(name1, new String[]{"File", "Directory"})) {
            if (getType(name1) == "Directory") {
                if (name1.equals("..") || name1.equals(".") || name1.equals("~")) { // Move current or parent directory somewhere else (bad)
                    printError("Rename " + name1 + " to " + name2 + ": Invalid argument", "mv");
                    return;
                }
                if (getType(name2) == "File") { // Move directory to file (bad)
                    printError("Rename " + name1 + " to " + name2 + ": " + name2 + " is not a directory", "mv");
                    return;
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
                else if (getType(name2) == "Directory" || name2.equals("~/Notebook")) { // Move file to directory
                    if (clueGame) {
                        if (name2.equals("~/Notebook")) { // Move file to notebook directory
                            ROOT_DIR.getSubDir("Notebook").addChild(currentDir.getFile(name1));
                        }
                        if (currentDir.isEmpty()) {
                            System.out.println("You've found all the clues in this room! Use the command `cd ..` to move back to your previous directory.");
                        }
                    }
                    else {
                        currentDir.getSubDir(name2).addChild(currentDir.getFile(name1));
                    }
                    currentDir.remove(name1);
                }
                else { // Rename file
                    currentDir.getFile(name1).setName(name2);
                }
            }
            errorCounter = 0;
        }
    }

    public void pwd() {
        if (clueGame && currentDir.getParentName().equals("Rooms")) {
            System.out.println("You're in the " + currentDir.getName() + "! Use the `ls` command to list the clues hidden here. Use the `more` command to read what the clues contain.");
        }
        else {
            System.out.println(currentDir.getName());
        }
    }

    public void rm(String fileName) {
        if(validateName(fileName, new String[]{"File"})) {
            errorCounter = 0;
            currentDir.remove(fileName);
        }
    }

    public void rmdir(String dirName) {
        if (dirName.equals(".") || dirName.equals("..") || dirName.equals("~")) {
            printError("rmdir: " + dirName + ": Operation not permitted", "rmdir");
        }
        else if(validateName(dirName, new String[]{"Directory"})) {
            if (!currentDir.getSubDir(dirName).isEmpty()) {
                printError(dirName + ": Directory not empty", "rmdir");
            }
            else {
                errorCounter = 0;
                currentDir.remove(dirName);
                rmdirCounter++;
                if(clueGame && rmdirCounter >= 9){
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
            printError(name + " is a directory", "man");
        }
        else if (getType(name) == "File") {
            if (Arrays.asList(validTypes).contains("File")) {
                return true;
            }
            printError(name + ": Not a directory", "man");
        }
        else {
            printError(name + ": No such file or directory", "man");
        }
        return false;
    }

    // We want to print to stdout and not stderr here because we're essentially treating this method as our exception catcher.
    protected void printError(String errorMessage, String command) {
        errorCounter++;
        System.out.println(errorMessage);
        if (errorCounter >= 3) {
            if (command.equals("man")) {
                System.out.println("Need help? Type the `man` command for more information.");
            } else {
                System.out.println("Need help? Type `man " + command + "` for more information.");
            }
        }
    }
}