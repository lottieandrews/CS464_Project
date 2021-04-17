package filesys;

public class File extends Node {

    private String fileText = "";

    public File() {
        super();
    }
    public File(String name) {
        super(name);
    }

    public File(String name, Directory parent) {
        super(name, parent);
    }

    public File(String name, String fileText) {
        super(name);
        this.fileText = fileText;
    }

    public String getFileText() {
        return fileText;
    }

    public void setFileText(String fileText) {
        this.fileText = fileText;
    }
}