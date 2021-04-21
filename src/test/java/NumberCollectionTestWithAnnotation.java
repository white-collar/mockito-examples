import business.logic.NumberCollection;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@RunWith(MockitoJUnitRunner.class)
public class NumberCollectionTestWithAnnotation {
    @Mock
    private List<Integer> mockList;

    @InjectMocks
    private NumberCollection nc;


    @Test
    public void getTotalUsingLoop() {
        when(mockList.size()).thenReturn(3);
        when(mockList.get(0)).thenReturn(1);
        when(mockList.get(1)).thenReturn(2);
        when(mockList.get(2)).thenReturn(3);

        // Only requires the stub behavior,
        //  i.e., that the get(i) methods return the expected values
        assertEquals(6, nc.getTotalUsingLoop());

        // Verify the protocol -- that the mock methods are called
        //  the right number of times
        verify(mockList).size();
        verify(mockList, times(3)).get(anyInt());
        verify(mockList, never()).clear();
    }

    @Test
    public void getTotalUsingStream() {
        when(mockList.stream()).thenReturn(Stream.of(1, 2, 3));

        // Only requires the stub behavior,
        assertEquals(6, nc.getTotalUsingStream());

        // Verify the protocol -- that the mock methods are called
        //  the right number of times
        verify(mockList).stream();
    }
}
