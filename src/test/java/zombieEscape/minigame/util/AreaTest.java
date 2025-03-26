package zombieEscape.minigame.util;

import com.github.elic0de.zombieEscape.util.Area;
import org.bukkit.Location;
import org.bukkit.World;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockbukkit.mockbukkit.MockBukkit;
import org.mockbukkit.mockbukkit.ServerMock;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AreaTest {

    private World world;

    @BeforeEach
    public void setUp() {
        ServerMock server = MockBukkit.mock();
        world = server.addSimpleWorld("test");
    }

    @AfterEach
    public void tearDown() {
        MockBukkit.unmock();
    }

    @Test
    void testContainsInside() {
        Location point1 = new Location(world, 10, 64, 10);
        Location point2 = new Location(world, 20, 70, 20);
        Area area = new Area(point1, point2);

        // 内側の点
        Location testLoc = new Location(world, 15, 65, 15);
        assertTrue(area.contains(testLoc), "エリア内の座標は true であるべき");
    }

    @Test
    void testContainsOutside() {
        Location point1 = new Location(world, 10, 64, 10);
        Location point2 = new Location(world, 20, 70, 20);
        Area area = new Area(point1, point2);

        // 外側の点
        Location testLoc = new Location(world, 25, 65, 25);
        assertFalse(area.contains(testLoc), "エリア外の座標は false であるべき");
    }
}
