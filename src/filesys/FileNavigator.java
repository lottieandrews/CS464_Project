package filesys;

public class FileNavigator {

    public static final Directory ROOT_DIR = new Directory();
    public static Directory currentDir = ROOT_DIR;

    public static void pwd() {
        System.out.println(currentDir.getName());
    }

    public static void ls() {
        for (String fileName : currentDir.getChildren().keySet()) {
            System.out.println(fileName);
        }
    }

    public static void less(String fileName) {
        if (currentDir.getChildren().get(fileName) != null) {
            System.out.println(currentDir.getChildren().get(fileName).getFileText());
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
        File file1 = new File("File1", "This is a file.");
        file1.setFileText("This is a file. It contains text.");
        ROOT_DIR.addChild(file1);
        //ls();
        less("File1");
        //System.out.println((ROOT_DIR.getChildren().get("File1")).getFileText());
        //System.out.println(folder.getParentName() + "/" + folder.getName());

    }
}
