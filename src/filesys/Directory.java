package filesys;

import java.util.*;

public class Directory extends File {

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

    public void remove(String fileName) {
        files.remove(fileName);
        subDirs.remove(fileName);
    }

    public TreeMap<String, File> getFileList() {
        return files;
    }

    public TreeMap<String, Directory> getSubDirList() {
        return subDirs;
    }

    public File getFile(String fileName) {
        return files.get(fileName);
    }

    public Directory getSubDir(String dirName) {
        return subDirs.get(dirName);
    }
}