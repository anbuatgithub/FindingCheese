package com.meeran.stringandpatterns;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class BalancedParens {
	private static List<String> parStringList;
    private static int total;
    public static void exploreParantheses(String parString,int leftCnt,int rightCnt){
        if (leftCnt < total) exploreParantheses(parString + "(", leftCnt+1, rightCnt);
        if ((rightCnt < total) &&(rightCnt < leftCnt)) exploreParantheses(parString + ")", leftCnt, rightCnt+1);
        else if (rightCnt == total) parStringList.add(parString);
    }
    
    public static List <String> balancedParens (int n) {
    	total = n;
        parStringList = new ArrayList<String>();
        exploreParantheses("", 0, 0);
        return parStringList;
    }



    
    @Test
    public void testExample() {
       List<String> warriorsList = new ArrayList<String>();
       //test for n = 0
       warriorsList = BalancedParens.balancedParens(0);
       assertEquals(new ArrayList<String>(Arrays.asList(new String[] {""}))
                    ,  warriorsList
                    );
     //test for n = 1
       warriorsList = BalancedParens.balancedParens(1);
       assertEquals(new ArrayList<String>(Arrays.asList(new String[] {"()"}))
                    , warriorsList
                    );
     //test for n =2
       warriorsList = BalancedParens.balancedParens(2);
       Collections.sort(warriorsList);
       assertEquals(new ArrayList<String>(Arrays.asList(new String[] {"(())","()()"}))
                    , warriorsList
                    );
     //test for n = 3
       warriorsList = BalancedParens.balancedParens(3);
       Collections.sort(warriorsList);
       assertEquals(new ArrayList<String>(Arrays.asList(new String[] {"((()))","(()())","(())()","()(())","()()()"}))
                    , warriorsList
                    );
     //test for n = 4
       warriorsList = BalancedParens.balancedParens(4);
       Collections.sort(warriorsList);
       assertEquals(new ArrayList<String>(Arrays.asList(new String[] {"(((())))","((()()))","((())())","((()))()","(()(()))","(()()())","(()())()","(())(())","(())()()","()((()))","()(()())","()(())()","()()(())","()()()()"}))
                   , warriorsList
                   );
     
     }
}
