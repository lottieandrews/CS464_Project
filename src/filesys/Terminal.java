package filesys;
import assessment.GroceryList;

public class Terminal extends FileNavigator {

    public Terminal() {
        super();
    }

    public Terminal(Directory ROOT_DIR) {
        super(ROOT_DIR);
    }

    public static void main(String[] args) {
        GroceryList gl = new GroceryList();
        Terminal tr = new Terminal(gl.gl);
        tr.pwd();

    }
}