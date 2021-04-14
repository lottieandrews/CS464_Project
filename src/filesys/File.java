package filesys;

import java.util.TreeMap;

public class File {
    private Directory parent = null;
    private String name;
    private String fileText = "";

    public File() {
        this.name = "Untitled";
    }

    public File(String name) {
        this.name = name;
    }

    public File(String name, String fileText) {
        this.name = name;
        this.fileText = fileText;
    }

    public File(String name, String fileText, Directory parent) {
        this.name = name;
        this.fileText = fileText;
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFileText() {
        return fileText;
    }

    public void setFileText(String fileText) {
        this.fileText = fileText;
    }

    public Directory getParent() {
        return parent;
    }

    protected void setParent(Directory parent) {
        this.parent = parent;
    }

    public String getParentName() {
        return parent.getName();
    }

    public void addChild(File child) {
        return;
    }

    public TreeMap<String, File> getChildren() throws Exception {
        throw new Exception(name + " is not a directory");
    }

    // This method is just here so the ArrayList.toString() method will work for print debugging
    // the Directory subclass. Use getName() instead.
    public String toString() {
        return name;
    }
}