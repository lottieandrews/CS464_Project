package filesys;

//This class is exactly the same as Node. The only difference is that Directory extends Node and not File.
public class File extends Node {

    public File() {
        super();
    }

    public File(String name) {
        super(name);
    }

    public File(Directory parent, String name) {
        super(parent, name);
    }

    public File(String name, String fileText) {
        super(name, fileText);
    }

    public File(Directory parent, String name, String fileText) {
        super(parent, name, fileText);
    }
}