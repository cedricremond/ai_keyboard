import models.Keyboard;
import models.OccurencesData;
import models.Position;
import tools.DataParser;

import java.util.ArrayList;

/**
 * Created by cremond on 17/12/16.
 */
public class Main {

    public static void main (String [] args){

        System.out.println("Wesh je me lance\n");

        String data_file_path = "./datafiles/bigramFreqEng-Occurrence.dat";

        DataParser data_parser = new DataParser(data_file_path);

        data_parser.ParseData();

        OccurencesData occurences_data = data_parser.getOccurencesData();

        /*
        System.out.println("Occurences importées");
        System.out.println(occurences.toString());
        */

        ArrayList<Position> max_to_min_positions = occurences_data.getMax_to_min_positions();
        long[][] occurences = occurences_data.getOccurences();
        for (int i = 0; i < max_to_min_positions.size(); i++) {
            Position current_pos = max_to_min_positions.get(i);
//            System.out.println("X : " + current_pos.getX() + ", Y : " + current_pos.getY());
//            System.out.println(occurences[current_pos.getX()][current_pos.getY()]);
        }

        Keyboard k = new Keyboard();

        k.createRandomKeyboard();

        System.out.println("Tableau de lettres random");
        System.out.println(k.toString());
    }

}