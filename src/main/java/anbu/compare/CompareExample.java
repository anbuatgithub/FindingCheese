package anbu.compare;

import java.util.*;
import java.util.stream.Collectors;

public class CompareExample {

    public static void main(String[] args) {

        //https://www.baeldung.com/java-comparator-comparable
        Player p1 = new Player(2, "kohli", 23);
        Player p2 = new Player(125, "dhoni", 43);
        Player p3 = new Player(45, "rahul", 34);
        Player p4 = new Player(2, "kohli", 23);


        List<Player> footballTeam = Arrays.asList(p1, p2, p3);

        System.out.println("Before Sorting : " + footballTeam);
        Collections.sort(footballTeam);
        System.out.println("After Sorting : " + footballTeam);
        Collections.sort(footballTeam,new PlayerAgeComparator().reversed());
        System.out.println("After comparator : " + footballTeam);

        Comparator<Player> c1 = (Player pl1,Player pl2) -> Integer.compare(pl1.getRanking(),pl2.getRanking());
        Collections.sort(footballTeam,c1);
        System.out.println("After c1 : " + footballTeam);

        Comparator c2= Comparator.comparing(Player::getName);
        Collections.sort(footballTeam,c2);

        System.out.println("After c2 : " + footballTeam);
        Comparator<Player> c3 = (pl1,pl2) -> pl1.getRanking()- pl2.getRanking();
        Collections.sort(footballTeam,c3);

        System.out.println("After c3 : " + footballTeam);

        footballTeam = new ArrayList<>(Arrays.asList(p1,p2,p3));
        footballTeam.add(p4);

        System.out.println("After adding p4 : " + footballTeam);

        Map<String,Long> grouping = footballTeam.stream().collect(Collectors.groupingBy(Player::getName,Collectors.counting()));
        grouping.forEach((key,value)-> System.out.println("Name "+key+" : "+value+ " times"));

        Player oldage= footballTeam.stream().max(Comparator.comparing(Player::getAge)).get();
        System.out.println("old age player "+oldage.getName());


    }

}

 class PlayerAgeComparator implements Comparator<Player> {

    @Override
    public int compare(Player firstPlayer, Player secondPlayer) {
        return Integer.compare(firstPlayer.getAge(), secondPlayer.getAge());
    }

}
