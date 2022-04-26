package lt.viko.eif.vandraityte.Canoe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RouteTest {
    @Test
    void setNewRoute (){
        Route route = new Route();
        route.setRiverName("Neris");
        assertEquals("Neris", route.getRiverName());
    }

}