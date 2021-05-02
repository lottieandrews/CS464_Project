
import Directory;
import File;
import Terminal;
import filesys.*;

public class Clue {
    public Directory clue = new Directory("Clue");
        public File confidential = new File("CONFIDENTIAL", "Colonel Mustard in the study with the revolver!");
        public Directory rooms = new Directory("Rooms");
            public Directory study = new Directory("Study");
                public File studyClue1 = new File("studyClue1", "You have to believe me! It wasn't Miss Scarlet!");
                public File studyClue2 = new File("studyClue2", "The wrench wasn't the murder weapon! I swear!");
            public Directory kitchen = new Directory("Kitchen");
                public File kitchenClue1 = new File("kitchenClue1", "I've been with Reverend Green all night! It couldn't have been him!");
                public File kitchenClue2 = new File("kitchenClue2", "No way it happened in the Library!");
            public Directory hall = new Directory("Hall");
                public File hallClue1 = new File("hallClue1", "I don't know who dunnit but it wasn't Professor Plum!");
                public File hallClue2 = new File("hallClue2", "Not sure where it happened but it definitely wasn't in the Billiard Room!");
            public Directory conservatory = new Directory("Conservatory");
                public File conservatoryClue1 = new File("conservatoryClue1", "It didn't happen in the Lounge now leave me alone!");
                public File conservatoryClue2 = new File("conservatoryClue2", "A murder using a candlestick? Can you imagine? Definitely not!");
            public Directory lounge = new Directory("Lounge");
                public File loungeClue1 = new File("loungeClue1", "Mrs. White wouldn't hurt a fly! It most certainly wasn't her!");
                public File loungeClue2 = new File("loungeClue2", "Don't know where it happened but it definitely wasn't in the conservatory!");
            public Directory ballroom = new Directory("Ballroom");
                public File ballroomClue1 = new File("ballroomClue1", "It wasn't in the dining room! Couldn't have been!");
                public File ballroomClue2 = new File("ballroomClue2", "No way he was killed with a knife!");
            public Directory diningRoom = new Directory("DiningRoom");
                public File diningClue1 = new File("diningClue1", "Don't ask me how I know this but it wasn't Mrs. Peacock!");
                public File diningClue2 = new File("diningClue2", "Ballroom's too clean for it to have happened in there!");
            public Directory library = new Directory("Library");
                public File libraryClue1 = new File("libraryClue1", "Definitely didn't happen in the Kitchen!");
                public File libraryClue2 = new File("libraryClue2", "All the plumbing seems to be intact so it couldn't have been the lead pipe!");
            public Directory billiardRoom = new Directory("BilliardRoom");
                public File billiardClue1 = new File("billiardClue1", "It most certainly couldn't have happened in the hall!");
                public File billiardClue2 = new File("billiardClue2", "Seriously? Obviously the murder weapon wasn't the rope!");

    public Clue() {
        clue.addChild(confidential);
        clue.addChild(rooms);
            rooms.addChild(study);
                study.addChild(studyClue1);
                study.addChild(studyClue2);
            rooms.addChild(kitchen);
                kitchen.addChild(kitchenClue1);
                kitchen.addChild(kitchenClue2);
            rooms.addChild(hall);
                hall.addChild(hallClue1);
                hall.addChild(hallClue2);
            rooms.addChild(conservatory);
                conservatory.addChild(conservatoryClue1);
                conservatory.addChild(conservatoryClue2);
            rooms.addChild(lounge);
                lounge.addChild(loungeClue1);
                lounge.addChild(loungeClue2);
            rooms.addChild(ballroom);
                ballroom.addChild(ballroomClue1);
                ballroom.addChild(ballroomClue2);
            rooms.addChild(diningRoom);
                diningRoom.addChild(diningClue1);
                diningRoom.addChild(diningClue2);
            rooms.addChild(library);
                library.addChild(libraryClue1);
                library.addChild(libraryClue2);
            rooms.addChild(billiardRoom);
                billiardRoom.addChild(billiardClue1);
                billiardRoom.addChild(billiardClue2);
    }

    public static void main(String[] args){
        System.out.println("\nWelcome to Bash Detective: The Clue-Inspired Terminal Game!");
        System.out.println("\nUse the cd, exit, grep, ls, mkdir, more, mv, pwd, and rm commands to " +
        "investigate the clues hidden in each room and find out who dunnit, where they dunnit, and what they dunnit with! " + 
        "Feel free to use the man command if you get stuck on how to properly use a command and need some help. Use the " +
        "exit command when you're finished to exit the game.");
        System.out.println("\nStart by creating a directory called 'Notebook' to store your clues.\n");
        Clue clue = new Clue();
        Terminal tr = new Terminal(clue.clue);
        tr.launch();
    }
}
