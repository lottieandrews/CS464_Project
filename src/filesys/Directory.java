package filesys;

import java.util.*;

public class Directory extends Node {

        private TreeMap<String, File> files;
        private TreeMap<String, Directory> subDirs;

    public Directory() {
        super();
        this.files = new TreeMap<String, File>();
        this.subDirs = new TreeMap<String, Directory>();
    }

    public Directory(String name) {
        super(name);
        this.files = new TreeMap<String, File>();
        this.subDirs = new TreeMap<String, Directory>();
    }

    public Directory(String name, Directory parent) {
        super(name, parent);
        this.files = new TreeMap<String, File>();
        this.subDirs = new TreeMap<String, Directory>();
    }

    public void addChild(Directory child) {
        child.setParent(this);
        subDirs.put(child.getName(), child);
    }

    public void addChild(File child) {
        child.setParent(this);
        files.put(child.getName(), child);
    }

    public File remove(String fileName) {
        return files.remove(fileName);
    }

    public TreeMap<String, File> getFiles() {
        return files;
    }

    public TreeMap<String, Directory> getSubDirs() {
        return subDirs;
    }
}