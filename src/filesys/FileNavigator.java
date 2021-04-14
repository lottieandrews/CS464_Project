package filesys;

import java.io.IOException;

public class FileNavigator {

    public static final Directory ROOT_DIR = new Directory();
    public static Directory currentDir = ROOT_DIR;

    public static void pwd() {
        System.out.println(currentDir.getName());
    }

    public static void ls() {
        for (Directory dir : currentDir.getSubDirs().values()) {
            System.out.println(dir.getName());
        }
        for (File file : currentDir.getFiles().values()) {
            System.out.println(file.getName());
        }
    }

    public static void less(String fileName) {
        if (currentDir.getFiles().get(fileName) != null) {
            System.out.println(currentDir.getFiles().get(fileName).getFileText());
        }
        else if (currentDir.getSubDirs().get(fileName) != null) {
            errorHandler(new IOException(fileName + " is a directory"));
        }
        else {
            errorHandler(new NullPointerException(fileName + ": No such file or directory"));
        }
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
        //ls();
        less("Folder2");
        less("File1");
    }
}
