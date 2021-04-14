package tutorial;

import filesys.*;

public class Tutorial {

    public static Directory root = new Directory("Untitled");
    public static Directory current = root;

    public static void main(String[] args) {
        root.setName("Root");
        System.out.println(root.getName());
        Directory folder = new Directory("Folder");
        root.addChild(folder);
        System.out.println(folder.getParentName() + "/" + folder.getName());
        System.out.println(root.getChildren().toString());
    }

}