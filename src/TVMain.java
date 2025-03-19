import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class TVMain{
    // Attributes
    private ArrayList<TVSeries> shows = new ArrayList<>();
    //TVSeries user1 = new TVSeries();

    // Methods
    public TVMain(){
        String name;
        
        Scanner keyboard = new Scanner(System.in);
        int choice = 0;

        createShowData();
        
        while (choice != 5) {
            System.out.println();
            System.out.println("Menu: (Please, select a number to initiate the corresponding action!)");
            System.out.println(" 1. Save a Tv Series.\n 2. Add amount of episodes and seasons for a Tv Series.\n 3. Change the rating and amount of episodes on saved Tv Series.\n 4. Print info. \n 5. Shut down Television.");
            System.out.print("Choice: ");
            try{
                choice = keyboard.nextInt();
                keyboard.nextLine();
            }catch(Exception e){
                choice = 5;
            }

            switch (choice) {
                case 1:
                    System.out.print("Name of Tv Series: ");
                    name = keyboard.nextLine();
                    System.out.println();
                    System.out.print("Amount of seasons: ");
                    int season = keyboard.nextInt();
                    keyboard.nextLine();
                    System.out.println("Amount of episodes: ");
                    int numOfEpisodes = keyboard.nextInt();
                    keyboard.nextLine();

                    shows.add(new TVSeries(name, numOfEpisodes, season));
                    break;
                case 2:
                // user first neeeds tochoos which show to work with
                    System.out.println("Available shows:");
                    for(TVSeries series : shows){
                        System.out.println(" - " + series.getName());
                    }
                    System.out.println("Wich show would you like to edit (enter a number based on the order of the displayed alternatives:)");
                    System.out.print("Choice: ");
                    int showChoice = keyboard.nextInt();
                    keyboard.nextLine();
                    TVSeries chosenShow = shows.get(showChoice-1);

                    System.out.println("Steps to add information about a Tv Series:");
                    System.out.println();
                    System.out.print("Amount of seasons: ");
                    season = keyboard.nextInt();
                    keyboard.nextLine();
                    System.out.println("Amount of episodes: ");
                    numOfEpisodes = keyboard.nextInt();
                    keyboard.nextLine();

                    //shows.set(showChoice-1, chosenShow.addEpisodes(numOfEpisodes, season));
                    
                    //user1.addEpisodes(numOfEpisodes, season);
                    break;
                case 3:
                // user first neeeds to choos which show to work with
                    System.out.print("New rating: ");
                    int newRating = keyboard.nextInt();
                    keyboard.nextLine();

                   // user1.changeRating(newRating);
                    break;
                case 4:
                // user first neeeds to choos which show to work with
                    //user1.printInfo();
                    break;
                default:
                System.out.println("You made a faulty input, please enter the number corresponding to the alternative in the menu.");
                    break;
            }
        }
        keyboard.close();
    }
    public void createShowData(){
        shows.add( new TVSeries("Air Crash Investigation", 120, 6));
        shows.add( new TVSeries("Blacklist", 150, 11));
        shows.add( new TVSeries("Lost", 80, 6));
    }
    public void Write2File() throws IOException{   //Serializing
        FileOutputStream fileOut = new FileOutputStream("TVSeriesInfo.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(shows);
        out.close();
        fileOut.close();
    }
    public void readFromFile() throws IOException{     //Deserializing
        FileInputStream fileIn = new FileInputStream("C:\\Users\\adrian.eriksson\\Documents\\Java projects 2\\lekv_prog2_uppg2_klasser\\TVSeriesInfo.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        try {
            shows = (ArrayList<TVSeries>) in.readObject();
        } catch (ClassNotFoundException e) {
            System.out.println("Reading of previously saved file failed!");
        }
        in.close();
        fileIn.close();
    }
}
