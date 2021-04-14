package filesys;

import java.util.*;

public class Directory extends File {

    private TreeMap<String, File> children;

    public Directory() {
        super();
        this.children = new TreeMap<String, File>();
    }

    public Directory(String name) {
        super(name);
        this.children = new TreeMap<String, File>();
    }

    @Override
    public void addChild(File child) {
        child.setParent(this);
        children.put(child.getName(), child);
    }

    @Override
    public TreeMap<String, File> getChildren() {
        return children;
    }
}