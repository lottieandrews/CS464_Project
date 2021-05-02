package tutorial;
import filesys.*;

public class Tutorial {

    public Directory start = new Directory("Start");
        public Directory goHere = new Directory("GoHere");
            public Directory keepGoing = new Directory("KeepGoing");
                public Directory evenFurther = new Directory("EvenFurther");
        public File readMe = new File("readMe",
                "This file contains some text.");
        public File searchMe = new File("searchMe",
                "This line contains the word 'foobar'.\n" +
                "This line doesn't.\n" +
                "Programmers use the word 'foobar' when they don't feel like coming up with real names for their variables.\n" +
                "Don't ask me why.");
        public File renameMe = new File("renameMe",
                "Use this file to practice the mv command.");
        //Directory NewFolder will be created
        //renameMe will change to moveMe, then be moved to NewFolder
        public Directory deleteMe = new Directory("DeleteMe");
            public File removeMe = new File ("removeMe", "Remove this file.");

    public Tutorial() {
        start.addChild(goHere);
            goHere.addChild(keepGoing);
                keepGoing.addChild(evenFurther);
        start.addChild(readMe);
        start.addChild(searchMe);
        start.addChild(renameMe);
        start.addChild(deleteMe);
            deleteMe.addChild(removeMe);
    }

    public static void main(String[] args) {
        Tutorial tutorial = new Tutorial();
        Terminal tr = new Terminal(tutorial.start);
        tr.launch();
    }
}
