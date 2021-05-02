package filesys;
public class File extends Node {

    public File() {
        super();
    }

    public File(String name) {
        super(name);
    }

    public File(String name, String fileText) {
        super(name, fileText);
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
}