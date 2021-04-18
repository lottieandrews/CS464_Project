package filesys;
import assessment.GroceryList;

import java.util.Scanner;

public class Terminal extends FileNavigator {

    public final String USER;

    public Terminal() {
        super();
        this.USER = "user@Bash-Terminal";
    }

    public Terminal(Directory ROOT_DIR) {
        super(ROOT_DIR);
        this.USER = "user@Bash-Terminal";
    }

    public Terminal(String USER, Directory ROOT_DIR) {
        super(ROOT_DIR);
        this.USER = USER;
    }

    public void processUserInput(String in) {
        System.out.println(in);
    }

    public static void main(String[] args) {
        GroceryList gl = new GroceryList();
        Terminal tr = new Terminal(gl.gl);
        Scanner s = new Scanner(System.in);
        System.out.print(tr.USER + ":" + tr.getCurrentDirName() + " % ");
        while(s.hasNextLine()) {
            String in = s.nextLine();
            if (in.equals("exit")) {
                break;
            }
            else {
                tr.processUserInput(in);
                System.out.print(tr.USER + ":" + tr.getCurrentDirName() + " % ");
            }
        }
        s.close();
        System.out.println("\n[Process completed]");
        System.out.println("Rerun the program to access a new terminal window.");
    }
}