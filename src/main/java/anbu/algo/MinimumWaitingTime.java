        package anbu.algo;

        import org.junit.Test;

        import java.util.*;

        import static org.junit.jupiter.api.Assertions.assertEquals;

        public class MinimumWaitingTime {

            public int minWaitingTime(int[] queries) {
                int time=0;
                Arrays.sort(queries);
                for(int i=1;i< queries.length ;i++){
                    int queriesLeft = (queries.length-i);
                    int duration = queries[i-1];
                    time += queriesLeft * duration ;
                }
                return time;
            }


            @Test
            public void testFindOddInt() {
                assertEquals(6, minWaitingTime(new int[]{1,4,5}));
                assertEquals(17, minWaitingTime(new int[]{3,2,1,2,6}));
                assertEquals(40, minWaitingTime(new int[]{6,7,8,9}));
            }
        }
