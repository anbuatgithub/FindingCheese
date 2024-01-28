package anbu.algo;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidateSubSequence {

    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence ) {
        int arrIdx = 0;
        int seqIdx = 0;

        while(arrIdx < array.size() && seqIdx < sequence.size() )
        {
            if(array.get(arrIdx).equals(sequence.get(seqIdx)))
            {
                seqIdx++;
            }
            arrIdx++;

        }
        return sequence.size() == seqIdx ;
    }


    @Test
    public void testFindOddInt() {
        assertEquals(true, isValidSubsequence(Arrays.asList(5,1,22,25,6,-1,8,10),Arrays.asList(1,6,-1,10)));
        assertEquals(false, isValidSubsequence(Arrays.asList(5,22,25,6,-1,8,10),Arrays.asList(1,6,-1,10)));

    }
}
