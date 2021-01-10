import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class TestCycled {
    @Test
    public void testCycledEndless() {
        Iterator<String> cycled = new Cycled<String>(
                new LinkedList<>(
                        Arrays.asList("Foo", "Bar", "Baz")
                )
        ).iterator();


        LinkedList<String> next = new LinkedList<>(
                Arrays.asList("Foo", "Bar", "Baz")
        );
        Iterator<String> nextIterator = next.iterator();
        for (int i = 0; i < 50; i++) {
            Assert.assertTrue(cycled.hasNext());
            if (!nextIterator.hasNext())
                nextIterator = next.iterator();
            Assert.assertEquals(cycled.next(), nextIterator.next());
        }
    }

}
