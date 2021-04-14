package filesys;

public class Node {
    private Directory parent = null;
    private String name;

    public Node(String name) {
        this.name = name;
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

    public String getParentName() {
        return parent.getName();
    }

    // This method is just here so the ArrayList.toString() method will work for print debugging
    // the Directory subclass. Use getName() instead.
    public String toString() {
        return name;
    }
}
