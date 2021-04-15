package filesys;
import java.io.*;

public class FileNavigator {

    public static final Directory ROOT_DIR = new Directory();
    public static Directory currentDir = ROOT_DIR;

    public static void cd() {
        currentDir = ROOT_DIR;
    }

    public static void cd(String dirName) {
        if (validateName(dirName, "Directory")) {
            currentDir = currentDir.getSubDirs().get(dirName);
        }
    }

    public static void less(String fileName) {
        if (validateName(fileName, "File")) {
            System.out.println(currentDir.getFiles().get(fileName).getFileText());
        }
    }

    public static void ls() {
        for (Directory dir : currentDir.getSubDirs().values()) {
            System.out.println(dir.getName());
        }
        for (File file : currentDir.getFiles().values()) {
            System.out.println(file.getName());
        }
    }

    public static void mkdir(String dirName) {
        currentDir.addChild(new Directory(dirName));
    }

    public static void pwd() {
        System.out.println(currentDir.getName());
    }

    public static void rm(String fileName) {
        if(validateName(fileName, "File")) {
            currentDir.remove(fileName);
        }
    }

    private static boolean validateName(String name, String validType) {
        if (currentDir.getSubDirs().get(name) != null) {
            if (validType == "Directory") {
                return true;
            }
            errorHandler(new IOException(name + " is a directory"));
        }
        else if (currentDir.getFiles().get(name) != null) {
            if (validType == "File") {
                return true;
            }
            errorHandler(new IOException(name + " is not a directory"));
        }
        else {
            errorHandler(new FileNotFoundException(name + ": No such file or directory"));
        }
        return false;
    }

    private static void errorHandler(Exception e) {
        System.err.println(e.getMessage());
    }

    public static void main(String[] args) {
        ROOT_DIR.setName("Start");
        //pwd();
        Directory folder1 = new Directory("Folder1");
        Directory folder2 = new Directory("Folder2");
        Directory folder3 = new Directory("Folder3");
        ROOT_DIR.addChild(folder1);
        ROOT_DIR.addChild(folder2);
        ROOT_DIR.addChild(folder3);
        //System.out.println(folder.getParentName() + "/" + folder.getName());
        File file1 = new File("File1", "This is a file.");
        file1.setFileText("This is a file. It contains text.");
        ROOT_DIR.addChild(file1);
        //less("Folder2");
        //less("File1");
        //System.out.println("Before:");
        //ls();
        //rm("File1");
        //System.out.println("After:");
        //ls();
        //cd("Folder2");
        pwd();
    }
}
