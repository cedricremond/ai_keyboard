package model;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by cremond on 27/12/16.
 */
public class OccurencesData {
    long[][] occurences;

    ArrayList<Position >max_to_min_positions;

    public OccurencesData(long[][] occurences) {
        this.occurences = occurences;
        this.max_to_min_positions = new ArrayList<Position>();
        sortOccurences();
    }

    private void sortOccurences() {
        Position max_pos;
        // For each couple of letter
        for (int k = 0; k < occurences.length * occurences[0].length; k++) {
            max_pos = new Position(0,0);
            // We search the next max and add it to the array
            for (int i = 0; i < occurences.length; i++) {
                for (int j = 0; j < occurences[i].length; j++) {
                    Position current_pos = new Position(i,j);
                    // If is higher and not already in the array
                    if (occurences[i][j] >= occurences[max_pos.getX()][max_pos.getY()] &&
                            !max_to_min_positions.contains(new Position(i, j))) {
                        max_pos.setXandY(i, j);
                    }
                }
            }
            System.out.println("max_pos : " + max_pos);
            max_to_min_positions.add(max_pos);
        }

    }

    public String toString() {
        String res ="";
        for(int i=0; i < occurences.length; i++) {
            res+="\n";
            for(int j=0; j < occurences[i].length; j++) {
                long current_occurence = occurences[i][j];
                if (current_occurence < 10) {
                    res += current_occurence + " ";
                } else {
                    res += current_occurence;
                }
                res+="|";
            }
        }
        return res;
    }

    public ArrayList<Position> getMax_to_min_positions() {
        return max_to_min_positions;
    }

    public long[][] getOccurences() {
        return occurences;
    }
}
