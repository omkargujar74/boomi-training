import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class TestExample {

    Example service = mock(Example.class);
    MockExample mockExample = new MockExample(service);

    @Test
    public void testAdd() {
        Example example = new Example();
        assertEquals(15, example.add(10, 5));
//        fail();
    }

    @Test
    public void testMoveZero() {
        Example example = new Example();
        int[] arr = new int[]{0, 0, 0, 1, 0, 1, 1, 1, 1};
        int[] expected = new int[]{1, 1, 1, 1, 1, 0, 0, 0, 0};

        assertArrayEquals(expected, example.moveZero(arr));
//        fail();
    }

    @Test
    public void testMock() {
        when(service.add(5, 3)).thenReturn(8);
        assertEquals(40, mockExample.mockTest(5, 3));
        verify(service, atLeast(1)).add(5, 3);
//        fail();
    }
}
