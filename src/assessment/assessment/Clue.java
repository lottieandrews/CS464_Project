package assessment;
import filesys.*;

public class Clue {
    public Directory clue = new Directory("Clue");
        public Directory rooms = new Directory("Rooms");
            public Directory study = new Directory("Study");
                public File studyClue1 = new File("StudyClue1", "You have to believe me! It wasn't Miss Scarlet!");
                public File studyClue2 = new File("StudyClue2", "The wrench wasn't the murder weapon! I swear!");
            public Directory kitchen = new Directory("Kitchen");
                public File kitchenClue1 = new File("KitchenClue1", "I've been with Reverend Green all night! It couldn't have been him!");
                public File kitchenClue2 = new File("KitchenClue2", "No way it happened in the Library!");
            public Directory hall = new Directory("Hall");
                public File hallClue1 = new File("HallClue1", "I don't know who dunnit but it wasn't Professor Plum!");
                public File hallClue2 = new File("HallClue2", "Not sure where it happened but it definitely wasn't in the Billiard Room!");
            public Directory conservatory = new Directory("Conservatory");
                public File conservatoryClue1 = new File("ConservatoryClue1", "It didn't happen in the Lounge now leave me alone!");
                public File conservatoryClue2 = new File("ConservatoryClue2", "A murder using a candlestick? Can you imagine? Definitely not!");
            public Directory lounge = new Directory("Lounge");
                public File loungeClue1 = new File("LoungeClue1", "Mrs. White wouldn't hurt a fly! It most certainly wasn't her!");
                public File loungeClue2 = new File("LoungeClue2", "Don't know where it happened but it definitely wasn't in the conservatory!");
            public Directory ballroom = new Directory("Ballroom");
                public File ballroomClue1 = new File("BallroomClue1", "It wasn't in the dining room! Couldn't have been!");
                public File ballroomClue2 = new File("BallroomClue2", "No way he was killed with a knife!");
            public Directory diningRoom = new Directory("Dining_Room");
                public File diningClue1 = new File("DiningClue1", "Don't ask me how I know this but it wasn't Mrs. Peacock!");
                public File diningClue2 = new File("DiningClue2", "Ballroom's too clean for it to have happened in there!");
            public Directory library = new Directory("Library");
                public File libraryClue1 = new File("LibraryClue1", "Definitely didn't happen in the Kitchen!");
                public File libraryClue2 = new File("LibraryClue2", "All the plumbing seems to be intact so it couldn't have been the lead pipe!");
            public Directory billiardRoom = new Directory("Billiard_Room");
                public File billiardClue1 = new File("BilliardClue1", "It most certainly couldn't have happened in the hall!");
                public File billiardClue2 = new File("BilliardClue2", "Seriously? Obviously the murder weapon wasn't the rope!");

    public Clue() {
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
        Clue clue = new Clue();
        Terminal tr = new Terminal(clue.rooms);
        tr.launch();
    }
}
