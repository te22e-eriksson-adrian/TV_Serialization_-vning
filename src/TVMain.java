import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class TVMain{
    // Attributes
    private ArrayList<TVSeries> shows = new ArrayList<>();
    TVSeries user1 = new TVSeries();

    // Methods
    public TVMain(){
        String name;
        
        Scanner keyboard = new Scanner(System.in);
        int choice = 0;
        
        while (choice != 5) {
            System.out.println();
            System.out.println("Menu: (Please, select a number to initiate the corresponding action!)");
            System.out.println(" 1. Save a Tv Series.\n 2. Add amount of episodes and seasons for a Tv Series.\n 3. Change the rating and amount of episodes on saved Tv Series.\n 4. Print info. \n 5. Shut down Television.");
            System.out.print("Choice: ");
            try{
                choice = keyboard.nextInt();
                keyboard.nextLine();
            }catch(Exception e){
                choice = 4;
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
                    System.out.println("Steps to add information about a Tv Series:");
                    System.out.println();
                    System.out.print("Amount of seasons: ");
                    season = keyboard.nextInt();
                    keyboard.nextLine();
                    System.out.println("Amount of episodes: ");
                    numOfEpisodes = keyboard.nextInt();
                    keyboard.nextLine();
                    
                    user1.addEpisodes(numOfEpisodes, season);
                    break;
                case 3:
                    System.out.print("New rating: ");
                    int newRating = keyboard.nextInt();
                    keyboard.nextLine();

                    user1.changeRating(newRating);
                    break;
                case 4:
                    user1.printInfo();
                    break;
                default:
                System.out.println("You made a faulty input, please enter the number corresponding to the alternative in the menu.");
                    break;
            }
        }
        keyboard.close();
    }
    public void createShowData(){   //?
        //jj
    }
    public void Write2File() throws IOException{   //Serializing
        FileOutputStream fileOut = new FileOutputStream("TVSeriesInfo.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(user1);
        out.close();
        fileOut.close();
    }
    public void readFromFile() throws IOException{     //Deserializing
        FileInputStream fileIn = new FileInputStream("C:\\Users\\adrian.eriksson\\Documents\\Java projects 2\\lekv_prog2_uppg2_klasser\\TVSeriesInfo.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        try {
            user1 = (TVSeries) in.readObject();
        } catch (ClassNotFoundException e) {
            System.out.println("Reading of previously saved file failed!");
        }
        in.close();
        fileIn.close();
    }
}
