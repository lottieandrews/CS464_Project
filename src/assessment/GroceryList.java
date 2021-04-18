package assessment;
import filesys.*;

public class GroceryList {
    public Directory gl = new Directory("GroceryList");
        public Directory beverages = new Directory("Beverages");
            public Directory hotDrinks = new Directory("HotDrinks");
                public File blackTea = new File("blackTea",
                        "A lovely morning beverage.\n" +
                        "Contains 47mg of caffeine per serving.");
                public File coffee = new File("coffee",
                        "A lovely morning beverage.\n" +
                        "Contains 96mg of caffeine per serving.");
                public File hotCocoa = new File("hotCocoa",
                        "Makes the holiday season bright.");
            public Directory juice = new Directory("Juice");
                public File appleJuice = new File("appleJuice",
                        "It's super sweet!");
                public File orangeJuice = new File("orangeJuice",
                        "No pulp please.");
                public File pruneJuice = new File("pruneJuice",
                        "For good digestive health.");
            public Directory soda = new Directory("Soda");
                public File cocaCola = new File("cocaCola",
                        "Share it with friends.");
                public File dietSprite = new File("dietSprite",
                        "Tastes like water (but sharp).");
                public File rootBeer = new File("rootBeer",
                        "The rootin' tootinest!");
        public Directory dairy = new Directory("Dairy");
            public Directory cheese = new Directory("Cheese");
                public File mozzarella = new File("mozzarella",
                        "Pizza night wouldn't be the same without it.");
                public File pepperJack = new File("pepperJack",
                        "The cheddar of the southwest.");
                public File swiss = new File("swiss",
                        "Holy cheese!");
            public Directory iceCream = new Directory("IceCream");
                public File vanilla = new File("vanilla",
                        "My favorite flavor.");
        public Directory meat = new Directory("Meat");
            public File chickenWings = new File("chickenWings",
                    "Don't forget the sauce.");
            public Directory beef = new Directory("Beef");
                public File groundBeef = new File("groundBeef",
                        "Burgers or tacos?");
                public File steak = new File("steak",
                        "For a special occasion.");
            public Directory seafood = new Directory("Seafood");
                public File cannedTuna = new File("cannedTuna",
                        "An easy way to make the whole office hate you.");
                public File crabLegs = new File("crabLegs",
                        "Why go to this much effort when you could just drink melted butter?");
                public File jumboShrimp = new File("jumboShrimp",
                        "An oximoron.");
        public Directory produce = new Directory("Produce");
            public Directory fruit = new Directory("Fruit");
                public File banana = new File("banana",
                        "Orange you glad I didn't say... wait a minute.");
                public File peach = new File("peach",
                        "Fuzzy and sweet, just like my dog.");
                public File watermelon = new File("watermelon",
                        "Am I ripe? Slap me and find out.");
            public Directory vegetables = new Directory("Vegetables");
                public File broccoli = new File("broccoli",
                        "Look at these tiny trees! I feel like a giant!");
                public File brusselsSprouts = new File("brusselsSprouts",
                        "Every child's worst nightmare.");
                public File carrot = new File("carrot",
                        "A great healthy snack. \n" +
                        "Tastes very sweet, if you've never tried dessert before.");
                public File cucumber = new File("cucumber",
                        "WARNING: Does NOT taste good in zucchini bread.");

    public GroceryList() {
        gl.addChild(beverages);
            beverages.addChild(hotDrinks);
                hotDrinks.addChild(blackTea);
                hotDrinks.addChild(coffee);
                hotDrinks.addChild(hotCocoa);
            beverages.addChild(juice);
                juice.addChild(appleJuice);
                juice.addChild(orangeJuice);
                juice.addChild(pruneJuice);
            beverages.addChild(soda);
                soda.addChild(cocaCola);
                soda.addChild(dietSprite);
                soda.addChild(rootBeer);
        gl.addChild(dairy);
            dairy.addChild(cheese);
                cheese.addChild(mozzarella);
                cheese.addChild(pepperJack);
                cheese.addChild(swiss);
            dairy.addChild(iceCream);
                iceCream.addChild(vanilla);
        gl.addChild(meat);
            meat.addChild(chickenWings);
            meat.addChild(beef);
                beef.addChild(groundBeef);
                beef.addChild(steak);
            meat.addChild(seafood);
                seafood.addChild(cannedTuna);
                seafood.addChild(crabLegs);
                seafood.addChild(jumboShrimp);
        gl.addChild(produce);
            produce.addChild(fruit);
                fruit.addChild(banana);
                fruit.addChild(peach);
                fruit.addChild(watermelon);
            produce.addChild(vegetables);
                vegetables.addChild(broccoli);
                vegetables.addChild(brusselsSprouts);
                vegetables.addChild(carrot);
                vegetables.addChild(cucumber);
    }
}