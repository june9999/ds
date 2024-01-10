package deque;

import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayDequeTest {




    @Test
    public void addIsEmptySizeTest(){
        ArrayDeque<String> g =new ArrayDeque<String>();
        assertTrue("IT IS EMPTY",g.isEmpty());
        g.addFirst("d");
        assertEquals(1,g.size());
        g.addLast("second");
        assertEquals(2, g.size());
        System.out.println("Printing out deque: ");
        g.printDeque();
    }

    @Test
    public void addRemoveTest(){
        ArrayDeque<String> g =new ArrayDeque<String>();
        g.addFirst("ss");
        assertFalse("lld1 should contain 1 item", g.isEmpty());
        g.removeFirst();
        assertTrue("lld1 should contain 1 item", g.isEmpty());
    }

    @Test
    public void  removeEmptyTest(){
        ArrayDeque<Integer> g =new ArrayDeque<Integer>();
        g.addFirst(3);
        g.removeLast();


        g.removeLast();
        g.removeFirst();
        g.removeLast();
        g.removeFirst();

        int size = g.size();
        String errorMsg = "  Bad size returned when removing from empty deque.\n";
        errorMsg += "  student size() returned " + size + "\n";
        errorMsg += "  actual size() returned 0\n";

        assertEquals(errorMsg, 0, size);
    }
}
