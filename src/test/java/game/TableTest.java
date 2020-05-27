package game;

import game.Table;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TableTest {

    @Test
    void testAvailable() {
        assertEquals(true,Table.available(1,5,1));
        assertEquals(false,Table.available(0,1,3));
        assertEquals(true,Table.available(9,9,1));
        assertEquals(false, Table.available(10,0,1));
    }

}
