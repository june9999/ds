package deque;
import org.junit.Test;
import java.util.Comparator;
import static org.junit.Assert.assertEquals;


public class MaxArrayDequeTest {


    @Test
    public void maxTest() {
        Comparator comTry = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return (Integer) o2 - (Integer) o1;
            }
        };

        MaxArrayDeque<Integer> snew = new MaxArrayDeque(comTry);

        snew.addFirst(10);
        snew.addLast(2);

        snew.addLast(50);

        assertEquals(10, (long) snew.max());

    }


    @Test
    public void maxTest2(){
        Comparator comTry = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return (Integer) o2 - (Integer) o1;
            }
        };

        Comparator comTry2 = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return (Integer) o1 - (Integer) o2;
            }
        };

        MaxArrayDeque<Integer> snew = new MaxArrayDeque(comTry);

        snew.addFirst(10);
        snew.addLast(2);
        snew.addLast(50);

        assertEquals(2, (long) snew.max(comTry2));

    }


}
