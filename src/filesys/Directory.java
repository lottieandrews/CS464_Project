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

    public Directory(String name, String fileText) {
        super(name, fileText);
        this.files = new TreeMap<String, File>();
        this.subDirs = new TreeMap<String, Directory>();
    }

    @Override
    public void setName(String name) {
        String oldName = this.getName();
        super.setName(name);
        if (this.getParent() != null) {
            this.getParent().remove(oldName);
            this.getParent().addChild(this);
        }
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
        if (dirName.equals("..")) {
            if (getParent() != null) {
                return getParent();
            }
            else {
                return this;
            }
        }
        if (dirName.equals(".")) {
            return this;
        }
        if (dirName.equals("~")) {
            return getRootDir();
        }
        return subDirs.get(dirName);
    }

    public boolean isEmpty() {
        return files.isEmpty() && subDirs.isEmpty();
    }
}