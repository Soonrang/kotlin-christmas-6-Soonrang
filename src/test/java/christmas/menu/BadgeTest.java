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

        // 테스트 케이스 2: 1000원인 경우 (조건을 만족하지 않아서 null이 반환되어야 함)
        assertNull(Badge.presentBadge(1000));

        // 테스트 케이스 3: 10000원인 경우
        assertEquals("트리", Badge.presentBadge(10000));

        // 테스트 케이스 4: 25000원인 경우
        assertEquals("산타", Badge.presentBadge(20000));

    }
}
