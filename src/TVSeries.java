import java.util.ArrayList;
import java.util.Scanner;

public class TVSeries {
    // Keyboard
    Scanner keyboard = new Scanner(System.in);

    // Attributes
    private String name;
    private ArrayList<Integer> episodes = new ArrayList<>();
    private int rating;

    // Methods
    public void TvSeries(){
        System.out.print("Please insert the name of the Series here: ");
        name = keyboard.nextLine();
    }
    public void TvSeries(String name){
        //jj
    }
    public void addEpisodes(int numOfEpisodes, int season){
        episodes.add(season-1,numOfEpisodes);
        System.out.println("The number of episodes, "+numOfEpisodes+", of  season "+season+" was added.");
    }
    public void changeRating(){
        //jj
    }
    public void printInfo(){
        //jj
    }
}
