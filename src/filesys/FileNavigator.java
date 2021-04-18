package filesys;
import java.util.Arrays;
import java.util.List;

public abstract class FileNavigator {

    private final Directory ROOT_DIR;
    private Directory currentDir;

    public FileNavigator() {
        this.ROOT_DIR = new Directory();
        this.currentDir = this.ROOT_DIR;
    }

    public FileNavigator(Directory ROOT_DIR) {
        this.ROOT_DIR = ROOT_DIR;
        this.currentDir = ROOT_DIR;
    }

    public String getCurrentDirName() {
        return currentDir.getName();
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

    public void cat(String fileName) {
        if (validateName(fileName, new String[]{"File"})) {
            System.out.println(currentDir.getFile(fileName).getFileText());
        }
    }

    public void ls() {
        for (Directory dir : currentDir.getSubDirList().values()) {
            System.out.println(dir.getName());
        }
        for (File file : currentDir.getFileList().values()) {
            System.out.println(file.getName());
        }
    }

    public void mkdir(String dirName) {
        if (getType(dirName) != null) {
            printError(dirName + ": File already exists");
        }
        else {
            currentDir.addChild(new Directory(dirName));
        }
    }

    public void mv(String name1, String name2) {
        if (validateName(name1, new String[]{"File", "Directory"})) {
            if (getType(name1) == "Directory") {
                if (getType(name2) == "File") {
                    printError("Rename " + name1 + " to " + name2 + ": " + name2 + " is not a directory");
                }
                else {
                    if (getType(name2) == null) {
                        currentDir.addChild(new Directory(name2));
                    }
                    currentDir.getSubDir(name2).addChild(currentDir.getSubDir(name1));
                }
            }
            else if (getType(name1) == "File") {
                if (getType(name2) == "File") { //We may want to ask the user if they want to override the contents of the destination file inside this statement.
                    currentDir.remove(name2);
                    currentDir.getFile(name1).setName(name2);
                }
                else {
                    if (getType(name2) == null) {
                        currentDir.addChild(new File(name2));
                    }
                    currentDir.getSubDir(name2).addChild(currentDir.getFile(name1));
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

    private void printError(String errorMessage) {
        System.err.println(errorMessage);
    }
}