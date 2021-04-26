package filesys;
import java.util.Arrays;

public abstract class FileNavigator {

    protected final Directory ROOT_DIR;
    protected Directory currentDir;

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

    public void mkdir(String dirName) {
        if (getType(dirName) != null) {
            printError(dirName + ": File or directory already exists");
        }
        else {
            currentDir.addChild(new Directory(dirName));
        }
    }

    public void more(String fileName) {
        if (validateName(fileName, new String[]{"File"})) {
            System.out.println(currentDir.getFile(fileName).getFileText());
        }
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