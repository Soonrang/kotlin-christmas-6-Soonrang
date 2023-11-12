package christmas.menu;

import christmas.model.Badge;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class BadgeTest {
    @Test
    public void testPresentBadge() {
        assertEquals("트리", Badge.presentBadge(15000));

        assertNull(Badge.presentBadge(1000));

        assertEquals("트리", Badge.presentBadge(10000));

        assertEquals("산타", Badge.presentBadge(20000));

    }
}
