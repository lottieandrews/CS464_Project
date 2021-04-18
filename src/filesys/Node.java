package filesys;

public class Node {
    private Directory parent = null;
    private String name;
    private String fileText = "";

    public Node() {
        this.name = "Untitled";
    }

    public Node(String name) {
        this.name = name;
    }

    public Node(String name, String fileText) {
        this.name = name;
        this.fileText = fileText;
    }

    public Node(Directory parent, String name) {
        this.parent = parent;
        this.name = name;
    }

    public Node(Directory parent, String name, String fileText) {
        this.parent = parent;
        this.name = name;
        this.fileText = fileText;
    }

    public Directory getParent() {
        return parent;
    }

    protected void setParent(Directory parent) {
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

    public String getParentName() {
        return parent.getName();
    }

    // This method is just here so the ArrayList.toString() method will work for print debugging
    // the Directory subclass. Use getName() instead.
    public String toString() {
        return name;
    }

}
