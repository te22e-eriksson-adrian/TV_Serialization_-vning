import java.util.ArrayList;
import java.util.Scanner;
import java.io.Serializable;

public class TVSeries implements Serializable{
    // Keyboard
    Scanner keyboard = new Scanner(System.in);

    // Attributes
    private String name;
    private ArrayList<Integer> episodes = new ArrayList<>();
    private int rating;
    private int seasons;

    // Methods
    public TVSeries(){
        System.out.print("Please insert the name of the Series here: ");
        name = keyboard.nextLine();
    }
    public TVSeries(String name, int episodes, int seasons){
        this.name = name;
        this.seasons = seasons;
        addEpisodes(episodes, seasons);
    }

    public void addEpisodes(int numOfEpisodes, int season){
        episodes.add(season-1,numOfEpisodes);
        System.out.println("The number of episodes, "+numOfEpisodes+", of  season "+season+" was added.");
    }

    public void changeRating(int newRating){
        rating = newRating;
        System.out.println("Current rating: "+newRating);
    }
    public void printInfo(){
        System.out.println("Information about the Tv Series:");
        System.out.println("- "+name+"\n- "+rating);
        for (Integer integer : episodes) {
            System.out.println(" - "+integer);
        }
    }
    public String getName(){
        return name;
    }
}