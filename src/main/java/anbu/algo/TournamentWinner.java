package anbu.algo;

import org.junit.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TournamentWinner {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 4, 5, 5, 7, 45, 9);
        System.out.println(Collections.max(integers));
    }
    public String tournamentWinner(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
        Map<String, Integer> winnerMap = new HashMap<String, Integer>();
        String str;
        for (int i = 0; i < competitions.size(); i++) {
            if (results.get(i) == 1) {
                str = competitions.get(i).get(0);
            } else {
                str = competitions.get(i).get(1);
            }
            winnerMap.put(str, winnerMap.getOrDefault(str, 0) + 1);
        }



        return Collections.max(winnerMap.entrySet(), Map.Entry.comparingByValue()).getKey();





    }


}
