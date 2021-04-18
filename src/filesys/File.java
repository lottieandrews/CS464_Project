package filesys;

//This class is exactly the same as Node, but can be instantiated. A Directory is-a Node, not a File.
public class File extends Node {

    public File() {
        super();
    }

    public File(String name) {
        super(name);
    }

    public File(String name, String fileText) {
        super(name, fileText);
    }
}