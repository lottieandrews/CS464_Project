package filesys;

import java.util.*;

public class Directory extends File {

    private ArrayList<Node> children;

    public Directory() {
        super();
        this.children = new ArrayList<Node>();
    }

    public Directory(String name) {
        super(name);
        this.children = new ArrayList<Node>();
    }

    public void addChild(Node child) {
        child.setParent(this);
        children.add(child);
    }

    public ArrayList<Node> getChildren() {
        return children;
    }
}