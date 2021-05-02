package filesys;

public abstract class Node {
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

    protected Directory getRootDir() {
        Node current = this;
        Directory parent = this.getParent();
        while (parent != null) {
            current = current.getParent();
            try {
                parent = parent.getParent();
            } catch (NullPointerException e) {
                return (Directory) current;
            }
        }
        return (Directory) current; // This should never be reached
    }

    // This method is just here so the ArrayList.toString() method will work for print debugging
    // the Directory subclass. Use getName() instead.
    public String toString() {
        return name;
    }

}
