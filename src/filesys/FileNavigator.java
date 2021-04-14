package filesys;

public class FileNavigator {

    public static final Directory ROOT_DIR = new Directory();
    public static Directory currentDir = ROOT_DIR;

    public static void pwd() {
        System.out.println(currentDir.getName());
    }

    public static void ls() {
        for (Node item : currentDir.getChildren()) {
            System.out.println(item.getName());
        }
    }

    public static void less(File file) {
        System.out.println(file.getFileText());
    }

    public static void main(String[] args) {
        ROOT_DIR.setName("Start");
        pwd();
        Directory folder1 = new Directory("Folder1");
        Directory folder2 = new Directory("Folder2");
        Directory folder3 = new Directory("Folder3");
        ROOT_DIR.addChild(folder1);
        ROOT_DIR.addChild(folder2);
        ROOT_DIR.addChild(folder3);
        //System.out.println(folder.getParentName() + "/" + folder.getName());
        ls();
    }
}
