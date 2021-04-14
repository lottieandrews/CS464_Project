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

    public String toString() {
        return name;
    }
}
